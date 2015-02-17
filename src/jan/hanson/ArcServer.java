package jan.hanson;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * This is the Servlet class, it is responsible for handling the HTTP requests/responses and
 * provides methods to access this. At the moment only doGet:void is implemented properly.
 * @author orpheus
 *
 */
@SuppressWarnings("serial")
public class ArcServer extends HttpServlet
{
	/** conatiner for the QID parameter**/
	private String queryID;
	/** container for the query to be run**/
	private DBQuery query;
	/** query selector, choses appropriate query,given parameter 'QID'**/
	private QuerySelector querySelector;
	
	/**
	 * default ctor initialises the query selector
	 */
	public ArcServer()
	{
		querySelector = new QuerySelector();
	}
	
	/**
	 * this method is responsible for taking the parameter 'QID' submitted in the 'GET'
	 * request, passing it to the query selector which then in turn passes back the 
	 * appropriate query(stored in -query:DBQuery). The query is then executed and the 
	 * formatted results added to the response content.
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        queryID = req.getParameter("QID");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println(queryID);
        
        query = querySelector.request(queryID);
        query.executeQuery();
        out.println(query.getFormattedResults());
        
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        String field = req.getParameter("field");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("You entered \"" + field + "\" into the text box.");
        out.println("</body>");
        out.println("</html>");
    }
}