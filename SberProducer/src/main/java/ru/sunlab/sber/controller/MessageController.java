package ru.sunlab.sber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sunlab.sber.service.MessageService;

import java.text.ParseException;


@Controller
@RequestMapping("api/1.0/message")
public class MessageController {

    private final MessageService messageService;
    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public String catchMessage(@RequestParam("id") long id,
                               @RequestParam("options") String text,
                               @RequestParam("date") String date,
                               Model model){
        try {
            messageService.sendMessage(id, text, date);
            return "message/send_message_success";
        } catch (ParseException e) {
            //logging..
            model.addAttribute("cause", e.getCause());
            return "error/incorrect_input";
        }
    }

    @GetMapping("/send")
    public String sendMessage(){
        return "message/send_message";
    }
}
