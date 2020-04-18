/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service.impl;

import com.fstg.commande.bean.Categorie;
import com.fstg.commande.bean.SupCategorie;
import com.fstg.commande.dao.CategorieDao;
import com.fstg.commande.service.CategorieService;
import com.fstg.commande.service.ProduitService;
import com.fstg.commande.service.SupCategorieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    private CategorieDao categorieDao;
    @Autowired
    private SupCategorieService supCategorieService;
    @Autowired
    private ProduitService  produitService;
    @Override
    public Categorie findByNom(String nom) {
     
        return categorieDao.findByNom(nom);
    }

    @Override
    public void save(Categorie categorie) {
        categorie.setSupCategorie(supCategorieService.findByNom(categorie.getSupCatrgorie().getNom()));
        categorieDao.save(categorie);
    }
    // abd al ati niv 2
    @Override
    public int saveCategorie(SupCategorie supcategorie, List<Categorie> categories) {
        for (Categorie categorie : categories) {
             categorie.setSupCategorie(supcategorie);
              categorieDao.save(categorie);
              
        }
        return 1;
    }

}
