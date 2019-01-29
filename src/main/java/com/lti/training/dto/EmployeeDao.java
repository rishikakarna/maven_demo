package com.lti.training.dto;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.lti.training.dto.*;

//data access object
public class EmployeeDao {

	// public void insert(int empno, String ename, double salary)
	// to insert
	public void store(Employee emp) {
		Connection conn = null;
		PreparedStatement pstmt = null; // precompiled sql statements
		try {
			//why not FileInputStream is = new FileInputStream("dev-db.properties")
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("dev-db.properties");
			Properties dbProps = new Properties();
			dbProps.load(is);
			String driverClassName = dbProps.getProperty("driverClassName");
			String url = dbProps.getProperty("url");
			String username = dbProps.getProperty("username");
			String password = dbProps.getProperty("password");

			// using properties of dev-db.properties
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);

			pstmt = conn.prepareStatement("insert into TBL_EMP values(?,?,?)");
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getName());
			pstmt.setDouble(3, emp.getSalary());
			pstmt.executeUpdate(); // any dml command
		} catch (Exception e) {
			System.out.println("problem while inserting emp data");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}
}
