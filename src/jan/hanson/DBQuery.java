package jan.hanson;

/**
 * The interface to which all queries must implement. currently only supports queries
 * that DO NOT modify the database.
 * in order to add new queries to the system, this class should be subtyped.
 * @author orpheus
 *
 */
public interface DBQuery 
{	
	/**
	 * This method formats the results of the results returned by executeQuery() as a
	 * and stores it in private variable formattedResults:String. It then returns 
	 * this String.
	 * @return String containing formatted results.
	 */
	public String getFormattedResults();
	
	/**
	 * executes the query stored in the private variable SQLstatement:String and stores
	 * it in the private variable rawResults:ResultSet.
	 * This method should not change much from query to query.
	 */
	public void executeQuery();
}