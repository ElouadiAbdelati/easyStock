/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.rest;
import com.fstg.commande.bean.Produit;
import com.fstg.commande.service.ProduitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/easyStock/produit")
public class ProduitRest {

    @Autowired
    private ProduitService produitService;

    @PostMapping("/")
    public Produit save(@RequestBody Produit produit) {
        return produitService.save(produit);
    }

    @GetMapping("/reference/{reference}")
    public Produit finByReference(@PathVariable("reference") String reference) {
        return produitService.finByReference(reference);
    }
   @PostMapping("/create")
    public Produit create(@RequestBody Produit produit) {
        return produitService.create(produit);
    }
    @GetMapping("/produitsFinStock")
    public List<Produit> produitsFinStock() {
        return produitService.produitsFinStock();
    }
   
   @DeleteMapping("/deleteProduit/{reference}")
    public int deleteProduit(@PathVariable String reference) {
        return produitService.deleteProduit(reference);
    }
    

   
   
    
}
