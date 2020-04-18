/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.rest;

import com.fstg.commande.bean.Demande;
import com.fstg.commande.bean.Reception;
import com.fstg.commande.service.ReceptionService;
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
@RequestMapping("/easyStock/reception")
public class ReceptionRest {
    @Autowired
    private ReceptionService receptionService;
   @PostMapping("/")
    public Reception saveReceptionWhithReceptionItm(@RequestBody Reception reception) {
        return receptionService.saveReceptionWhithReceptionItm(reception);
    }
   @PostMapping("/payeReception")
    public int payeReception(@RequestBody Reception reception) {
        return receptionService.payeReception(reception);
    }

    public ReceptionService getReceptionService() {
        return receptionService;
    }
    @PostMapping("/receptionsNonPayee")
    public List<Reception> receptionsNonPayee(@RequestBody Demande demande) {
        return receptionService.receptionsNonPayee(demande);
    }
   
    
    
}
