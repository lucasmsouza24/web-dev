package com.sptech.demo.repositorio;

import com.sptech.demo.entidade.Salgadinho;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalgadinhoRepository extends JpaRepository<Salgadinho, Integer> {
    
}
