<%-- 
    Document   : profile
    Created on : 06-août-2018, 22:12:14
    Author     : Angela
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="entity.Followers"%>
<%@page import="entity.Users"%>
<%@page import="java.util.List"%>
<%@page import="entity.Logins"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Users</title>
        <meta http-equiv = "Content-Type" content = "text/html; charset=utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
        <script src="js/submitBoard.js"></script>
        <link rel="stylesheet" href="css/movies.css">
    </head>
    <body>
        <div class="container-fluid users">
            
        </div>
        <a href="display_boards.jsp" style="text-decoration: none; text-align:center; background: transparent; color: white; margin-left:60px"><-Back</a>
        <div class="container-fluid">
            <h3 class="f">Followers</h3>
             <%
        List<Users> followers= (ArrayList<Users>)request.getAttribute("followers");
        for (int i=0; i<followers.size();i++)
        {
        %>
        <div class="row row-social">
            <div class="col-md-3">
                <p style="color:#333;"><%=followers.get(i).getFirstname()%></p>
            </div>
            <div class="col-md-3">
                <p style="color:#333;"><%=followers.get(i).getLastname()%></p>
            </div>
            <div class="col-md-3">
                <p style="color:#333;"><%=followers.get(i).getEmail()%></p>
            </div>
            <div class="col-md-3">
               <form action="Block" method="post">
                    <input type="hidden" name = "followerId" id="followerId" value="<%=followers.get(i).getId()%>">
                    <button type="submit" class="link" style="color:white;background:red;">Block</button>
                </form>
            </div>
        </div>
        <%}%>
        </div>
     </body>
 </html>
