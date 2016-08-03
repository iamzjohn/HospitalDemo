package org.mozdevz.grupo3.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "expediente", catalog = "hospital_db")
public class Expediente implements Serializable{
    private Integer id;
    private Date diaEntrada;
    private Date diaSaida;
    private Date horaEntrada;
    private Date horaSaida;
    
    
    public Expediente(){}

    @Id
    @GenericGenerator(name = "gerador-chave", strategy = "increment")
    @GeneratedValue(generator = "gerador-chave")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    public Date getDiaEntrada() {
        return diaEntrada;
    }

    public void setDiaEntrada(Date diaEntrada) {
        this.diaEntrada = diaEntrada;
    }

    @Temporal(TemporalType.DATE)
    public Date getDiaSaida() {
        return diaSaida;
    }

    public void setDiaSaida(Date diaSaida) {
        this.diaSaida = diaSaida;
    }

    @Temporal(TemporalType.TIME)
    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    @Temporal(TemporalType.TIME)
    public Date getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Date HoraSaida) {
        this.horaSaida = HoraSaida;
    }

  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.diaEntrada);
        hash = 41 * hash + Objects.hashCode(this.diaSaida);
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
        final Expediente other = (Expediente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
