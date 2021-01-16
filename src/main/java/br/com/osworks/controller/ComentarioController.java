package br.com.osworks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.osworks.controller.dto.ComentarioDTO;
import br.com.osworks.controller.dto.ComentarioInput;
import br.com.osworks.service.OrdemServicoService;

@RestController
@RequestMapping(value = "/ordens-servico/{idOrdem}/comentarios")
public class ComentarioController {

	@Autowired
	private OrdemServicoService os;

	
	@PostMapping
	public ComentarioDTO criarComentario(@PathVariable Long idOrdem, @RequestBody ComentarioInput comentario){
		return os.criarComentario(idOrdem, comentario);
	}
	
	@GetMapping
	public List<ComentarioDTO> listarComentarios(@PathVariable Long idOrdem){
		return os.listarComentarios(idOrdem);
	}
	
	@GetMapping("/{idComentario}")
	public ComentarioDTO buscarComentario(@PathVariable Long idOrdem, @PathVariable Long idComentario){
		return os.buscarComentario(idOrdem, idComentario);
	}
	
}
