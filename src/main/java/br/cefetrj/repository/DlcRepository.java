package br.cefetrj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.cefetrj.model.Dlc;

@Repository
public interface DlcRepository extends JpaRepository<Dlc, Integer>, JpaSpecificationExecutor<Dlc> {

}