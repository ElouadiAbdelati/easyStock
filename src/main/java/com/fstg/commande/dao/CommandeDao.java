 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.dao;

import com.fstg.commande.bean.Commande;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc
 */
@Repository
public interface  CommandeDao extends JpaRepository<Commande,Long>{
    public Commande findByReference(String referece);

    /**
     *
     * @param date
     * @return
     */
    @Query("SELECT c FROM Commande c WHERE c.dateFinCommande < ?1 ")
    public List<Commande>  findCommande(Date date);
    @Query("SELECT c FROM Commande c WHERE c.dateCommande > ?1 and c.dateCommande <?2")
     public List<Commande> finCommandesBetwenTwoDate(Date pDate,Date dDate);
     
    @Query("SELECT c FROM Commande c WHERE c.dateFinCommande <=?1  ")
     public  List<Commande>  findByDateFin(Date dateFin);
     
     public List<Commande> findByDateFinCommandeAfter(Date dateFin);
     
}
