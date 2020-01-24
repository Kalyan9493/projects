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

public class UpdateLeaves extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empId=Integer.parseInt(req.getParameter("empId"));
		int empLeaves=Integer.parseInt(req.getParameter("leaves"));
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","collectionadmin","collectionadmin");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select empleaves from employee where empid= "+empId+";");
			int leaves = 0;
			while(rs.next()) {
				
				leaves=rs.getInt("empleaves");
			}
			
			leaves=leaves+empLeaves;
			String sql="update employee set empleaves= "+leaves+" where empid= "+empId+";";
			st.execute(sql);
			PrintWriter out=resp.getWriter();
			out.print("Updated");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	
		 catch (SQLException e) {
			System.out.println(e);
		}

	}
	

}
