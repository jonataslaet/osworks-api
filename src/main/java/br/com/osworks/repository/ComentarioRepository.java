package br.com.osworks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.osworks.model.Comentario;
import br.com.osworks.model.OrdemServico;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
	List<Comentario> findAllByOrdemServico(OrdemServico ordemServico);
}
