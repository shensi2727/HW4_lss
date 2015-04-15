package HW4jdbc;

import java.sql.Date;

public class Comment {
	private String id;
	private String comment;
	private Date date;
	private String username;
	private String movieId;
	
	public void setComment(String comment) {
	     this.comment = comment;
	}
	
	public String getComment() {
	     return comment;
	}
	
	
	
	public void setDate(Date date) {
	     this.date = date;
	}
	
	public Date getDate() {
	     return date;
	}
	
	
	
	public void setUsername(String username) {
	     this.username = username;
	}
	
	public String getUsername() {
	     return username;
	}
	
	
	public void setMovieId(String movieId) {
	     this.movieId = movieId;
	}
	
	public String getMovieId() {
	     return movieId;
	}
	
	
	public Comment(String id, String comment, Date date, String username, String movieId) {
		super();
		this.id = id;
		this.comment = comment;
		this.date = date;
		this.username = username;
		this.movieId = movieId;
	}
	
	public Comment() {
		super();
	}
}
