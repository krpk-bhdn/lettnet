package com.krpk.lettnet.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.krpk.lettnet.domain.Message;
import com.krpk.lettnet.domain.User;
import com.krpk.lettnet.domain.Views;
import com.krpk.lettnet.dto.EventType;
import com.krpk.lettnet.dto.ObjectType;
import com.krpk.lettnet.repo.MessageRepo;
import com.krpk.lettnet.util.WsSender;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.BiConsumer;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageRepo messageRepo;
    private final BiConsumer<EventType, Message> wsSender;

    @Autowired
    public MessageController(MessageRepo messageRepo, WsSender wsSender) {
        this.messageRepo = messageRepo;
        this.wsSender = wsSender.getSender(ObjectType.MESSAGE, Views.IdName.class);
    }

    @GetMapping
    @JsonView(Views.IdName.class)
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
        Message newMessage = messageRepo.save(message);

        wsSender.accept(EventType.CREATE, newMessage);

        return newMessage;
    }

    @PutMapping("{id}")
    public Message updateMessage(
            @PathVariable("id") Message messageFromDb,
            @RequestBody Message message
    ) {
        BeanUtils.copyProperties(message, messageFromDb, "id");
        Message updatedMessage = messageRepo.save(messageFromDb);

        wsSender.accept(EventType.UPDATE, updatedMessage);

        return updatedMessage;
    }

    @DeleteMapping("{id}")
    public void deleteMessage(@PathVariable("id") Message message) {
        messageRepo.delete(message);
        wsSender.accept(EventType.REMOVE, message);
    }
}
