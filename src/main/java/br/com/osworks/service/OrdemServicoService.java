package br.com.osworks.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.osworks.controller.dto.OrdemServicoDTO;
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
	
	public OrdemServicoDTO criar(OrdemServico ordemServico) {
		Cliente cliente = cr.findById(ordemServico.getCliente().getId()).orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado"));
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setCliente(cliente);
		ordemServico.setDataAbertura(OffsetDateTime.now());
		return new OrdemServicoDTO(or.save(ordemServico));
	}

	public List<OrdemServicoDTO> listar() {
		return or.findAll().stream().map(x -> new OrdemServicoDTO(x)).collect(Collectors.toList());
	}

	public ResponseEntity<OrdemServicoDTO> buscar(Long id) {
		Optional<OrdemServico> ordemServico = or.findById(id);
		if (ordemServico.isPresent()) {
			return ResponseEntity.ok(new OrdemServicoDTO(ordemServico.get()));
		}
		throw new ObjectNotFoundException("Ordem de Serviço não encontrada");
	}
}
