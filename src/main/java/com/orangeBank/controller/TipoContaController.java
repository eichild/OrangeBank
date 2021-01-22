package com.orangeBank.controller;

import com.orangeBank.model.TipoConta;
import com.orangeBank.service.TipoContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tipoConta")
public class TipoContaController {

    @Autowired
    TipoContaService tipoContaService;

    @GetMapping("listar")
    public ResponseEntity<List<TipoConta>> findAll(){
        return ResponseEntity.ok(this.tipoContaService.findAll());
    }
}
