package br.com.fiap.suffra.repository;

import br.com.fiap.suffra.entity.Campanha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampanhaRepository extends JpaRepository<Campanha, Long> {
}
