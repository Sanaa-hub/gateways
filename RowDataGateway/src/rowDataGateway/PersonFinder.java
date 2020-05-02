package rowDataGateway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonFinder {
	
	private String DbName="Person";
	private Connection myConn=null;
	private Statement myState= null;
	private ResultSet myRs = null;

	   public PersonFinder() {

		try
		{
			myConn=DriverManager.getConnection(  
					"jdbc:mysql://localhost:444/Person","root","");   
						
		}
		
		catch(Exception ex)
		{ 
			System.out.println(ex);
		}  
		}

	   private final static String findStatementString =
		         "SELECT id, firstname, lastname" +
		         "  from Person " +
		         "  WHERE id = ?";
	  
		   public  PersonGateway find(int id) {
			   
		      PersonGateway result = (PersonGateway) Registory.getPerson(id);
		      if (result != null) return result;
		      PreparedStatement findStatement = null;
		      ResultSet rs = null;
		      try {
		         findStatement =  myConn.prepareStatement(findStatementString);
		         findStatement.setInt(1,id);
		         rs = findStatement.executeQuery();
		         rs.next();
		         result = PersonGateway.load(rs);
		         return result;
		      } catch (SQLException e) 
		      {
		    	  System.out.println(e);
		      }
		      return null;
		      
		   }
		   
		   public  PersonGateway find(long id) {
			   return find(new Long(id));
		   }

		   
			  private final static String findResponsibleStatement =
				         "SELECT id, firstname, lastname" +
				         "  from Person " +
				         "  WHERE id > 0";
			  
				   public  List findResponsibles() {
					   
					   List result = new ArrayList();
					   PreparedStatement stmt = null;
					   ResultSet rs = null;
					   

				      try {
				    	  stmt =  myConn.prepareStatement(findResponsibleStatement);
				         rs = stmt.executeQuery();
				         while(rs.next())
				         {
					         result.add(PersonGateway.load(rs));

				        	 
				         }
				         
				         return result;
				      } catch (SQLException e) 
				      {
				    	  System.out.println(e);
				      }
				      return null;
				      
				   }
		   
}