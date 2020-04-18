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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Demande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private double prixtotal;
    private double prixpaye;
    @OneToMany(mappedBy = "demande")
    private List<Reception> receptions ;
    @OneToMany(mappedBy = "demande")
    private List<DemandeItem> demandeItems;
     @JsonFormat(pattern="yyyy-MM-dd")
     @Temporal(javax.persistence.TemporalType.DATE)
     private Date dateDemande;
    public Demande() {

    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getPrixtotal() {
        return prixtotal;
    }

    public void setPrixtotal(double prixtotal) {
        this.prixtotal = prixtotal;
    }

    public double getPrixpaye() {
        return prixpaye;
    }

    public void setPrixpaye(double prixpaye) {
        this.prixpaye = prixpaye;
    }
   
    @JsonIgnore
    public List<Reception> getReceptions() {
        return receptions;
    }

    @JsonSetter   
    public void setReceptions(List<Reception> receptions) {
        this.receptions = receptions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demande)) {
            return false;
        }
        Demande other = (Demande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
 
    @JsonIgnore
    public List<DemandeItem> getDemandeItems() {
        return demandeItems;
    }
    @JsonSetter
    public void setDemandeItems(List<DemandeItem> demandeItems) {
        this.demandeItems = demandeItems;
    }
    

    @Override
    public String toString() {
        return "Demande{" + "id=" + id + ", reference=" + reference + ", prixtotal=" + prixtotal + ", prixpaye=" + prixpaye + '}';
    }

  

}
