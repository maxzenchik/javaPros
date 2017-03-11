package parker;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
@ComponentScan
public class ParkerManager extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
		//	ÑÒÐÀÍÈÖÀ ÏÎßÂËßÅÒÑß ÏÐÈ ÀÂÒÎÐÈÇÀÖÈÈ ÌÅÍÅÄÆÅÐÀ. 
		//  ÄÎËÆÍÀ ÂÛÂÎÄÈÒÜÑß ÒÀÁËÈÖÀ Ñ ÏÀÐÊÎÂÎ×ÍÛÌÈ ÌÅÑÒÀÌÈ È ÒÄ
		//	ÄÀÍÍÛÅ ÁÅÐÓÒÑß ÈÇ ÁÀÇÛ 
		String url = "jdbc:mysql://localhost/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    String user = "root";
	    String pass = "dave2302387";
		//String url = "jdbc:sqlserver://localhost:8080/Parking";

		//String user = null;
		//String pass = null;
		//String query = "SELECT TOP 3 * FROM Parking.PLACE"; 
		String query = "SELECT * FROM city WHERE Population > 9000000";
		String result = "result:";
		try {
			 //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {  
				result += rs.getString("Name");
	            //System.out.println(rs.getString("COST_DAY"));
	         }  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 String username = (String) request.getParameter("username");
		 response.getWriter().println("<!DOCTYPE HTML>");
		 response.getWriter().println("<html><body><p> zdarodva " + result + "</p></body></html>");
    }

    /**
      * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // TODO Auto-generated method stub
    	
    	    doGet(request, response);
    	
    }
}
