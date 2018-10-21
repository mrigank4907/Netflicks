package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class RegistrationDAO {
	/**
	 * 
	 * @return connection to database
	 */
	public Connection getConnection(){
		Connection connection = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "root");
			if(connection !=null) {
				System.out.println("Connected to database OK!");	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;

	}
	/**
	 * Add user in the database
	 * @param user
	 */
	public void saveUser(User user) { 
		Connection connection = getConnection();
		try {
			PreparedStatement psmt = connection.prepareStatement("INSERT INTO USER (First_Name,Last_Name,User_name,Password,Mobile_no) VALUES(?,?,?,?,?)");
			
			psmt.setString(1,user.getFirstName());
			psmt.setString(2,user.getLastName());
			psmt.setString(3,user.getUsername());
			psmt.setString(4,user.getPassword());
			psmt.setString(5,user.getMobile_no());
			psmt.executeUpdate();
			System.out.println("Added " + user.getFirstName()+ " to the database.");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

/** 
 * 
 * @param userName
 * @return a user with given userName
 */
	public User getUserByUserName(String userName) {
		Connection connection = getConnection();
		User user=null;
		try {
			PreparedStatement psmt = connection.prepareStatement("SELECT * FROM USER WHERE user_name = ?");
			psmt.setString(1,userName);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				user=new User();
				
				user.setFirstName(rs.getString("First_name"));
				user.setFirstName(rs.getString("Last_name"));
				user.setFirstName(rs.getString("User_name"));
				user.setFirstName(rs.getString("Password"));
				user.setFirstName(rs.getString("Mobile_no"));
				System.out.println("username " +userName+ " is in the database");
			}
			else
			{
				System.out.println("username " +userName+ " is not in the database");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;

	}
}
