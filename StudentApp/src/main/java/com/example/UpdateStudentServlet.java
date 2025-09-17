package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE students SET name=?, email=? WHERE id=?");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, Integer.parseInt(id));

            int rows = ps.executeUpdate();
            if (rows > 0) {
                out.println("<p>Student updated successfully!</p>");
            } else {
                out.println("<p>No student found.</p>");
            }
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
