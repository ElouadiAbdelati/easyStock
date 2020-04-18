/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.dao;

import com.fstg.commande.bean.Demande;
import com.fstg.commande.bean.DemandeItem;
import com.fstg.commande.bean.Produit;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc
 */
@Repository
public interface DemandeItemDao extends JpaRepository<DemandeItem, Long>{
       public List<DemandeItem> findByDemande(Demande demande);
       
       @Query("SELECT d FROM DemandeItem d WHERE d.produit=?1 and d.demande=?2")
       public DemandeItem findByProduitAndDemande(Produit produit,Demande demande);
}
