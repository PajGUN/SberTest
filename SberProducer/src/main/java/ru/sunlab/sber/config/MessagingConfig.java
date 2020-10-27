package ru.sunlab.sber.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.*;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import ru.sunlab.sber.model.SberMessage;

import javax.jms.ConnectionFactory;
import java.util.Arrays;

@Configuration
@EnableJms
public class MessagingConfig {

    public static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
    public static final String MESSAGE_QUEUE = "sber.queue";

    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        connectionFactory.setTrustedPackages(Arrays.asList("ru.sunlab.sber", "java.util"));
        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName(MESSAGE_QUEUE);
        return template;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        return factory;
    }

    @Bean
    Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(SberMessage.class);
        return marshaller;
    }

    @Bean
    MessageConverter messageConverter(Jaxb2Marshaller marshaller) {
        MarshallingMessageConverter converter = new MarshallingMessageConverter();
        converter.setMarshaller(marshaller);
        converter.setUnmarshaller(marshaller);
        return converter;
    }
}
