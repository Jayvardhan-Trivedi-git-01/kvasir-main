
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DAO;
import com.models.Employee;

public class DatabaseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			DAO objDAO = new DAO();
			objDAO.connect();
			List<Employee> listEmp = new LinkedList<Employee>();
			listEmp = objDAO.getAllData_employee();

			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<html>");
			pw.print("<head><title>Employee info</title></head>");
			pw.println("<body>");
			pw.println("Data retrived from db is : <br>");
			for (int i = 0; i < listEmp.size(); i++) {
				pw.println(" ID : " + listEmp.get(i).id);
				pw.println(", Name : " + listEmp.get(i).name);
				pw.println(", Age : " + listEmp.get(i).age);
				pw.println(", Department : " + listEmp.get(i).departmentID);
				pw.println(", isActive : " + listEmp.get(i).isActive);
				pw.println("<br>");
			}
			
			pw.println("<a href=\"AddEmployee.html\"> Add Employee </a>");
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
