/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service;

import com.fstg.commande.bean.Commande;
import com.fstg.commande.bean.CommandeItem;

import java.util.List;

/**
 *
 * @author pc
 */
public interface CommandeItemService {
    
      public int   saveCommandeItem(Commande commande,List<CommandeItem>  commandeItems);
          public List<CommandeItem> findByCommande(Commande commande);
}
