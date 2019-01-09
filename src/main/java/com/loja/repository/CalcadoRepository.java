package com.loja.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.loja.domain.Calcado;

@Repository
public interface CalcadoRepository extends JpaRepository<Calcado, Integer>{
	
	@Query("SELECT c from Calcado c WHERE c.modelo LIKE %:modelo% ORDER BY c.modelo")
	public Optional<Calcado> findByName(@Param("modelo") String modelo);
	
}
