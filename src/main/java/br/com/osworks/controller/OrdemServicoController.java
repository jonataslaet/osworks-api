package br.com.osworks.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.osworks.model.OrdemServico;
import br.com.osworks.service.OrdemServicoService;

@RestController
@RequestMapping(value = "/ordens-servico")
public class OrdemServicoController {

	@Autowired
	private OrdemServicoService os;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServico criar(@Valid @RequestBody OrdemServico ordemServico) {
		return os.criar(ordemServico);
	}
}
