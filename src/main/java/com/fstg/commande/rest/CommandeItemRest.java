/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.rest;

import com.fstg.commande.bean.Commande;
import com.fstg.commande.bean.CommandeItem;
import com.fstg.commande.service.CommandeItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pc
 */
@RestController
@RequestMapping("easyStock/commandeItem")
public class CommandeItemRest {
    @Autowired
    private CommandeItemService commandeItemService;

    @PostMapping("/")
    public List<CommandeItem> findByCommande(@RequestBody Commande commande) {
        return commandeItemService.findByCommande(commande);
    }
    
    
}
