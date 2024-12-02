package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entitie.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{

}
