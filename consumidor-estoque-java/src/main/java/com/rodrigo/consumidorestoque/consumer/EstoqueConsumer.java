package com.rodrigo.consumidorestoque.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.RabbitMQConstantes;
import dto.Estoque;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueConsumer {

    @RabbitListener(queues = RabbitMQConstantes.FILA_ESTOQUE)
    private void consumer(String mensagem) throws JsonProcessingException {
        Estoque estoque = new ObjectMapper().readValue(mensagem, Estoque.class);
        System.out.println(estoque.getCodigoProduto());
        System.out.println(estoque.getQuantidade());
        System.out.println("=====================");
    }
}
