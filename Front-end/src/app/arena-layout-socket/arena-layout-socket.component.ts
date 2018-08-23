import { Component, OnInit } from '@angular/core';
import Stomp from 'stompjs';
import SockJS from 'sockjs-client';
import $ from 'jquery';
import * as Socket from 'socket.io-client';

@Component({
  selector: 'app-arena-layout-socket',
  templateUrl: './arena-layout-socket.component.html',
  styleUrls: ['./arena-layout-socket.component.css']
})

export class ArenaLayoutSocketComponent {
  private serverUrl = 'http://172.23.238.222:9001/socket'
  private title = 'WebSockets chat';
  private stompClient;

  constructor(){
    this.initializeWebSocketConnection();
  }

  initializeWebSocketConnection(){
    let ws = Socket(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe("/chat", (message) => {
        if(message.body) {
          $(".chat").append("<div class='message'>"+message.body+"</div>")
          console.log(message.body);
        }
      });
    });
  }

  sendMessage(message){
    this.stompClient.send("/app/send/message" , {}, message);
    $('#input').val('');
  }

}
