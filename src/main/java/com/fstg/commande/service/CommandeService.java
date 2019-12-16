/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service;
import com.fstg.commande.bean.Commande;
import com.fstg.commande.bean.Paiement;
import java.util.List;
/**
 *
 * @author pc
 */
public interface CommandeService {
     public Commande  saveCommandeWithCommandeItem(Commande commande);
     public Commande  save(Commande commande);
     public Commande findByReference(String referece);
     public int encaisser(Paiement paiement);
     public List<Commande> getFactures();
     public double chiffreAffaire();
}

