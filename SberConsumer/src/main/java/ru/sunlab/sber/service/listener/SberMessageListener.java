package ru.sunlab.sber.service.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ru.sunlab.sber.config.MessagingConfig;
import ru.sunlab.sber.model.SberMessage;
import ru.sunlab.sber.service.MessageService;

@Component
public class SberMessageListener {

    private final MessageService messageService;
    @Autowired
    public SberMessageListener(MessageService messageService) {
        this.messageService = messageService;
    }

    @JmsListener(destination = MessagingConfig.MESSAGE_QUEUE)
    public void listen(SberMessage message){
        messageService.addMessage(message);
    }
}
