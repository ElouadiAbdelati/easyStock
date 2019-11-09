/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author pc
 */
@Entity
public class PaiementCheque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean encaissement;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datedepot;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEmenEncaissement;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datesoumission;

    public boolean isEncaissement() {
        return encaissement;
    }

    public void setEncaissement(boolean encaissement) {
        this.encaissement = encaissement;
    }

    public Date getDatedepot() {
        return datedepot;
    }

    public void setDatedepot(Date datedepot) {
        this.datedepot = datedepot;
    }

    public Date getDateEmenEncaissement() {
        return dateEmenEncaissement;
    }

    public void setDateEmenEncaissement(Date dateEmenEncaissement) {
        this.dateEmenEncaissement = dateEmenEncaissement;
    }

    public Date getDatesoumission() {
        return datesoumission;
    }

    public void setDatesoumission(Date datesoumission) {
        this.datesoumission = datesoumission;
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
        if (!(object instanceof PaiementCheque)) {
            return false;
        }
        PaiementCheque other = (PaiementCheque) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "PaiementCheque{" + "id=" + id + ", encaissement=" + encaissement + ", datedepot=" + datedepot + ", dateEmenEncaissement=" + dateEmenEncaissement + ", datesoumission=" + datesoumission + '}';
    }

   
}
