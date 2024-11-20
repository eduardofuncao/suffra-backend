package br.com.fiap.suffra.service;

import br.com.fiap.suffra.controller.DTO.VotoDTO;
import br.com.fiap.suffra.entity.Regiao;
import br.com.fiap.suffra.entity.Usuario;
import br.com.fiap.suffra.entity.Voto;
import br.com.fiap.suffra.exception.NaoEncontradoException;
import br.com.fiap.suffra.exception.VotoFuturoException;
import br.com.fiap.suffra.repository.RegiaoRepository;
import br.com.fiap.suffra.repository.UsuarioRepository;
import br.com.fiap.suffra.repository.VotoRepository;
import br.com.fiap.suffra.service.mapper.VotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;
    @Autowired
    private VotoMapper votoMapper;

    @Autowired
    private RegiaoRepository regiaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public VotoDTO criarVoto(VotoDTO votoDTO) {
        Voto voto = votoMapper.votoDTOToVoto(votoDTO);

        Regiao foundRegiao = regiaoRepository.findById(votoDTO.getRegiaoId())
                .orElseThrow(() -> new NaoEncontradoException("Regiao não encontrada"));
        voto.setRegiao(foundRegiao);

        Usuario foundUsuario = usuarioRepository.findById(votoDTO.getUsuarioId())
                .orElseThrow(() -> new NaoEncontradoException("Usuario não encontrado"));
        voto.setUsuario(foundUsuario);

        if (voto.getDataVoto().isAfter(LocalDateTime.now().plusDays(1))) {
            throw new VotoFuturoException("Para registrar um voto, sua data deve ser uma data de hoje ou mais antiga");
        }

        foundRegiao.setContador(foundRegiao.getContador() + voto.getPeso());
        Voto savedVoto = votoRepository.save(votoMapper.votoDTOToVoto(votoDTO));
        votoDTO.setId(savedVoto.getId());
        return votoDTO;
    }

    public List<VotoDTO> listarVotos() {
        return votoRepository.findAll()
                .stream()
                .map(voto -> votoMapper.votoToVotoDTO(voto))
                .collect(Collectors.toList());
    }

    public Page<VotoDTO> listarVotosPaginadas(Pageable pageable) {
        return votoRepository.findAll(pageable).map(voto -> votoMapper.votoToVotoDTO(voto));
    }

    public VotoDTO buscarVotoPorId(Long id) {
        Voto foundVoto = votoRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Voto não encontrada"));
        return votoMapper.votoToVotoDTO(foundVoto);
    }

    public void deletarVoto(Long id) {votoRepository.deleteById(id);}

}
