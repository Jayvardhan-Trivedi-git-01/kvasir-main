
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DAO;
import com.models.Employee;

public class ScrollableRS extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			DAO objDAO = new DAO();
			objDAO.connect();
		
			ResultSet rs = objDAO.getAllData_Employee_scrollable();

			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<html>");
			pw.print("<head><title>Employee info</title></head>");
			pw.println("<body>");
			pw.println("Data retrived from db is : <br>");
			
			pw.println("Reading from Last Row : <br>");
			rs.afterLast();
			while(rs.previous())
			{
			
				pw.println(" ID :  "+  rs.getInt("idemployee"));
				pw.println(",name :  "+  rs.getString("employee_name"));
				pw.println(",age :  "+  rs.getInt("employee_age"));
				pw.println(",department :  "+ rs.getInt("employee_department"));
				pw.println(",isactive :  "+  rs.getInt("employee_isactive"));
				pw.println("<br>------------<br>");
				
			}
			
			pw.println("Getting 5th row <br>");
			rs.absolute(5);
			pw.println(" ID :  "+  rs.getInt("idemployee"));
			pw.println(",name :  "+  rs.getString("employee_name"));
			pw.println(",age :  "+  rs.getInt("employee_age"));
			pw.println(",department :  "+ rs.getInt("employee_department"));
			pw.println(",isactive :  "+  rs.getInt("employee_isactive"));
			pw.println("<br>------------<br>");
			
			
			pw.println("Relative (-2) row : <br>");
			rs.relative(-2);
			
			pw.println(" ID :  "+  rs.getInt("idemployee"));
			pw.println(",name :  "+  rs.getString("employee_name"));
			pw.println(",age :  "+  rs.getInt("employee_age"));
			pw.println(",department :  "+ rs.getInt("employee_department"));
			pw.println(",isactive :  "+  rs.getInt("employee_isactive"));
			pw.println("<br>------------<br>");
			
			pw.println("Getting the current row position : " + rs.getRow() + " <br>");
			
			
			
			pw.println("<a href=\"AddEmployee.html\"> Add Employee </a>");
			pw.println("<br>");
			pw.println("<a href=\"UpdateEmployee.html\"> Update Employee </a>");
			pw.println("<br>");
			pw.println("<a href=\"DeleteEmployee.html\"> Delete Employee </a>");
			pw.println("<br>");
			pw.println("<a href=\"ViewEmployee.html\"> View Employee </a>");
			pw.println("<br>");
			pw.println("<a href=\"ShowMetaDataRS\"> View Meta Data </a>");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
