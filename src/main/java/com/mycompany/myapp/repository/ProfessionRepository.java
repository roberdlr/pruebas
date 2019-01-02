package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Profession;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Profession entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProfessionRepository extends JpaRepository<Profession, Long> {

}
