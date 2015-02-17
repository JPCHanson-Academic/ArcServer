package jan.hanson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class is responsible for connecting to the database, it provides methods for opening
 * and closing a connection as well as executing a query(passed to if by a DBQuery)
 * @author orpheus
 *
 */
public class JDBCQueryConnector
{
	/** container for an sql statement **/
	private Statement sqlStatement;
	/** container for a database session **/
	private Connection dbConnection;
	/** mariaDB driver, change to oracle driver for production **/
	private String driver="org.mariadb.jdbc.Driver";
	/** JDBC url for the database, change to production db **/
	private String URL="jdbc:mysql://localhost:3306/testdb";
	/** DB user **/
	private String user="root";
	/** DB user's password **/
	private String Passwd = "b4b00n6.63e-34{}[]";
	
	/**
	 * opens a connection to the database specified by the constants driver,URL,user,Passwd
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void openDBConnection()
	{
		try {Class.forName(driver);} 
		catch (ClassNotFoundException DRIVER) {DRIVER.printStackTrace();}
		
		try 
		{
		dbConnection = DriverManager.getConnection(URL, user, Passwd);
		sqlStatement = dbConnection.createStatement(); 		
		}
		catch (SQLException SQL) {SQL.printStackTrace();}
	}
	
	/**
	 * closes the connection to the database
	 * @throws SQLException
	 */
	public void closeDBConnection()
	{
		try {dbConnection.close();} 
		catch (SQLException e) {e.printStackTrace();}
	}
	
	/**
	 * this method is passed in a string representing an SQL statement. This statement is
	 * then executed and the resulting ResultSet is returned to the caller.
	 * 
	 * @param SQL String representing an SQL statement.
	 * 
	 * @return ResultSet containing the result of the query(if succesful). Otherwise returns
	 * 			a null value.
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String SQL) 
	{
		try {return sqlStatement.executeQuery(SQL);} 
		catch (SQLException e) {e.printStackTrace();}
		return null;
	}
}