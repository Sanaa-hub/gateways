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
		         findStatement =  myConn.prepareStatement("Select * from Users where username= ?");
		         findStatement.setString("Bill_G");
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
		statement.setString(1, "secretPassword");
		statement.setString(2, "Bill Gates");
	    	statement.setString(3, "billgates@gmail.com"); 
		
		
	
	    	 
	    	int rowsUpdated = statement.executeUpdate();
	    	if (rowsUpdated > 0) {
	    	    System.out.println("An existing user was updated successfully!");
	    	}
	    
	    
	    }
	    public void insert(int id, String firstName, String lastName) throws SQLException{

	    	String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
	    	 
	    	PreparedStatement statement = myConn.prepareStatement(sql);
	    	statement.setString(1, "Bill_G");
	    	statement.setString(2, "secretPassword");
		statement.setString(3, "Bill Gates");
		statement.setString(4, "billgates@gmail.com");    
	    	 
	    	int rowsInserted = statement.executeUpdate();
	    	if (rowsInserted > 0) {
	    	    System.out.println("A new user was inserted successfully!");
	    	}


	    }
	    public void delete(int id) throws SQLException{

	    	String sql = "DELETE FROM Users WHERE username=?";
	    	 
	    	PreparedStatement statement = myConn.prepareStatement(sql);
	    	statement.setString("Bill_G");
	    	 
	    	int rowsDeleted = statement.executeUpdate();
	    	if (rowsDeleted > 0) {
	    	    System.out.println("A user was deleted successfully!");
	    	}

	    }

}
