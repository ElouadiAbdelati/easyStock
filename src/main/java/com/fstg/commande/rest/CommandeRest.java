/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.rest;

import com.fstg.commande.bean.Commande;
import com.fstg.commande.bean.Paiement;
import com.fstg.commande.service.CommandeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pc
 */
@RestController
@RequestMapping("easyStock/commande")
public class CommandeRest {

    @Autowired
    private CommandeService commandeService;
 

    @PostMapping("/")
    public Commande saveCommandeWithCommandeItem(@RequestBody Commande commande) {
        return commandeService.saveCommandeWithCommandeItem(commande);
    }

    @GetMapping("/reference/{reference}")
    public Commande findByReference(@PathVariable("reference") String referece) {
        return commandeService.findByReference(referece);
    }
    
    @PostMapping("/encaisser")
    public int encaisser(@RequestBody Paiement paiement) {
        return commandeService.encaisser(paiement);
    }
    @PostMapping("/getFactures")
    public List<Commande> getFactures() {
        return commandeService.getFactures();
    }
    
     @PostMapping("/chiffreAffaire")
    public double chiffreAffaire() {
        return commandeService.chiffreAffaire();
    }
  
    

}
