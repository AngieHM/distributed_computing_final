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
    <body class="register">
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
                        <label for = "num2">Gender</label><br>
                        <div class="radio">
                            <label><input type="radio" name="female" id="female" value="female">Female</label>
                            <label><input type="radio" name="male" id="male" value="male">Male</label>
                        </div>
                    </div>
                    <div class="form-check">
                        <div class="row" class="category">
                            <div class="card" style="width: 15rem;">
                                <div class="card-img-top"><img src="pics/lying.png"></div>
                                <div class="card-body">
                                    <p>Romance</p>
                                    <input type="checkbox" class="form-check-input" id="romance" value="romance">
                                </div>
                                
                            </div>
                            <div class="card" style="width: 15rem;">
                                <div class="card-img-top"><img src="pics/mother.jpg"></div>
                                <div class="card-body">
                                    <p>Comedy</p>
                                    <input type="checkbox" class="form-check-input" id="comedy" value="comedy">
                                </div>
                                
                            </div>
                            <div class="card" style="width: 14rem;">
                                <div class="card-img-top"><img src="pics/got.jpg"</div></div>
                                <div class="card-body">
                                    <p>Action</p>
                                    <input type="checkbox" class="form-check-input" id="action" value="action">
                                </div>
                                
                            </div>
                            <div class="card" style="width: 15rem;">
                                 <div class="card-img-top"><img src="pics/pll.png"></div>
                                <div class="card-body">
                                    <p>Thriller</p>
                                    <input type="checkbox" class="form-check-input" id="thriller" value="thriller">
                                </div>
                               
                            </div>
                        <div class="card" style="width: 15rem;">
                                 <div class="card-img-top"><img src="pics/tangles.jpg"></div>
                                <div class="card-body">
                                    <p>Family</p>
                                    <input type="checkbox" class="form-check-input" id="family" value="family">
                                </div>
                               
                            </div>
                        </div>
    
                    </div>
                </form>
                <input id="submit" type="submit" value="Register" class="submit" class="btn btn-primary" onclick="send()">
            </div>
    <script>
        function send(){
        var firstname = $("#firstname").val();
        var lastname = $("#lastname").val();
        var username = $("#username").val();
        var password = "pass";
        var email = $("#email").val();

        var romance;
        var comedy;
        var action;
        var thriller;
        var gender;
        var family;

        console.log(password);  
        if (document.getElementById('romance').checked) {

            romance = "1";

            console.log(romance);
        }
        else if (document.getElementById('romance').checked===false){

            romance = "0";
        }
        if (document.getElementById('comedy').checked) {

            comedy = "1";
        }
        else if (document.getElementById('comedy').checked===false) {

            comedy = "0";
        }
        if (document.getElementById('action').checked) {

            action = "1";
        }
        else if (document.getElementById('action').checked===false) {

            action = "0";
        }
        if (document.getElementById('thriller').checked) {

            thriller = "1";
        }
        else if (document.getElementById('thriller').checked===false){

            thriller = "0";

        }
         if (document.getElementById('family').checked) {

            family = "1";
        }
        else if (document.getElementById('family').checked===false){

            family = "0";

        }
         if (document.getElementById('female').checked) {

            gender = document.getElementById('female').value;

        }

        else if (document.getElementById('male').checked) {

            gender = document.getElementById('male').value;

        }
        //Calling servlet
        if (username === '' || email === '' || firstname === '' || lastname === '' ) {
        alert("Please all fileds must be filled");
        
        }
        else{
        $.post("RegisterController",
        {

            firstname : firstname,
            lastname : lastname,
            username : username,
            password : password,
            email : email,
            gender : gender,
            romance : romance,
            comedy: comedy,
            action : action,
            thriller: thriller,
            family:family



        }, //It is not useful since we are computing values locally. However, it shows that we can receive the response from server. 
        function(data, status){
            if (status === "success"){
                console.log(username);

            }

        });
        //do some stuff
    }
    }

    </script>
    </body>
</html>