package org.mozdevz.grupo3.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="contacto", catalog="hospital_db")
public class Contacto implements Serializable{
    
    private Integer id;
    private String email;
    private String nrCelular;
    private String nrCelular2;
    
    public Contacto(){}

    public Contacto(String email, String nrCelular, String nrCelular2) {
        this.email = email;
        this.nrCelular = nrCelular;
        this.nrCelular2 = nrCelular2;
    }
    
    

    @Id
    @GenericGenerator(name = "gerador-chave", strategy = "increment")
    @GeneratedValue(generator = "gerador-chave")
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() { return id;}
    public void setId(Integer id) { this.id = id;}

    
    public String getEmail() { return email;}
    public void setEmail(String email) {this.email = email;}

    @Column(name = "nr_celular")
    public String getNrCelular() {
        return nrCelular;
    }

    public void setNrCelular(String nrCelular) {
        this.nrCelular = nrCelular;
    }
    
    @Column(name = "nr_celular2")
    public String getNrCelular2() {
        return nrCelular2;
    }

    public void setNrCelular2(String nrCelular2) {
        this.nrCelular2 = nrCelular2;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contacto other = (Contacto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   
  
}
