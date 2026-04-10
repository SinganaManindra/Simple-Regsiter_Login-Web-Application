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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get username from form
		String username = request.getParameter("username");

		// Set into model
		ModelTest m = new ModelTest();
		m.setUsername(username);

		// Call DAO
		CurdClass dao = new CurdClass();
		String status = dao.delete(m);

		// Response
		if (status.equals("success")) {
			response.getWriter().println("Delete Successful ✅");
			RequestDispatcher rd = request.getRequestDispatcher("DashBoard.jsp");
			rd.forward(request, response);
		} else {
			response.getWriter().println("Delete Failed ❌");
			RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
			rd.forward(request, response);
			System.out.println("something worng");
		}
	}
}