package id.nanda;

import io.smallrye.reactive.messaging.annotations.Channel;
import io.smallrye.reactive.messaging.annotations.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class KafkaProducer {

    @Inject
    @Channel("producers")
    Emitter<Message<String>> emitter;

    public void produce(String message) {
        emitter.send(Message.of(message));
    }
}
