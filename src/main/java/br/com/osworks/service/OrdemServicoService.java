package br.com.osworks.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.osworks.controller.exception.ObjectNotFoundException;
import br.com.osworks.model.Cliente;
import br.com.osworks.model.OrdemServico;
import br.com.osworks.model.StatusOrdemServico;
import br.com.osworks.repository.ClienteRepository;
import br.com.osworks.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {

	@Autowired
	OrdemServicoRepository or;
	
	@Autowired
	ClienteRepository cr;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		Cliente cliente = cr.findById(ordemServico.getCliente().getId()).orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado"));
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setCliente(cliente);
		ordemServico.setDataAbertura(LocalDateTime.now());
		return or.save(ordemServico);
	}
}
