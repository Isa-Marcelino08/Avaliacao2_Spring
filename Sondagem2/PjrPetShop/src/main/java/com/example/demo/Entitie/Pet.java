package com.example.demo.Entitie;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table
@Data

public class Pet {
	
	@Id
   @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String tipo;
   
	
	@NotNull
	private String raca;

	@NotNull
	private String idade;
	
	@ManyToOne
	@JoinColumn(name = "clienId")
	private Cliente cliente;
	
	
}