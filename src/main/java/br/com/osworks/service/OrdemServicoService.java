package br.com.osworks.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.osworks.controller.dto.ComentarioDTO;
import br.com.osworks.controller.dto.ComentarioInput;
import br.com.osworks.controller.dto.OrdemServicoDTO;
import br.com.osworks.controller.dto.OrdemServicoInput;
import br.com.osworks.controller.exception.ObjectNotFoundException;
import br.com.osworks.model.Cliente;
import br.com.osworks.model.Comentario;
import br.com.osworks.model.OrdemServico;
import br.com.osworks.model.StatusOrdemServico;
import br.com.osworks.repository.ClienteRepository;
import br.com.osworks.repository.ComentarioRepository;
import br.com.osworks.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {

	@Autowired
	OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ComentarioRepository comentarioRepository;

	public OrdemServicoDTO criar(OrdemServicoInput osi) {
		Cliente cliente = clienteRepository.findById(osi.getCliente().getId()).orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado"));
		OrdemServico ordemServico = new OrdemServico();
		ordemServico.setDescricao(osi.getDescricao());
		ordemServico.setPreco(osi.getPreco());
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setCliente(cliente);
		ordemServico.setDataAbertura(OffsetDateTime.now());
		return new OrdemServicoDTO(ordemServicoRepository.save(ordemServico));
	}

	public List<OrdemServicoDTO> listar() {
		return ordemServicoRepository.findAll().stream().map(x -> new OrdemServicoDTO(x)).collect(Collectors.toList());
	}

	public ResponseEntity<OrdemServicoDTO> buscar(Long id) {
		Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(id);
		if (ordemServico.isPresent()) {
			return ResponseEntity.ok(new OrdemServicoDTO(ordemServico.get()));
		}
		throw new ObjectNotFoundException("Ordem de Serviço não encontrada");
	}
	
	public Comentario adicionarComentario(Long ordemServicoId, String descricao) {
		OrdemServico ordemServico = ordemServicoRepository.findById(ordemServicoId).orElseThrow(() -> new ObjectNotFoundException("Ordem de serviço não encontrada"));
		
		Comentario comentario = new Comentario();
		comentario.setDataEnvio(OffsetDateTime.now());
		comentario.setDescricao(descricao);
		comentario.setOrdemServico(ordemServico);
		ordemServico.getComentarios().add(comentario);
//		ordemServicoRepository.save(ordemServico);
		return comentarioRepository.save(comentario);
	}

	public ComentarioDTO criarComentario(Long id, ComentarioInput comentario) {
		return new ComentarioDTO(this.adicionarComentario(id, comentario.getDescricao()));
	}

	public List<ComentarioDTO> listarComentarios(Long idOrdem) {
		OrdemServico ordemServico = ordemServicoRepository.findById(idOrdem).orElseThrow(() -> new ObjectNotFoundException("Ordem de serviço não encontrada"));
		List<ComentarioDTO> comentarios = comentarioRepository.findAllByOrdemServico(ordemServico).stream().map(x -> new ComentarioDTO(x)).collect(Collectors.toList());;
		return comentarios;
	}

	public ComentarioDTO buscarComentario(Long idOrdem, Long idComentario) {
		Optional<Comentario> comentario = comentarioRepository.findById(idComentario);
		if (comentario.isPresent()) {
			return new ComentarioDTO(comentario.get());
		}
		throw new ObjectNotFoundException("Comentario não encontrada");
	}
	
}
