package com.rodrigo.consumidorestoque.consumer;

import constants.RabbitMQConstantes;
import dto.Estoque;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueConsumer {

    @RabbitListener(queues = RabbitMQConstantes.FILA_ESTOQUE)
    private void consumidor(Estoque estoque) {
        System.out.println(estoque.getCodigoProduto());
        System.out.println(estoque.getQuantidade());
    }
}
