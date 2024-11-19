package br.com.fiap.suffra.service;

import br.com.fiap.suffra.controller.DTO.RegiaoDTO;
import br.com.fiap.suffra.entity.Campanha;
import br.com.fiap.suffra.entity.Regiao;
import br.com.fiap.suffra.exception.NaoEncontradoException;
import br.com.fiap.suffra.repository.CampanhaRepository;
import br.com.fiap.suffra.repository.RegiaoRepository;
import br.com.fiap.suffra.service.mapper.RegiaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegiaoService {

    @Autowired
    private RegiaoRepository regiaoRepository;
    @Autowired
    private RegiaoMapper regiaoMapper;

    @Autowired
    private CampanhaRepository campanhaRepository;

    public RegiaoDTO criarRegiao(RegiaoDTO regiaoDTO) {
        Regiao regiao = regiaoMapper.regiaoDTOToRegiao(regiaoDTO);
        Campanha foundCampanha = campanhaRepository.findById(regiaoDTO.getCampanhaId())
                .orElseThrow(() -> new NaoEncontradoException("Campanha não encontrada"));
        regiao.setCampanha(foundCampanha);

        Regiao savedRegiao = regiaoRepository.save(regiao);
        regiaoDTO.setId(savedRegiao.getId());
        return regiaoDTO;
    }

    public List<RegiaoDTO> listarRegiaos() {
        return regiaoRepository.findAll()
                .stream()
                .map(regiao -> regiaoMapper.regiaoToRegiaoDTO(regiao))
                .collect(Collectors.toList());
    }

    public Page<RegiaoDTO> listarRegiaosPaginadas(Pageable pageable) {
        return regiaoRepository.findAll(pageable).map(regiao -> regiaoMapper.regiaoToRegiaoDTO(regiao));
    }

    public RegiaoDTO buscarRegiaoPorId(Long id) {
        Regiao foundRegiao = regiaoRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Regiao não encontrada"));
        return regiaoMapper.regiaoToRegiaoDTO(foundRegiao);
    }

    public void deletarRegiao(Long id) {regiaoRepository.deleteById(id);}


}
