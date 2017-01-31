
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SuccessLogin
 */
public class SuccessLogin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("userName");
		out.print("Welcome " + n);

		// SESSION CODE
		HttpSession mySession = request.getSession();
		mySession.setAttribute("uName", n);

		if (mySession.isNew()) {
			out.print("<br /> New Session created...");
		} else {
			out.print("<br /> Reading from session ID : " + mySession.getId());
		}

		String uName = (String) mySession.getAttribute("uName");
		out.print("<br /> User name from session :  " + uName);

		RequestDispatcher rd = request.getRequestDispatcher("/logout1.html");
		rd.include(request, response); // Include Login page if not OK

	}

}
