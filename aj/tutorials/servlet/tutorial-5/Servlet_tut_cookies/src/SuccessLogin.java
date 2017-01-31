
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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

		// String n = request.getParameter("userName");
		// out.print("Welcome " + n);

		Cookie[] ck = request.getCookies();
		for (int i = 0; i < ck.length; i++) {
			Cookie c = ck[i];

			String name = c.getName();
			String value = c.getValue();
			out.print("<br /> Cookie Name : " + name + "   Cookie Value :" + value);
		}

		RequestDispatcher rd = request.getRequestDispatcher("/logout1.html");
		rd.include(request, response); 

	}

}
