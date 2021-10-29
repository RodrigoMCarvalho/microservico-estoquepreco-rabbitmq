package com.rodrigo.estoquepreco.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void enviaMensagem(String nomeFila, Object mensagem) {
        try {
            String mensagemJson = objectMapper.writeValueAsString(mensagem);
            rabbitTemplate.convertAndSend(nomeFila, mensagemJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
