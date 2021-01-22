package com.orangeBank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_conta")
    private Integer id;

    @Column(name = "saldo")
    private double saldo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private TipoConta tipoConta;

    @OneToOne
    @JoinColumn(nullable = false, unique = true)
    private Cliente cliente;
}
