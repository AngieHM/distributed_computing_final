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
        <link rel="stylesheet" href="css/main.css" >
    </head>
    <body>
        <div class="container-fluid settings">
        </div>
        <center>
            <div class="jumbotron text-center">
                <form id="form1" action="post">
             
                    <div class="input_fields">
                        <img src="pics/logo.png" style="width:70px; margin-bottom: 2px"><br>
                        <label for="num1">First name</label><br>
                        <input id="firstname" type="text" name ="firstname" placeholder = "First name" value=""><br><br>
                        <label for="num1">Last name</label><br>
                        <input id="lastname" type="text" name ="lastname" placeholder= "Last name" value=""><br><br>
                        <label for = "num2">Username</label><br>
                        <input id="username" type="text" name ="username" placeholder="username" value=""><br><br>
                        <label for = "num2">Email</label><br>
                        <input id="email" type="email" name ="email" placeholder="Email" value=""><br><br>
                    </div>
                </form>
                <input id="submit" type="submit" value="Submit" class="submit" class="btn btn-primary" onclick="sendChange()">
            </div>
    <script>
        function sendChange(){
        var firstname = $("#firstname").val();
        var lastname = $("#lastname").val();
        var username = $("#username").val();
        var email = $("#email").val();
        //Calling servlet
        $.post("RegisterChange",
        {

            firstname : firstname,
            lastname : lastname,
            username : username,
            email : email



        }, //It is not useful since we are computing values locally. However, it shows that we can receive the response from server. 
        function(data, status){
            if (status === "success"){
                console.log(username);

            }

        });
        //do some stuff
    }

    </script>
    </body>
</html>