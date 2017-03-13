

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DAO;
import com.models.Employee;


public class UpdateEmp extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			DAO objDAO = new DAO();
			objDAO.connect();

			Employee e1 = new Employee();
			e1.name = request.getParameter("name");
			e1.departmentID = Integer.parseInt(request.getParameter("departmentID"));
			e1.age = Integer.parseInt(request.getParameter("age"));
			e1.isActive = Integer.parseInt(request.getParameter("isActive"));
			e1.id = Integer.parseInt(request.getParameter("ID"));
			

			int rowsAffected = objDAO.updateEmployee(e1);

			
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<html>");
			pw.print("<head><title>Employee info</title></head>");
			pw.println("<body>");
			pw.println("<br>");
			if(rowsAffected==1){
			 pw.println("<br> Employee Updated Successfully.");
			}else{
				pw.println("<br> Failed to update Employee.");
			}

			
			pw.println("<br>");
			pw.println("<br>");
			pw.println("<a href=\"AddEmployee.html\"> Add Employee </a>");
			pw.println("<br>");
			pw.println("<a href=\"DatabaseServlet\"> List All Employee </a>");
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
