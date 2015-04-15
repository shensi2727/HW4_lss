package HW4jdbc;

import java.sql.Date;

public class User {
	private String id;
        private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Date dateOfBirth;
	
	public void setId(String id) {
	     this.id = id;
	}
	
	public String getId() {
	     return id;
	}

public void setUsername(String username) {
	     this.username = username;
	}
	
	public String getUsername() {
	     return username;
	}
	
	
	public void setPassword(String password) {
	     this.password = password;
	}
	
	public String getPassword() {
	     return password;
	}
	
	
	public void setFirstName(String firstName) {
	     this.firstName = firstName;
	}
	
	public String getFirstName() {
	     return firstName;
	}
	
	
	public void setLastName(String lastName) {
	     this.lastName = lastName;
	}
	
	public String getLastName() {
	     return lastName;
	}
	
	
	public void setEmail(String email) {
	     this.email = email;
	}
	
	public String getEmail() {
	     return email;
	}
	
	
	public void setDateOfBirth(Date dateOfBirth) {
	     this.dateOfBirth = dateOfBirth;
	}
	
	public Date getDateOfBirth() {
	     return dateOfBirth;
	}
	
	
	public User(String id, String username, String password, String firstName, 
                    String lastName, String email, Date dateOfBirth) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	
	public User() {
		super();
	}
}
