package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.ProfessionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Profession and its DTO ProfessionDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProfessionMapper extends EntityMapper<ProfessionDTO, Profession> {



    default Profession fromId(Long id) {
        if (id == null) {
            return null;
        }
        Profession profession = new Profession();
        profession.setId(id);
        return profession;
    }
}
