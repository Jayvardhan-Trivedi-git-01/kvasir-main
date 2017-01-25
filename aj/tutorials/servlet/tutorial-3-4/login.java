
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	
	public static Boolean isValidUser(String name, String pass){
		 if(pass.equals("admin") && name.equals("admin")){  
			 return true;
		 }
		 return false;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String uname=request.getParameter("userName");  
		    String upass=request.getParameter("userPass");  
		          
		    if(login.isValidUser(uname,upass)){  
		        RequestDispatcher rd=request.getRequestDispatcher("SuccessLogin");  
		        rd.forward(request, response);  
		    }  
		    else{  
		        out.print("Sorry UserName/Password is incorrect!");  
		        RequestDispatcher rd=request.getRequestDispatcher("/login.html");  
		        rd.include(request, response);  
		                      
		        }  
		
	}
	

}
