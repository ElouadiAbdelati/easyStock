/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service.impl;

import com.fstg.commande.bean.Commande;
import com.fstg.commande.bean.CommandeItem;
import com.fstg.commande.dao.CommandeDao;
import com.fstg.commande.service.CommandeItemService;
import com.fstg.commande.service.CommandeService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class CommandeServiceImpl implements CommandeService{
    @Autowired
   private CommandeDao commandeDao;
    @Autowired
    private CommandeItemService  commandeItemService;
    @Override
    public Commande saveCommandeWithCommandeItem(Commande commande) {
       calculerTotal(commande,commande.getCommandeItems());
       commandeDao.save(commande);
       commandeItemService.saveCommandeItem(commande,commande.getCommandeItems());
       return commande;
    }

    @Override
    public Commande findByReference(String referece) {
        return commandeDao.findByReference(referece);
    }


    private void calculerTotal(Commande commande, List<CommandeItem> commandeItems) {
        BigDecimal total=BigDecimal.ZERO;
        if(commandeItems!=null && !commandeItems.isEmpty()){
            for (CommandeItem commandeItem : commandeItems) {
                total=total.add(commandeItem.getPrix().multiply(commandeItem.getQte()));
               
            }
            commande.setTotal(total);
        }
    }

    public CommandeDao getCommandeDao() {
        return commandeDao;
    }

    public void setCommandeDao(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }

    public CommandeItemService getCommandeItemService() {
        return commandeItemService;
    }

    public void setCommandeItemService(CommandeItemService commandeItemService) {
        this.commandeItemService = commandeItemService;
    }
}
