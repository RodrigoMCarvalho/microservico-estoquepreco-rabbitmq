package com.rodrigo.consumidorestoque.exceptions;

import org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;

public class CustomErrorStrategy extends ConditionalRejectingErrorHandler.DefaultExceptionStrategy {
    
    @Override
    public boolean isFatal(Throwable t) {
        String mensagem = new String(((ListenerExecutionFailedException) t).getFailedMessage().getBody());
        System.out.println(mensagem);
        return t.getCause() instanceof IllegalArgumentException;
    }
}
