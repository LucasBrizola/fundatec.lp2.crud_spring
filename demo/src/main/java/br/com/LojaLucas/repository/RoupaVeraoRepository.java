package br.com.LojaLucas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.LojaLucas.domain.RoupaVerao;

@Repository
public interface RoupaVeraoRepository extends JpaRepository<RoupaVerao, Integer>{
	
	@Query("SELECT v from RoupaVerao v WHERE v.modelo LIKE %:modelo% ORDER BY v.modelo")
	public Optional<RoupaVerao> findByName(@Param("modelo") String modelo);
	
}
