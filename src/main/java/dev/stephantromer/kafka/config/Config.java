package dev.stephantromer.kafka.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@EnableKafka
@Configuration
@RequiredArgsConstructor
public class Config {

    private final KafkaProperties kafkaProperties;

//    @Bean
//    public ConsumerFactory<String, String> jsonConsumerFactory() {
//        JsonDeserializer jsonDeserializer = new JsonDeserializer<>();
//        jsonDeserializer.addTrustedPackages("*");
//        ErrorHandlingDeserializer errorHandlingDeserializer = new ErrorHandlingDeserializer(jsonDeserializer);
//
//        Map<String, Object> props = kafkaProperties.buildConsumerProperties();
//        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), errorHandlingDeserializer);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String> jsonListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(jsonConsumerFactory());
//        factory.setErrorHandler(new LoggingErrorHandler());
//        return factory;
//    }

//    @Bean
//    public ConsumerFactory<String, String> jsonConsumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties(), new StringDeserializer(), new JsonDeserializer());
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String> jsonListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(jsonConsumerFactory());
//        return factory;
//    }
}
