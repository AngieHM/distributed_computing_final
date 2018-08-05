/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function sendRegister(){
    var firstname = $("#firstname").val();
    var lastname = $("#lastname").val();
    var username = $("#username").val();
    var password = $("#password").val();
    
    var romance;
    var comedy;
    var action;
    var thriller;
    
    if (document.getElementById('romance').checked) {
 
        romance = document.getElementById('romance').value;
        
        console.log(romance);
    }
    if (document.getElementById('comedy').checked) {
 
        comedy = document.getElementById('comedy').value;
    }
    if (document.getElementById('action').checked) {
 
        action = document.getElementById('action').value;
    }
    if (document.getElementById('thriller').checked) {
 
        action = document.getElementById('thriller').value;
    }
 

    //Calling servlet
    $.post("RegisterController",
    {
        
        firstname : firstname,
        lastname : lastname,
        username : username,
        password : password,
        romance : romance,
        comedy: comedy,
        action : action,
        thriller: thriller
        
        
    }, //It is not useful since we are computing values locally. However, it shows that we can receive the response from server. 
    function(data, status){
        if (status === "success"){
            console.log(username);

        }

    });
    //do some stuff
}
