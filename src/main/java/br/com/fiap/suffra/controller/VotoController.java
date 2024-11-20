package br.com.fiap.suffra.controller;

import br.com.fiap.suffra.controller.DTO.VotoDTO;
import br.com.fiap.suffra.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/votos")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @PostMapping
    public ResponseEntity<VotoDTO> criarVoto(@RequestBody VotoDTO votoDTO) {
        VotoDTO createdVoto = votoService.criarVoto(votoDTO);

        createdVoto.add(linkTo(methodOn(VotoController.class).listarVotos()).withRel("listar-votos"));
        createdVoto.add(linkTo(methodOn(CampanhaController.class).exibirContador(votoDTO.getId())).withRel("listar-contadores-por-regiao"));

        return ResponseEntity.ok(votoService.criarVoto(votoDTO));
    }

    @GetMapping
    public ResponseEntity<List<VotoDTO>> listarVotos() {
        List<VotoDTO> votosDTO = votoService.listarVotos();

        votosDTO.forEach(votoDTO -> {
            votoDTO.add(linkTo(methodOn(VotoController.class).atualizarVoto(votoDTO.getId(), votoDTO)).withRel("atualizar-voto"));
            votoDTO.add(linkTo(methodOn(VotoController.class).deletarVoto(votoDTO.getId())).withRel("deletar-voto"));
        });

        return ResponseEntity.ok(votosDTO);
    }

    @GetMapping("/paginado")
    public ResponseEntity<Page<VotoDTO>> listarVotosPaginada(Pageable pageable) {
        return ResponseEntity.ok(votoService.listarVotosPaginadas(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VotoDTO> buscarVotoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(votoService.buscarVotoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VotoDTO> atualizarVoto(@PathVariable Long id, @RequestBody VotoDTO votoDTO) {
        VotoDTO foundVoto = votoService.buscarVotoPorId(id);
        foundVoto.setDataVoto(votoDTO.getDataVoto());
        foundVoto.setPeso(votoDTO.getPeso());
        foundVoto.setRegiaoId(votoDTO.getRegiaoId());
        foundVoto.setUsuarioId(votoDTO.getUsuarioId());
        return ResponseEntity.ok(votoService.criarVoto(foundVoto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVoto(@PathVariable long id) {
        votoService.deletarVoto(id);
        return ResponseEntity.noContent().build();
    }
}
