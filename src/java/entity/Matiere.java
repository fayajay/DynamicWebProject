/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "matiere")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matiere.findAll", query = "SELECT m FROM Matiere m"),
    @NamedQuery(name = "Matiere.findByNumMat", query = "SELECT m FROM Matiere m WHERE m.numMat = :numMat"),
    @NamedQuery(name = "Matiere.findByNomMat", query = "SELECT m FROM Matiere m WHERE m.nomMat = :nomMat")})
public class Matiere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_mat")
    private Integer numMat;
    @Size(max = 40)
    @Column(name = "nom_mat")
    private String nomMat;
    @ManyToMany(mappedBy = "matiereCollection")
    private Collection<Classe> classeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matiere")
    private Collection<Obtenir> obtenirCollection;

    public Matiere() {
    }

    public Matiere(Integer numMat) {
        this.numMat = numMat;
    }

    public Integer getNumMat() {
        return numMat;
    }

    public void setNumMat(Integer numMat) {
        this.numMat = numMat;
    }

    public String getNomMat() {
        return nomMat;
    }

    public void setNomMat(String nomMat) {
        this.nomMat = nomMat;
    }

    @XmlTransient
    public Collection<Classe> getClasseCollection() {
        return classeCollection;
    }

    public void setClasseCollection(Collection<Classe> classeCollection) {
        this.classeCollection = classeCollection;
    }

    @XmlTransient
    public Collection<Obtenir> getObtenirCollection() {
        return obtenirCollection;
    }

    public void setObtenirCollection(Collection<Obtenir> obtenirCollection) {
        this.obtenirCollection = obtenirCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numMat != null ? numMat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matiere)) {
            return false;
        }
        Matiere other = (Matiere) object;
        if ((this.numMat == null && other.numMat != null) || (this.numMat != null && !this.numMat.equals(other.numMat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servlet.Matiere[ numMat=" + numMat + " ]";
    }
    
}
