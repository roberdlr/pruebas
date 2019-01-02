package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Gnome;
import com.mycompany.myapp.repository.GnomeRepository;
import com.mycompany.myapp.service.dto.GnomeDTO;
import com.mycompany.myapp.service.mapper.GnomeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Gnome.
 */
@Service
@Transactional
public class GnomeService {

    private final Logger log = LoggerFactory.getLogger(GnomeService.class);

    private final GnomeRepository gnomeRepository;

    private final GnomeMapper gnomeMapper;

    public GnomeService(GnomeRepository gnomeRepository, GnomeMapper gnomeMapper) {
        this.gnomeRepository = gnomeRepository;
        this.gnomeMapper = gnomeMapper;
    }

    /**
     * Save a gnome.
     *
     * @param gnomeDTO the entity to save
     * @return the persisted entity
     */
    public GnomeDTO save(GnomeDTO gnomeDTO) {
        log.debug("Request to save Gnome : {}", gnomeDTO);

        Gnome gnome = gnomeMapper.toEntity(gnomeDTO);
        gnome = gnomeRepository.save(gnome);
        return gnomeMapper.toDto(gnome);
    }

    /**
     * Get all the gnomes.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<GnomeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Gnomes");
        return gnomeRepository.findAll(pageable)
            .map(gnomeMapper::toDto);
    }


    /**
     * Get one gnome by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<GnomeDTO> findOne(Long id) {
        log.debug("Request to get Gnome : {}", id);
        return gnomeRepository.findById(id)
            .map(gnomeMapper::toDto);
    }

    /**
     * Delete the gnome by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Gnome : {}", id);
        gnomeRepository.deleteById(id);
    }
}
