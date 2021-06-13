package dev.stephantromer.kafka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/produce-order")
    public void produceOrder() {
        kafkaTemplate.send("orders", "Monitor, 300");
    }
}
