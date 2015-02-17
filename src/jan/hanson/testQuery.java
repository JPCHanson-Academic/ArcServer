package jan.hanson;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This is a test query, it shows the usage of the system. each query should be encoded as 
 * a DBQuery subclass, a new subclass for each new query.
 * @author orpheus
 *
 */
public class testQuery implements DBQuery {
	/** storage medium for the raw results returned by the execution of the query**/
	private ResultSet rawResults;
	/** the results after having been formatted by getFormattedResults()**/
	private String formattedResults="";
	/** representation of the query to be performed**/
	private String SQLstatement="SELECT test1,test2 FROM testTable;";
	
	/**
	 * this being a rather simple query, formats the results as plain text, nothing fancy
	 */
	@Override
	public String getFormattedResults() 
	{
		try 
		{
			while(rawResults.next())
			{
				formattedResults = formattedResults 
									+ "</br>"
									+ rawResults.getInt(1)
									+ " "
									+ rawResults.getString(2);
			}
		} 
		catch (SQLException e) 
		{e.printStackTrace(); formattedResults="something went wrong";}

		return formattedResults;
	}
	
	/**
	 * executes the SQLstatement as a query and stores the resutls in rawResults:ResultSet
	 * this method does not change much between queries.
	 */
	@Override
	public void executeQuery()
	{
		JDBCQueryConnector query = new JDBCQueryConnector();
      
			query.openDBConnection();
			
			rawResults = query.executeQuery(SQLstatement);
			
			query.closeDBConnection();
	}
}
