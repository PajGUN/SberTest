package ru.sunlab.sber.repository;

import org.springframework.stereotype.Repository;
import ru.sunlab.sber.model.SberMessage;

import java.util.ArrayList;
import java.util.List;

@Repository
//aka real DB
public class SberMessageRepository {

    private final List<SberMessage> messages = new ArrayList<>();


    public void addMessage(SberMessage message){
        messages.add(message);
    }

    public List<SberMessage> getMessages(){
        return messages;
    }
}
