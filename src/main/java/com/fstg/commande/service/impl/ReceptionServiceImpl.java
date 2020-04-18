/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service.impl;

import com.fstg.commande.bean.Demande;
import com.fstg.commande.bean.DemandeItem;
import com.fstg.commande.bean.Reception;
import com.fstg.commande.bean.ReceptionItem;
import com.fstg.commande.dao.ReceptionDao;
import com.fstg.commande.dao.ReceptionItemDao;
import com.fstg.commande.service.DemandeItemService;
import com.fstg.commande.service.DemandeService;
import com.fstg.commande.service.ProduitService;
import com.fstg.commande.service.ReceptionItemService;
import com.fstg.commande.service.ReceptionService;
import com.fstg.commande.service.StockService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class ReceptionServiceImpl implements ReceptionService{
  @Autowired
    private ReceptionDao receptionDao;
  @Autowired
  private DemandeService demandeService;
  @Autowired
  private ReceptionItemService receptionItemService;
  
    @Autowired
  private ProduitService  produitService;
  @Autowired
  private StockService stockService;
  @Autowired
  private ReceptionItemDao receptionItemDao;
  @Autowired
  private DemandeItemService demandeItemService;
  
      // abd al ati niv 3
     @Override
    public Reception saveReceptionWhithReceptionItm(Reception reception) {
        reception.setDemande(demandeService.finByReference( reception.getDemande().getReference()));
        reception.getDemande().setDemandeItems(demandeItemService.findByDemande(reception.getDemande()));
        receptionDao.save(reception);
      
          for (ReceptionItem receptionItem : reception.getReceptionItems()) {
                receptionItem.setReception(reception);
                receptionItem.setProduit(produitService.finByReference(receptionItem.getProduit().getReferance()));
                receptionItem.getStock().setProduit(receptionItem.getProduit());
                receptionItem.setStock(stockService.findByReferance(receptionItem.getStock().getReferance()));
                receptionItem.getStock().setQte(receptionItem.getQte()+receptionItem.getStock().getQte());
                for (DemandeItem  demandeItem :  reception.getDemande().getDemandeItems()) {
                    if ((receptionItem.getProduit())==demandeItem.getProduit() ){
                         if( demandeItem.getQteReceptionne()+receptionItem.getQte()<=demandeItem.getQte()){
                            demandeItem.setQteReceptionne(demandeItem.getQteReceptionne()+receptionItem.getQte());
                            demandeItemService.save(demandeItem);
                             stockService.save(receptionItem.getStock());
                            receptionItemDao.save(receptionItem);
                        }
                 }
          
               }
          }
        //receptionItemService.saveReceptionItem(reception, reception.getReceptionItems());
        return reception;
    }
    
    @Override
    public int  saveReceptionInsideDemande(Demande demande, Reception reception) {
       demandeService.save(demande);
       return 1;
    }
    // abd al ati niv 2
    @Override
    public int payeReception(Reception reception) {
        reception.setDemande(demandeService.finByReference(reception.getDemande().getReference()));
        if(reception.getDemande()==null){
            return -1;
        }else {
            reception=receptionDao.findById(reception.getId()).get();
            if(reception==null){
                return -2;
            }else if(reception.isPaye()){
                return -3;
            }else{
                reception.setReceptionItems(receptionItemService.findByReception(reception));
                double prixPaye=0;
                for (ReceptionItem  receptionItem : reception.getReceptionItems()) {
                    DemandeItem demandeItem=demandeItemService.findByProduitAndDemande(receptionItem.getProduit(), reception.getDemande());
                    prixPaye+=receptionItem.getQte()*demandeItem.getPrix();
                    reception.getDemande().setPrixpaye(prixPaye);
                }
                demandeService.save(reception.getDemande());
                return 1;
                }
        }
    }

    @Override
    public List<Reception> receptionsNonPayee(Demande demande) {
     demande=demandeService.finByReference(demande.getReference());
     return receptionDao.receptionsNonPayee(demande);

    }
    
    
}
