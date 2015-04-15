package HW4jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class UserManager {
	
	DataSource ds;
	
	public UserDAO()
	{
	  try {
		Context ctx = new InitialContext();
		ds = (DataSource)ctx.lookup("jdbc/HW4DB"); //fake addr
		System.out.println(ds);		//output result of connection
	  } catch (NamingException e) {
                // TODO Auto-generated catch block
		e.printStackTrace();
	  }
	}
	
	
	// create a user
	public User createUser(User newUser)
	{
		String sql = "insert into user values (null,?,?,?,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newUser.getUsername());
			statement.setString(2, newUser.getPassword());
			statement.setString(3, newUser.getFirstName());
			statement.setString(4, newUser.getLastName());
			statement.setString(5, newUser.getEmail());
			statement.setDate(6, newUser.getDateOfBirth());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// read all users
	public List<User> findAllUsers()
	{
		List<User> userList = new ArrayList<User>();
		String sql = "select * from user";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				User user = new User();
				user.setId(results.getString("id"));
				user.setUsername(results.getString("username"));
				user.setPassword(results.getString("password"));
				user.setFirstName(results.getString("firstName"));
				user.setLastName(results.getString("lastName"));
				user.setEmail(results.getString("email"));
				user.setDateOfBirth(results.getDate("dateOfBirth"));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	
	// retrieve a user by id
	public User readUser(String userId)
	{
		User user = new User();
		
		String sql = "select * from user where id = ?";
		try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, userId);
				ResultSet result = statement.executeQuery();
				if(result.next())
				{
					user.setId(results.getString("id"));
					user.setUsername(results.getString("username"));
					user.setPassword(results.getString("password"));
					user.setFirstName(results.getString("firstName"));
					user.setLastName(results.getString("lastName"));
					user.setEmail(results.getString("email"));
					user.setDateOfBirth(results.getDate("dateOfBirth"));
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		return user;
	}
	
	// update a user by id
	public void updateUser(String userId, User user)
	{
		String sql = "update user set username=?, password=?, firstName=?, lastName=?, email=?, dateOfBirth=? where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
			statement.setString(5, user.getEmail());
			statement.setDate(6, user.getDateOfBirth());
			statement.setString(7, userId);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return user;
	}
	
	// delete a user by id
	public int deleteUser(String userId)
	{
		String sql = "delete from user where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userId);
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
