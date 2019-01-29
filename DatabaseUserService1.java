package com.lti.training.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.lti.training.day7.io.Employee;

//data access object
public class DatabaseUserService1 {

	// public void insert(int empno, String ename, double salary)
	// to insert
	public void add(String username, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null; // precompiled sql statements
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			pstmt = conn.prepareStatement("insert into TBL_USER1 values(?,?)");

			// inserting records into the db

			pstmt.setString(1, username);
			pstmt.setString(2, password);
			// select
			rs = pstmt.executeQuery();

		} catch (Exception e) {
			System.out.println("problem while inserting emp data");
		}

		finally {
			try {
				rs.close();
				pstmt.close();
			} catch (Exception e) {
			}

			try {
				conn.close();
			} catch (Exception e) {	}
		}
	}
}
