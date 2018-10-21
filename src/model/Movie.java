package model;


public class Movie {

		public int id;
		public String title;
	    public String genre;
	    public String description;
	    public int release_year;
	    public String language;
	    public String imdb_rating;
	    public String duration_minutes;
	    public String main_actors;
	    

	    public Movie(int id, String title, String genre, String description, int release_year, String language, String imdb_rating, String duration_minutes, String main_actors) {
	    	this.id = id;
	    	this.title = title;
	        this.genre = genre;
	        this.description = description;
	        this.release_year = release_year;
	        this.language = language;
	        this.imdb_rating = imdb_rating;
	        this.duration_minutes = duration_minutes;
	        this.main_actors = main_actors;
	        
	    }
	    
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }
	    
	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	       this.title = title;
	    }

	    public String getGenre() {
	        return genre;
	    }

	    public void setGenre(String genre) {
	        this.genre = genre;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }
	    
	    public int getRelease_year() {
	        return release_year;
	    }

	    public void setRelease_year(int release_year) {
	    	this.release_year = release_year;
	    }
	    
	    public String getLanguage() {
	        return language;
	    }

	    public void setLanguage(String language) {
	        this.language = language;
	    }
	    
	    public String getImdb_rating() {
	        return imdb_rating;
	    }

	    public void setImdb_rating(String imdb_rating) {
	    	this.imdb_rating = imdb_rating;
	    }
	    
	    public String getDuration_minutes() {
	        return duration_minutes;
	    }

	    public void setDuration_minutes(String duration_minutes) {
	    	this.duration_minutes = duration_minutes;
	    }
	    
	    public String getMain_actors() {
	        return main_actors;
	    }

	    public void setMain_actors(String main_actors) {
	    	this.main_actors = main_actors;
	    }
	    
}