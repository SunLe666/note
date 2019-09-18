package com.sunle;

import com.sunle.fanout.FanoutSender;
import com.sunle.model.User;
import com.sunle.receiver.HelloReceiver;
import com.sunle.sender.HelloSender;
import com.sunle.sender.HelloSender2;
import com.sunle.sender.SenderModel;
import com.sunle.sender.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {


    @Autowired
    private HelloSender helloSender;


    @Autowired
    private HelloSender2 helloSender2;

    @Autowired
    private SenderModel senderModel;

    @Autowired
    private TopicSender topicSender;

    @Autowired
    private FanoutSender fanoutSender;


    @Test
    public void contextLoads() {
        helloSender.send();
    }


    @Test
    public void oneToMany() throws Exception {
        for (int i=0;i<100;i++){
            helloSender.send(i);

        }
    }

    @Test
    public void manyToMany() throws Exception {
        for (int i=0;i<100;i++){
            helloSender.send(i);
            helloSender2.send(i);
        }
    }


    @Test
    public void modelTest() throws Exception {
        senderModel.send(new User("sunle",26));
    }



    @Test
    public void topicTest() throws Exception {
        topicSender.send1();
    }


    @Test
    public void topicTest2() throws Exception {
        topicSender.send2();
    }


    @Test
    public void fanoutTest() throws Exception {
        fanoutSender.send();
    }



}
