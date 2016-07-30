package org.mozdevz.grupo3.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ficha_medica")
public class Consulta implements Serializable{
    private Long id;
    private Date data;
    private Date hora;
    private Secretaria secretaria;
    private Medico medico;
    private Doente doente;

    public Consulta() {
        
    }

    public Consulta(Date data, Date hora, Secretaria secretaria, Medico medico, Doente doente) {
        this.data = data;
        this.hora = hora;
        this.secretaria = secretaria;
        this.medico = medico;
        this.doente = doente;
    }
    
    

    @Id
    @GenericGenerator(name = "gerador-chave", strategy = "increment")
    @GeneratedValue(generator = "gerador-chave")
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    @Temporal(TemporalType.TIME)
    @Column(name = "hora_consulta")
    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }
    
    

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

     @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @OneToOne(fetch = FetchType.EAGER)
    public Doente getDoente() {
        return doente;
    }

    public void setDoente(Doente doente) {
        this.doente = doente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.data);
        hash = 53 * hash + Objects.hashCode(this.secretaria);
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
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
