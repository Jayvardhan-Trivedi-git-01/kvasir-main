
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadFileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext ctx = getServletContext();

		String myFile = ctx.getRealPath("jay.txt");
		BufferedReader br = new BufferedReader(new FileReader(myFile));
		StringBuilder sb = new StringBuilder();
		String line = "";
		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}

		br.close();
		response.setContentType("text/html");// SET CONTENT TYPE
		PrintWriter pw = response.getWriter(); // GET THE STREAM TO WRITE DATA
												// INTO RESPONSE

		// WRITE HTML
		pw.println("<html><body><br>");
		pw.println("Here's the data from text file :");
		pw.println(sb.toString());
		pw.println("</body></html>");

		pw.close();// closing the stream

	}

}
