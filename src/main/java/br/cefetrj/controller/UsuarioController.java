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

import br.cefetrj.model.Biblioteca;
import br.cefetrj.model.Usuario;
import br.cefetrj.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

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
    public ResponseEntity<Usuario> save(@RequestBody Usuario input) {
        final var usuario = input;

        System.out.println("Salvando usuario: " + usuario.getNome());

        if (usuario.getBiblioteca() == null) {
            var biblioteca = new Biblioteca();
            biblioteca.setUsuario(usuario);
            usuario.setBiblioteca(biblioteca);
        }

        final Usuario created = usuarioService.save(usuario);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Pesquisar por ID", notes = "Retorna o registro de acordo com o ID repassado")
    public ResponseEntity<Usuario> findById(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(usuarioService.findById(id).orElse(null));

    }

    @GetMapping
    @ApiOperation(value = "Listar todos", notes = "Retorna todos os registros")
    public ResponseEntity<List<Usuario>> findAll() {

        return ResponseEntity.ok(usuarioService.findAll());

    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar por ID", notes = "Remove o registro de acordo com o ID repassado")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {

        usuarioService.delete(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar registro", notes = "Atualiza o registro de acordo com o ID repassado")
    public ResponseEntity<Usuario> update(
            @PathVariable("id") Integer id,
            @RequestBody Usuario input) {

        return usuarioService.findById(id)
                .map(existing -> {
                    existing.setNome(input.getNome());
                    existing.setEmail(input.getEmail());
                    existing.setSenha(input.getSenha());
                    existing.setDataNascimento(input.getDataNascimento());
                    Usuario atualizado = usuarioService.save(existing);
                    return ResponseEntity.ok(atualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
