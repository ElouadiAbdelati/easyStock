/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service.impl;

import com.fstg.commande.bean.Categorie;
import com.fstg.commande.dao.CategorieDao;
import com.fstg.commande.service.CategorieService;
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

    @Override
    public Categorie findByNom(String nom) {
        return categorieDao.findByNom(nom);
    }

    @Override
    public void save(Categorie categorie) {
        categorieDao.save(categorie);
    }

}
