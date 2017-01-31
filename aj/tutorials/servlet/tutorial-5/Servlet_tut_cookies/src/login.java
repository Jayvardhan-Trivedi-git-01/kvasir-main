
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
 * Servlet implementation class login
 */
public class login extends HttpServlet {

	public static Boolean isValidUser(String name, String pass) {
		if (pass.equals("admin") && name.equals("admin")) {
			return true;
		}
		return false;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Getting the parameters
		String uname = request.getParameter("userName");
		String upass = request.getParameter("userPass");

		Cookie[] ck = request.getCookies();
		if (ck != null) {
			for (int i = 0; i < ck.length; i++) {
				Cookie c = ck[i];

				String name = c.getName();
				String value = c.getValue();
				out.print("<br /> Cookie Name : " + name + "   Cookie Value :" + value);
			}
		} else {
			out.print("<br />No cookies found!");
		}

		// Check if user is valid
		if (login.isValidUser(uname, upass)) {

			Cookie c = new Cookie("user_name", uname);
			c.setMaxAge(60 * 60 * 24);
			response.addCookie(c);

			Cookie c1 = new Cookie("user_right", "admin rights");
			c1.setMaxAge(60 * 60 * 24);
			response.addCookie(c1);

			RequestDispatcher rd = request.getRequestDispatcher("SuccessLogin");
			rd.forward(request, response); // Forward if OK
		} else {
			out.print("Sorry UserName/Password is incorrect!");
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			rd.include(request, response); // Include Login page if not OK

		}

	}

}
