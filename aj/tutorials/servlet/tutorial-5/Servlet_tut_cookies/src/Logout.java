
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession s = request.getSession();
		s.invalidate();
		Cookie[] ck = request.getCookies();
		for (int i = 0; i < ck.length; i++) {
			Cookie c = ck[i];

			c.setMaxAge(0);
			out.print("<br /> Deleting Cookie : " + c.getName());
			response.addCookie(c);
		}

		out.print("<br /> You've been logged out successfully!");
	}

}
