/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service;

import com.fstg.commande.bean.BonLivraison;
import com.fstg.commande.bean.Commande;
import java.util.List;

/**
 *
 * @author pc
 */
public interface BonLivraisonService {
    public void  bonLivriasonCommande(BonLivraison bonLivraison);
    public List<BonLivraison> findByCommande(Commande commande);
    
}
