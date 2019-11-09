/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service;

import com.fstg.commande.bean.Categorie;
/**
 *
 * @author pc
 */

public interface CategorieService { 
    public Categorie findByNom(String nom); 
    public void save(Categorie categorie);
   
}
