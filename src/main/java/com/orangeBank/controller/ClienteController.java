package com.orangeBank.controller;

import com.orangeBank.dtos.ClienteDTO;
import com.orangeBank.model.Cliente;
import com.orangeBank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Cliente> cliente = clienteService.findAll();
        List<ClienteDTO> clienteDTO = cliente.stream().map(obj -> new ClienteDTO()).collect(Collectors.toList());
        return ResponseEntity.ok().body(clienteDTO);
    }
}
