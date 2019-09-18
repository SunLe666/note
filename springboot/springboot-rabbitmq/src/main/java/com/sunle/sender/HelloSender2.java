package com.sunle.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloSender2 {

    @Autowired
    private AmqpTemplate rabbitTemplate;


    public void send(){
        String context = "hello"+ new Date();
        System.out.println("Sender2:"+context);

        this.rabbitTemplate.convertAndSend("hello",context);

    }


    public void send(int i) {
        String context = "spirng boot neo queue"+" ****** "+i;
        System.out.println("Sender2 : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }





}


