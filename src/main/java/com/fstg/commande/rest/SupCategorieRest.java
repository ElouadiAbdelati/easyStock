/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.rest;

import com.fstg.commande.bean.SupCategorie;
import com.fstg.commande.service.SupCategorieService;
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
@RequestMapping("/easyStock/supCategorie")
public class SupCategorieRest {
    @Autowired
    private SupCategorieService supCategorieService;
  @GetMapping("/nom/{nom}")
    public SupCategorie findByNom(@PathVariable String nom) {
        return supCategorieService.findByNom(nom);
    }
 @PostMapping("/")
    public void save(@RequestBody SupCategorie supcategorie) {
        supCategorieService.save(supcategorie);
    }
    
    
}
