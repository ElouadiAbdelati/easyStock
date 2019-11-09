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
public class PaiementEcpece implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String devise;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datePaienemnt;

    public PaiementEcpece() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public Date getDatePaienemnt() {
        return datePaienemnt;
    }

    public void setDatePaienemnt(Date datePaienemnt) {
        this.datePaienemnt = datePaienemnt;
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
        if (!(object instanceof PaiementEcpece)) {
            return false;
        }
        PaiementEcpece other = (PaiementEcpece) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "PaiementEcpece{" + "id=" + id + ", devise=" + devise + ", datePaienemnt=" + datePaienemnt + '}';
    }

  
}
