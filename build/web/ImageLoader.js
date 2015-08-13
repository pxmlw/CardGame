var source;
var gameid;

$(function () {
    gameid = location.search.substring(8).split("?");
    document.getElementById("GameID").textContent = "Game ID:" + gameid;
    $.getJSON("api/setgame/startgame/" + gameid).done(function (result) {

        resultObj = JSON.stringify(result);
        console.log(resultObj);
        $("#card1").append("<img id=" + result.card1 + " src='images/cards/" + result.card1 + ".gif' width='100' height='100'>");
        $("#card2").append("<img id=" + result.card2 + " src='images/cards/" + result.card2 + ".gif' width='100' height='100'>");
        $("#card3").append("<img id=" + result.card3 + " src='images/cards/" + result.card3 + ".gif' width='100' height='100'>");
        $("#card4").append("<img id=" + result.card4 + " src='images/cards/" + result.card4 + ".gif' width='100' height='100'>");
        $("#card5").append("<img id=" + result.card5 + " src='images/cards/" + result.card5 + ".gif' width='100' height='100'>");
        $("#card6").append("<img id=" + result.card6 + " src='images/cards/" + result.card6 + ".gif' width='100' height='100'>");
        $("#card7").append("<img id=" + result.card7 + " src='images/cards/" + result.card7 + ".gif' width='100' height='100'>");
        $("#card8").append("<img id=" + result.card8 + " src='images/cards/" + result.card8 + ".gif' width='100' height='100'>");
        $("#card9").append("<img id=" + result.card9 + " src='images/cards/" + result.card9 + ".gif' width='100' height='100'>");
        $("#card10").append("<img id=" + result.card10 + " src='images/cards/" + result.card10 + ".gif' width='100' height='100'>");
        $("#card11").append("<img id=" + result.card11 + " src='images/cards/" + result.card11 + ".gif' width='100' height='100'>");
        $("#card12").append("<img id=" + result.card12 + " src='images/cards/" + result.card12 + ".gif' width='100' height='100'>");
    });
    source = new EventSource("api/gameroom/" + gameid);
    $(source).on(gameid.toString(), function (event) {
        console.log("test");

        console.log(gameid);
        var chat = JSON.parse(event.originalEvent.data);
        var a;
        for (var i = 0; i < chat.length; i++)
        {
            a=chat[i].username;
            k = i + 1;
            console.log(i);
            var x = "#card" + k;
            $(x).contents().replaceWith("<img id=" + chat[i].id + " src='images/cards/" + chat[i].id + ".gif' width='100' height='100'>");
        }
        alert(a+" get a set!");
    });

    var count = 0;
    var array = [];
    var array1 = [];
    $(".click").on("click", function () {
        ++count;
        array1.push(this.id);
        var $img = $(this).find("img");
        array.push($img.attr("id"));
        console.log(">> img = " + $img.attr("id"));
        $(this).find("img").toggleClass('selected');
        console.log(count);
        if (count === 3) {

            
            var cd1 = array[0];
            var cd2 = array[1];
            var cd3 = array[2];
            $.get("api/setgame/" + gameid + "/" + cd1 + "/" + cd2 + "/" + cd3 + "/" + $.session.get("user")).done(
                    function () {
                        alert("you have selected three cards");
                        for (var i = 0; i < 3; i++) {
                            $("#" + array1.shift()).find("img").toggleClass('selected');
                            array.pop();
                        }


                    });
            count = 0;
        }
    });
//    $(source).on(gameid.toString(), function (event) {
//        console.log("test");
//
//        var chat = JSON.parse(event.originalEvent.data);
//        for (var i = 0; i < chat.length; i++)
//        {
//            k = i + 1;
//            console.log(i);
//            var x = "#card" + k;
//            $(x).contents().replaceWith("<img id=" + chat[i].id + " src='images/cards/" + chat[i].id + ".gif' width='100' height='100'>");
//
//        }
//    });




    //$(this).fadeIn('slow');


    //array[count-1]= $img.attr("id");
    //array[count-1]=$img.position();
//        console.log("id" + this.id);
});

