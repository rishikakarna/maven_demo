package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.training.dto.Employee;
import com.lti.training.dto.EmployeeDao;
import com.lti.training.service.DatabaseUserService2;

/**
 * Servlet implementation class AddEmployeeServlet
 */
public class AddEmployeeServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeDao dao = new EmployeeDao();
		Employee emp = new Employee();

		emp.setEmpno(Integer.parseInt(request.getParameter("empno")));
		emp.setName(request.getParameter("name"));
		emp.setSalary(Double.parseDouble(request.getParameter("salary")));

		dao.store(emp);

		HttpSession session = request.getSession();
		session.setAttribute("message", "Record added successfully");

		response.sendRedirect("addEmployee.jsp");
	}
}
