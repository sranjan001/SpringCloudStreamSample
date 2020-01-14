package com.satya.SpringCloudStreamSample;

import com.satya.SpringCloudStreamSample.channels.MyProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyCustomListener {

    @Autowired
    private MyProcessor processor;

    /** One way commented
    @StreamListener(MyProcessor.INPUT)
    public void routeValues(Integer val) {
        if (val < 10) {
            processor.myOutput().send(message(val));
        } else {
            processor.anotherOutput().send(message(val));
        }
    }  **/

    @StreamListener(
            target = MyProcessor.INPUT,
            condition = "payload < 10")
    public void routeToMyOutput(Integer val) {
        processor.myOutput().send(message(val));
    }

    @StreamListener(
            target = MyProcessor.INPUT,
            condition = "payload >= 10")
    public void routeToAnotherOutput(Integer val) {
        processor.anotherOutput().send(message(val));
    }
    // methods must not return a value in above sample


    private static final <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val).build();
    }
}
