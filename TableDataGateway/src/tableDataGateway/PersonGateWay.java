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
		         findStatement =  myConn.prepareStatement("Select * from Person where id= ?");
		         findStatement.setInt(1,1);
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

	    
	    	String sql = "UPDATE Person SET firstName=?, lastname=? WHERE id=?";
	    	 
	    	PreparedStatement statement =myConn.prepareStatement(sql);
		statement.setString(1, "Samia");
		statement.setString(2, "ahmed");
	    	statement.setString(3,1); 
		
		
	
	    	 
	    	int rowsUpdated = statement.executeUpdate();
	    	if (rowsUpdated > 0) {
	    	    System.out.println("An existing person was updated successfully!");
	    	}
	    
	    
	    }
	    public void insert(int id, String firstName, String lastName) throws SQLException{

	    	String sql = "INSERT INTO Person (firstName, lastname) VALUES (?, ?)";
	    	 
	    	PreparedStatement statement = myConn.prepareStatement(sql);
		statement.setString(1, "Bill Gates");
		statement.setString(2, "billgates@gmail.com");    
	    	 
	    	int rowsInserted = statement.executeUpdate();
	    	if (rowsInserted > 0) {
	    	    System.out.println("A new person was inserted successfully!");
	    	}


	    }
	    public void delete(int id) throws SQLException{

	    	String sql = "DELETE FROM Person WHERE id=?";
	    	 
	    	PreparedStatement statement = myConn.prepareStatement(sql);
	    	statement.setInt(1,1);
	    	 
	    	int rowsDeleted = statement.executeUpdate();
	    	if (rowsDeleted > 0) {
	    	    System.out.println("A person was deleted successfully!");
	    	}

	    }

}
