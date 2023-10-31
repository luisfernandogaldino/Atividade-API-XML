package com.projetoGerenciamentoDeFuncionarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoGerenciamentoDeFuncionarios.entities.Funcionarios;
import com.projetoGerenciamentoDeFuncionarios.repository.FuncionariosRepository;

@Service
public class FuncionariosService {

	private final FuncionariosRepository funcionariosRepository;

	@Autowired
	public FuncionariosService(FuncionariosRepository funcionariosRepository) {
		this.funcionariosRepository = funcionariosRepository;
	}
	public List<Funcionarios> buscaTodosFuncionarios(){
		return funcionariosRepository.findAll();
	}
	public Funcionarios buscaFuncionariosId(Long id) {
		Optional <Funcionarios> Funcionarios = funcionariosRepository.findById(id);
		return Funcionarios.orElse(null);
	}
	public Funcionarios salvaFuncionarios(Funcionarios Funcionarios){
		return funcionariosRepository.save(Funcionarios);
	}
	public Funcionarios alterarFuncionarios(Long id, Funcionarios alterarFuncionarios) {
		Optional <Funcionarios> existeFuncionarios = funcionariosRepository.findById(id);
		if (existeFuncionarios.isPresent()) {
			alterarFuncionarios.setId(id);
			return funcionariosRepository.save(alterarFuncionarios);
		}
		return null;
	}
	public boolean apagarFuncionarios (Long id) {
		Optional <Funcionarios> existeFuncionarios= funcionariosRepository.findById(id);
		if (existeFuncionarios.isPresent()) {
			funcionariosRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
