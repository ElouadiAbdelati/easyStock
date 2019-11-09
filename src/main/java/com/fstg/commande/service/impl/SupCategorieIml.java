/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service.impl;

import com.fstg.commande.dao.SupCategorieDao;
import com.fstg.commande.service.SupCategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class SupCategorieIml extends SupCategorieService{
    @Autowired
   private SupCategorieDao supCategorieDao;

    public SupCategorieDao getSupCategorieDao() {
        return supCategorieDao;
    }

    public void setSupCategorieDao(SupCategorieDao supCategorieDao) {
        this.supCategorieDao = supCategorieDao;
    }
   
 
  
}
