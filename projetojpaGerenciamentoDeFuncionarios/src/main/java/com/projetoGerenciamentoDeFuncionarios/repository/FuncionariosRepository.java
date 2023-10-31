package com.projetoGerenciamentoDeFuncionarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoGerenciamentoDeFuncionarios.entities.Funcionarios;

public interface FuncionariosRepository  extends JpaRepository<Funcionarios,Long> {

}
