package com.orangeBank.service;

import com.orangeBank.exception.ObjectNotFoundException;
import com.orangeBank.model.TipoConta;
import com.orangeBank.repository.TipoContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoContaService {

    @Autowired
    TipoContaRepository tipoContaRepository;

    public List<TipoConta> findAll(){
        List<TipoConta> tipoConta = this.tipoContaRepository.findAll();
        return tipoConta;

    }

}
