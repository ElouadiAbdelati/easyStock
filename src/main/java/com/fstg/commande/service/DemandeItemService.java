/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service;

import com.fstg.commande.bean.Demande;
import com.fstg.commande.bean.DemandeItem;
import com.fstg.commande.bean.Produit;
import java.util.List;

/**
 *
 * @author pc
 */
public interface DemandeItemService {
    public int saveDemandeItem(Demande demande,List<DemandeItem> demandeItems);
    public void save(DemandeItem demandeItem);
    public List<DemandeItem> findByDemande(Demande demande);
    
           public DemandeItem findByProduitAndDemande(Produit produit,Demande demande);

}
