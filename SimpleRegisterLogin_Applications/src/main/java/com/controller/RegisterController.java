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

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {

	String status = "fail";

	private static final long serialVersionUID = 1L;

	public RegisterController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Welcome to Registerservlets");

		// frontend-data assigning to local variable
		String username = request.getParameter("UserName");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("LastName");
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");

		// creating reference object to model-calss
		ModelTest m = new ModelTest();

		// setting data to model
		m.setUsername(username);
		m.setFirstname(firstname);
		m.setLastname(lastname);
		m.setEmail(email);
		m.setPassword(password);

		// creating reference object to DAO-class
		CurdClass md = new CurdClass();

		// Model-class data assigning to CURD-operation methods
		status = md.insert(m);

		if (status.equals("success")) {
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}
}