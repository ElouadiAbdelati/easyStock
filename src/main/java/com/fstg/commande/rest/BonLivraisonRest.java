/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.rest;

import com.fstg.commande.bean.BonLivraison;
import com.fstg.commande.service.BonLivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pc
 */
@RestController
@RequestMapping("easyStock/bonLivraison")
public class BonLivraisonRest {
    @Autowired
    private BonLivraisonService bonLivraisonService;
@PostMapping("/")
    public void bonLivriasonCommande(@RequestBody BonLivraison bonLivraison) {
        bonLivraisonService.bonLivriasonCommande(bonLivraison);
    }
    
    
}
