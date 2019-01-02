package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.GnomeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Gnome and its DTO GnomeDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface GnomeMapper extends EntityMapper<GnomeDTO, Gnome> {



    default Gnome fromId(Long id) {
        if (id == null) {
            return null;
        }
        Gnome gnome = new Gnome();
        gnome.setId(id);
        return gnome;
    }
}
