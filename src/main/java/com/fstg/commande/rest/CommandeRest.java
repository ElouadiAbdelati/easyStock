/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.rest;

import com.fstg.commande.bean.Commande;
import com.fstg.commande.bean.Paiement;
import com.fstg.commande.service.CommandeService;
import com.fstg.commande.service.util.DateUtil;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("easyStock/commande")
@CrossOrigin("*")
public class CommandeRest {

    @Autowired
    private CommandeService commandeService;
      @GetMapping("/")
    public List<Commande> findAll() {
        return commandeService.findAll();
    }
 
   
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
    @GetMapping("/date/{dateAsString}")
    public List<Commande> findCommande(@PathVariable String dateAsString) throws ParseException {
            return commandeService.findCommande(DateUtil.parse(dateAsString));
    }
      @GetMapping("/pDate/{pDate}/dDate/{dDate}")
    public double chiffreAffaireBetwenTwoDate(@PathVariable String pDate,@PathVariable   String dDate) {
        return commandeService.chiffreAffaireBetwenTwoDate(DateUtil.parse(pDate),DateUtil.parse(dDate));
    }
     @PostMapping("/commandeNonLivree")
    public Commande CommandeNonLivree(@RequestBody Commande commande) {
        return commandeService.CommandeNonLivree(commande);
    }
    @PostMapping("/commandesNonLivree")
    public List<Commande> CommandesNonLivree(@RequestBody  List<Commande> commandes) {
        return commandeService.CommandesNonLivree(commandes);
    }
    @GetMapping("/dateFin/{dateFin}")
    public List<Commande> findByDateFin(@PathVariable String dateFin) {
        return commandeService.findByDateFin(DateUtil.parse(dateFin));
    }
     @PostMapping("/commandePaye") 
    public int commandePaye(@RequestBody Commande commande) {
        return commandeService.commandePaye(commande);
    }
     @GetMapping("/commandesPayes") 
    public List<Commande> commandesPaye() {
        return commandeService.commandesPaye();
    }
   @GetMapping("/commandesLivreeNonPayee")
    public List<Commande> livreeNonPayee() {
        return commandeService.livreeNonPayee();
    }
   
    
   
  
    

}
