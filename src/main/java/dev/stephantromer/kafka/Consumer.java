package dev.stephantromer.kafka;

import dev.stephantromer.kafka.model.Order;
import lombok.extern.slf4j.Slf4j;
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
}
