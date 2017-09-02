package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class EmployeeInsert {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			String dburl = "jdbc:mysql://localhost:3306/companyApp?user=root&password=password";
			con = DriverManager.getConnection(dburl);
			String query = "insert into empdetails values (7,'Sid','Gharge','ghargesid@gmail.com')";
			stmt = con.createStatement();
			int insert = stmt.executeUpdate(query);
			System.out.println("Affect conut :" + insert);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
