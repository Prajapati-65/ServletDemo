package com.bridgelabz.servlet;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class DatabaseAccess extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String title = "Database Result found :";
		out.print(title);
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			String dburl = "jdbc:mysql://localhost:3306/companyApp?user=root&password=password";
			con =  DriverManager.getConnection(dburl);
			String query = "select * from company";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int regNo = rs.getInt("regno");
				String fName = rs.getString("firstname");
				String lName = rs.getString("lastname");
				System.out.println("Reg.No : " + regNo + "<br>");
				System.out.println("First name : " + fName + "<br>");
				System.out.println("Last name : " + lName);
			}
		} catch (SQLException  e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
