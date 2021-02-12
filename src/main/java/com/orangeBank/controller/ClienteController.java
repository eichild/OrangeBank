package com.orangeBank.controller;

import com.orangeBank.dtos.ClienteDTO;
import com.orangeBank.model.Cliente;
import com.orangeBank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id){
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok().body(cliente);
    }
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll(){
        return ResponseEntity.ok(this.clienteService.findAll());
    }
    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        cliente = clienteService.create(cliente);
        //Ver lógica do URI
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO){
      this.clienteService.update(id, clienteDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    }
