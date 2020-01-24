package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeDetails extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("empid"));
		try {
			resp.setContentType("text/html");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","collectionadmin","collectionadmin");
			Statement st=con.createStatement();
			String sql="select * from employee where empid='"+id+"';";
			ResultSet rs=st.executeQuery(sql);
			PrintWriter out = resp.getWriter();
			out.print("<html><body><table border='1'><tr><td>Employee Id</td><td>Employee Name</td><td>No Of Leaves</td>");
			while(rs.next()) {
				int empId=rs.getInt("empid");
				String empName=rs.getString("empname");
				int empLeaves=rs.getInt("empleaves");
				
				
				out.print("<tr><td>"+empId+"</td><td>"+empName+"</td><td>"+empLeaves+"</td><td>");
				
			}
			out.print("</table></body></html>");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
