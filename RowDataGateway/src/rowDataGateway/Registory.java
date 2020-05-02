package rowDataGateway;

import java.util.HashMap;
import java.util.Map;

public class Registory {

	
	private static final Map registory = new HashMap();
	
	public static synchronized PersonGateway  getPerson(final int id)
	{
		PersonGateway result = null;
		if (isRegistered(id))
		{
			result = (PersonGateway) registory.get(id);

		}
		return result;
			
	}
	
	public static synchronized void  addPerson(final PersonGateway object)
	{
		registory.put(object.getId(), object);
		
			
	}
	
	public static boolean isRegistered (final int id)
	{
		return registory.containsKey(id);
	}
	
	

	
}
