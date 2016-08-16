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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "classe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM Classe c"),
    @NamedQuery(name = "Classe.findByNumClasse", query = "SELECT c FROM Classe c WHERE c.numClasse = :numClasse"),
    @NamedQuery(name = "Classe.findByNomClasse", query = "SELECT c FROM Classe c WHERE c.nomClasse = :nomClasse")})
public class Classe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_classe")
    private Integer numClasse;
    @Size(max = 30)
    @Column(name = "nom_classe")
    private String nomClasse;
    @JoinTable(name = "comprendre", joinColumns = {
        @JoinColumn(name = "num_classe", referencedColumnName = "num_classe")}, inverseJoinColumns = {
        @JoinColumn(name = "num_mat", referencedColumnName = "num_mat")})
    @ManyToMany
    private Collection<Matiere> matiereCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClasse")
    private Collection<Etudiant> etudiantCollection;

    public Classe() {
    }

    public Classe(Integer numClasse) {
        this.numClasse = numClasse;
    }

    public Integer getNumClasse() {
        return numClasse;
    }

    public void setNumClasse(Integer numClasse) {
        this.numClasse = numClasse;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    @XmlTransient
    public Collection<Matiere> getMatiereCollection() {
        return matiereCollection;
    }

    public void setMatiereCollection(Collection<Matiere> matiereCollection) {
        this.matiereCollection = matiereCollection;
    }

    @XmlTransient
    public Collection<Etudiant> getEtudiantCollection() {
        return etudiantCollection;
    }

    public void setEtudiantCollection(Collection<Etudiant> etudiantCollection) {
        this.etudiantCollection = etudiantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numClasse != null ? numClasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classe)) {
            return false;
        }
        Classe other = (Classe) object;
        if ((this.numClasse == null && other.numClasse != null) || (this.numClasse != null && !this.numClasse.equals(other.numClasse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servlet.Classe[ numClasse=" + numClasse + " ]";
    }
    
}
