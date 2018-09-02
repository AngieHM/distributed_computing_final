/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    else{
        
        romance = "0";
    }
    if (document.getElementById('comedy').checked) {
 
        comedy = "1";
    }
    else{
        
        comedy = "0";
    }
    if (document.getElementById('action').checked) {
 
        action = "1";
    }
    else{
        
        action = "0";
    }
    if (document.getElementById('thriller').checked) {
 
        thriller = "1";
    }
    else{
        
        thriller = "0";
        
    }
     if (document.getElementById('family').checked) {
 
        family = "1";
    }
    else{
        
        family = "0";
        
    }
     if (document.getElementById('female').checked) {
 
        gender = document.getElementById('female').value;
        
    }
    
    else if (document.getElementById('male').checked) {
 
        gender = document.getElementById('male').value;
        
    }
    //Calling servlet
    if (username === '' || email === '' || firstname === '' ) {
        alert("Please all fileds must be filled");
        console.log("please fill ");
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
