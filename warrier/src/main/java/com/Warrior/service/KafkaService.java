package com.Warrior.service;

import ch.qos.logback.core.joran.sanity.Pair;
import com.Warrior.config.Producer;
import com.Warrior.constants.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private Producer producer;

    private final Logger logger = LoggerFactory.getLogger(KafkaService.class);


    public Boolean updateKill(String kill,String player) {
        logger.info("{} Kills happening for player {}",kill,player);
         Map<String,String> playerKill = new HashMap<>();
         playerKill.put(player,kill);
         try {
             producer.sendMessage(AppConstants.SCOREBOARD_TOPIC_NAME,playerKill);
         }catch (Exception e) {
             e.getMessage();
         }

        return Boolean.TRUE;
    }



}
