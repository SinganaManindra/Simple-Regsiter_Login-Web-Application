package com.controller;

import java.io.IOException;

import com.dao.CurdClass;
import com.model.ModelTest;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get data from JSP form
		String username = request.getParameter("username");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// Set data into model
		ModelTest m = new ModelTest();
		m.setUsername(username);
		m.setFirstname(firstname);
		m.setLastname(lastname);
		m.setEmail(email);
		m.setPassword(password);

		// Call DAO
		CurdClass dao = new CurdClass();
		String status = dao.update(m);

		// Response
		if (status.equals("success")) {
			response.getWriter().println("Update Successful ✅");
			RequestDispatcher rd = request.getRequestDispatcher("DashBoard.jsp");
			rd.forward(request, response);
		} else {
			response.getWriter().println("Update Failed ❌");
			RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);
		}
	}
}