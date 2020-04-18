/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.rest;

import com.fstg.commande.bean.Demande;
import com.fstg.commande.bean.DemandeItem;
import com.fstg.commande.service.DemandeItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pc
 */
@RestController
@RequestMapping("easyStock/demandeItem")
public class DemandeItemRest {
    @Autowired
    private  DemandeItemService demandeItemService;
    @PostMapping("/")
      public List<DemandeItem> findByDemande(@RequestBody Demande demande) {
        return demandeItemService.findByDemande(demande);
    }
    
}
