package org.mozdevz.grupo3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
//@MappedSuperclass
@Table(name = "funcionario", catalog = "hospital_db")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Funcionario extends Pessoa implements Serializable{
    private List<Expediente> expedientes = new ArrayList<>();
    
    public Funcionario(){}

    public Funcionario(String nome, String apelido, String tipoID, String nrID, Genero genero, Date dataNascimento, Contacto contacto, Endereco endereco) {
        super(nome, apelido, tipoID, nrID, genero, dataNascimento, contacto, endereco);
    }

    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_id")
    public List<Expediente> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(List<Expediente> expedientes) {
        this.expedientes = expedientes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.expedientes);
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
