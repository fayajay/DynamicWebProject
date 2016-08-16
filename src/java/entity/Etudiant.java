/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "etudiant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e"),
    @NamedQuery(name = "Etudiant.findByNumEt", query = "SELECT e FROM Etudiant e WHERE e.numEt = :numEt"),
    @NamedQuery(name = "Etudiant.findByNomEt", query = "SELECT e FROM Etudiant e WHERE e.nomEt = :nomEt"),
    @NamedQuery(name = "Etudiant.findByPrenomEt", query = "SELECT e FROM Etudiant e WHERE e.prenomEt = :prenomEt"),
    @NamedQuery(name = "Etudiant.findByDateNaissEt", query = "SELECT e FROM Etudiant e WHERE e.dateNaissEt = :dateNaissEt")})
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_et")
    private Integer numEt;
    @Size(max = 30)
    @Column(name = "nom_et")
    private String nomEt;
    @Size(max = 30)
    @Column(name = "prenom_et")
    private String prenomEt;
    @Column(name = "date_naiss_et")
    @Temporal(TemporalType.DATE)
    private Date dateNaissEt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiant")
    private Collection<Obtenir> obtenirCollection;
    @JoinColumn(name = "id_classe", referencedColumnName = "num_classe")
    @ManyToOne(optional = false)
    private Classe idClasse;

    public Etudiant() {
    }

    public Etudiant(Integer numEt) {
        this.numEt = numEt;
    }

    public Integer getNumEt() {
        return numEt;
    }

    public void setNumEt(Integer numEt) {
        this.numEt = numEt;
    }

    public String getNomEt() {
        return nomEt;
    }

    public void setNomEt(String nomEt) {
        this.nomEt = nomEt;
    }

    public String getPrenomEt() {
        return prenomEt;
    }

    public void setPrenomEt(String prenomEt) {
        this.prenomEt = prenomEt;
    }

    public Date getDateNaissEt() {
        return dateNaissEt;
    }

    public void setDateNaissEt(Date dateNaissEt) {
        this.dateNaissEt = dateNaissEt;
    }

    @XmlTransient
    public Collection<Obtenir> getObtenirCollection() {
        return obtenirCollection;
    }

    public void setObtenirCollection(Collection<Obtenir> obtenirCollection) {
        this.obtenirCollection = obtenirCollection;
    }

    public Classe getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Classe idClasse) {
        this.idClasse = idClasse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numEt != null ? numEt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.numEt == null && other.numEt != null) || (this.numEt != null && !this.numEt.equals(other.numEt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servlet.Etudiant[ numEt=" + numEt + " ]";
    }
    
}
