/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service;
import com.fstg.commande.bean.Demande;


/**
 *
 * @author pc
 */
public interface DemandeService {
    public int saveDemmandeWhithDemmandeItem(Demande demande);
     public Demande finByReference(String reference);
     
      public Demande save(Demande demande);
      
     public int nbrDemande_Annee(String annee);
}
