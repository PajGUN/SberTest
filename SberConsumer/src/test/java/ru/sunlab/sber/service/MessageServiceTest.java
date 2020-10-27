package ru.sunlab.sber.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.sunlab.sber.model.SberMessage;
import ru.sunlab.sber.repository.SberMessageRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {

    private MessageService messageService;
    @Mock
    private SberMessageRepository messageRepository;

    @Before
    public void setUp() throws Exception {
        messageService = new MessageService(messageRepository);
    }

    @Test
    public void getMessages() {
        given(messageRepository.getMessages()).willReturn(
                Arrays.asList(new SberMessage(1, "one", new Date(40000000000L)),
                        new SberMessage(2,"two", new Date(80000000000L)),
                        new SberMessage(3,"three", new Date()),
                        new SberMessage(4,"four", new Date(120000000000L)))
        );
        List<SberMessage> messages = messageService.getMessages();

        Assert.assertEquals(4,messages.size());
        Assert.assertEquals(1,messages.get(0).getId());
        Assert.assertEquals(2,messages.get(1).getId());
        Assert.assertEquals(4,messages.get(2).getId());
        Assert.assertEquals(3,messages.get(3).getId());
    }
}