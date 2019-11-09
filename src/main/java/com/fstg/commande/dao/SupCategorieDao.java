/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.dao;

import com.fstg.commande.bean.SupCategorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc
 */
@Repository
public interface SupCategorieDao extends  JpaRepository<SupCategorie, Long>{
    public SupCategorie findByNom(String nom);
    
}
