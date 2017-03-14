
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DAO;
import com.models.Employee;

public class AddEmp extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			DAO objDAO = new DAO();
			objDAO.connect();

			Employee e1 = new Employee();
			e1.name = request.getParameter("name");
			e1.departmentID = Integer.parseInt(request.getParameter("departmentID"));
			e1.age = Integer.parseInt(request.getParameter("age"));
			e1.isActive = Integer.parseInt(request.getParameter("isActive"));
			
			int rows = objDAO.insertEmployee(e1);

			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<html>");
			pw.print("<head><title>Employee info</title></head>");
			pw.println("<body>");
			pw.println("<br>");
			if(rows==1){
			 pw.println("<br> Employee inserted Successfully.");
			}else{
				pw.println("<br> Failed to store Employee.");
			}

			
			pw.println("<br>");
			pw.println("<br>");
			pw.println("<a href=\"DatabaseServlet\"> List All Employee </a>");
			pw.println("<br>");
			pw.println("<a href=\"UpdateEmployee.html\"> Update Employee </a>");
			pw.println("<br>");
			pw.println("<a href=\"DeleteEmployee.html\"> Delete Employee </a>");
			pw.println("<br>");
			
			pw.println("</body>");
			pw.println("</html>");
			pw.close();
			objDAO.closeConnection();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
