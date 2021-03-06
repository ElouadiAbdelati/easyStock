/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.dao;

import com.fstg.commande.bean.Commande;
import com.fstg.commande.bean.CommandeItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc
 */
@Repository
public interface  CommandeItemDao extends JpaRepository<CommandeItem,Long>{
    
    public List<CommandeItem> findByCommande(Commande commande);
} 
    

