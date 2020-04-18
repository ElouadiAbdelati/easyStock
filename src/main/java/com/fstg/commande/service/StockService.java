/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service;

import com.fstg.commande.bean.Produit;
import com.fstg.commande.bean.Stock;
import java.util.List;
 

/**
 *
 * @author pc
 */
public interface StockService {
    public Stock stockFull(Produit  produit);
    public void save(Stock stock);
    public Stock findByReferance(String  referance);
    public void saveStock_Produit(Produit produit,Stock stock);
    
        public Stock findByProduit(Produit  produit);
       public void deleteStock(Stock  stock);
    
}
