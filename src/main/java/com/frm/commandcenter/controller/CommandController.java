package com.frm.commandcenter.controller;


import com.frm.commandcenter.model.Command;
import com.frm.commandcenter.service.CommandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/commands")
public class CommandController {

    private final CommandService commandService;

    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Command> createCommand(@RequestBody Command command) {
        Command newCommand = commandService.saveCommand(command);
        return new ResponseEntity<>(newCommand, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Command>> getCommands(@RequestParam Optional<String> controlNumber,
                                                     @RequestParam Optional<LocalDateTime> registrationDate) {
        List<Command> commands = commandService.getCommands(controlNumber, registrationDate);
        return new ResponseEntity<>(commands, HttpStatus.OK);
    }
}
