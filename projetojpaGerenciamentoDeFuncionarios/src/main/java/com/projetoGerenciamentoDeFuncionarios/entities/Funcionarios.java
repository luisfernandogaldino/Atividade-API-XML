package com.projetoGerenciamentoDeFuncionarios.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data
@NoArgsConstructor
@AllArgsConstructor 
@Table(name = "funcionario")
public class Funcionarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	private String rg;

	@NotNull
	private String cpf;

	@NotNull
	private String endereco;

	@NotNull
	private String telefone;

	@NotNull
	private String cargo;

	@NotNull
	private double salario;

	
}