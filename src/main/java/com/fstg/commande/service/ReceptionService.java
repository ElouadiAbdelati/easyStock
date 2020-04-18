/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service;

import com.fstg.commande.bean.Demande;
import com.fstg.commande.bean.Reception;
import java.util.List;

/**
 *
 * @author pc
 */
public interface ReceptionService {
    public Reception  saveReceptionWhithReceptionItm(Reception reception);
    public int  saveReceptionInsideDemande(Demande demande,Reception reception);
    public int payeReception(Reception reception);
    
    public List<Reception> receptionsNonPayee(Demande demande) ;
    
}
