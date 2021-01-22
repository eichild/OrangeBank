package com.orangeBank.service;

import com.orangeBank.exception.ObjectNotFoundException;
import com.orangeBank.model.TipoConta;
import com.orangeBank.repository.TipoContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoContaService {

    @Autowired
    TipoContaRepository tipoContaRepository;

    public List<TipoConta> findAll(){
        List<TipoConta> tipoConta = this.tipoContaRepository.findAll();
        return tipoConta;
    }

    public TipoConta findById(Integer id_tipo_conta){
        Optional<TipoConta> tipoConta = this.tipoContaRepository.findById(id_tipo_conta);
        return tipoConta.orElseThrow(() -> new ObjectNotFoundException("Tipo de conta não encontrado! Id: "+id_tipo_conta));
    }


}
