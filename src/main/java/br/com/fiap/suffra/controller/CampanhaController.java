package br.com.fiap.suffra.controller;

import br.com.fiap.suffra.controller.DTO.CampanhaDTO;
import br.com.fiap.suffra.controller.DTO.ContadorRegiaoDTO;
import br.com.fiap.suffra.service.CampanhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/campanhas")
public class CampanhaController {

    @Autowired
    private CampanhaService campanhaService;

    @PostMapping
    public ResponseEntity<CampanhaDTO> criarCampanha(@RequestBody CampanhaDTO campanhaDTO) {
        return ResponseEntity.ok(campanhaService.criarCampanha(campanhaDTO));
    }

    @GetMapping
    public ResponseEntity<List<CampanhaDTO>> listarCampanhas() {
        return ResponseEntity.ok(campanhaService.listarCampanhas());
    }

    @GetMapping("/paginado")
    public ResponseEntity<Page<CampanhaDTO>> listarCampanhasPaginada(Pageable pageable) {
        return ResponseEntity.ok(campanhaService.listarCampanhasPaginadas(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampanhaDTO> buscarCampanhaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(campanhaService.buscarCampanhaPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampanhaDTO> atualizarCampanha(@PathVariable Long id, @RequestBody CampanhaDTO campanhaDTO) {
        CampanhaDTO foundCampanha = campanhaService.buscarCampanhaPorId(id);
        foundCampanha.setNome(campanhaDTO.getNome());
        foundCampanha.setCategoria(campanhaDTO.getCategoria());
        foundCampanha.setEndpoint(campanhaDTO.getEndpoint());
        foundCampanha.setDataInicio(campanhaDTO.getDataInicio());
        foundCampanha.setDataFim(campanhaDTO.getDataFim());
        foundCampanha.setBeneficio_concedido(campanhaDTO.getBeneficio_concedido());
        foundCampanha.setIdRegiaoVencedora(campanhaDTO.getIdRegiaoVencedora());
        foundCampanha.setVariavelContabilizada(campanhaDTO.getVariavelContabilizada());
        return ResponseEntity.ok(campanhaService.criarCampanha(foundCampanha));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCampanha(@PathVariable long id) {
        campanhaService.deletarCampanha(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/contador")
    public ResponseEntity<CollectionModel<ContadorRegiaoDTO>> exibirContador(@PathVariable Long id) {
        List<ContadorRegiaoDTO> contadorRegiaoDTOS = campanhaService.listarContadorersPorCampanhaId(id);

        CollectionModel<ContadorRegiaoDTO> collectionModel = CollectionModel.of(contadorRegiaoDTOS);
        collectionModel.add(linkTo(methodOn(CampanhaController.class).encerrarCampanha(id)).withRel("encerrar-campanha"));

        return ResponseEntity.ok(collectionModel);
    }

    @PutMapping("/{id}/encerrar")
    public ResponseEntity<CampanhaDTO> encerrarCampanha(@PathVariable Long id) {
        CampanhaDTO endedCampanha = campanhaService.encerrarCampanhaPorID(id);
        endedCampanha.add(linkTo(methodOn(CampanhaController.class).buscarCampanhaPorId(id)).withRel("campanha"));

        return ResponseEntity.ok(endedCampanha);
    }
}
