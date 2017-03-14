
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DAO;
import com.models.Employee;

public class DelEmp extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			DAO objDAO = new DAO();
			objDAO.connect();

			Employee e1 = new Employee();

			int delete_ID = Integer.parseInt(request.getParameter("EmpID"));
			e1.id = delete_ID;
			int rows = objDAO.deleteEmployee(e1);

			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<html>");
			pw.print("<head><title>Employee info</title></head>");
			pw.println("<body>");
			pw.println("<br>");
			if (rows == 1) {
				pw.println("<br> Employee Deleted Successfully.");
			} else {
				pw.println("<br> Failed to Delete Employee.");
			}

			
			pw.println("<br>");
			pw.println("<br>");
			pw.println("<a href=\"AddEmployee.html\"> Add Employee </a>");
			pw.println("<br>");
			pw.println("<a href=\"UpdateEmployee.html\"> Update Employee </a>");
			pw.println("<br>");
			pw.println("<a href=\"DatabaseServlet\"> List All Employee </a>");
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
