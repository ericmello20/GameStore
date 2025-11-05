package br.cefetrj.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import br.cefetrj.model.Jogo;
import br.cefetrj.service.JogoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/jogos", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/jogos", tags = { "Jogos - JogoController" })
public class JogoController {
    private final JogoService jogoService;

    @Autowired
    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @PostMapping
    @ApiOperation(value = "Salvar registro", notes = "Salva um novo registro no banco de dados")
    public ResponseEntity<Jogo> save(@RequestBody Jogo input) {
        final var jogo = input;

        System.out.println("Salvando jogo: " + jogo.getNome());

        final Jogo created = jogoService.save(jogo);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Pesquisar por ID", notes = "Retorna o registro de acordo com o ID repassado")
    public ResponseEntity<Jogo> findById(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(jogoService.findById(id).orElse(null));

    }

    @GetMapping
    @ApiOperation(value = "Listar todos", notes = "Retorna todos os registros")
    public ResponseEntity<List<Jogo>> findAll() {

        return ResponseEntity.ok(jogoService.findAll());

    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar por ID", notes = "Remove o registro de acordo com o ID repassado")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {

        jogoService.delete(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar registro", notes = "Atualiza o registro de acordo com o ID repassado")
    public ResponseEntity<Jogo> update(
            @PathVariable("id") Integer id,
            @RequestBody Jogo input) {

        return jogoService.findById(id)
                .map(existing -> {
                    existing.setNome(input.getNome());
                    existing.setDesenvolvedora(input.getDesenvolvedora());
                    existing.setDescricao(input.getDescricao());
                    existing.setValor(input.getValor());
                    existing.setpCusto(input.getpCusto());
                    existing.setDataLancamento(input.getDataLancamento());

                    Jogo atualizado = jogoService.save(existing);
                    return ResponseEntity.ok(atualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
