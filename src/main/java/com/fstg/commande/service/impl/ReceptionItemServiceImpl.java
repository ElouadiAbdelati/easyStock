/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service.impl;

import com.fstg.commande.bean.Reception;
import com.fstg.commande.bean.ReceptionItem;
import com.fstg.commande.dao.ReceptionItemDao;
import com.fstg.commande.service.ProduitService;
import com.fstg.commande.service.ReceptionItemService;
import com.fstg.commande.service.StockService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class ReceptionItemServiceImpl  implements ReceptionItemService{
  @Autowired
  private ProduitService  produitService;
  @Autowired
  private StockService stockService;
  @Autowired
  private ReceptionItemDao receptionItemDao;
    @Override
    public int saveReceptionItem(Reception reception, List<ReceptionItem> receptionItems) {
          if (receptionItems == null || !receptionItems.isEmpty()) {
            return -1;
        } else {
            for (ReceptionItem receptionItem : receptionItems) {
                receptionItem.setReception(reception);
                 
                receptionItem.setProduit(produitService.finByReference(receptionItem.getProduit().getReferance()));
                receptionItem.getStock().setProduit(receptionItem.getProduit());
                receptionItem.setStock(stockService.findByReferance(receptionItem.getStock().getReferance()));
                receptionItem.getStock().setQte(receptionItem.getQte()+receptionItem.getStock().getQte());
                   stockService.save(receptionItem.getStock());
                   receptionItemDao.save(receptionItem);
            }
            return 1;
        }
    }

    @Override
    public List<ReceptionItem> findByReception(Reception reception) {
             return receptionItemDao.findByReception(reception);
    }
    
}
