/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service.impl;

import com.fstg.commande.bean.Produit;
import com.fstg.commande.bean.Stock;
import com.fstg.commande.dao.StockDao;
import com.fstg.commande.service.ProduitService;
import com.fstg.commande.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class StockServiceImpl  implements StockService{
  @Autowired
    private StockDao stockDao;
  @Autowired
  private ProduitService produitService;
    @Override
    public void save(Stock stock) {
       stock.setProduit(produitService.finByReference(stock.getProduit().getReferance()));
       stockDao.save(stock);
       
    }

    @Override
    public Stock findByReferance(String referance) {
        return stockDao.findByReferance(referance);
    }

    @Override
    public void saveStock_Produit(Produit produit, Stock stock) {
            stock.setProduit(produitService.finByReference(produit.getReferance()));
            stockDao.save(stock);
    }

    @Override
    public Stock stockFull(Produit produit) {
        produit=produitService.finByReference(produit.getReferance());
        return stockDao.stockFull(produit);
    }

    @Override
    public Stock findByProduit(Produit produit) {
   return stockDao.findByProduit(produit);
    }

    @Override
    public void  deleteStock(Stock stock) {
          stockDao.delete(stock);
    }

   
    
}
