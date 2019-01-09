package br.com.LojaLucas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.LojaLucas.domain.RoupaInverno;

@Repository
public interface RoupaInvernoRepository extends JpaRepository<RoupaInverno, Integer>{
	
	@Query("SELECT i from Roupa i WHERE i.modelo LIKE %:modelo% ORDER BY i.modelo")
	public Optional<RoupaInverno> findByName(@Param("modelo") String modelo);
	
}