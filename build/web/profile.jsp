<%-- 
    Document   : profile
    Created on : 06-août-2018, 22:12:14
    Author     : Angela
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Logins"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create boards</title>
        <meta http-equiv = "Content-Type" content = "text/html; charset=utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
        <script src="js/submitBoard.js"></script>
        <link rel="stylesheet" href="css/movies.css">
    </head>
    <body>
        <div class="container-fluid profile">
            
        </div>
        <div class="container-fluid">
        <table class="table">
        <thead>
        <tr>
        <%
        List<Logins> login = (List<Logins>)request.getAttribute("eList");

        for (int i=0; i<login.size();i++)
        {
        %>
        
        <td width="119"><p style="color:white;">Date and time</p></td>
        </tr>
        <tbody>
        <tr>
            <td width="119"><p style="color:white;"><%=login.get(i).getDate()%></p></td>
        </tr>
        </tbody>
        <%}%>
        </div>
    </body>
</html>
