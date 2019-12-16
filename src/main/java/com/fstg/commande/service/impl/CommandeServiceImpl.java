/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service.impl;

import com.fstg.commande.bean.Commande;
import com.fstg.commande.bean.CommandeItem;
import com.fstg.commande.bean.Paiement;
import com.fstg.commande.dao.CommandeDao;
import com.fstg.commande.service.CommandeItemService;
import com.fstg.commande.service.CommandeService;
import com.fstg.commande.service.PaiementService;
import com.fstg.commande.service.ProduitService;
import com.fstg.commande.service.constant.CommandeConstant;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.persistence.sessions.coordination.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private PaiementService paiementService;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private CommandeDao commandeDao;
    @Autowired
    private CommandeItemService commandeItemService;

    @Override
    public Commande saveCommandeWithCommandeItem(Commande commande) {
        if (produitService.valide(commande.getCommandeItems())) {
            calculerTotal(commande, commande.getCommandeItems());
            commandeDao.save(commande);
            commandeItemService.saveCommandeItem(commande, commande.getCommandeItems());
            return commande;
        }

        return null;
    }

    @Override
    public Commande findByReference(String referece) {
        return commandeDao.findByReference(referece);
    }

    private void calculerTotal(Commande commande, List<CommandeItem> commandeItems) {
        BigDecimal total = BigDecimal.ZERO;
        if (commandeItems != null && !commandeItems.isEmpty()) {
            for (CommandeItem commandeItem : commandeItems) {
                total = total.add(commandeItem.getPrix().multiply(commandeItem.getQte()));

            }
            commande.setTotal(total);
        }
    }

    @Override
    public Commande save(Commande commande) {
        commandeDao.save(commande);
        return commande;

    }

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
            } else {
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
        for (Commande commande : commandes) {
           
            if (commande.getMontantPayeCheque() == 0 && commande.getMontantPayeEspece() == 0) {
                commandes.add(commande);
            }
        }
        return commandes;
    }

    @Override
    public double chiffreAffaire() {
        double somme = 0;
        List<Commande> commandes=commandeDao.findAll();
        for (Commande commande : commandes) {
           
            somme += commande.getMontantPayeEspece();
        }
        return somme;
    }
}
