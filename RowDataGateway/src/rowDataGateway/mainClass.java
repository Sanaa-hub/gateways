package rowDataGateway;

import java.util.Iterator;

public class mainClass {
	
	public static void main (String[] args)
	{
		System.out.println(findPerson());
	}

	private static String findPerson()
	{
		PersonFinder finder = new PersonFinder(); 
		Iterator Person = finder.findResponsibles().iterator();
		StringBuffer result = new StringBuffer();
		while (Person.hasNext()) {
		   PersonGateway each = (PersonGateway) Person.next();
		   result.append(each.getFirstName());
		   result.append("  ");
		   result.append(each.getLastName());
		   result.append("  ");
		  
	}
	return result.toString();
}
	
}
