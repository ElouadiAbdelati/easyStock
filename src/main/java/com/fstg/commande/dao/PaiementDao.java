/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.dao;

import com.fstg.commande.bean.Commande;
import com.fstg.commande.bean.Paiement;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc
 */
@Repository
public interface  PaiementDao extends JpaRepository<Paiement, Long>{
    List<Paiement> findByCommande(Commande commande);
    Paiement findByCode(String code);
    @Query("SELECT p FROM Paiement p where p.code=?2 and p.commande=?1")
     Paiement  findByCommandeAndCode(Commande commande,String code); 
}
