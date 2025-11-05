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
import br.cefetrj.model.Dlc;
import br.cefetrj.service.DlcService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/dlcs", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/dlcs", tags = { "Dlcs - DlcController" })
public class DlcController {
    private final DlcService dlcService;

    @Autowired
    public DlcController(DlcService dlcService) {
        this.dlcService = dlcService;
    }

    @PostMapping
    @ApiOperation(value = "Salvar registro", notes = "Salva um novo registro no banco de dados")
    public ResponseEntity<Dlc> save(@RequestBody Dlc input) {
        final var dlc = input;

        System.out.println("Salvando dlc: " + dlc.getNome());

        final Dlc created = dlcService.save(dlc);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Pesquisar por ID", notes = "Retorna o registro de acordo com o ID repassado")
    public ResponseEntity<Dlc> findById(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(dlcService.findById(id).orElse(null));

    }

    @GetMapping
    @ApiOperation(value = "Listar todos", notes = "Retorna todos os registros")
    public ResponseEntity<List<Dlc>> findAll() {

        return ResponseEntity.ok(dlcService.findAll());

    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar por ID", notes = "Remove o registro de acordo com o ID repassado")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {

        dlcService.delete(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar registro", notes = "Atualiza o registro de acordo com o ID repassado")
    public ResponseEntity<Dlc> update(
            @PathVariable("id") Integer id,
            @RequestBody Dlc input) {

        return dlcService.findById(id)
                .map(existing -> {
                    existing.setNome(input.getNome());
                    existing.setDesenvolvedora(input.getDesenvolvedora());
                    existing.setDescricao(input.getDescricao());
                    existing.setValor(input.getValor());
                    existing.setpCusto(input.getpCusto());
                    existing.setDataLancamento(input.getDataLancamento());
                    existing.setJogoBase(input.getJogoBase());
                    Dlc atualizado = dlcService.save(existing);
                    return ResponseEntity.ok(atualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
