
package org.mozdevz.grupo3.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;


@Entity
public class Medico extends Funcionario implements Serializable{
    private String especializacao;

    public Medico() {
    }

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
