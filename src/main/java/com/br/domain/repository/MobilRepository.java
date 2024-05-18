package com.br.domain.repository;

import java.util.Optional;

import com.br.domain.model.Movement;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.br.domain.model.Mobil;

@Repository
public interface MobilRepository extends JpaRepository<Mobil, Long>, JpaSpecificationExecutor<Movement> {

	@Query("SELECT m FROM Mobil m LEFT JOIN FETCH m.movimentacoes WHERE m.mobilId = :mobilId")
	Optional<Mobil> findByIdWithMovimentacoes(@Param("mobilId") Long mobilId);
	Optional<Mobil> findById(Long mobilId);

}
