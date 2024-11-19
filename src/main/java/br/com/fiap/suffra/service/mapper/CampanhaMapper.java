package br.com.fiap.suffra.service.mapper;

import br.com.fiap.suffra.controller.DTO.CampanhaDTO;
import br.com.fiap.suffra.entity.Campanha;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CampanhaMapper {
    CampanhaDTO campanhaToCampanhaDTO(Campanha campanha);

    Campanha campanhaDTOToCampanha(CampanhaDTO campanhaDTO);

    List<CampanhaDTO> campanhasToCampanhasDTO(List<Campanha> campanhas);

    List<Campanha> campanhasDTOToCampanhas(List<CampanhaDTO> campanhasDTO);
}
