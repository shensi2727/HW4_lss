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


public class CastManager {
		
	
	DataSource ds;
	
	public CastDAO()
	{
	  try {
		Context ctx = new InitialContext();
		ds = (DataSource)ctx.lookup("jdbc/HW4DB"); //fake addr
		System.out.println(ds);		//output result of connection
	  } catch (NamingException e) {
		e.printStackTrace();
	  }
	}
	
	// create a cast
	public void createCast(Cast newCast)
	{
		String sql = "insert into cast values (null,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newComment.getCharacterName());
			statement.setString(2, newComment.getActorId());
			statement.setString(3, newComment.getMovieId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// read all cast
	public List<Cast> readAllCast()
	{
		List<Cast> castList = new ArrayList<Cast>();
		String sql = "select * from cast";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Cast cast = new Cast();
				cast.setId(results.getString("id"));
				cast.setCharacterName(results.getString("characterName"));
				cast.setActorId(results.getString("actorId"));
				cast.setMovieId(results.getString("movieId"));
				castList.add(cast);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return castList;
	}
	
	//read all cast for actor
	public List<Cast> readAllCastForActor(String actorId)
	{
		List<Cast> castList = new ArrayList<Cast>();
		String sql = "select * from cast where actorId = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, actorId);
			ResultSet results = statement.executeQuery();
			if(results.next())
			{
				Cast cast = new Cast();
				cast.setId(results.getString("id"));
				cast.setCharacterName(results.getString("characterName"));
				cast.setActorId(results.getString("actorId"));
				cast.setMovieId(results.getString("movieId"));
				castList.add(cast);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return castList;
	}

	//read all cast for movie
		public List<Cast> readAllCastForMoive(String movieId)
		{
			List<Cast> castList = new ArrayList<Cast>();
			String sql = "select * from cast where movieId = ?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, moiveId);
				ResultSet results = statement.executeQuery();
				if(results.next())
				{
					Cast cast = new Cast();
					cast.setId(results.getString("id"));
					cast.setCharacterName(results.getString("characterName"));
					cast.setActorId(results.getString("actorId"));
					cast.setMovieId(results.getString("movieId"));
					castList.add(cast);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return castList;
		}
	
	// retrieve a cast by id
	public Cast readCastForId(String castId)
	{
		Cast cast = new Cast();
		
		String sql = "select * from cast where id = ?";
		try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, castId);
				ResultSet result = statement.executeQuery();
				if(result.next())
				{
					cast.setId(results.getString("id"));
					cast.setCharacterName(results.getString("characterName"));
					cast.setActorId(results.getString("actorId"));
					cast.setMovieId(results.getString("movieId"));
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		return cast;
	}
	
	// update a cast by id
	void updateCast(String castId, Cast cast)
	{
		String sql = "update cast set characterName=?, actorId=?, movieId=? where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, cast.getCharacterName());
			statement.setString(2, cast.getActorId());
			statement.setString(3, cast.getMovieId());
			statement.setString(4, castId);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return cast;
	}
	
	// delete a cast by id
	public int deleteCast(String castId)
	{
		String sql = "delete from cast where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, castId);
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
