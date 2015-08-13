var source;
var source2;
//handlebar to generate Three more cards
$(function() {
   var goodtemplate = Handlebars.compile($( "#resultTemplate" ).html()); 

    var parameters = location.search.substring(12).split("?");
    document.getElementById("chattitle").textContent = parameters;
    console.log(location.search.substring(3).split("?"));
    console.log("start"+$("#chattitle").text());

//Everytime we enter the room , we need to have the cards be loaded and posted back, hence this part should be run at everytime we enter
    $.getJSON('initcards',{
        roomid: $("#chattitle").text()
    }).done(function(result){
        console.log(JSON.stringify(result));
        
        var t = JSON.parse(JSON.stringify(result));        
        console.log(t[0].cardId);
        
        for(var i=0; i<t.length; i++){      
        document.getElementById("p"+i).setAttribute("src","img/"+t[i].cardId+".gif");
        }
        
    });
    
    //sent path game process, send to $("#chattitle").text()
    source = new EventSource("api/" +"game/"+$("#chattitle").text());
    //receive the 12 card from backend, if the 
    $(source).on($("#chattitle").text(),function(event){
    var chat = JSON.parse(event.originalEvent.data);
    console.log("going through cards sending back process");
        console.log(">> msg11 = " + JSON.stringify(chat));
        var t = JSON.parse(JSON.stringify(chat));
        
        for(var i=0; i<t.length; i++){      
        document.getElementById("p"+i).setAttribute("src","img/"+t[i].cardNumber+".gif");
        }
        console.log("tst result");
        console.log(t[0].card1);
          var data2 = {
          m0: "img/"+t[0].card1+".gif",
          m1: "img/"+t[0].card2+".gif",
          m2: "img/"+t[0].card3+".gif"  
        };
        console.log("tst result");
        $("#resultdemo").append(goodtemplate(data2));
        document.getElementById("flag").textContent = "Congurations! You Find a Set!";
        console.log("img out");
    });
    
    //send
       $("#submit").on("click", function() {
       console.log(parameters);
       $.get("playgame", { 
           card1: $("#a").val(),
           card2: $("#b").val(),
           card3: $("#c").val(),
           chatname: $("#chattitle").text()
       }).done(function() {
               document.getElementById("flag").textContent = "This is not a set, Try Again.";
          console.log("checkbox test");
          for(var i=0; i<12; i++){
              $("#chkbx"+i).prop("checked", false);
          }
       });
       });
   
    //chat process
    source2 = new EventSource("api/"+"A"+$("#chattitle").text());
    $(source2).on("A"+$("#chattitle").text(),function(event){
    var chat = JSON.parse(event.originalEvent.data);
    console.log("got message");
    console.log($("#chattitle").val()+"|"+$("#chattitle").text());
        var $messages2 = $("#messages2");
        console.log(">> msg = " + JSON.stringify(chat));
        $messages2.text(chat.name + ": " + chat.message + "\n" 
                + $messages2.text());
    });
    
    
    
      $("#sendBtn").on("click", function() {
       console.log(parameters);
       $.get("newMessage", { 
           name2: $("#name2").val(),
           message2: $("#msg2").val(),
           chatname2: "A"+$("#chattitle").text()
       }).done(function() {
          $("#msg2").val(""); 
       });
   });
   
   
   
   
   
   $("#findResult").on("click",function(){
       var source = new EventSource("api/"+"counter/"+$("#chattitle").text());
       source.onmessage = eventHandler;

   function eventHandler(event){
       
       //console.log(">> msgresult = " + JSON.stringify(event));
       //var t = JSON.stringify(event);
       var t = JSON.parse(JSON.stringify(event));        
       //console.log(t);
       console.log(t.data);
       var m = JSON.parse(t.data);
       console.log(m[0].cardid);
       
        for(var i=0; i<m.length; i++){      
        document.getElementById("p"+i).setAttribute("src","img/"+m[i].cardid+".gif");
        }
        for(var j=m.length; j<=26; j++){
        document.getElementById("p"+j).setAttribute("src","");
        }
        var data = {
          m0: "img/"+m[0].carddemo1+".gif",
          m1: "img/"+m[0].carddemo2+".gif",
          m2: "img/"+m[0].carddemo3+".gif"  
        };
        console.log("tst result");
        $("#resultdemo").append(goodtemplate(data));
        console.log("tst result2222");
        
   };
       
     });     
//       console.log(t[2]);
//        for (var i=0; i<t.length; i++){
//       
//          console.log(t[i]);
//
//        }
       //console.log(t["card"]);
   
   
   
   
   
});


