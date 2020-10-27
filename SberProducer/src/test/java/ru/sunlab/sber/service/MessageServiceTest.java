package ru.sunlab.sber.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jms.core.JmsTemplate;
import ru.sunlab.sber.model.SberMessage;

import java.text.ParseException;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {

    private MessageService messageService;
    @Mock
    private JmsTemplate jmsTemplate;

    @Before
    public void setUp() throws Exception {
        messageService = new MessageService(jmsTemplate);
    }

    @Test
    public void sendMessage() throws ParseException {
        messageService.sendMessage(555,"five","2020-11-25");
        ArgumentCaptor<SberMessage> captor = ArgumentCaptor.forClass(SberMessage.class);
        verify(jmsTemplate).convertAndSend(captor.capture());
        SberMessage message = captor.getValue();
        Assert.assertEquals(555, message.getId());
        Assert.assertEquals("five", message.getText());
        Assert.assertEquals(1606251600000L, message.getDate().getTime());
    }
    @Test(expected = ParseException.class)
    public void sendMessageParseException() throws ParseException {
        messageService.sendMessage(555,"five","2020-1525");
    }
}