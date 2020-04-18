/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.dao;

import com.fstg.commande.bean.Demande;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc
 */
@Repository
public interface DemandeDao extends JpaRepository<Demande, Long>{
       public Demande findByReference(String referece);
       
       @Query("SELECT d FROM Demande d WHERE d.dateDemande LIKE '%?1%' ")
       public List<Demande> nbrDemande_Annee(Date annee) ;

}
