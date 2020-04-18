/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author pc
 */
@Entity
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private double total;
    private double remise;
    private double montantPayeCheque;
    private double montantPayeEspece;
    @OneToMany(mappedBy = "commande")
    private List<CommandeItem> commandeItems ;
    @OneToMany(mappedBy = "commande")
    private List<Paiement> paiements;
    @OneToMany(mappedBy = "commande")
    private List<BonLivraison> bonLivraisons;
     @JsonFormat(pattern="yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCommande; 
    @JsonFormat(pattern="yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
     private Date dateFinCommande; 
    

    public Commande() {
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }
   
    public Date getDateFinCommande() {
        return dateFinCommande;
    }

    public void setDateFinCommande(Date dateFinCommande) {
        this.dateFinCommande = dateFinCommande;
    }
   
    
    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getReference() {
        return reference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
   @JsonIgnore
    public List<BonLivraison> getBonLivraisons() {
        return bonLivraisons;
    }
   @JsonSetter
    public void setBonLivraisons(List<BonLivraison> bonLivraisons) {
        this.bonLivraisons = bonLivraisons;
    }
   @JsonIgnore
    public List<Paiement> getPaiements() {
        return paiements;
    }
   @JsonSetter
    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }

    public double getMontantPayeCheque() {
        return montantPayeCheque;
    }

    public void setMontantPayeCheque(double montantPayeCheque) {
        this.montantPayeCheque = montantPayeCheque;
    }
   @JsonIgnore
    public double getMontantPayeEspece() {
        return montantPayeEspece;
    }
   @JsonSetter
    public void setMontantPayeEspece(double montantPayeEspece) {
        this.montantPayeEspece = montantPayeEspece;
    }
   @JsonIgnore
    public List<CommandeItem> getCommandeItems() {
        return commandeItems;
    }
   @JsonSetter
    public void setCommandeItems(List<CommandeItem> commandeItems) {
        this.commandeItems = commandeItems;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Commande other = (Commande) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", reference=" + reference + ", total=" + total + ", montantPayeCheque=" + montantPayeCheque + ", montantPayeEspece=" + montantPayeEspece + '}';
    }

   
    
    

}
