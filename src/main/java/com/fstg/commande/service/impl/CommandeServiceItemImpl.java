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
import com.fstg.commande.service.ProduitService;
import java.math.BigDecimal;
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
        return commandeItemDao.findByCommande(commande);
    }
    
    public CommandeItemDao getCommandeItemDao() {
        return commandeItemDao;
    }
    
    public void setCommandeItemDao(CommandeItemDao commandeItemDao) {
        this.commandeItemDao = commandeItemDao;
    }
    
    private void calculerPrix(CommandeItem commandeItem) {
        BigDecimal prix = BigDecimal.ZERO;
        prix = prix.add(commandeItem.getQte().multiply(commandeItem.getProduit().getPrix()));
        commandeItem.setPrix(prix);
    }
    
}
