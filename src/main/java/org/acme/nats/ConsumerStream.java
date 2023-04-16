package org.acme.nats;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.source.util.TaskEvent;
import io.nats.client.*;
import io.nats.client.api.ConsumerConfiguration;
import io.nats.client.api.DeliverPolicy;
import io.quarkus.logging.Log;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@ApplicationScoped
public class ConsumerStream {

    @Inject
    Connection connection;

    public void init(@Observes StartupEvent event) {
//        this.subscribeToStream();
    }

    private static final String STREAM_TOPIC = "my-stream-topic";
    private static final String STREAM_CONSUMER_NAME = "my-stream-consumer";
    private static final DeliverPolicy DELIVER_POLICY = DeliverPolicy.All;

    public void subscribeToStream() {
        try {
            JetStream jetStream = connection.jetStream();
            MessageHandler messageHandler = createMessageHandler();
            PushSubscribeOptions subscribeOptions = createSubscribeOptions();
            jetStream.subscribe(STREAM_TOPIC, connection.createDispatcher(), messageHandler, false, subscribeOptions);
        } catch (IOException | JetStreamApiException e) {
            Log.errorv("Error subscribing to stream: {}", e.getMessage());
        }
    }

    private MessageHandler createMessageHandler() {
        return (message) -> {
            Log.infov("Received message: {}", new String(message.getData(), StandardCharsets.UTF_8));

            try {
                TaskEvent taskEvent = deserializeTaskEvent(message.getData());
                handleTaskEvent(taskEvent);
                message.ack();
            } catch (JsonProcessingException e) {
                Log.errorv("Error deserializing message payload: {}", e.getMessage());
                message.nak();
            }
        };
    }

    private TaskEvent deserializeTaskEvent(byte[] data) throws JsonProcessingException {
        String jsonString = new String(data, StandardCharsets.UTF_8);
        return new ObjectMapper().readValue(jsonString, new TypeReference<>() {});
    }

    private void handleTaskEvent(TaskEvent taskEvent) {
        // Use strategyHolder to route task event to appropriate handler
        // ...
    }

    private PushSubscribeOptions createSubscribeOptions() {
        ConsumerConfiguration consumerConfig = ConsumerConfiguration.builder()
                .deliverPolicy(DELIVER_POLICY)
                .build();

        return PushSubscribeOptions.builder()
                .durable(STREAM_CONSUMER_NAME)
                .configuration(consumerConfig)
                .build();
    }
}
