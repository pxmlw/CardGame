/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {
    console.log("aaa");
    $("#logIn").click(function () {
        console.log("bbb");
        $.getJSON("api/login/" + $("#username").val() + "/" + $("#password").val())
         .done(function (result)
        {
            console.log(result);
            var obj;
            for(var i in result )
            {
              obj=result[i];}
            if(obj!==null){
            alert("welcome"+obj);
            $.session.set("user",obj);
            location.href = "gamelist.html";
             }
             else {
                 alert("password incorrect!");
             }
        }
               
        ).fail(function () {
            alert("please try again");
        });
    });
});
//function aaa(){
//    console.log("0");
// console.log($("#username").val());
// console.log($("#password").val());
