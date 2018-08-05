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
        <title>JSP Page</title>
    </head>
    <body>
        <%
    List<Tracks> tracks = (List<Tracks>)request.getAttribute("eList");
    // do whatever you want with names
        String title = tracks.get(0).getTitle();
        for (int i=0; i<tracks.size();i++)
        {
        %>
        <tr>
        <td width="119"><%=tracks.get(i).getTitle()%></td>
        <audio controls>
            <source src="tracks/<%=tracks.get(i).getLinkp()%>" type="audio/mpeg">
        </audio>
        </tr>
        <%}%>
    </body>
</html>
