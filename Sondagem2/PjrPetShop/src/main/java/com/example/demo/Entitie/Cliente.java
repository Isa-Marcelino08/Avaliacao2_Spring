package com.example.demo.Entitie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table
@Data
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	//*@Size(min = 4, message = "minimo de 4 caracteres")
	private String nome;
	
	@NotNull
	//*@Size(min = 10, message = "mínimo de 10 caracteres")
	private String telefone;
	
	@NotNull
	//*@Size(min = 10, message = "minimo de 10 caracteres")
	private String email;

	}
	


