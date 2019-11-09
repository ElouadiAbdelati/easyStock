/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service.impl;

import com.fstg.commande.bean.SupCategorie;
import com.fstg.commande.dao.SupCategorieDao;
import com.fstg.commande.service.SupCategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupCategorieServiceImpl implements SupCategorieService {

    @Autowired
    private SupCategorieDao SupcategorieDao;

    @Override
    public SupCategorie findByNom(String nom) {
        return SupcategorieDao.findByNom(nom);
    }

    @Override
    public void save(SupCategorie supcategorie) {
        SupcategorieDao.save(supcategorie);
    }

   
}
