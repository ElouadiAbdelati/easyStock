/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.rest;


import com.fstg.commande.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pc
 */
@RestController
@RequestMapping("/easyStock/produit")
public class ProduitRest {
    @Autowired
   private  ProduitService produitService;
    
    

    public ProduitService getProduitService() {
        return produitService;
    }

   
    
}
