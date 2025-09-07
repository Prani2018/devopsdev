package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class HelloServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("HelloServlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            if (name == null || name.trim().isEmpty()) {
                name = "World";
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello Servlet from krishna Sarikonda</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 50px; }");
            out.println("h1 { color: #333; }");
            out.println(".info { background-color: #f0f0f0; padding: 15px; border-radius: 5px; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Greetings from Krishna Sarikonda !!! Hello, " + name + "!</h1>");
            out.println("<div class='info'>");
            out.println("<p><strong>Current Time:</strong> " + new Date() + "</p>");
            out.println("<p><strong>Server Info:</strong> " + getServletContext().getServerInfo() + "</p>");
            out.println("<p><strong>Servlet Name:</strong> " + getServletName() + "</p>");
            out.println("</div>");
            out.println("<p><a href='index.jsp'>Back to Home</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("HelloServlet destroyed");
        super.destroy();
    }
}
