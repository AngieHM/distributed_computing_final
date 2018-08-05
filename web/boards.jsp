<%-- 
    Document   : boards
    Created on : 09-juil.-2018, 13:31:00
    Author     : Angela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            session.setAttribute("user",session.getAttribute("user"));
            session.setAttribute("board",session.getAttribute("board")); 
            
        %>
        <p>Hello</p>
    
        <a href="add_tracks.jsp"><p>${title}</p></a>
        <p>${category}</p>
        <img src="${image}" alt="image"/>
        <form action="FollowServlet" method="post">
            <button type="submit">Follow</button>
        </form>
    </body>
</html>
