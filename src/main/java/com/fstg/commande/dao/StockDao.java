/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.dao;

import com.fstg.commande.bean.Produit;
import com.fstg.commande.bean.Stock;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc
 */
@Repository
public interface StockDao extends JpaRepository<Stock, Long>{
    public Stock findByReferance(String  referance);
    
    @Query("SELECT s FROM Stock s WHERE s.produit=?1   ")
    public Stock stockFull(Produit  produit);
    
    public Stock findByProduit(Produit  produit);
}
