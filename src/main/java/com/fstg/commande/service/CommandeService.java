/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service;
import com.fstg.commande.bean.Commande;
import com.fstg.commande.bean.Paiement;
import java.util.Date;
import java.util.List;
/**
 *
 * @author pc
 */
public interface CommandeService {
    public List<Commande> findAll();
     public Commande  saveCommandeWithCommandeItem(Commande commande);
     public Commande  save(Commande commande);
     public Commande findByReference(String referece);
     public int encaisser(Paiement paiement);
     public List<Commande> getFactures();
     public double chiffreAffaire();
      public List<Commande>  findCommande(Date date);
      public double chiffreAffaireBetwenTwoDate(Date pDate,Date dDate);
      public Commande CommandeNonLivree(Commande commande);
      public List<Commande> CommandesNonLivree(List<Commande> commandes);
      public  List<Commande>  findByDateFin(Date dateFin);
      //public List<Commande> livreeNonPaye();
      public int commandePaye(Commande commande);
      public List<Commande>  commandesPaye();
      
      public int livreeNonPayee(Commande commande);
      public List<Commande>  livreeNonPayee();
      
        
}

