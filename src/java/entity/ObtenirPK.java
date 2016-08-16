/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author admin
 */
@Embeddable
public class ObtenirPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "num_et")
    private int numEt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_mat")
    private int numMat;

    public ObtenirPK() {
    }

    public ObtenirPK(int numEt, int numMat) {
        this.numEt = numEt;
        this.numMat = numMat;
    }

    public int getNumEt() {
        return numEt;
    }

    public void setNumEt(int numEt) {
        this.numEt = numEt;
    }

    public int getNumMat() {
        return numMat;
    }

    public void setNumMat(int numMat) {
        this.numMat = numMat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numEt;
        hash += (int) numMat;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObtenirPK)) {
            return false;
        }
        ObtenirPK other = (ObtenirPK) object;
        if (this.numEt != other.numEt) {
            return false;
        }
        if (this.numMat != other.numMat) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servlet.ObtenirPK[ numEt=" + numEt + ", numMat=" + numMat + " ]";
    }
    
}
