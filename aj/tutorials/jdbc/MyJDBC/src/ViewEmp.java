

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DAO;
import com.models.Employee;

public class ViewEmp extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			DAO objDAO = new DAO();
			objDAO.connect();

			Employee e = new Employee();
			e.id = Integer.parseInt(request.getParameter("EmpID"));
			 
			
			e = objDAO.getEmployeeBasedOnID_call(e);

			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<html>");
			pw.print("<head><title>Employee info</title></head>");
			pw.println("<body>");
			pw.println("Data retrived from db is : <br>");
			
				pw.println(" ID : " + e.id);
				pw.println(", Name : " + e.name);
				pw.println(", Age : " + e.age);
				pw.println(", Department : " + e.departmentID);
				pw.println(", isActive : " + e.isActive);
				pw.println("<br>");
			
			
			pw.println("<a href=\"AddEmployee.html\"> Add Employee </a>");
			pw.println("<br>");
			pw.println("<a href=\"UpdateEmployee.html\"> Update Employee </a>");
			pw.println("<br>");
			pw.println("<a href=\"DeleteEmployee.html\"> Delete Employee </a>");
			pw.println("<br>");

			pw.println("<a href=\"DatabaseServlet\"> List All Employee </a>");
			pw.println("<br>");
			
			pw.println("<a href=\"ScrollableRS\"> Scrollable RS </a>");
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
