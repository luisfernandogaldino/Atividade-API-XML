package com.projetoGerenciamentoDeFuncionarios.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoGerenciamentoDeFuncionarios.entities.Funcionarios;
import com.projetoGerenciamentoDeFuncionarios.service.FuncionariosService;

import jakarta.validation.Valid;

@RestController
	@RequestMapping("/funcionario")
	public class FuncionariosController {

		private final FuncionariosService funcionariosService;

		@Autowired
		public FuncionariosController(FuncionariosService funcionariosService) {
			this.funcionariosService = funcionariosService;
		}

		@GetMapping("/{id}")

		public ResponseEntity<Funcionarios> buscaFuncionariosControlId(@PathVariable Long id) {
			Funcionarios funcionarios = funcionariosService.buscaFuncionariosId(id);
			if (funcionarios != null) {
				return ResponseEntity.ok(funcionarios);
			} else {
				return ResponseEntity.notFound().build();
			}
		}

		@GetMapping("/")
	      public ResponseEntity<List<Funcionarios>> buscaTodosFuncionariosControl() {
			List<Funcionarios> Funcionarios = funcionariosService.buscaTodosFuncionarios();
			return ResponseEntity.ok(Funcionarios);
		}

		@PostMapping("/")

		public ResponseEntity<Funcionarios> salvaFuncionariosControl(@RequestBody @Valid Funcionarios funcionarios) {
			Funcionarios salvaFuncionarios = funcionariosService.salvaFuncionarios(funcionarios);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaFuncionarios);
		}

		@PutMapping("/{id}")

		public ResponseEntity<Funcionarios> alteraFuncionariosControl(@PathVariable Long id, @RequestBody @Valid Funcionarios funcionarios) {
			Funcionarios alteraFuncionarios = funcionariosService.alterarFuncionarios(id, funcionarios);
			if (alteraFuncionarios != null) {
				return ResponseEntity.ok(funcionarios);
			} else {
				return ResponseEntity.notFound().build();
			}
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<Funcionarios> apagaFuncionariosControl(@PathVariable Long id) {
			boolean apagar = funcionariosService.apagarFuncionarios(id);
			if (apagar) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			} else {
				return ResponseEntity.notFound().build();
			}
		}

	}
