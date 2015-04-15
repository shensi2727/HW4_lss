package HW4jdbc;

import java.sql.Date;

public class Movie {
	private String id;
	private String title;
	private String posterImage;
	private Date releaseDate;
	
	public void setId(int id) {
		this.id = id;
	}

        public String getId() {
		return id;
	}

	public void setTitle(String title) {
	     this.title = title;
	}
	
	public String getTitle() {
	     return title;
	}
	
	
	public void setPosterImage(String posterImage) {
	     this.posterImage = posterImage;
	}
	
	public String getPosterImage() {
	     return posterImage;
	}
	
	
	public void setReleaseDate(Date releaseDate) {
	     this.releaseDate = releaseDate;
	}
	
	public String getReleaseDate() {
	     return releaseDate;
	}
	
	public Movie(String id, String title, String posterImage, Date releaseDate) {
		super();
		this.id = id;
		this.title = title;
		this.posterImage = posterImage;
		this.releaseDate = releaseDate;
	}
	
	public Movie() {
		super();
	}
}
