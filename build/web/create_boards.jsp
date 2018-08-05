<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Create boards</title>
        <meta http-equiv = "Content-Type" content = "text/html; charset=utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
        <script src="js/submitBoard.js"></script>
    </head>
    <body>
        <%
        if(session.getAttribute("user")==null){
            response.sendRedirect("login.jsp");
        }
        
        %>
        <center>
            <div class="jumbotron text-center">
                <form id="form2" action= "BoardServlet" method="post" enctype="multipart/form-data">
                    <label for="num1"><b>Board title</b></label>
                    <input id="title" type="text" name="title" value="Board title"><br><br>
                    <label for="num1"><b>Categorie</b></label>
                    <div id="radioDiv">
                        <label for="num1"><b>Romance</b></label>
                        <input id="romance" type="radio" name="categorie" value="romance"><br><br>
                        <label for="num1"><b>Comedy</b></label>
                        <input id="comedy" type="radio" name="categorie" value="comedy"><br><br>
                        <label for="num1"><b>Action</b></label>
                        <input id="action" type="radio" name="categorie" value="action"><br><br>
                        <label for="num1"><b>Thriller</b></label>
                        <input id="thriller" type="radio" name="categorie" value="thriller"><br><br>
                    </div>
                    <label for="num1"><b>Upload image</b></label>
                    <input id="file" type="file" name ="file"><br><br>
                    <input id="submitB" type="submit" value="Create" class="btn btn-primary" onclick="">
                    </div>
                </form>
            </div>
    </body>
</html>