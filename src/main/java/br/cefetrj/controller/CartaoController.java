package br.cefetrj.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.cefetrj.model.Cartao;
import br.cefetrj.service.CartaoService;
import br.cefetrj.to.input.CartaoTOInput;
import br.cefetrj.to.output.CartaoTOOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/cartoes", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/cartoes", tags = { "Cartoes - CartaoController" })
public class CartaoController {

    private final CartaoService cartaoService;

    @Autowired
    public CartaoController(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }

    @PostMapping
    @ApiOperation(value = "Salvar registro", notes = "Salva um novo cartão no banco de dados")
    public ResponseEntity<CartaoTOOutput> save(@RequestBody CartaoTOInput input) {
        Cartao cartao = input.build();
        Cartao created = cartaoService.save(cartao);
        return new ResponseEntity<>(new CartaoTOOutput(created), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Pesquisar por ID", notes = "Retorna o cartão de acordo com o ID repassado")
    public ResponseEntity<CartaoTOOutput> findById(@PathVariable("id") Integer id) {
        return cartaoService.findById(id)
                .map(cartao -> ResponseEntity.ok(new CartaoTOOutput(cartao)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @ApiOperation(value = "Listar todos", notes = "Retorna todos os cartões")
    public ResponseEntity<List<CartaoTOOutput>> findAll() {
        List<CartaoTOOutput> cartoes = cartaoService.findAll()
                .stream()
                .map(CartaoTOOutput::new)
                .toList();
        return ResponseEntity.ok(cartoes);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar por ID", notes = "Remove o cartão de acordo com o ID repassado")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        cartaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar registro", notes = "Atualiza o cartão de acordo com o ID repassado")
    public ResponseEntity<CartaoTOOutput> update(
            @PathVariable("id") Integer id,
            @RequestBody CartaoTOInput input) {

        return cartaoService.findById(id)
                .map(existing -> {
                    existing.setNumero(input.getNumero());
                    existing.setValidade(input.getValidade());
                    existing.setCvv(input.getCvv());
                    existing.setCpfTitular(input.getCpfTitular());
                    existing.setBandeira(input.getBandeira());
                    Cartao atualizado = cartaoService.save(existing);
                    return ResponseEntity.ok(new CartaoTOOutput(atualizado));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
