/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service;
import com.fstg.commande.bean.Commande;
/**
 *
 * @author pc
 */
public interface CommandeService {
     public Commande  saveCommandeWithCommandeItem(Commande commande);
     //public Commande  saveCommandeWithPaiment(Commande commande,List<Paiement> paiments);
     public Commande findByReference(String referece);
}

