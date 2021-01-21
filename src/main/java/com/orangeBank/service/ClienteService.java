package com.orangeBank.service;

import com.orangeBank.model.Cliente;
import com.orangeBank.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Integer id){
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        return cliente.orElse(null);
    }
}
