/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function submitBoard(){
    var selectedVal = "";
    var selected = $("#radioDiv input[type='radio']:checked");
    if(selected.length > 0){
        var original_value = selected.val();
        selected.val(original_value+'checked');
        console.log(selected.val());
    }
 
}


