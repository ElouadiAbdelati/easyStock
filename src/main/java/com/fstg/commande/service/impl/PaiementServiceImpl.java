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
    // abd al ati niv 2
    @Override
    public List<Paiement> findByCommande(Commande commande) {
         commande = commandeService.findByReference(commande.getReference());  
        return paiementDao.findByCommande(commande);
    }
    // abd al ati niv 3
    @Override
    public int save(Paiement paiement) {
        Commande commande = commandeService.findByReference(paiement.getCommande().getReference());
        if (commande == null) {
            return -1;
        } else if (!PaiementConstant.INSTRUMENT_PAIMENT.contains(paiement.getType())) {
            return -2;     
        }else if(commande.getMontantPayeCheque()+commande.getMontantPayeEspece()==commande.getTotal()){
           return -3;   
        }else if(commande.getMontantPayeCheque()+commande.getMontantPayeEspece()+paiement.getMontant()>commande.getTotal()){
           return -4;   
        }else {
            int res = 0;
            paiement.setCommande(commande);
            if (paiement.getType().equalsIgnoreCase(PaiementConstant.ESPECE)) {
                paiement.setEncaissement(true);
                commande.setMontantPayeEspece(commande.getMontantPayeEspece() + paiement.getMontant());
                res = 1;
            } else if (paiement.getType().equalsIgnoreCase(PaiementConstant.CHEQUE)) {
                commande.setMontantPayeCheque(commande.getMontantPayeCheque() + paiement.getMontant());
                res = 2;
            }
            paiementDao.save(paiement);
            commandeService.save(commande);
            return res;
        }
    }

    @Override
    public Paiement findByCode(String code) {
       return paiementDao.findByCode(code);
    }

        //hind niv 2
    @Override
    public int annulerPaiement(Paiement paiement) {
       
     Commande commande = commandeService.findByReference(paiement.getCommande().getReference());
     if (commande == null ){
             return -1;
     }else{
      paiement=paiementDao.findByCommandeAndCode(commande, paiement.getCode());
        if ( paiement==null) {
            return -2;
        } else if (!PaiementConstant.INSTRUMENT_PAIMENT.contains(paiement.getType())) {
            return -3;     
        }else {
            int res = 0;
            if (paiement.getType().equalsIgnoreCase(PaiementConstant.ESPECE)) {
                
                commande.setMontantPayeEspece(commande.getMontantPayeEspece() - paiement.getMontant());
                res = 1;
            } else if (paiement.getType().equalsIgnoreCase(PaiementConstant.CHEQUE)) {
                commande.setMontantPayeCheque(commande.getMontantPayeCheque() - paiement.getMontant());
                res = 2;
            }
            paiementDao.delete(paiement);
            commandeService.save(commande);
            return res;
        }
     }

    }

}
