package br.com.osworks.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.osworks.controller.dto.OrdemServicoDTO;
import br.com.osworks.controller.dto.OrdemServicoInput;
import br.com.osworks.service.OrdemServicoService;

@RestController
@RequestMapping(value = "/ordens-servico")
public class OrdemServicoController {

	@Autowired
	private OrdemServicoService os;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServicoDTO criar(@Valid @RequestBody OrdemServicoInput ordemServico) {
		return os.criar(ordemServico);
	}
	
	@GetMapping
	public List<OrdemServicoDTO> listar(){
		return os.listar();
	}
	
	@GetMapping("/{id}")
	ResponseEntity<OrdemServicoDTO> buscar(@PathVariable Long id){
		return os.buscar(id);
	}
	
}
