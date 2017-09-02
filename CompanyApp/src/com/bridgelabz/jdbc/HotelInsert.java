package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Driver;

public class HotelInsert {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			String dburl = "jdbc:mysql://localhost:3306/companyApp?user=root&password=password";
			con = DriverManager.getConnection(dburl);
			String query = " insert into hotel values (?,?,?,?)";
			pstmt = con.prepareStatement(query);
			String regno = args[0];
			String name = args[1];
			String address = args[2];
			String type = args[3];
			int regNumber = Integer.parseInt(regno);
			pstmt.setInt(1, regNumber);
			pstmt.setString(2, name);
			pstmt.setString(3, address);
			pstmt.setString(4, type);
			pstmt.executeUpdate();
			System.out.println("Insert :");
			System.out.println("Reg no. " + regNumber);
			System.out.println("Hotel name :" + name);
			System.out.println("Hotel Address :" + address);
			System.out.println("Hotel type :" + type);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
