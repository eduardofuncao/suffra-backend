package br.com.fiap.suffra.service;

import br.com.fiap.suffra.controller.DTO.CampanhaDTO;
import br.com.fiap.suffra.controller.DTO.ContadorRegiaoDTO;
import br.com.fiap.suffra.entity.Campanha;
import br.com.fiap.suffra.exception.CampanhaJaFinalizadaException;
import br.com.fiap.suffra.exception.NaoEncontradoException;
import br.com.fiap.suffra.repository.CampanhaRepository;
import br.com.fiap.suffra.service.mapper.CampanhaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampanhaService {

    @Autowired
    private CampanhaRepository campanhaRepository;
    @Autowired
    private CampanhaMapper campanhaMapper;

    public CampanhaDTO criarCampanha(CampanhaDTO campanhaDTO) {
        Campanha savedCampanha = campanhaRepository.save(campanhaMapper.campanhaDTOToCampanha(campanhaDTO));
        campanhaDTO.setId(savedCampanha.getId());
        return campanhaDTO;
    }

    public List<CampanhaDTO> listarCampanhas() {
        return campanhaRepository.findAll()
                .stream()
                .map(campanha -> campanhaMapper.campanhaToCampanhaDTO(campanha))
                .collect(Collectors.toList());
    }

    public Page<CampanhaDTO> listarCampanhasPaginadas(Pageable pageable) {
        return campanhaRepository.findAll(pageable).map(campanha -> campanhaMapper.campanhaToCampanhaDTO(campanha));
    }

    public CampanhaDTO buscarCampanhaPorId(Long id) {
        Campanha foundCampanha = campanhaRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Campanha não encontrada"));
        return campanhaMapper.campanhaToCampanhaDTO(foundCampanha);
    }

    public void deletarCampanha(Long id) {campanhaRepository.deleteById(id);}

    public CampanhaDTO encerrarCampanhaPorID(Long id) {
       Campanha foundCampanha = campanhaRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Campanha não encontrada"));
       if (foundCampanha.getIdRegiaoVencedora() != null && foundCampanha.getIdRegiaoVencedora() > 0) {
            throw new CampanhaJaFinalizadaException("Essa campanha já foi finalizada! a Região vencedora foi a de id " + foundCampanha.getIdRegiaoVencedora());
       }
       foundCampanha.setDataFim(LocalDateTime.now());
       foundCampanha.setIdRegiaoVencedora(campanhaRepository.findIdOfRegiaoWithHighestContador(foundCampanha.getId()));
       return campanhaMapper.campanhaToCampanhaDTO(foundCampanha);
    }

    public List<ContadorRegiaoDTO> listarContadorersPorCampanhaId(Long id) {
        return campanhaRepository.findContadoresByCampanhaId(id);
    }

}
