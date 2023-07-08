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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Signupp
 */
public class Signupp extends HttpServlet {
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
		response.setContentType("text/html");
		
		String name=request.getParameter("user");
		String passw=request.getParameter("pass");
		String doob=request.getParameter("dob");
		String pno=request.getParameter("phone");
		String email=request.getParameter("mail");
		String langua=request.getParameter("lang");
		String gend=request.getParameter("gender");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/irctc","root","javadB@9");
			PreparedStatement ps=con.prepareStatement("insert into userdet values(?,?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, passw);
			ps.setString(3, doob);
			ps.setString(4, pno);
			ps.setString(5, email);
			ps.setString(6, langua);
			ps.setString(7, gend);
			int a=ps.executeUpdate();
			if(a>0) {
				PrintWriter out = new PrintWriter(System.out);
				System.out.println("Registration Successfull");
					RequestDispatcher rdd=request.getRequestDispatcher("/login.jsp");
				rdd.forward(request, response);
				out.print("Registered Successfully");
			}
				
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
