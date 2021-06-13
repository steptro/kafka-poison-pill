package dev.stephantromer.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@ConditionalOnExpression("${spring.kafka.dlt.enable}")
public class DltConsumer {

    @KafkaListener(topics = {"orders.DLT"}, containerFactory = "bytesArrayListenerContainerFactory")
    public void recoverDLT(@Payload ConsumerRecord<String, byte[]> consumerRecord) {
        log.info("Poison pill value: {}", new String(consumerRecord.value()));
    }
}
