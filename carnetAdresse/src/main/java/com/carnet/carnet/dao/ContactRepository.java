package com.carnet.carnet.dao;

import com.carnet.carnet.entities.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
       @Query  ("select  c from Contact c where c.nom like :x")
         public   Page<Contact> chercher(@Param("x") String c, Pageable pageable);
    }

