/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.dao;

import com.fstg.commande.bean.Produit;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc
 */
@Repository
public interface  ProduitDao  extends JpaRepository<Produit, Long>{
     public Produit findByReferance(String  referance);
     
    /**
     *
     * @return
     */
    @Query("SELECT p FROM Produit p,Stock s WHERE p.stock.id = s.id  and s.qte<= s.qteAlert  ")
     public List<Produit> produitsFinStock();
}
