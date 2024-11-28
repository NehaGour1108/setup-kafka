package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducerExample {
    public static void main(String[] args) {
        // Kafka producer configuration
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // Send a few messages
        for (int i = 1; i <= 5; i++) {
            String message = "Message " + i;
            producer.send(new ProducerRecord<>("test-topic", Integer.toString(i), message));
            System.out.println("Produced: " + message);
        }

        // Close the producer
        producer.close();
    }
}

