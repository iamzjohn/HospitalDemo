package org.mozdevz.grupo3.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "doenca", catalog = "hospital_db")
public class Doenca implements Serializable{
    private Integer id;
    private String descricao;
    
    private Doenca(){}

    public Doenca(String descricao) {
        this.descricao = descricao;
    }

    
    
     @Id
    @GenericGenerator(name = "gerador-chave", strategy = "increment")
    @GeneratedValue(generator = "gerador-chave")
    public Integer getId() {
        return id;
    }

    public void setId(Integer ig) {
        this.id = ig;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.descricao);
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
        final Doenca other = (Doenca) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
