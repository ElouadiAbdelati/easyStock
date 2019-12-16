/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service.impl;

import com.fstg.commande.bean.CommandeItem;
import com.fstg.commande.bean.Produit;
import com.fstg.commande.dao.ProduitDao;
import com.fstg.commande.service.ProduitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    private ProduitDao produitDao;

    @Override
    public Produit finByReference(String reference) {
        return produitDao.findByReferance(reference);
    }

    @Override
    public Produit save(Produit produit) {
        produitDao.save(produit);
        return produit;
    }
    @Override
      public  boolean valide(List<CommandeItem> commandeItems) {
       int cmp=0;
       if(commandeItems==null || commandeItems.isEmpty()){
           return false;
       }
        for (CommandeItem commandeItem : commandeItems) {
            if (produitDao.findByReferance(commandeItem.getProduit().getReferance())!=null)
                cmp++;
            
        }
            return cmp==commandeItems.size();
      }

    ProduitDao getProduitDao() {
        return produitDao;
    }

    public void setProduitDao(ProduitDao produitDao) {
        this.produitDao = produitDao;
    }

}
