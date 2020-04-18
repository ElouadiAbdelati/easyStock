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
import com.fstg.commande.dao.BonLivraisonDao;
import com.fstg.commande.dao.LivraisonItemDao;
import com.fstg.commande.service.BonLivraisonService;
import com.fstg.commande.service.CommandeItemService;
import com.fstg.commande.service.CommandeService;
import com.fstg.commande.service.LivraisonItemService;
import com.fstg.commande.service.StockService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class BonLivraisonServiceImpl  implements BonLivraisonService{
@Autowired
private CommandeService commandeService;
@Autowired
private BonLivraisonDao bonLivraisonDao;
@Autowired
private LivraisonItemService livraisonItemService;
@Autowired
private CommandeItemService commandeItemService; 
@Autowired
private LivraisonItemDao livraisonItemDao;

    // abd al ati niv 3
    @Override
    public void bonLivriasonCommande(BonLivraison bonLivraison) {
        bonLivraison.setCommande(commandeService.findByReference(bonLivraison.getCommande().getReference()));
        bonLivraison.getCommande().setCommandeItems(commandeItemService.findByCommande(bonLivraison.getCommande()));
        bonLivraisonDao.save(bonLivraison);
         List<LivraisonItem> livraisonItems1=livraison(bonLivraison.getCommande().getCommandeItems());
            for (LivraisonItem livraisonItem : livraisonItems1) {
                 livraisonItem.setBonLivraison(bonLivraison);
                 livraisonItemDao.save(livraisonItem);   
             }
       // livraisonItemService.saveLivraisonItem(bonLivraison, bonLivraison.getLivraisonItems(),
               // bonLivraison.getCommande().getCommandeItems());    
} 
@Autowired
    private StockService stockService;
   public List<LivraisonItem> livraison( List<CommandeItem> commandeItems){
        List<LivraisonItem> livraisonItems = new ArrayList<>();
        for (CommandeItem commandeItem : commandeItems) {
             LivraisonItem livraisonItem=new LivraisonItem();
                 if (commandeItem.getQteLivree()!=commandeItem.getQte()){
                  double qt= commandeItem.getProduit().getStock().getQte() - commandeItem.getQte();
                  if (qt>0){
                      if( qt>commandeItem.getProduit().getStock().getQteAlert()){
                           livraisonItem.setProduit(commandeItem.getProduit());
                           livraisonItem.setQte(commandeItem.getQte());
                   commandeItem.getProduit().getStock().setQte(commandeItem.getProduit().getStock().getQte()
                                  -commandeItem.getQte());
                            commandeItem.setQteLivree(commandeItem.getQteLivree()+commandeItem.getQte());
                             commandeItemService.save(commandeItem);
                            stockService.save(commandeItem.getProduit().getStock());
                            livraisonItems.add(livraisonItem);
                      }
                  }
                   
               }
               
        }
        
       
       
        return livraisonItems;
    }

    @Override
    public List<BonLivraison> findByCommande(Commande commande) {
       return bonLivraisonDao.findByCommande(commande);
    }
    
}
