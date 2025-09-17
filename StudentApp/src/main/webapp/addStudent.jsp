<%@ page import="java.sql.*" %>
<html>
<body>
<h2>Add Student</h2>
<form action="addStudent.jsp" method="post">
    Name: <input type="text" name="name" /><br/>
    Email: <input type="text" name="email" /><br/>
    <input type="submit" value="Add" />
</form>

<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");

    if (name != null && email != null) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/student_db", 
                "your_pg_username", 
                "your_pg_password"
            );
            PreparedStatement ps = con.prepareStatement("INSERT INTO students (name, email) VALUES (?, ?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.executeUpdate();
            out.println("<p>Student added!</p>");
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
%>
</body>
</html>
