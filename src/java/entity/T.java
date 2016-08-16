/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "t")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "T.findAll", query = "SELECT t FROM T t"),
    @NamedQuery(name = "T.findByS1", query = "SELECT t FROM T t WHERE t.s1 = :s1")})
public class T implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "s1")
    private Integer s1;

    public T() {
    }

    public T(Integer s1) {
        this.s1 = s1;
    }

    public Integer getS1() {
        return s1;
    }

    public void setS1(Integer s1) {
        this.s1 = s1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (s1 != null ? s1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T)) {
            return false;
        }
        T other = (T) object;
        if ((this.s1 == null && other.s1 != null) || (this.s1 != null && !this.s1.equals(other.s1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servlet.T[ s1=" + s1 + " ]";
    }
    
}
