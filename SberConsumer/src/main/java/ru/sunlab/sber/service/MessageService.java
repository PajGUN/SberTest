package ru.sunlab.sber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sunlab.sber.model.SberMessage;
import ru.sunlab.sber.repository.SberMessageRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class MessageService {

    private final SberMessageRepository messageRepository;
    @Autowired
    public MessageService(SberMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<SberMessage> getMessages(){
        //We do not chang the original list!
        List<SberMessage> messagesTmp = new ArrayList<>(messageRepository.getMessages());
        Collections.sort(messagesTmp, new Comparator<SberMessage>() {
            @Override
            public int compare(SberMessage o1, SberMessage o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        return messagesTmp;
    }

    public void addMessage(SberMessage message) {
        messageRepository.addMessage(message);
    }
}
