package ru.sunlab.sber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sunlab.sber.service.MessageService;


@Controller
@RequestMapping("api/1.0/message")
public class MessageController {

    private final MessageService messageService;
    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/getall")
    public String getAllMessages(Model model){
        model.addAttribute("messages", messageService.getMessages());
        return "message/all_messages";
    }
}
