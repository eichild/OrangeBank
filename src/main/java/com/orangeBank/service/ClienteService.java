package com.orangeBank.service;

import com.orangeBank.dtos.ClienteDTO;
import com.orangeBank.exception.ObjectNotFoundException;
import com.orangeBank.model.Cliente;
import com.orangeBank.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Cliente findById(Integer id){
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! Id: " +id));
    }
    public List<ClienteDTO> findAll(){
        List<Cliente> cliente = clienteRepository.findAll();
        List<ClienteDTO> clienteDTO =new ArrayList<>();
        cliente.forEach(
                cliente1 -> clienteDTO.add(clienteToClienteDTO(cliente1))
        );
        return clienteDTO;
    }

    public Cliente create(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente update(Integer id, ClienteDTO clienteDTO) throws ObjectNotFoundException{
        Cliente cliente =  this.clienteRepository.findById(id).orElse(null);
        if (cliente == null) {
            throw new ObjectNotFoundException("Cliente com ID: " + id + " Não encontrado!");
        }
        
        return clienteRepository.save(cliente);

    }
    private ClienteDTO clienteToClienteDTO(Cliente cliente){
        return modelMapper.map(cliente, (Type) ClienteDTO.class);
    }


}
