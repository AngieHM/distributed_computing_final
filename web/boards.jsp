<%-- 
    Document   : boards
    Created on : 09-juil.-2018, 13:31:00
    Author     : Angela
--%>

<%@page import="entity.Boards"%>
<%@page import="java.util.List"%>
<%@page import="entity.Followed"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <title>Welcome</title>
    </head>
    
    <body>
    <div class="container-fluid">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a href="" style="color: #00ebac">Podflix <img src="pics/logo.png" style="width:70px; margin-bottom: 2px"></a><br>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav" style="margin-left: 5%;">
          <ul class="navbar-nav">
            <li class="nav-item active">
              <form action="Profile" method="post">
                    <button type="submit" class="link">Profile</button>
              </form>
            </li>
            <li class="nav-item">
                <%
                String notification = request.getParameter("notif");
            // do whatever you want with names
                if(notification=="true"){
                    %>
                    <script>
                        alert("You have a new notification");
                    </script>
                    <%
                     }
                    %>
              <form action="" method="post">
                    <button type="submit" class="link">Notifications</button>
              </form>
            </li>
            <li class="nav-item">
                <a href="settings.jsp"><button type="submit" class="link">Settings</button></a>
            </li>
            <li class="nav-item">
                <form action="UserFollow" method="post">
                    <button type="submit" class="link">Users</button>
                </form>
            </li>
            <li class="nav-item">
                <form action="UserBoards" method="post">
                    <button type="submit" class="link">My boards</button>
                </form>
            </li>
            <li class="nav-item">
                <form action="MyUsers" method="post">
                    <button type="submit" class="link">My users</button>
                </form>
            </li>
            <li class="nav-item" style="float:right">
              <form action="Logout" method="post">
                    <button type="submit" class="link">Logout</button>
              </form>
            </li>
   
          </ul>
        </div>
        </nav>
    </div>
        
  <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src="pics/got.jpg" alt="First slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="pics/sherlock.jpg" alt="Second slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="pics/pll.png" alt="Third slide">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
        
        
        
 
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    <div class="container-fluid" style="background: #f5f5f5">
    <div class="row" style="text-align: center;">
        <h3 style="text-align: center; margin: 0 auto;">Recommended</h3>
    </div>
    <div class="row">
    
    <%
    List<Boards> catList = (List<Boards>)request.getAttribute("catList");
// do whatever you want with names
    if(catList.isEmpty())
    {%>
    <p style="color:#333;">No recommended boards</p>
    <%
     }
    else{
    for (int i=0; i<catList.size();i++)
    {
    %>

    <div class="card" style="width:18.5rem;">
        <div class="card-img-top">
            <img src="images/<%=catList.get(i).getImage()%>" alt="image"/> 
        </div>
        <div class="card-body">
            <form action="ShowServlet" method="post">
                <input type="hidden" name="boardId" id="boardId" value="<%=catList.get(i).getBoardId()%>">
                <button type="submit" class="view"><%=catList.get(i).getTitle()%></button>
             </form>
             <p><%=catList.get(i).getCategory()%></p>
             <form action="FollowServlet" method="post">
                <button type="submit">Follow</button>
             </form>
        </div>
    </div>
    <%}}%>
    </div>
        
        
        
        
        
        
        
        
        
        
        
        
    <div class="row" style="text-align: center;">
        <h3 style="text-align: center; margin: 0 auto;">Following</h3>
    </div>
    <div class="row">
    
    <%
    List<Followed> followed = (List<Followed>)request.getAttribute("fList");
// do whatever you want with names
    for (int i=0; i<followed.size();i++)
    {
    %>

    <div class="card" style="width:18.5rem;">
        <div class="card-img-top">
            <img src="images/<%=followed.get(i).getBoardid().getImage()%>" alt="image"/> 
        </div>
        <div class="card-body">
            <form action="ShowServlet" method="post">
                <input type="hidden" name="boardId" id="boardId" value="<%=followed.get(i).getBoardid().getBoardId()%>">
                <button type="submit" class="view"><%=followed.get(i).getBoardid().getTitle()%></button>
             </form>
            <form action="UnfollowServlet" method="post">
                <input type="hidden" name="followedId" id="followedId" value="<%=followed.get(i).getFollowedId()%>">
                <button type="submit">Unfollow</button>
            </form>
        </div>
    </div>
    <%}%>
    </div>
    </div>    
    <div class="container-fluid boards">
        <div class="row" style="text-align: center;">
        <h3 style="text-align: center; margin: 0 auto;">All boards</h3>
        </div>
        <div class="row">
        <%
            session.setAttribute("user",session.getAttribute("user"));
            session.setAttribute("board",session.getAttribute("board")); 
            
        %>
        
         <%
        List<Boards> boards = (List<Boards>)request.getAttribute("eList");
    // do whatever you want with names
        for (int i=0; i<boards.size();i++)
        {
        %>
            <div class="card" style="width:18.5rem;">
                <div class="card-img-top">
                   <img src="images/<%=boards.get(i).getImage()%>" alt="image"/> 
                </div>
                <div class="card-body">
                    <form action="ShowServlet" method="post">
                        <input type="hidden" name="boardId" id="boardId" value="<%=boards.get(i).getBoardId()%>">
                        <button type="submit" class="view"><%=boards.get(i).getTitle()%></button>
                    </form>
                    <p><%=boards.get(i).getCategory()%></p>
                    <form action="FollowServlet" method="post">
                    <button type="submit">Follow</button>
                    </form>
                </div>
            </div>
        <%}%>
        </div>
    </div>
    </body>
</html>
