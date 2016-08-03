
package org.mozdevz.grupo3.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "medico", catalog = "hospital_db")
public class Medico extends Funcionario implements Serializable{
//    private Long id;
    private String especializacao;

    public Medico() {
    }

    
//    @Override
//    @Id
//    @GenericGenerator(name = "gerador-chave", strategy = "increment")
//    @GeneratedValue(generator = "gerador-chave")
//    @Column(name = "medico_id", unique = true, nullable = false)
//    public Long getId() {
//        return id;
//    }
//
////    @Override
//    public void setId(Long id) {
//        this.id = id;
//    }
    

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.especializacao);
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
