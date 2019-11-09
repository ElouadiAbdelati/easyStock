/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service;
import com.fstg.commande.bean.CommandeItem;
import com.fstg.commande.bean.Produit;

/**
 *
 * @author pc
 */

public interface ProduitService {
      public Produit saveProduit(Produit produit,CommandeItem commandeItem);
      public Produit finByReference(String reference);
}
