/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service;

import com.fstg.commande.bean.Categorie;
import com.fstg.commande.bean.SupCategorie;
import java.util.List;
/**
 *
 * @author pc
 */

public interface CategorieService { 
    public Categorie findByNom(String nom); 
    public void save(Categorie categorie);
   public int  saveCategorie(SupCategorie supcategorie,List<Categorie> categories);
   
}
