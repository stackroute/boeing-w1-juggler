var stompClient = null;
var block = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    console.log("inside connect")
    var socket = new SockJS("http://13.232.40.6:8092/ticket-engine/socket");
    console.log("after connect")
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/chat', function (blockedSeats) {
            console.log("Response: "+blockedSeats.body);
            block = blockedSeats.body;

            console.log("block: "+block);
            var obj = new TheatreLayoutComponent();
            obj.updatestatus();
          //  return blockedSeats.body;
        });
    });
    
   // receiveBlockedSeats(stompClient);
  //  console.log(receiveBlockedSeats(stompClient));
}

function getSeats() {
    console.log(block);
    return block;
}

function receiveBlockedSeats( stomps) {
   // stompClient = Stomp.over(socket);
   stomps.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stomps.subscribe('/chat', function (blockedSeats) {
            console.log("Response: "+blockedSeats.body);
            return blockedSeats.body;
        });
    });

    
 }



function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendBlockedSeats(blockedSeat) {
    console.log("Blocked Seats: " +  JSON.stringify(blockedSeat));
    stompClient.send("/app/send/message", {}, JSON.stringify(blockedSeat));
}

