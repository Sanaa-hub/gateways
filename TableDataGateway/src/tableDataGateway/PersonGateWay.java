package tableDataGateway;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonGateWay {
	
	private Connection myConn=null;

	 public ResultSet find(int id){

		   PersonGateWay result = PersonGateWay.getId();
		      if (result != null)
		    	  {return (ResultSet) result;}
		      PreparedStatement findStatement = null;
		      ResultSet rs = null;
		      try {
		         findStatement =  myConn.prepareStatement("Select * from Person whree id = ?");
		         findStatement.setInt(1,id);
		         rs = findStatement.executeQuery();
		         rs.next();
		         result = PersonGateWay.load(rs);
		         return (ResultSet) result;
		      } catch (SQLException e) 
		      {
		    	  System.out.println(e);
		      }
		      return null;
		    
		 
		 
	    }



		public void update(int id, String firstName, String lastName) throws SQLException{

	    
	    	String sql = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";
	    	 
	    	PreparedStatement statement =myConn.prepareStatement(sql);
	    	statement.setInt(1, 9);
	    	statement.setString(2, "William Henry Bill Gates");
	    	statement.setString(3, "my Francklin");
	
	    	 
	    	int rowsUpdated = statement.executeUpdate();
	    	if (rowsUpdated > 0) {
	    	    System.out.println("An existing user was updated successfully!");
	    	}
	    
	    
	    }
	    public void insert(int id, String firstName, String lastName) throws SQLException{

	    	String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
	    	 
	    	PreparedStatement statement = myConn.prepareStatement(sql);
	    	statement.setInt(1, 1);
	    	statement.setString(2, "secretpass");
	    	statement.setString(3, "Bill Gates");
	    	 
	    	int rowsInserted = statement.executeUpdate();
	    	if (rowsInserted > 0) {
	    	    System.out.println("A new user was inserted successfully!");
	    	}


	    }
	    public void delete(int id) throws SQLException{

	    	String sql = "DELETE FROM Users WHERE id=?";
	    	 
	    	PreparedStatement statement = myConn.prepareStatement(sql);
	    	statement.setInt(1, 1);
	    	 
	    	int rowsDeleted = statement.executeUpdate();
	    	if (rowsDeleted > 0) {
	    	    System.out.println("A user was deleted successfully!");
	    	}

	    }

}
