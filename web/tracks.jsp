<%-- 
    Document   : tracks
    Created on : 15-juil.-2018, 22:14:34
    Author     : Angela
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Tracks"%>
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
        <title>Welcome</title>
    </head>
    <body>
        <div class="container-fluid tracks">
        </div>
        <div class="container-fluid">
        <%
        List<Tracks> tracks = (List<Tracks>)request.getAttribute("eList");
        if(tracks .isEmpty()){
        %>
            <p style="color:white;">No tracks added yet</p>
            
        <%
        }
        else
        {
        
    // do whatever you want with names
        String title = tracks.get(0).getTitle();
        for (int i=0; i<tracks.size();i++)
        {
        %>
        <div class="col-md-3">
            <p width="119"><%=tracks.get(i).getTitle()%></p>
            <audio controls>
                <source src="tracks/<%=tracks.get(i).getLinkp()%>" type="audio/mpeg">
            </audio>
            <form action="DeleteTrack" method="post">
                <input type="hidden" name="trackId" id="trackId" value="<%=tracks.get(i).getTrackId()%>">
                <button style="font-size: 50px; width: 100%; background: transparent; color: white;" type="submit" class="view">-</button>
            </form>
        </div>
        <%}}%>
        </div>
    </body>
</html>
