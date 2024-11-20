package br.com.fiap.suffra.service;

import br.com.fiap.suffra.controller.DTO.UsuarioDTO;
import br.com.fiap.suffra.entity.Usuario;
import br.com.fiap.suffra.exception.NaoEncontradoException;
import br.com.fiap.suffra.exception.UsuarioJaExisteException;
import br.com.fiap.suffra.repository.UsuarioRepository;
import br.com.fiap.suffra.service.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioMapper usuarioMapper;

    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.usuarioDTOToUsuario(usuarioDTO);

        if (usuario.getCpf() != null && !usuario.getCpf().isEmpty()) {
            Optional<Usuario> existingUsuario = usuarioRepository.findByCpf(usuario.getCpf());
            if (existingUsuario.isPresent()) {
                throw new UsuarioJaExisteException("Usuário com CPF " + usuario.getCpf() + " já existe");
            }
        }
        Usuario savedUsuario = usuarioRepository.save(usuario);
        usuarioDTO.setId(savedUsuario.getId());
        return usuarioDTO;
    }

    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> usuarioMapper.usuarioToUsuarioDTO(usuario))
                .collect(Collectors.toList());
    }

    public Page<UsuarioDTO> listarUsuariosPaginadas(Pageable pageable) {
        return usuarioRepository.findAll(pageable).map(usuario -> usuarioMapper.usuarioToUsuarioDTO(usuario));
    }

    public UsuarioDTO buscarUsuarioPorId(Long id) {
        Usuario foundUsuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Usuario não encontrada"));
        return usuarioMapper.usuarioToUsuarioDTO(foundUsuario);
    }

    public void deletarUsuario(Long id) {usuarioRepository.deleteById(id);}

}
