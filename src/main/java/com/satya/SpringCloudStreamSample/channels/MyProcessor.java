package com.satya.SpringCloudStreamSample.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MyProcessor {
    String INPUT = "myInput"; //Used in the StreamListener class

    @Input
    SubscribableChannel myInput();

    @Output  //@Output("appOutput")
    MessageChannel myOutput();

    @Output
    MessageChannel anotherOutput();
}
