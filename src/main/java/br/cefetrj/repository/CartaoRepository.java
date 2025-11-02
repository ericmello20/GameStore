package br.cefetrj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.cefetrj.model.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Integer>, JpaSpecificationExecutor<Cartao> {

}