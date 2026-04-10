package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.utility.DBconnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Logincontroller")
public class Logincontroller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Login Controller Called");

        // Get form data
        String username = request.getParameter("UserName"); // match JSP name
        String password = request.getParameter("password");

        try {
            DBconnection db = new DBconnection();
            Connection con = db.getconnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM studentinfo WHERE username=? AND password=?"
            );

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                // ✅ Create session and store user data
                HttpSession session = request.getSession();
                session.setAttribute("username", rs.getString("username"));
                session.setAttribute("firstname", rs.getString("firstname"));
                session.setAttribute("lastname", rs.getString("lastname"));
                session.setAttribute("email", rs.getString("email"));

                // ✅ Redirect to dashboard
                response.sendRedirect("DashBoard.jsp");

            } else {
                // ❌ Invalid login
                response.sendRedirect("Login.jsp?msg=invalid");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}