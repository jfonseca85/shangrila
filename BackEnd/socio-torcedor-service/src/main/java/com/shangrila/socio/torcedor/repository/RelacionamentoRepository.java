package com.shangrila.socio.torcedor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.shangrila.socio.torcedor.model.IdRelacionamento;
import com.shangrila.socio.torcedor.model.Relacionamento;

@Repository
public interface RelacionamentoRepository extends JpaQueryDslPredicateRepository<Relacionamento, IdRelacionamento>{

	List<Relacionamento> findByIdSoccerTeam(Integer idSoccerTeam);


}
