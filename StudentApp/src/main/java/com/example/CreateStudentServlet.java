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
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        try {
            if (id == null || id.trim().isEmpty() || name == null || name.trim().isEmpty() || email == null || email.trim().isEmpty()) {
                out.println("<p>Error: All fields are required.</p>");
                java.util.Enumeration<String> parameterNames = req.getParameterNames();
                while (parameterNames.hasMoreElements()) {
                    String param = parameterNames.nextElement();
                    out.println("<p>" + param + ": " + req.getParameter(param) + "</p>");
                }}
            // Validate ID only once
            Integer.parseInt(id);

            id = id.trim();
            Integer.parseInt(id);
            Integer.parseInt(id);
        } catch (NumberFormatException e) {
            out.println("<p>Error: ID must be a valid integer.</p>");
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO students (id, name, email) VALUES (?, ?, ?) RETURNING *");
            ps.setInt(1, Integer.parseInt(id));
            ps.setString(2, name);
            ps.setString(3, email);

            Boolean rs = ps.execute();

            if (rs) {
                out.println("<p>Student created successfully!</p>");
            } else {
                out.println("<p>Error creating student.</p>");
            }
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
