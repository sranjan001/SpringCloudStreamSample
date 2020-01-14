package com.satya.SpringCloudStreamSample;

import com.satya.SpringCloudStreamSample.channels.MyProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = SpringCloudStreamSampleApplicationTests.class)
@SpringBootTest
@DirtiesContext
class SpringCloudStreamSampleApplicationTests {

	@Autowired
	private Processor pipe;

	@Autowired
	private MyProcessor myProcessor;

	@Autowired
	private MessageCollector messageCollector;

	@Test
	public void whenSendMessage_thenResponseShouldUpdateText() {
		pipe.input()
				.send(MessageBuilder.withPayload(new LogMessage("This is my message"))
						.build());

		Object payload = messageCollector.forChannel(pipe.output())
				.poll()
				.getPayload();

		assertEquals("{\"message\":\"[1]: This is my message\"}", payload.toString());
	}

	@Test
	public void whenSendMessageToMyProcessor_thenResponseShouldbesenttooutput_basedOnValue() {
		myProcessor.myInput()
				.send(MessageBuilder.withPayload(8).build());


		Object payload = messageCollector.forChannel(myProcessor.myOutput())
				.poll()
				.getPayload();

		Object payload1 = messageCollector.forChannel(myProcessor.anotherOutput())
				.poll();

		assertEquals(8, Integer.parseInt(payload.toString()));
		assertNull(payload1);

	}

}
