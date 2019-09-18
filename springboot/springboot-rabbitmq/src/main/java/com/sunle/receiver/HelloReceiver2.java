package com.sunle.receiver;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver2 {


    @RabbitHandler
    public void  process(String hello){
        System.out.println("Receiver2:"+hello);
    }
}
