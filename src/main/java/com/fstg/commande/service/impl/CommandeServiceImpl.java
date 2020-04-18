 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service.impl;

import com.fstg.commande.bean.BonLivraison;
import com.fstg.commande.bean.Commande;
import com.fstg.commande.bean.CommandeItem;
import com.fstg.commande.bean.LivraisonItem;
import com.fstg.commande.bean.Paiement;
import com.fstg.commande.dao.CommandeDao;
import com.fstg.commande.dao.CommandeItemDao;
import com.fstg.commande.service.BonLivraisonService;
import com.fstg.commande.service.CommandeItemService;
import com.fstg.commande.service.CommandeService;
import com.fstg.commande.service.LivraisonItemService;
import com.fstg.commande.service.PaiementService;
import com.fstg.commande.service.ProduitService;
import com.fstg.commande.service.constant.CommandeConstant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class CommandeServiceImpl implements CommandeService {
@Autowired
private BonLivraisonService bonLivraisonService;
@Autowired
private LivraisonItemService livraisonItemService;
    @Autowired
    private PaiementService paiementService;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private CommandeDao commandeDao;
    @Autowired
    private CommandeItemService commandeItemService;
  @Autowired
    private CommandeItemDao commandeItemDao;
   // abd ati niv 3
    @Override
    public Commande saveCommandeWithCommandeItem(Commande commande) {
        if (produitService.valide(commande.getCommandeItems())) {
          
            commandeDao.save(commande);
             for (CommandeItem commandeItem : commande.getCommandeItems()) {
                commandeItem.setCommande(commande);
                commandeItem.setProduit(produitService.finByReference(commandeItem.getProduit().getReferance()));
          
                calculerPrix(commandeItem);   
                commandeItemDao.save(commandeItem);
            }
               calculerTotal(commande, commande.getCommandeItems());
               remise(commande);
                commandeDao.save(commande);
            //commandeItemService.saveCommandeItem(commande, commande.getCommandeItems());
            return commande;
        }

        return null;
    }
      //commandeItem
    private void calculerPrix(CommandeItem commandeItem) {
        double prix = 0;
        prix = prix+ (commandeItem.getQte()*commandeItem.getProduit().getPrix());
        commandeItem.setPrix(prix);
    }

    @Override
    public Commande findByReference(String referece) {
        return commandeDao.findByReference(referece);
    }

    private void calculerTotal(Commande commande, List<CommandeItem> commandeItems) {
        double total = 0;
        if (commandeItems != null && !commandeItems.isEmpty()) {
            for (CommandeItem commandeItem : commandeItems) {
                total = total +(commandeItem.getProduit().getPrix()*commandeItem.getQte());

            }
            
            commande.setTotal(total);
        }
    }
    // hind niv 2
    public void remise(Commande commande){
        double remise=0;
        double total=commande.getTotal();
        if(total<100){
            remise=0;
          
        }else if( total>100 && total<1000){
            remise=(total*10)/100;
           
        }else if( total>1000 && total<10000){
            remise=(total*20)/100;
        }else if( total>10000 && total<100000){
            remise=(total*30)/100;
        }else{
            remise=(total*40)/100; 
        }
        
        commande.setRemise(remise);
        commande.setTotal(commande.getTotal()-remise);
        
    }
    @Override
    public Commande save(Commande commande) {
        commandeDao.save(commande);
        return commande;

    }

    // abd al ati niv 2
    @Override
    public int encaisser(Paiement paiement) {
        Commande commande = commandeDao.findByReference(paiement.getCommande().getReference());
        if (commande == null) {
            return -1;
        } else {
            paiement = paiementService.findByCode(paiement.getCode());
            if (paiement == null) {
                return -2;
            } else if (paiement.getType().equalsIgnoreCase(CommandeConstant.ESPECE)) {
                return -3;
            } else if (paiement.isEncaissement()) {
                return -4;
            }else if (commande.getMontantPayeCheque() - paiement.getMontant()<0) {
                return -5;
            }else {
                paiement.setEncaissement(true);
                commande.setMontantPayeCheque(commande.getMontantPayeCheque() - paiement.getMontant());
                commande.setMontantPayeEspece(commande.getMontantPayeEspece() + paiement.getMontant());
                paiementService.save(paiement);
                save(commande);
                return 1;
            }
        }
    }

    @Override
    public List<Commande> getFactures() {
           List<Commande> commandes=commandeDao.findAll();
           List<Commande> c=new ArrayList<Commande>();
        for (Commande commande : commandes) {
           
            if (commande.getMontantPayeCheque() == 0 && commande.getMontantPayeEspece() == 0) {
                c.add(commande);
            }
        }
        return c;
    }
    // abd al ati niv 2
    @Override
    public double chiffreAffaire() {
        double somme = 0;
        List<Commande> commandes=commandeDao.findAll();
        for (Commande commande : commandes) {
           
            somme += commande.getMontantPayeEspece();
        }
        return somme;
    }

    @Override
    public List<Commande> findCommande(Date date) {
        List<Commande> commandes=commandeDao.findCommande(date);
        List<Commande> cs=new ArrayList<Commande>();
        for(Commande commande : commandes) {
            if(commande.getTotal()!=commande.getMontantPayeEspece()){
                cs.add(commande);
            
            }
            
        }
        return cs;
    }

        // abd al ati niv 2
    @Override
    public double chiffreAffaireBetwenTwoDate(Date pDate, Date dDate) {
         List<Commande> commandes=commandeDao.finCommandesBetwenTwoDate(pDate, dDate);
          double somme = 0;
        for (Commande commande : commandes) {
           
            somme += commande.getMontantPayeEspece();
        }
        return somme;
    }

        // hind ati niv 2
    @Override
    public Commande CommandeNonLivree(Commande commande) {
          commande=commandeDao.findByReference(commande.getReference());
          commande.setBonLivraisons(bonLivraisonService.findByCommande(commande));
          double qtelivree=0;
          for (BonLivraison  bonLivraison : commande.getBonLivraisons()) {
              bonLivraison.setLivraisonItems(livraisonItemService.findByBonLivraison(bonLivraison));
              for ( LivraisonItem  livraisonItem : bonLivraison.getLivraisonItems()){
                  qtelivree+=livraisonItem.getQte();
                  
              }
                  
        }
        if(qtelivree==Qtelivree(commande)){
            return null;
            
        }else {
            return commande;
        }
          
    }
    
    public double Qtelivree(Commande commande){
        double qtelicommande=0;
        for ( CommandeItem commandeItem : commande.getCommandeItems()){
            qtelicommande+=commandeItem.getQte();
        }
         return qtelicommande;
    }

        // faty niv 2
    @Override
    public List<Commande> CommandesNonLivree(List<Commande> commandes) {
       List<Commande> CommandesNonLivree=new ArrayList<>(0);
       int val;
       for (Commande commande: commandes){
           val=commandeNonLivree(commande);
           if( val==-1){
               CommandesNonLivree.add(commande);
           }
           
       }
       
     return CommandesNonLivree;
    }
        // hind niv 2
    public int commandeNonLivree(Commande commande){
         commande=commandeDao.findByReference(commande.getReference());
         commande.setCommandeItems(commandeItemService.findByCommande(commande));
         for (CommandeItem commandeItem : commande.getCommandeItems()) {
             if(commandeItem.getQte()!=commandeItem.getQteLivree()){
                 return -1;
             }
            
        }
      return 1;  
    }

        // faty ati niv 2
    @Override
    public List<Commande> findByDateFin(Date dateFin) {
         List<Commande> commandes=commandeDao.findByDateFin(dateFin);
            commandes = CommandesNonLivree(commandes);
         return commandes;
    }

    @Override
    public int commandePaye(Commande commande) {
         commande=findByReference(commande.getReference());
         if(commande.getMontantPayeEspece()==commande.getTotal()){
             return 1;
         }else{
          return -1;
         } 
    }

        // hind niv 2
    @Override
    public List<Commande> commandesPaye() {
        int val;
       List<Commande> commandes =commandeDao.findAll();
        List<Commande> commandesPayes=new ArrayList<>(0);
        for (Commande commande : commandes) {
            val=commandePaye(commande);
            if(val==1){
                commandesPayes.add(commande);
            }
            
        }

     return commandesPayes;
    }

        // faty niv 2
    @Override
    public int livreeNonPayee(Commande commande) {
    commande=findByReference(commande.getReference());
    int paye=commandePaye(commande);
    int livree=commandeNonLivree(commande);
    if (paye==1 &&livree==1 ){
        return 1;
    }else if(paye==-1 && livree==1){
        return -1;
    }else {
        return -2;
    }
     

    }
    //fati niv 2
    @Override
    public List<Commande> livreeNonPayee() {
    List<Commande> commandes =commandeDao.findAll();
    int val;
    List<Commande> commandeLivreeNonPayee =new ArrayList<>(0);
        for (Commande commande : commandes) {
            val=livreeNonPayee(commande);
            if(val==-1){
                commandeLivreeNonPayee.add(commande);
            }
            
        }
      return commandeLivreeNonPayee;
    }

    @Override
    public List<Commande> findAll() {
    return  commandeDao.findAll();
     }
   
}
