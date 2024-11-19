package br.com.fiap.suffra.service.mapper;

import br.com.fiap.suffra.controller.DTO.UsuarioDTO;
import br.com.fiap.suffra.entity.Usuario;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);

    Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO);

    List<UsuarioDTO> usuariosToUsuariosDTO(List<Usuario> usuarios);

    List<Usuario> usuariosDTOToUsuarios(List<UsuarioDTO> usuariosDTO);
}
