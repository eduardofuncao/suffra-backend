package br.com.fiap.suffra.service.mapper;

import br.com.fiap.suffra.controller.DTO.VotoDTO;
import br.com.fiap.suffra.entity.Voto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VotoMapper {

    VotoDTO votoToVotoDTO(Voto voto);

    Voto votoDTOToVoto(VotoDTO votoDTO);

    List<VotoDTO> votosToVotosDTO(List<Voto> votos);

    List<Voto> votosDTOToVotos(List<VotoDTO> votosDTO);
}
