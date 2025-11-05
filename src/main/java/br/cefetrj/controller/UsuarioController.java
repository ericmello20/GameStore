package br.cefetrj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.cefetrj.model.Biblioteca;
import br.cefetrj.model.Usuario;
import br.cefetrj.service.UsuarioService;
import br.cefetrj.to.input.UsuarioTOInput;
import br.cefetrj.to.output.UsuarioTOOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/usuarios", tags = { "Usuarios - UsuarioController" })
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @ApiOperation(value = "Salvar registro", notes = "Salva um novo registro no banco de dados")
    public ResponseEntity<UsuarioTOOutput> save(@RequestBody UsuarioTOInput input) {
        Usuario usuario = input.build();

        if (usuario.getBiblioteca() == null) {
            var biblioteca = new Biblioteca();
            biblioteca.setUsuario(usuario);
            usuario.setBiblioteca(biblioteca);
        }

        Usuario created = usuarioService.save(usuario);
        return new ResponseEntity<>(new UsuarioTOOutput(created), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Pesquisar por ID", notes = "Retorna o registro de acordo com o ID repassado")
    public ResponseEntity<UsuarioTOOutput> findById(@PathVariable("id") Integer id) {
        return usuarioService.findById(id)
                .map(usuario -> ResponseEntity.ok(new UsuarioTOOutput(usuario)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @ApiOperation(value = "Listar todos", notes = "Retorna todos os registros")
    public ResponseEntity<List<UsuarioTOOutput>> findAll() {
        List<UsuarioTOOutput> usuarios = usuarioService.findAll()
                .stream()
                .map(UsuarioTOOutput::new)
                .toList();

        return ResponseEntity.ok(usuarios);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar por ID", notes = "Remove o registro de acordo com o ID repassado")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar registro", notes = "Atualiza o registro de acordo com o ID repassado")
    public ResponseEntity<UsuarioTOOutput> update(
            @PathVariable("id") Integer id,
            @RequestBody UsuarioTOInput input) {

        return usuarioService.findById(id)
                .map(existing -> {
                    existing.setNome(input.getNome());
                    existing.setEmail(input.getEmail());
                    existing.setSenha(input.getSenha());
                    existing.setDataNascimento(input.getDataNascimento());

                    Usuario atualizado = usuarioService.save(existing);
                    return ResponseEntity.ok(new UsuarioTOOutput(atualizado));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
