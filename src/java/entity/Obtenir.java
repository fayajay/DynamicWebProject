/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "obtenir")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Obtenir.findAll", query = "SELECT o FROM Obtenir o"),
    @NamedQuery(name = "Obtenir.findByNumEt", query = "SELECT o FROM Obtenir o WHERE o.obtenirPK.numEt = :numEt"),
    @NamedQuery(name = "Obtenir.findByNumMat", query = "SELECT o FROM Obtenir o WHERE o.obtenirPK.numMat = :numMat"),
    @NamedQuery(name = "Obtenir.findByNote", query = "SELECT o FROM Obtenir o WHERE o.note = :note"),
    @NamedQuery(name = "Obtenir.findByAppreciation", query = "SELECT o FROM Obtenir o WHERE o.appreciation = :appreciation")})
public class Obtenir implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ObtenirPK obtenirPK;
    @Column(name = "note")
    private Integer note;
    @Size(max = 100)
    @Column(name = "appreciation")
    private String appreciation;
    @JoinColumn(name = "num_et", referencedColumnName = "num_et", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Etudiant etudiant;
    @JoinColumn(name = "num_mat", referencedColumnName = "num_mat", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Matiere matiere;

    public Obtenir() {
    }

    public Obtenir(ObtenirPK obtenirPK) {
        this.obtenirPK = obtenirPK;
    }

    public Obtenir(int numEt, int numMat) {
        this.obtenirPK = new ObtenirPK(numEt, numMat);
    }

    public ObtenirPK getObtenirPK() {
        return obtenirPK;
    }

    public void setObtenirPK(ObtenirPK obtenirPK) {
        this.obtenirPK = obtenirPK;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (obtenirPK != null ? obtenirPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Obtenir)) {
            return false;
        }
        Obtenir other = (Obtenir) object;
        if ((this.obtenirPK == null && other.obtenirPK != null) || (this.obtenirPK != null && !this.obtenirPK.equals(other.obtenirPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servlet.Obtenir[ obtenirPK=" + obtenirPK + " ]";
    }
    
}
