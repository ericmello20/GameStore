package br.cefetrj.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.cefetrj.model.Jogo;
import br.cefetrj.service.JogoService;
import br.cefetrj.to.input.JogoTOInput;
import br.cefetrj.to.output.JogoTOOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
    @ApiOperation(value = "Salvar registro", notes = "Salva um novo jogo no banco de dados")
    public ResponseEntity<JogoTOOutput> save(@RequestBody JogoTOInput input) {
        Jogo jogo = input.build();
        Jogo created = jogoService.save(jogo);
        return new ResponseEntity<>(new JogoTOOutput(created), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Pesquisar por ID", notes = "Retorna o jogo de acordo com o ID repassado")
    public ResponseEntity<JogoTOOutput> findById(@PathVariable("id") Integer id) {
        return jogoService.findById(id)
                .map(jogo -> ResponseEntity.ok(new JogoTOOutput(jogo)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @ApiOperation(value = "Listar todos", notes = "Retorna todos os jogos")
    public ResponseEntity<List<JogoTOOutput>> findAll() {
        List<JogoTOOutput> jogos = jogoService.findAll()
                .stream()
                .map(JogoTOOutput::new)
                .toList();
        return ResponseEntity.ok(jogos);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar por ID", notes = "Remove o jogo de acordo com o ID repassado")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        jogoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar registro", notes = "Atualiza o jogo de acordo com o ID repassado")
    public ResponseEntity<JogoTOOutput> update(
            @PathVariable("id") Integer id,
            @RequestBody JogoTOInput input) {

        return jogoService.findById(id)
                .map(existing -> {
                    existing.setNome(input.getNome());
                    existing.setDesenvolvedora(input.getDesenvolvedora());
                    existing.setDescricao(input.getDescricao());
                    existing.setValor(input.getValor());
                    existing.setpCusto(input.getpCusto());
                    existing.setDataLancamento(input.getDataLancamento());
                    Jogo atualizado = jogoService.save(existing);
                    return ResponseEntity.ok(new JogoTOOutput(atualizado));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
