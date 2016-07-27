package org.mozdevz.grupo3.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "previlegio", catalog = "hospital_db")
public class Previlegio implements java.io.Serializable {

    public static final String PREVILEGIO_DOENTE = "Apenas Doentes";
    public static final String PREVILEGIO_ADMINISTRACAO = "Administração";
    public static final String PREVILEGIO_POWER_USER = "Power User";
    //---------------------------------------------------------
    private Integer id;
    private String previlegio;
    private List<Utilizador> utilizadores = new ArrayList<>();

    public Previlegio() {
    }

    @Id
    @GenericGenerator(name = "gerador-chave", strategy = "increment")
    @GeneratedValue(generator = "gerador-chave")
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "previlegio", length = 45)
    public String getPrevilegio() {
        return previlegio;
    }

    public void setPrevilegio(String previlegio) {
        this.previlegio = previlegio;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "previlegio")
    public List<Utilizador> getUtilizadores() {
        return this.utilizadores;
    }

    public void setUtilizadores(List<Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

    @Override
    public String toString() {
        return previlegio;
    }
}
