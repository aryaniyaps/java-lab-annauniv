package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/students")
public class ViewStudentsServlet extends GenericServlet {
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<h2>Student List</h2>");
        try (Connection con = DBConnection.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Email</th></tr>");
            while (rs.next()) {
                out.printf("<tr><td>%d</td><td>%s</td><td>%s</td></tr>",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"));
            }
            out.println("</table>");
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
