/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service.impl;

import com.fstg.commande.bean.BonLivraison;
import com.fstg.commande.bean.CommandeItem;
import com.fstg.commande.bean.LivraisonItem;
import com.fstg.commande.dao.LivraisonItemDao;
import com.fstg.commande.service.LivraisonItemService;
import com.fstg.commande.service.ProduitService;
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
public class LivraisonServiceImpl implements LivraisonItemService {

    @Autowired
    private LivraisonItemDao livraisonItemDao;
    @Autowired
    private ProduitService produitService;

    @Override
    public int saveLivraisonItem(BonLivraison bonLivraison, List<LivraisonItem> livraisonItems,
            List<CommandeItem> commandeItems) {
        List<LivraisonItem> livraisonItems1 = livraison(commandeItems);
        if (livraisonItems1 == null || !livraisonItems1.isEmpty()) {
            return -1;
        } else {
            for (LivraisonItem livraisonItem : livraisonItems1) {
                livraisonItem.setBonLivraison(bonLivraison);
                livraisonItemDao.save(livraisonItem);
            }
            return 1;
        }
    }
    @Autowired
    private StockService stockService;

    public List<LivraisonItem> livraison(List<CommandeItem> commandeItems) {
        List<LivraisonItem> livraisonItems = new ArrayList<>();
        for (CommandeItem commandeItem : commandeItems) {
            LivraisonItem livraisonItem = new LivraisonItem();

            livraisonItem.setProduit(commandeItem.getProduit());
            livraisonItem.setQte(commandeItem.getQte());

            commandeItem.getProduit().getStock().setQte(commandeItem.getProduit().getStock().getQte()
                    - commandeItem.getQte());

            stockService.save(commandeItem.getProduit().getStock());

            livraisonItems.add(livraisonItem);
        }

        return livraisonItems;
    }

    @Override
    public List<LivraisonItem> findByBonLivraison(BonLivraison bonLivraison) {
        return livraisonItemDao.findByBonLivraison(bonLivraison);
    }

}
