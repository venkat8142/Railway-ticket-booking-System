package Javaproject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String un=request.getParameter("user");
		String pw=request.getParameter("pass");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/irctc","root","javadB@9");
			PreparedStatement ps=con.prepareStatement("select uname from userdet where uname=? and pass=?");
			ps.setString(1, un);
			ps.setString(2, pw);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				RequestDispatcher rdd=request.getRequestDispatcher("book.jsp");
				rdd.forward(request,response);
			}
			else
			{
				out.println("<font color=red size=18>LOGIN FAILED!WORNG CREDENTIALS</font>");
				RequestDispatcher rd1=request.getRequestDispatcher("login.jsp");
				rd1.include(request,response);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

}
