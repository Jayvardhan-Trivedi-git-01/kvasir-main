
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSetMetaData;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DAO;
import com.models.Employee;

public class ShowMetaDataRS extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			DAO objDAO = new DAO();
			objDAO.connect();
			ResultSetMetaData resultMeta = objDAO.getAllData_employee_resultsetmeta();

			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<html>");
			pw.print("<head><title>Employee info</title></head>");
			pw.println("<body>");
			pw.println("metaData are : <br>");

			pw.println("Table Name : " + resultMeta.getTableName(1) + "<br>");

			
			pw.println("Column Count: "+resultMeta.getColumnCount() + "<br>");
			
			pw.println("Column details : <br>");

			pw.println("<br> ---------------- <br>");
			for(int i=1; i<= resultMeta.getColumnCount(); i++){
			
				pw.println("Column Name "+resultMeta.getColumnName(i));  
				pw.println("<br>Column Type "+resultMeta.getColumnTypeName(i));  
				pw.println("<br> ---------------- <br>");
			}			
			
			pw.println("<a href=\"AddEmployee.html\"> Add Employee </a>");
			pw.println("<br>");
			pw.println("<a href=\"UpdateEmployee.html\"> Update Employee </a>");
			pw.println("<br>");
			pw.println("<a href=\"DeleteEmployee.html\"> Delete Employee </a>");
			pw.println("<br>");
			pw.println("<a href=\"ViewEmployee.html\"> View Employee </a>");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
