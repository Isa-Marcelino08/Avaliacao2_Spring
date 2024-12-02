package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entitie.Cliente;

public interface ClienteRepository extends JpaRepository< Cliente, Long> {

}
