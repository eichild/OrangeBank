package com.orangeBank.controller;

import com.orangeBank.model.TipoConta;
import com.orangeBank.service.TipoContaService;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(value = "/{id_tipo_conta}")
    public ResponseEntity<TipoConta> findById(@PathVariable Integer id_tipo_conta){
        TipoConta tipoConta = tipoContaService.findById(id_tipo_conta);
        return ResponseEntity.ok().body(tipoConta);

    }
}
