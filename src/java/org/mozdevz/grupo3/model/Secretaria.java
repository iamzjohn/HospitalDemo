package org.mozdevz.grupo3.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name = "secretaria", catalog = "hospital_db")
public class Secretaria extends Funcionario implements Serializable{
//   private Long id;
    private Date dataCriacao;
    
    
    public Secretaria() {
    }
    
//   @Override
//   @Id
//    @GenericGenerator(name = "gerador-chave", strategy = "increment")
//    @GeneratedValue(generator = "gerador-chave")
//    @Column(name = "secretaria_id", unique = true, nullable = false)
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    @Temporal(TemporalType.DATE)
    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
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
        return true;
    }
    
    
}
