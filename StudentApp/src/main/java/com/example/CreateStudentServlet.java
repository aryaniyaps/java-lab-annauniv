package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createStudent")
public class CreateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO students (id, name, email) VALUES (?, ?, ?)");
            ps.setInt(1, Integer.parseInt(id));
            ps.setString(2, name);
            ps.setString(3, email);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                out.println("<p>Student created successfully!</p>");
            } else {
                out.println("<p>Could not create student.</p>");
            }
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
