package ru.sunlab.sber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import ru.sunlab.sber.model.SberMessage;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class MessageService {

    private final JmsTemplate jmsTemplate;
    @Autowired
    public MessageService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(long id, String text, String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        jmsTemplate.convertAndSend(new SberMessage(id, text, sdf.parse(date)));
    }

}
