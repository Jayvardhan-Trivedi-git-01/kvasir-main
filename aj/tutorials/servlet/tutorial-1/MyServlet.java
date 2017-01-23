
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");// SET CONTENT TYPE
		PrintWriter pw = response.getWriter(); // GET THE STREAM TO WRITE DATA
												// INTO RESPONSE

		// WRITE HTML
		pw.println("<html><body>");
		pw.println("Welcome to servlet first servlet!");
		pw.println("</body></html>");

		pw.close();// closing the stream
	}

}
