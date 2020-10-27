package br.com.osworks.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
		ordemServico.setDataAbertura(OffsetDateTime.now());
		return or.save(ordemServico);
	}

	public List<OrdemServico> listar() {
		return or.findAll();
	}

	public ResponseEntity<OrdemServico> buscar(Long id) {
		Optional<OrdemServico> ordemServico = or.findById(id);
		if (ordemServico.isPresent()) {
			return ResponseEntity.ok(ordemServico.get());
		}
		throw new ObjectNotFoundException("Ordem de Serviço não encontrada");
	}
}
