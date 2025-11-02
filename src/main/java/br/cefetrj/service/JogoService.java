package br.cefetrj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.cefetrj.model.Jogo;
import br.cefetrj.repository.JogoRepository;

@Service
public class JogoService {
    protected JogoRepository repository;

    public JogoService(JogoRepository repository) {
        this.repository = repository;
    }

    public Jogo save(Jogo entity) {
        return repository.save(entity);
    }

    public Jogo update(Jogo entity) {
        return repository.save(entity);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Optional<Jogo> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Jogo> findAll() {

        return repository.findAll();
    }
}
