package jan.hanson;

/**
 * essentially just an error message for when a 'GET' parameter from the servlet cannot
 * be matched to a DBQuery.
 * @author orpheus
 *
 */
public class QueryError implements DBQuery 
{
	/**
	 * returns an error message
	 */
	@Override
	public String getFormattedResults() 
	{
		return "ERROR: no valid query found";
	}
	
	/**
	 * empty
	 */
	@Override
	public void executeQuery() {}
}
