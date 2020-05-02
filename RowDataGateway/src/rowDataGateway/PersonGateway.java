package rowDataGateway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonGateway {
	
	
	private String DbName="Person";
	private Connection myConn=null;
	private Statement myState= null;
	private ResultSet myRs = null;
	
       private int id;
	   private String firstName;
	   private String lastName;
	   
	   
	   public PersonGateway( int id,String firstName, String lastName) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;

		try
		{
			myConn=DriverManager.getConnection(  
					"jdbc:mysql://localhost:444/Person","root","");   
						
		}
		
		catch(SQLException ex)
		{ 
			System.out.println(ex);
		}  
		}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}






	private static final String updateStatementString =
	         "UPDATE Person " +
	         "  set firstname = ?, lastname = ? " +
	         "  where id = ?";
	
	public void update(int id,String firstName, String lastName) {
		
	
	      PreparedStatement updateStatement = null;
	      try {
	         updateStatement = myConn.prepareStatement(updateStatementString);
	         updateStatement.setString(1, firstName);
             updateStatement.setString(2, lastName);
             updateStatement.setInt(3, id);

             updateStatement.executeUpdate();
	      } catch (Exception e) {
				System.out.println(e);

	      }
	        
	   }
	
	   private static final String insertStatementString =
		         "INSERT INTO Person (firstName, lastName) VALUES (?, ?)";
	   
		   public int insert(String firstName, String lastName) {
		      PreparedStatement insertStatement = null;
		      try {
		         insertStatement = myConn.prepareStatement(insertStatementString);
		         insertStatement.setString(1, firstName);
		         insertStatement.setString(2, lastName);
		         int id = insertStatement.executeUpdate();
		        
		      }
		      catch (Exception e) 
		      {
		         
					System.out.println(e);
		      }
		      return  0;
		   }
	
	
	
		      public static PersonGateway load(ResultSet rs) throws SQLException {
		          int id = new Integer(rs.getInt(1));
		          
		          
		          PersonGateway result =Registory.getPerson(id);
		          if (result != null) 
		        	  {
		        	  return result;
		        	  }
		          String lastNameArg = rs.getString(2);
		          String firstNameArg = rs.getString(1);
		          result = new PersonGateway(id,firstNameArg, lastNameArg);
		          Registory.addPerson(result);
		          return result;
		    }
	
	
	
	
	
	
	
	
	

}
