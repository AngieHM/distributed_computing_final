<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Register</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
        <script src="js/sendRegister.js"></script>
    </head>
    <body>
        <center>
            <div class="jumbotron text-center">
                <form id="form1" action="post">
                    <label for="num1"><b>First name</b></label>
                    <input id="firstname" type="text" name ="firstname" value="0"><br><br>
                    <label for="num1"><b>Last name</b></label>
                    <input id="lastname" type="text" name ="lastname" value="0"><br><br>
                    <label for = "num2"><b>Username</b></label>
                    <input id="username" type="text" name ="username" value="0"><br><br>
                    <label for = "num2"><b>Password</b></label>
                    <input id="password" type="text" name ="password" value="0"><br><br>
                    <div class="form-check">
                        <input type="checkbox" class="form-check-input" id="romance" value="romance">
                        <label class="form-check-label" for="exampleCheck1">Romance</label>
                        <input type="checkbox" class="form-check-input" id="comedy" value="comedy">
                        <label class="form-check-label" for="exampleCheck1">Comedy</label>
                        <input type="checkbox" class="form-check-input" id="action" value="action">
                        <label class="form-check-label" for="exampleCheck1">Action</label>
                        <input type="checkbox" class="form-check-input" id="thriller" value="thriller">
                        <label class="form-check-label" for="exampleCheck1">Thriller</label>
                    </div>
                </form>
            </div>
            <input id="submit" type="submit" value="submit" class="btn btn-primary" onclick="sendRegister()">
    </body>
</html>