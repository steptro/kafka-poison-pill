package dev.stephantromer.kafka.consumer;

import dev.stephantromer.kafka.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Consumer {
    @KafkaListener(topics = {"orders"})
    public void listen(@Payload Order order) {
        log.info("Consumed order: {} with price {}", order.getName(), order.getPrice());
    }

    @KafkaListener(topics = {"orders.DLT"}, containerFactory = "bytesArrayListenerContainerFactory")
    public void recoverDLT(@Payload ConsumerRecord<String, byte[]> consumerRecord) {
        log.info("Poison pill value: {}", new String(consumerRecord.value()));
    }
}
