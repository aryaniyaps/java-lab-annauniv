package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String id = req.getParameter("id");

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE id = ?");
            ps.setInt(1, Integer.parseInt(id));
            int rows = ps.executeUpdate();

            if (rows > 0) {
                out.println("<p>Student deleted successfully!</p>");
            } else {
                out.println("<p>Student not found.</p>");
            }
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
