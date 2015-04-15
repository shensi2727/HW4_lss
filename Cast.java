package HW4jdbc;

public class Cast {
	
	private String id;
	private String characterName;
	private String actorId;
	private String movieId;
	
	
	public void setCharacterName(String characterName) {
	     this.characterName = characterName;
	}
	
	public String getCharacterName() {
	     return characterName;
	}
	
	public void setActorId(String actorId) {
	     this.actorId = actorId;
	}
	
	public String getActorId() {
	     return actorId;
	}
	
	public void setMovieId(String movieId) {
	     this.movieId = movieId;
	}
	
	public String getMovieId() {
	     return movieId;
	}
	
	
	public Cast(String id, String characterName, String actorId, String movieId) {
		super();
		this.id = id;
		this.characterName = characterName;
		this.actorId = actorId;
		this.movieId = movieId;
	}
	
	public Cast() {
		super();
	}
	
}
