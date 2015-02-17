package jan.hanson;

/**
 * This class is used by the servlet to provide it with the appropriate query given the 
 * parameter QID provided to the servlet.
 * In order to add a new query to the system one needs to subclass the DBQuery type in the
 * appropriate manner and then add a corresponding entry the switch statement in 
 * this.request().
 * @author orpheus
 *
 */
public class QuerySelector 
{
	/**the query to return. defaults to error value**/
	private DBQuery queryToReturn;
	
	/**
	 * compares the queryID:String to the entries in the switch statement and changes 
	 * queryToReturn:DBQuery to contain the appropriate DBQuery. If no matching DBQuery
	 * exists, it will return its QueryError():DBQuery.
	 * @param queryID
	 * @return DBQuery containing either an error value or a DBQuery matching the queryID
	 */
	public DBQuery request(String queryID)
	{		
		 switch(queryID)
		 {	
		 	case "test":
		 		queryToReturn = new testQuery();
			break;
			 
//			 other queries defined here
		 
		 	default:
		 		queryToReturn = new QueryError();
			break;
		 }

	return queryToReturn;
	}
}