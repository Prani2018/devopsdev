package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UserServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private List<String> users = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialize with some sample users
        users.add("John Doe");
        users.add("Jane Smith");
        users.add("Bob Johnson");
        System.out.println("UserServlet initialized with " + users.size() + " users");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User Management</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 50px; }");
            out.println("h1 { color: #333; }");
            out.println("table { border-collapse: collapse; width: 100%; margin: 20px 0; }");
            out.println("th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }");
            out.println("th { background-color: #f2f2f2; }");
            out.println("form { margin: 20px 0; }");
            out.println("input[type='text'] { padding: 8px; margin: 5px; }");
            out.println("input[type='submit'] { padding: 8px 16px; background-color: #007cba; color: white; border: none; cursor: pointer; }");
            out.println("input[type='submit']:hover { background-color: #005a87; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>User Management System</h1>");
            
            // Add user form
            out.println("<form method='post' action='user'>");
            out.println("<h3>Add New User</h3>");
            out.println("<input type='text' name='username' placeholder='Enter username' required>");
            out.println("<input type='submit' value='Add User'>");
            out.println("</form>");
            
            // Display users
            out.println("<h3>Current Users (" + users.size() + ")</h3>");
            if (users.isEmpty()) {
                out.println("<p>No users found.</p>");
            } else {
                out.println("<table>");
                out.println("<tr><th>ID</th><th>Username</th></tr>");
                for (int i = 0; i < users.size(); i++) {
                    out.println("<tr>");
                    out.println("<td>" + (i + 1) + "</td>");
                    out.println("<td>" + users.get(i) + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            }
            
            out.println("<p><a href='index.jsp'>Back to Home</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        if (username != null && !username.trim().isEmpty()) {
            users.add(username.trim());
            System.out.println("Added new user: " + username);
        }
        
        // Redirect back to GET to show updated list
        response.sendRedirect("user");
    }
}
