package com.sunle.sender;

import com.sunle.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;


    public void send(){
        String context = "hello"+ new Date();
        System.out.println("Sender:"+context);

        this.rabbitTemplate.convertAndSend("hello",context);

    }

    public void send(int i) {
        String context = "spirng boot neo queue"+" ****** "+i;
        System.out.println("Sender1 : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }






}


