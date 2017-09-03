package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDatails {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/companyApp?user=root&password=password";
			con = DriverManager.getConnection(dburl);
			String query = "select * from company";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int regNo = rs.getInt("regno");
				String fName = rs.getString("firstname");
				String lName = rs.getString("lastname");
				System.out.println("Reg.No : " + regNo);
				System.out.println("First name : " + fName);
				System.out.println("Last name : " + lName);
				System.out.println();
			}
		} catch (SQLException | ClassNotFoundException e) {
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
