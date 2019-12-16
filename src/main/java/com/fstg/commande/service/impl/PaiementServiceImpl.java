/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service.impl;

import com.fstg.commande.bean.Commande;
import com.fstg.commande.bean.Paiement;
import com.fstg.commande.dao.PaiementDao;
import com.fstg.commande.service.CommandeService;
import com.fstg.commande.service.PaiementService;
import com.fstg.commande.service.constant.PaiementConstant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class PaiementServiceImpl implements PaiementService {

    @Autowired
    private PaiementDao paiementDao;
    @Autowired
    private CommandeService commandeService;

    @Override
    public List<Paiement> findByCommande(Commande commande) {
         commande = commandeService.findByReference(commande.getReference());  
        return paiementDao.findByCommande(commande);
    }

    @Override
    public int save(Paiement paiement) {
        Commande commande = commandeService.findByReference(paiement.getCommande().getReference());
        if (commande == null) {
            return -1;
        } else if (!PaiementConstant.INSTRUMENT_PAIMENT.contains(paiement.getType())) {
            return -2;   
        }else {
            int res = 0;
            paiement.setCommande(commande);
            if (paiement.getType().equalsIgnoreCase(PaiementConstant.ESPECE)) {
                commande.setMontantPayeEspece(commande.getMontantPayeEspece() + paiement.getMontant());
                res = 1;
            } else if (paiement.getType().equalsIgnoreCase(PaiementConstant.CHEQUE)) {
                commande.setMontantPayeCheque(commande.getMontantPayeCheque() + paiement.getMontant());
                res = 2;
            }
            paiementDao.save(paiement);
            commandeService.save(paiement.getCommande());
            return res;
        }
    }

    @Override
    public Paiement findByCode(String code) {
       return paiementDao.findByCode(code);
    }

}
