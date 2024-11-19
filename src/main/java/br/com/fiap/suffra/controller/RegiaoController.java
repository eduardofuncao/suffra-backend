package br.com.fiap.suffra.controller;

import br.com.fiap.suffra.controller.DTO.RegiaoDTO;
import br.com.fiap.suffra.service.RegiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regioes")
public class RegiaoController {

    @Autowired
    private RegiaoService regiaoService;

    @PostMapping
    public ResponseEntity<RegiaoDTO> criarRegiao(@RequestBody RegiaoDTO regiaoDTO) {
        return ResponseEntity.ok(regiaoService.criarRegiao(regiaoDTO));
    }

    @GetMapping
    public ResponseEntity<List<RegiaoDTO>> listarRegiaos() {
        return ResponseEntity.ok(regiaoService.listarRegiaos());
    }

    @GetMapping("/paginado")
    public ResponseEntity<Page<RegiaoDTO>> listarRegiaosPaginada(Pageable pageable) {
        return ResponseEntity.ok(regiaoService.listarRegiaosPaginadas(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegiaoDTO> buscarRegiaoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(regiaoService.buscarRegiaoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegiaoDTO> atualizarRegiao(@PathVariable Long id, @RequestBody RegiaoDTO regiaoDTO) {
        RegiaoDTO foundRegiao = regiaoService.buscarRegiaoPorId(id);
        foundRegiao.setNome(regiaoDTO.getNome());
        foundRegiao.setDescricao(regiaoDTO.getDescricao());
        foundRegiao.setContador(regiaoDTO.getContador());
        foundRegiao.setCampanhaId(regiaoDTO.getCampanhaId());
        return ResponseEntity.ok(regiaoService.criarRegiao(foundRegiao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRegiao(@PathVariable long id) {
        regiaoService.deletarRegiao(id);
        return ResponseEntity.noContent().build();
    }
}
