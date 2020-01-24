package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewEmployee extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		int id=Integer.parseInt(req.getParameter("empId"));
		String name=req.getParameter("empName");
		int leaves=Integer.parseInt(req.getParameter("empLeaves"));
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","collectionadmin","collectionadmin");
			Statement st=con.createStatement();
			String sql="insert into employee values('"+id+"','"+name+"','"+leaves+"');";
			st.execute(sql);
			PrintWriter out= resp.getWriter();
			out.print("Details Saved");
			
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
