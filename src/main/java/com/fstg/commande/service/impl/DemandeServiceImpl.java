/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service.impl;

import com.fstg.commande.bean.Demande;
import com.fstg.commande.bean.DemandeItem;
import com.fstg.commande.dao.DemandeDao;
import com.fstg.commande.dao.DemandeItemDao;
import com.fstg.commande.service.DemandeItemService;
import com.fstg.commande.service.DemandeService;
import com.fstg.commande.service.ProduitService;
import com.fstg.commande.service.util.DateUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class DemandeServiceImpl implements DemandeService{
   @Autowired
    private DemandeDao demandeDao;
   @Autowired
   private DemandeItemService demandeItemService;
@Autowired
  private ProduitService produitService;
  @Autowired
  private DemandeItemDao demandeItemDao;
      // abd al ati niv 3
    @Override
    public int saveDemmandeWhithDemmandeItem(Demande demande) {
        calculerTotal(demande,demande.getDemandeItems());
        demandeDao.save(demande);
           for (DemandeItem demandeItem : demande.getDemandeItems()) {
                demandeItem.setDemande(demande);
                 demandeItem.setProduit(produitService.finByReference(demandeItem.getProduit().getReferance()));  
                demandeItemDao.save(demandeItem);
            }
        //demandeItemService.saveDemandeItem(demande,demande.getDemandeItems());
        return 1;
    }
    
      private void calculerTotal(Demande demande, List<DemandeItem> demandeItems) {
        double total = 0;
        if (demandeItems != null && !demandeItems.isEmpty()) {
            for (DemandeItem demandeItem : demandeItems) {
                total = total +(demandeItem.getPrix()*demandeItem.getQte());

            }
            demande.setPrixtotal(total);
        }
    }

    @Override
    public Demande finByReference(String reference) {
     return demandeDao.findByReference(reference);
    }

    @Override
    public Demande save(Demande demande) {
       return demandeDao.save(demande);
    }

    @Override
    public int nbrDemande_Annee(String annee) {
          List<Demande> demandes =demandeDao.nbrDemande_Annee(DateUtil.parseAnnee(annee));
          if(demandes.isEmpty()){
              return -1;
          }else{
          int i=0;
          for(Demande demande:demandes){
              i++;
          }
          return i;
    }
    }
}
