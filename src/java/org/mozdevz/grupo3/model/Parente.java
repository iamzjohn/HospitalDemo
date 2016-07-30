package org.mozdevz.grupo3.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Parente implements Serializable{
    private Integer id;
    private String nome;
    private String posicaoParental;
    private String nrCelular1;
    private String nrCelular2;
    
    private Parente(){}

    public Parente(String nome, String posicaoParental, String nrCelular1, String nrCelular2) {
        this.nome = nome;
        this.posicaoParental = posicaoParental;
        this.nrCelular1 = nrCelular1;
        this.nrCelular2 = nrCelular2;
    }

    
    
    @Id
    @GenericGenerator(name = "gerador-chave", strategy = "increment")
    @GeneratedValue(generator = "gerador-chave")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicaoParental() {
        return posicaoParental;
    }

    public void setPosicaoParental(String posicaoParental) {
        this.posicaoParental = posicaoParental;
    }
    
    @Column(name = "nr_celular1")
    public String getNrCelular1() {
        return nrCelular1;
    }

    public void setNrCelular1(String nrCelular1) {
        this.nrCelular1 = nrCelular1;
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
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.nome);
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
        final Parente other = (Parente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
