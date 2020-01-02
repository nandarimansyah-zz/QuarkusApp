package id.nanda;

import io.smallrye.reactive.messaging.kafka.KafkaMessage;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class KafkaConsumer {

    @Incoming("consumers")
    public CompletionStage<Void> processMessage(Message<String> message) {
        System.out.println("Value:" + message.getPayload());
        return message.ack();
    }

}
