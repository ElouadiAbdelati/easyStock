/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.rest;

import com.fstg.commande.bean.Commande;
import com.fstg.commande.bean.Paiement;
import com.fstg.commande.service.PaiementService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pc
 */
@RestController
@RequestMapping("easyStock/paiement")
public class PaiementRest {

    @Autowired
    private PaiementService paiementService;

    @PostMapping("/")
    public int save(@RequestBody Paiement paiement) {
        return paiementService.save(paiement);
    }

     @PostMapping("/paiementscommande")
    public List<Paiement> findByCommande(@RequestBody Commande commande) {
        return paiementService.findByCommande(commande);
    }
  @GetMapping("/code/{code}")
    public Paiement findByCode(String code) {
        return paiementService.findByCode(code);
    }
     @PostMapping("/annulerPaiement")
    public int annulerPaiement(@RequestBody Paiement paiement) {
        return paiementService.annulerPaiement(paiement);
    }
    
  
}
