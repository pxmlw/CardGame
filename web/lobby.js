$(function() {
        var goodtemplate = Handlebars.compile($( "#gameListTemplate" ).html());
         console.log(">>>>>>>>"); 
        $.getJSON('getallroom').done(function(result){
             console.log(JSON.stringify(result));
             var t = JSON.parse(JSON.stringify(result));             
             console.log(t[0].rooms);
             
             for(var i=0 ;i<t.length; i++){
                var data = {
                gameId: t[i].rooms
                };
            $( "#gameId").append(goodtemplate(data));
            }
         });
         
         $("#newgame").on("click", function(){
            console.log("where are you");
         $.getJSON('game').done(function(result){
                console.log(">>>>>>>>"+JSON.stringify(result)); 
        var t = JSON.parse(JSON.stringify(result));
              console.log(">>>>>>>>222"+t['name']); 
         var data = {
                     gameId: t['name']
              };
         $( "#gameId").append(goodtemplate(data));
         });  
        });
        $("#gameId").on("click",function(evt){
            console.log("tset222");
           console.log(evt.target.id);
           var rv = evt.target.id;
           url ="room.html?roomid="+rv;
           location.href = url;
        });
});


