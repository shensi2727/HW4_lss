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


public class CommentManager {
			
	DataSource ds;
	
	public CommentDAO()
	{
	  try {
		Context ctx = new InitialContext();
		ds = (DataSource)ctx.lookup("jdbc/HW4DB"); //fake addr
		System.out.println(ds);		//output result of connection
	  } catch (NamingException e) {
		e.printStackTrace();
	  }
	}
	
	// create a comment
	public void createComment(Comment newComment)
	{
		String sql = "insert into comment values (null,?,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newComment.getComment());
			statement.setDate(2, newComment.getDate());
			statement.setString(3, newComment.getUsername());
			statement.setString(3, newComment.getMovieId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// read all comments
	public List<Comment> readAllComments()
	{
		List<Comment> commentList = new ArrayList<Comment>();
		String sql = "select * from comment";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Comment comment = new Comment();
				comment.setId(results.getString("id"));
				comment.setComment(results.getString("comment"));
				comment.setDate(results.getString("date"));
				comment.setUsername(results.getString("username"));
				comment.setMovieId(results.getString("movieId"));
				commentList.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commentList;
	}
	
	//read all comment for username
	public List<Comment> readAllCommentForUsername(String username)
	{
		List<Comment> commentList = new ArrayList<Comment>();
		String sql = "select * from comment where username = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet results = statement.executeQuery();
			if(results.next())
			{
				Comment comment = new Comment();
				comment.setId(results.getString("id"));
				comment.setComment(results.getString("comment"));
				comment.setDate(results.getString("date"));
				comment.setUsername(results.getString("username"));
				comment.setMovieId(results.getString("movieId"));
				commentList.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commentList;
	}

	//read all comment for movie
		public List<Comment> readAllCommentForMoive(String movieId)
		{
			List<Comment> commentList = new ArrayList<Comment>();
			String sql = "select * from comment where movieId = ?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, moiveId);
				ResultSet results = statement.executeQuery();
				if(results.next())
				{
					Comment comment = new Comment();
					comment.setId(results.getString("id"));
					comment.setComment(results.getString("comment"));
					comment.setDate(results.getString("date"));
					comment.setUsername(results.getString("username"));
					comment.setMovieId(results.getString("movieId"));
					commentList.add(comment);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return commentList;
		}
	
	// retrieve a comment by id
	public Comment readCommentForId(String commentId)
	{
		Comment comment = new Comment();
		
		String sql = "select * from comment where id = ?";
		try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, commentId);
				ResultSet result = statement.executeQuery();
				if(result.next())
				{
					comment.setId(results.getString("id"));
					comment.setComment(results.getString("comment"));
					comment.setDate(results.getString("date"));
					comment.setUsername(results.getString("username"));
					comment.setMovieId(results.getString("movieId"));
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		return comment;
	}
	
	// update a comment by id
	void updateComment(String commentId, Comment comment)
	{
		String sql = "update cast set comment=?, date=?, username=?, movieId=? where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, comment.getComment());
			statement.setDate(2, comment.getDate());
			statement.setString(3, comment.getUsername());
			statement.setString(4, comment.getMovieId());
			statement.setString(5, commentId);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return comment;
	}
	
	// delete a comment by id
	public int deleteComment(String commentId)
	{
		String sql = "delete from cast where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, commentId);
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
