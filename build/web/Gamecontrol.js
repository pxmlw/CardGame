/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    console.log("000");
    var model = Handlebars.compile($("#table-template").html());
    $.getJSON("api/GameList/showGamelist").done(function (result) {
        console.log($.session.get("user"));
        console.log("111");
        var t = JSON.parse(JSON.stringify(result));
        console.log("> t = " + t + ", type " + (typeof t));
        console.log("result = " + (typeof result))
        console.log(t);
        for(var i=0;i<result.length;i++)
        {
            console.log("444:" + JSON.stringify(result[i]));
            var data = {
                gameID: result[i].gameid,
                Creater:result[i].Creater
            };
            console.log(data);
            $("#gamelist").append(model(data));
        }
    }).fail(console.log("222"));
});
    $("#newGameBtn").click(function () {
    $.get("api/GameList/" + $.session.get("user")).done(function () {
        console.log("333");
        location.reload();
    }).fail(console.log($.session.get("user")));
  }
  );
    console.log("test");
        $("#gamelist").on("click",function(evt){
           console.log(evt.target.id);
           var rv = evt.target.id;
           url ="CardGame.html?gameid="+rv;
           location.href = url;
        });
   