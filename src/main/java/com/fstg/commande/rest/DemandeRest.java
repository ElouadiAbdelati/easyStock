/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.rest;

import com.fstg.commande.bean.Demande;
import com.fstg.commande.service.DemandeService;
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
@RequestMapping("easyStock/demande")
public class DemandeRest {
    @Autowired
    private DemandeService demandeService;
    @PostMapping("/")
    public int saveDemmandeWhithDemmandeItem(@RequestBody Demande demande) {
        return demandeService.saveDemmandeWhithDemmandeItem(demande);
    }
  @GetMapping("/reference/{reference}")
    public Demande finByReference(@PathVariable String reference) {
        return demandeService.finByReference(reference);
    }
      @GetMapping("/nbrDemande_Annee/{annee}")
    public int nbrDemande_Annee(@PathVariable String annee) {
        return demandeService.nbrDemande_Annee(annee);
    }
    
    
}
