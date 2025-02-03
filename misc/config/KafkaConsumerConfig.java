package com.hariSolution.config;

import com.hariSolution.consumer.EmployeeDetails;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public  class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, EmployeeDetails> consumerFactory() {
        // Initialize JsonDeserializer for EmployeeDetails
        JsonDeserializer<EmployeeDetails> deserializer = new JsonDeserializer<>(EmployeeDetails.class);

        // Add trusted packages to allow deserialization of EmployeeDetails
        deserializer.addTrustedPackages("com.hariSolution.consumer");  // Add your package here
        deserializer.setRemoveTypeHeaders(false);
        deserializer.setUseTypeMapperForKey(false);

        // Configuration properties for the Kafka consumer
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, EmployeeDetails>> listenerContainerFactory(
            ConsumerFactory<String, EmployeeDetails> consumerFactory) {
        // Kafka listener factory setup
        ConcurrentKafkaListenerContainerFactory<String, EmployeeDetails> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }
}
