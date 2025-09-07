<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sample Java Web App - Krishna Sarikonda </title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        
        .container {
            background: white;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
            padding: 40px;
            text-align: center;
            max-width: 600px;
            width: 90%;
        }
        
        h1 {
            color: #333;
            margin-bottom: 30px;
            font-size: 2.5em;
        }
        
        .subtitle {
            color: #666;
            font-size: 1.2em;
            margin-bottom: 40px;
        }
        
        .nav-links {
            display: flex;
            flex-direction: column;
            gap: 20px;
            margin: 30px 0;
        }
        
        .nav-link {
            display: inline-block;
            padding: 15px 30px;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            text-decoration: none;
            border-radius: 8px;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            font-size: 1.1em;
            font-weight: 500;
        }
        
        .nav-link:hover {
            transform: translateY(-3px);
            box-shadow: 0 8px 25px rgba(0, 0, 0, 0.2);
        }
        
        .form-section {
            background-color: #f8f9fa;
            border-radius: 10px;
            padding: 30px;
            margin-top: 30px;
        }
        
        .form-section h3 {
            color: #333;
            margin-bottom: 20px;
        }
        
        input[type="text"] {
            padding: 12px;
            border: 2px solid #ddd;
            border-radius: 6px;
            font-size: 1em;
            margin: 10px;
            width: 200px;
        }
        
        input[type="submit"] {
            padding: 12px 25px;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 1em;
            margin: 10px;
            transition: transform 0.2s ease;
        }
        
        input[type="submit"]:hover {
            transform: scale(1.05);
        }
        
        .info-section {
            background-color: #e8f4fd;
            border-radius: 10px;
            padding: 20px;
            margin-top: 20px;
        }
        
        .current-time {
            color: #666;
            font-size: 0.9em;
            margin-top: 20px;
        }
        
        @media (max-width: 600px) {
            .container {
                padding: 20px;
            }
            
            h1 {
                font-size: 2em;
            }
            
            .nav-links {
                gap: 15px;
            }
            
            input[type="text"] {
                width: 100%;
                max-width: 250px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>🚀 Sample Java Web App - Krishna Sarikonda</h1>
        <p class="subtitle">Welcome to our Maven-powered web application!</p>
        
        <div class="nav-links">
            <a href="hello" class="nav-link">👋 Hello Servlet</a>
            <a href="user" class="nav-link">👥 User Management</a>
        </div>
        
        <div class="form-section">
            <h3>🎯 Try Hello Servlet with Custom Name</h3>
            <form method="get" action="hello">
                <input type="text" name="name" placeholder="Enter your name" />
                <br>
                <input type="submit" value="Say Hello!" />
            </form>
        </div>
        
        <div class="info-section">
            <h4>📋 Application Information</h4>
            <p><strong>Framework:</strong> Java Servlets & JSP</p>
            <p><strong>Build Tool:</strong> Apache Maven</p>
            <p><strong>Server:</strong> <%= application.getServerInfo() %></p>
        </div>
        
        <div class="current-time">
            <p>🕐 Current server time: <%= new java.util.Date() %></p>
        </div>
    </div>
</body>
</html>
