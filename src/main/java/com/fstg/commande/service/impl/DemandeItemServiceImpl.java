/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service.impl;

import com.fstg.commande.bean.Demande;
import com.fstg.commande.bean.DemandeItem;
import com.fstg.commande.bean.Produit;
import com.fstg.commande.dao.DemandeItemDao;
import com.fstg.commande.service.DemandeItemService;
import com.fstg.commande.service.DemandeService;
import com.fstg.commande.service.ProduitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class DemandeItemServiceImpl  implements DemandeItemService{
  @Autowired
  private ProduitService produitService;
  @Autowired
  private DemandeItemDao demandeItemDao;
  @Autowired
  private DemandeService demandeService;
    @Override
    public int saveDemandeItem(Demande demande, List<DemandeItem> demandeItems) {
            if (demandeItems == null || !demandeItems.isEmpty()) {
            return -1;
        } else {
            for (DemandeItem demandeItem : demandeItems) {
                demandeItem.setDemande(demande);
                 demandeItem.setProduit(produitService.finByReference(demandeItem.getProduit().getReferance()));
                 demandeItemDao.save(demandeItem);
            }
            return 1;
        }
    }

    @Override
    public void save(DemandeItem demandeItem) {
             demandeItemDao.save(demandeItem);
     }

    @Override
    public List<DemandeItem> findByDemande(Demande demande) {
        demande=demandeService.finByReference(demande.getReference());
      return demandeItemDao.findByDemande(demande);
    }

    @Override
    public DemandeItem findByProduitAndDemande(Produit produit, Demande demande) {
        return demandeItemDao.findByProduitAndDemande(produit, demande);

    }
    
}
