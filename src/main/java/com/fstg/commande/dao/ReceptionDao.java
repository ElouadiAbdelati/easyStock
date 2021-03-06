/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.dao;

import com.fstg.commande.bean.Demande;
import com.fstg.commande.bean.Reception;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc
 */
@Repository
public interface ReceptionDao extends JpaRepository<Reception, Long>{
     @Query(" SELECT r FROM Reception r WHERE r.demande=?1 AND r.paye=0")
     public List<Reception> receptionsNonPayee(Demande demande) ;
   
}
