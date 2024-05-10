package com.Warrior.controller;

import com.Warrior.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/kill")
public class KillController {


    @Autowired
    private KafkaService kafkaService;

    @PostMapping("{player}/{kill}")
    public ResponseEntity<?> updateKills(@PathVariable("kill") String kill,@PathVariable("player") String player) {

        kafkaService.updateKill(kill,player);

        return new ResponseEntity<>(Map.of("message","Kill updated"), HttpStatus.OK);
    }


}
