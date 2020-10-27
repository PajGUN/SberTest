package ru.sunlab.sber.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.sunlab.sber.model.SberMessage;
import ru.sunlab.sber.repository.SberMessageRepository;

import java.util.Date;


public class SberMessageRepositoryTest {

    private SberMessageRepository messageRepository;

    @Before
    public void setUp() throws Exception {
        messageRepository = new SberMessageRepository();
    }

    @Test
    public void getMessages() {
        messageRepository.addMessage(new SberMessage(2,"ads", new Date()));
        messageRepository.addMessage(new SberMessage(33,"two", new Date()));
        Assert.assertEquals(2, messageRepository.getMessages().size());
        Assert.assertEquals(2, messageRepository.getMessages().get(0).getId());
        Assert.assertEquals(33, messageRepository.getMessages().get(1).getId());
    }

    @Test
    public void addMessage() {
        messageRepository.addMessage(new SberMessage(2,"ads", new Date()));
        Assert.assertEquals(1, messageRepository.getMessages().size());
        Assert.assertEquals(2, messageRepository.getMessages().get(0).getId());
    }
}