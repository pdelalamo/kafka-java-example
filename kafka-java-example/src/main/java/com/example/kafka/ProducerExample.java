package com.example.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerExample {

    private static final String BOOTSTRAP_SERVERS = "localhost:9092";
    private static final String TOPIC = "test-topic";
    private static final String MESSAGE = "Hello Kafka from Java!";

    public static void main(String[] args) {
        Properties producerProperties = createProducerProperties();

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(producerProperties)) {
            sendMessage(producer, TOPIC, MESSAGE);
        }
    }

    private static Properties createProducerProperties() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties;
    }

    private static void sendMessage(KafkaProducer<String, String> producer, String topic, String message) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);
        producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                logSuccess(metadata);
            } else {
                logError(exception);
            }
        });
    }

    private static void logSuccess(RecordMetadata metadata) {
        System.out.printf("Message successfully sent to %s, partition: %d, offset: %d%n", 
                          metadata.topic(), metadata.partition(), metadata.offset());
    }

    private static void logError(Exception exception) {
        exception.printStackTrace();
    }
}
