package com.example.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerExample {

    public static void main(String[] args) {
        // Configuraciones del productor
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        String topic = "test-topic";
        String message = "Hello Kafka from Java!";

        // Enviar el mensaje
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);
        producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                System.out.println("Mensaje enviado con éxito a " + metadata.topic() +
                        " partición: " + metadata.partition() + " offset: " + metadata.offset());
            } else {
                exception.printStackTrace();
            }
        });

        // Cerrar el productor
        producer.close();
    }
}
