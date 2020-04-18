/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service.impl;

import com.fstg.commande.bean.Commande;
import com.fstg.commande.bean.CommandeItem;
import com.fstg.commande.dao.CommandeItemDao;
import com.fstg.commande.service.CommandeItemService;
import com.fstg.commande.service.CommandeService;
import com.fstg.commande.service.ProduitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class CommandeServiceItemImpl implements CommandeItemService {

    @Autowired
    private CommandeItemDao commandeItemDao;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private CommandeService commandeService;
// laysate ma7soba
    @Override
    public int saveCommandeItem(Commande commande, List<CommandeItem> commandeItems) {
        if (commandeItems == null || !commandeItems.isEmpty()) {
            return -1;
        } else {
            for (CommandeItem commandeItem : commandeItems) {
                commandeItem.setCommande(commande);
                commandeItem.setProduit(produitService.finByReference(commandeItem.getProduit().getReferance()));
          
                calculerPrix(commandeItem);
                commandeItemDao.save(commandeItem);
            }
            return 1;
        }
    }
    
    @Override
    public List<CommandeItem> findByCommande(Commande commande) {
        commande=commandeService.findByReference(commande.getReference());
        return commandeItemDao.findByCommande(commande);
    }
    
     
    
    private void calculerPrix(CommandeItem commandeItem) {
        double prix = 0;
        prix = prix+ (commandeItem.getQte()*commandeItem.getProduit().getPrix());
        commandeItem.setPrix(prix);
    }

    @Override
    public void save(CommandeItem commandeItem) {
        commandeItemDao.save(commandeItem);
    }
    
}
