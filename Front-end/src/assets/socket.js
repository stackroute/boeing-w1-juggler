var stompClient = null;

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
    var socket = new SockJS("http://13.232.40.6:9001/socket");
    console.log("after connect")
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/chat', function (blockedSeats) {
            console.log("Response: "+blockedSeats.body);
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

