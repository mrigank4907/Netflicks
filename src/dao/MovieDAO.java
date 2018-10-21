package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Movie;



public enum MovieDAO {

	instance;
	public Connection getConnection(){
	Connection connection = null;
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieDB?useSSL=false", "root", "");
				if(connection !=null) {
								System.out.println("Connected to database!");	
				}
	}catch(Exception e) {
				System.out.println("Error connecting to database");
				e.printStackTrace();
		}
		return connection;
	}


public Movie checkTitle(String title) {
	Connection connection = getConnection();
	Movie movie =null;
	
	try {
		PreparedStatement psmt = connection.prepareStatement ("SELECT * FROM movies WHERE title = ?");
		psmt.setString(1,title);
		ResultSet rs = psmt.executeQuery();
		if  (rs.next()) {
			
				 int id = rs.getInt("id");
				 String title1 = rs.getString("title");
				 String genre = rs.getString("genre");
				 String description = rs.getString("description");
				 int release_year = rs.getInt("release_year");
				 String language = rs.getString("language");
				 String imdb_rating = rs.getString("imdb_rating");
				 String duration_minutes = rs.getString("duration_minutes");
				 String main_actors = rs.getString("main_actors");
				 
				 movie = new Movie(id,title1,genre,description,release_year,
						                 language,imdb_rating,duration_minutes,main_actors);
				 
				 System.out.println("name " +title+ " is in the database");
				 }
		
		else{	
			
			System.out.println("name " +title+ " is not in the database");
		}
		 
	
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	return movie;
	
}
}
