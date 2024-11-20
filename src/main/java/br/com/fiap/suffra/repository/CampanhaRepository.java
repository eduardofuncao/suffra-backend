package br.com.fiap.suffra.repository;

import br.com.fiap.suffra.controller.DTO.ContadorRegiaoDTO;
import br.com.fiap.suffra.entity.Campanha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CampanhaRepository extends JpaRepository<Campanha, Long> {
    @Query("SELECT new br.com.fiap.suffra.controller.DTO.ContadorRegiaoDTO(r.id, r.contador) FROM Campanha c JOIN Regiao r on c.id = r.campanha.id WHERE c.id=:searchedId")
    List<ContadorRegiaoDTO> findContadoresByCampanhaId(@Param("searchedId") Long searchedId);

    @Query("SELECT r.id FROM Campanha c JOIN Regiao r on c.id = r.campanha.id WHERE c.id=:searchedId ORDER BY r.contador DESC LIMIT 1")
    long findIdOfRegiaoWithHighestContador(@Param("searchedId") Long searchedId);

}
