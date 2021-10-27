package com.rodrigo.estoquepreco.controller;

import com.rodrigo.estoquepreco.constants.RabbitMQConstantes;
import com.rodrigo.estoquepreco.dto.Estoque;
import com.rodrigo.estoquepreco.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estoque")
public class EstoqueController {

    @Autowired
    private RabbitMQService rabbitMQService;

    @PutMapping
    private ResponseEntity alteraEstoque(@RequestBody Estoque estoque) {
        rabbitMQService.enviaMensagem(RabbitMQConstantes.FILA_ESTOQUE, estoque);
        return ResponseEntity.ok(estoque);
    }
}
