package com.krpk.lettnet.controller;

import com.krpk.lettnet.domain.Message;
import com.krpk.lettnet.domain.User;
import com.krpk.lettnet.repo.MessageRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageRepo messageRepo;

    @Autowired
    public MessageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping
    public List<Message> getMessages(){
        return messageRepo.findAll();
    }

    @PostMapping
    public Message createMessage(
            @AuthenticationPrincipal User user,
            @RequestBody Message message
    ){
        message.setPublicationDate(LocalDateTime.now());
        message.setAuthor(user);
        return messageRepo.save(message);
    }

    @PutMapping("{id}")
    public Message updateMessage(
            @PathVariable("id") Message messageFromDb,
            @RequestBody Message message
    ) {
        BeanUtils.copyProperties(message, messageFromDb, "id");
        return messageRepo.save(messageFromDb);
    }

    @DeleteMapping("{id}")
    public void deleteMessage(@PathVariable("id") Message message) {
        messageRepo.delete(message);
    }
}
