/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
    private BigDecimal total;

    private double montantPayeCheque;
    private double montantPayeEspece;
    @OneToMany(mappedBy = "commande")
    private List<CommandeItem> commandeItems ;
    @OneToMany(mappedBy = "commande")
    private List<Paiement> paiements;
    @OneToMany(mappedBy = "commande")
    private List<BonLivraison> bonLivraisons;

   
    

    public Commande() {
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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<BonLivraison> getBonLivraisons() {
        return bonLivraisons;
    }

    public void setBonLivraisons(List<BonLivraison> bonLivraisons) {
        this.bonLivraisons = bonLivraisons;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }

    public double getMontantPayeCheque() {
        return montantPayeCheque;
    }

    public void setMontantPayeCheque(double montantPayeCheque) {
        this.montantPayeCheque = montantPayeCheque;
    }

    public double getMontantPayeEspece() {
        return montantPayeEspece;
    }

    public void setMontantPayeEspece(double montantPayeEspece) {
        this.montantPayeEspece = montantPayeEspece;
    }

    public List<CommandeItem> getCommandeItems() {
        return commandeItems;
    }

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
