package dev.stephantromer.kafka.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;

import java.util.Map;

@EnableKafka
@Configuration
@RequiredArgsConstructor
public class Config {

    private final KafkaProperties kafkaProperties;

    @Bean
    public SeekToCurrentErrorHandler errorHandler(DeadLetterPublishingRecoverer deadLetterPublishingRecoverer) {
        return new SeekToCurrentErrorHandler(deadLetterPublishingRecoverer);
    }

    @Bean
    public DeadLetterPublishingRecoverer publisher(KafkaTemplate<String, byte[]> bytesTemplate) {
        return new DeadLetterPublishingRecoverer(bytesTemplate);
    }

    private ConsumerFactory<String, byte[]> bytesArrayConsumerFactory() {
        Map<String, Object> props = kafkaProperties.buildConsumerProperties();
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new ByteArrayDeserializer());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, byte[]> bytesArrayListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, byte[]> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(bytesArrayConsumerFactory());
        return factory;
    }
}
