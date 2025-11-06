package br.cefetrj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.cefetrj.model.Cartao;

import br.cefetrj.repository.CartaoRepository;

@Service
public class CartaoService {
    protected CartaoRepository repository;

    public CartaoService(CartaoRepository repository) {
        this.repository = repository;
    }

    public Cartao save(Cartao entity) {
        return repository.save(entity);
    }

    public Cartao update(Cartao entity) {
        return repository.save(entity);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Optional<Cartao> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Cartao> findAll() {

        return repository.findAll();
    }
}
