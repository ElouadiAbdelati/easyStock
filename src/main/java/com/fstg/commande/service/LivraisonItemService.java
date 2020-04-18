/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service;

import com.fstg.commande.bean.BonLivraison;
import com.fstg.commande.bean.CommandeItem;
import com.fstg.commande.bean.LivraisonItem;
import java.util.List;

/**
 *
 * @author pc
 */
public interface LivraisonItemService {
    public int saveLivraisonItem(BonLivraison bonLivraison,List< LivraisonItem> livraisonItems,
            List<CommandeItem> commandeItems);
    
   public List<LivraisonItem> findByBonLivraison(BonLivraison bonLivraison);
    
}
