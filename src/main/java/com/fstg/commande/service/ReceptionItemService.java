/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service;

import com.fstg.commande.bean.Reception;
import com.fstg.commande.bean.ReceptionItem;
import java.util.List;

/**
 *
 * @author pc
 */
public interface ReceptionItemService {
    public int saveReceptionItem(Reception reception,List<ReceptionItem> receptionItems);
        public List<ReceptionItem> findByReception(Reception reception);

}
