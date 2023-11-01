/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.vdrl.concessionaria.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vdrl.concessionaria.entidade.Carro;

@Repository

public interface CarroRepositorio extends CrudRepository<Carro, Long>{

    @Override
    public Iterable<Carro> findAll();

    
    
}
