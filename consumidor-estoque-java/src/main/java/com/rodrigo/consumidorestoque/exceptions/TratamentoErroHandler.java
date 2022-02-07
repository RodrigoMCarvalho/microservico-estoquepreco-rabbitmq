package com.rodrigo.consumidorestoque.exceptions;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;
import org.springframework.util.ErrorHandler;

public class TratamentoErroHandler implements ErrorHandler {

    @Override
    public void handleError(Throwable t) {
        String nomeFila = ((ListenerExecutionFailedException) t).getFailedMessage().getMessageProperties().getConsumerQueue();
        String mensagem = new String(((ListenerExecutionFailedException) t).getFailedMessage().getBody());
        System.out.println(String.format("Erro na fila %s, mensagem %s", nomeFila, mensagem));
        throw new AmqpRejectAndDontRequeueException("Não deve retornar a fila em casos de erro.");
    }
}
