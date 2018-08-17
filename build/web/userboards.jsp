<%-- 
    Document   : userboards
    Created on : 06-août-2018, 21:28:08
    Author     : Angela
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Boards"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
		  integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
		  crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" 
			integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" 
			crossorigin="anonymous">
	</script>
        <link rel="stylesheet" href="css/movies.css">
        <title>My boards</title>
    </head>
    <body>
        <div class="container-fluid boardss">
        </div>
        <div class="container-fluid">
            <div class="row">
                <a href="create_boards.jsp" style="font-size: 100px; width: 100%; background: transparent; text-decoration: none; text-align: center;color: white;">+</a>
            </div>
        </div>
        <div class="container-fluid">
        <div class="row">
        <%
        List<Boards> boards = (List<Boards>)request.getAttribute("eList");
    // do whatever you want with names

        for (int i=0; i<boards.size();i++)
        {
        %>
        <div class="card" style="width: 20rem;">
        <div class="card-body">  

            <form action="ShowServlet" method="post">
                <input type="hidden" name="boardId" id="boardId" value="<%=boards.get(i).getBoardId()%>">
                <button type="submit" class="view"><%=boards.get(i).getTitle()%></button>
            </form>
        </div>
        <div class="card-img-top">
            <img src="images/<%=boards.get(i).getImage()%>">
            <form action="add_tracks.jsp" method="post">
                <input type="hidden" name="boardId" id="boardId" value="<%=boards.get(i).getBoardId()%>">
                <button style="font-size: 50px; width: 100%; background: transparent; color: white;" type="submit" class="view">+</button>
            </form>
            <form action="DeleteBoard" method="post">
                <input type="hidden" name="boardId1" id="boardId1" value="<%=boards.get(i).getBoardId()%>">
                <button style="font-size: 50px; width: 100%; background: transparent; color: white;" type="submit" class="view">-</button>
            </form>
        </div>
        </div>
        <%}%>
        </div>
        </div>
    </body>
</html>
