/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.modeles;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Christian
 */
@Entity
public class Telephone implements Serializable {


    enum TypeTel {FIXE, PORTABLE};
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Pattern(regexp = "[0]{1}[0-9]{9}")
    private String numero;

    @ManyToOne
    private Utilisateur u;
    
    private TypeTel t;

    public Telephone() {
    }

    public Telephone(final String numero, Utilisateur u, TypeTel t) {
        this.numero = numero;
        this.u = u;
        this.t = t;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telephone)) {
            return false;
        }
        Telephone other = (Telephone) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utilisateurs.modeles.Telephone[ id=" + id + " ]";
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the u
     */
    public Utilisateur getU() {
        return u;
    }

    /**
     * @param u the u to set
     */
    public void setU(Utilisateur u) {
        this.u = u;
    }

}
