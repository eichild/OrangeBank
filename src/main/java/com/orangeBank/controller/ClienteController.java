package com.orangeBank.controller;

import com.orangeBank.dtos.ClienteDTO;
import com.orangeBank.model.Cliente;
import com.orangeBank.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id){
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll(){
        List<Cliente> cliente = clienteService.findAll();
        List<ClienteDTO> clienteDTO =new ArrayList<>();

        cliente.forEach(
            cliente1 -> clienteDTO.add(clienteToClienteDTO(cliente1))
        );
        return ResponseEntity.ok().body(clienteDTO);
    }

    private ClienteDTO clienteToClienteDTO(Cliente cliente){
        return modelMapper.map(cliente, (Type) ClienteDTO.class);
    }
}
