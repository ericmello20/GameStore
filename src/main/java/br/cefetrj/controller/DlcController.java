package br.cefetrj.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.cefetrj.model.Dlc;
import br.cefetrj.service.DlcService;
import br.cefetrj.to.input.DlcTOInput;
import br.cefetrj.to.output.DlcTOOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
    @ApiOperation(value = "Salvar registro", notes = "Salva uma nova DLC no banco de dados")
    public ResponseEntity<DlcTOOutput> save(@RequestBody DlcTOInput input) {
        Dlc dlc = input.build();
        Dlc created = dlcService.save(dlc);
        return new ResponseEntity<>(new DlcTOOutput(created), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Pesquisar por ID", notes = "Retorna a DLC de acordo com o ID repassado")
    public ResponseEntity<DlcTOOutput> findById(@PathVariable("id") Integer id) {
        return dlcService.findById(id)
                .map(dlc -> ResponseEntity.ok(new DlcTOOutput(dlc)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @ApiOperation(value = "Listar todos", notes = "Retorna todas as DLCs")
    public ResponseEntity<List<DlcTOOutput>> findAll() {
        List<DlcTOOutput> dlcs = dlcService.findAll()
                .stream()
                .map(DlcTOOutput::new)
                .toList();
        return ResponseEntity.ok(dlcs);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar por ID", notes = "Remove a DLC de acordo com o ID repassado")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        dlcService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar registro", notes = "Atualiza a DLC de acordo com o ID repassado")
    public ResponseEntity<DlcTOOutput> update(
            @PathVariable("id") Integer id,
            @RequestBody DlcTOInput input) {

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
                    return ResponseEntity.ok(new DlcTOOutput(atualizado));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
