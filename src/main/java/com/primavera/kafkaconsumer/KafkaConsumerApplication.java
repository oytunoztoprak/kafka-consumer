package com.primavera.kafkaconsumer;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;


@SpringBootApplication
public class KafkaConsumerApplication implements CommandLineRunner {

	private final String topicName="ubr";
	private final String consumerGroup="default";

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

    @KafkaListener(topics = topicName, groupId = consumerGroup)
    private void listen(ConsumerRecord<?, ?> consumerRecord) {
        System.out.println("Received Message in Topic:" + topicName + " key: " + consumerRecord.key() + " message: " + consumerRecord.value());
    }
}
