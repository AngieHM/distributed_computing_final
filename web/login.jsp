<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Login</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
        <script src="js/sendRegister.js"></script>
        <link rel="stylesheet" href="css/main.css" >
    </head>
    <body class="register">
        <center>
            <div class="jumbotron text-center">
                <form id="form1" action="LoginServlet" method="post">
                    <div class="input_fields" style="width:50%; padding-bottom: 30px;">
                        <img src="pics/logo.png" style="width:70px; margin-bottom: 2px"><br>
                        <label for = "num2">Username</label><br>
                        <input id="username" type="text" name ="username"><br><br>
                        <label for = "num2">Email</label><br>
                        <input id="email" type="text" name="email"><br><br>
                        <input style="padding: 1rem ;background: #256F5B;" id="submit" type="submit" value="Login" class="btn btn-primary"><br><br>
                        <a href="googleSign.jsp" style="padding: 1rem 5.6rem; border-radius:.25rem; background: #256F5B; text-align: center; color: white; text-decoration: none; width: 30%;">Google Signin</a><br><br><br>
                        <a href="index.jsp" style="padding: 1rem 7rem; border-radius:.25rem; background: #256F5B; text-align: center; color: white; text-decoration: none; width: 30%;">Register</a>
                    </div>
                    </div>
                </form>
            </div>
    </body>
</html>