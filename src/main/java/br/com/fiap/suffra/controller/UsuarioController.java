package br.com.fiap.suffra.controller;

import br.com.fiap.suffra.controller.DTO.UsuarioDTO;
import br.com.fiap.suffra.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.criarUsuario(usuarioDTO));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/paginado")
    public ResponseEntity<Page<UsuarioDTO>> listarUsuariosPaginada(Pageable pageable) {
        return ResponseEntity.ok(usuarioService.listarUsuariosPaginadas(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO foundUsuario = usuarioService.buscarUsuarioPorId(id);
        foundUsuario.setNome(usuarioDTO.getNome());
        foundUsuario.setCpf(usuarioDTO.getCpf());
        foundUsuario.setEmail(usuarioDTO.getEmail());
        foundUsuario.setTelefone(usuarioDTO.getTelefone());
        return ResponseEntity.ok(usuarioService.criarUsuario(foundUsuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
