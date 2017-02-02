
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthFilter implements Filter {
	
	public static Boolean isValidUser(String name, String pass) {
		if (pass.equals("admin") && name.equals("admin")) {
			return true;
		}
		return false;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();

		// Getting the parameters
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		
		if (AuthFilter.isValidUser(uname, upass)) {
			chain.doFilter(request, response);

		} else {
			out.print("Username/Password is invalid. Please try again!");
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void destroy() {
		
	}

}
