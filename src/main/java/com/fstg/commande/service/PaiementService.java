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
public interface PaiementService {
    public int save(Paiement paiement);
    public  List<Paiement> findByCommande(Commande commande);
    public Paiement findByCode(String code);
    
   

}
