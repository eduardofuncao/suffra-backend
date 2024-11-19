package br.com.fiap.suffra.repository;

import br.com.fiap.suffra.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
