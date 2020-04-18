/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service.impl;

import com.fstg.commande.bean.CommandeItem;
import com.fstg.commande.bean.Produit;
import com.fstg.commande.dao.ProduitDao;
import com.fstg.commande.service.CategorieService;
import com.fstg.commande.service.ProduitService;
import com.fstg.commande.service.StockService;
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
     private StockService stockService;
    @Autowired
    private ProduitDao produitDao;
    @Autowired
     private CategorieService categorieService;
    @Override
    public Produit finByReference(String reference) {
        return produitDao.findByReferance(reference);
    }

        // abd al ati niv 2
    @Override
    public Produit save(Produit produit) {
        produit.setCatrgorie(categorieService.findByNom(produit.getCatrgorie().getNom()));
        stockService.save(produit.getStock());
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

    @Override
    public Produit create(Produit produit) {
      
        stockService.save(produit.getStock());
         produit.setCatrgorie(categorieService.findByNom(produit.getCatrgorie().getNom()));
          produit.setStock(stockService.findByReferance(produit.getStock().getReferance()));
         produitDao.save(produit);
        stockService.saveStock_Produit(produit,produit.getStock());
        return produit;   
    
    }

    @Override
    public List<Produit> produitsFinStock() {
     return produitDao.produitsFinStock();
    }

        // fati niv 2
    @Override
    public int deleteProduit( String reference) {
       Produit produit=finByReference(reference);
     if(produit==null ){
         return -1;
     }else{
        stockService.deleteStock(stockService.findByProduit(produit));
        produitDao.delete(produit);
        
        return 1;
     }
     
    }

    
    
}