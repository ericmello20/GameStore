package br.cefetrj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.cefetrj.model.Dlc;
import br.cefetrj.repository.DlcRepository;

@Service
public class DlcService {
    protected DlcRepository repository;

    public DlcService(DlcRepository repository) {
        this.repository = repository;
    }

    public Dlc save(Dlc entity) {
        return repository.save(entity);
    }

    public Dlc update(Dlc entity) {
        return repository.save(entity);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Optional<Dlc> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Dlc> findAll() {

        return repository.findAll();
    }
}
