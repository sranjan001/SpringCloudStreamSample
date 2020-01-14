package com.satya.SpringCloudStreamSample;

import com.satya.SpringCloudStreamSample.channels.MyProcessor;
import com.satya.SpringCloudStreamSample.converter.TextPlainMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MessageConverter;


@SpringBootApplication
@EnableBinding({Processor.class, MyProcessor.class})
public class SpringCloudStreamSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamSampleApplication.class, args);
	}


	@Bean
	public MessageConverter providesTextPlainMessageConverter() {
		return new TextPlainMessageConverter();
	}

}
