package br.com.fiap.suffra.service.mapper;

import br.com.fiap.suffra.controller.DTO.RegiaoDTO;
import br.com.fiap.suffra.entity.Regiao;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegiaoMapper {

    RegiaoDTO regiaoToRegiaoDTO(Regiao regiao);

    Regiao regiaoDTOToRegiao(RegiaoDTO regiaoDTO);

    List<RegiaoDTO> regiaosToRegiaosDTO(List<Regiao> regiaos);

    List<Regiao> regiaosDTOToRegiaos(List<RegiaoDTO> regiaosDTO);
}
