package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Gnome;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Gnome entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GnomeRepository extends JpaRepository<Gnome, Long> {

}
