/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.rest;

import com.fstg.commande.bean.Categorie;
import com.fstg.commande.service.CategorieService;
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
@RequestMapping("easyStock/categorie")
public class CategorieRest {

    @Autowired
    private CategorieService categorieService;

    @PostMapping("/")
    public void save(@RequestBody Categorie categorie) {
        categorieService.save(categorie);
    }

    @GetMapping("/nom/{nom}")
    public Categorie findByNom(@PathVariable String nom) {
        return categorieService.findByNom(nom);
    }

}
