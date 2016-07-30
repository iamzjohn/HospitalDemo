package org.mozdevz.grupo3.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "utilizador", catalog = "hospital_db")
public class Utilizador implements java.io.Serializable {

    private UtilizadorId id;
    private Previlegio previlegio;
    private String usuario;
    private String senha;
    private Departamento departamento;
    private List<LogUtilizador> logUtilizadores = new ArrayList<>();

    public Utilizador() {
        id = new UtilizadorId();
    }

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
        @AttributeOverride(name = "previlegioId", column = @Column(name = "previlegio_id", nullable = false))})
    public UtilizadorId getId() {
        return this.id;
    }

    public void setId(UtilizadorId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "previlegio_id", nullable = false, insertable = false, updatable = false)
    public Previlegio getPrevilegio() {
        id.setPrevilegioId(previlegio.getId());
        return this.previlegio;
    }

    public void setPrevilegio(Previlegio previlegio) {
        this.previlegio = previlegio;
    }


    @Column(name = "usuario", length = 45)
    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Column(name = "senha", length = 45)
    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "utilizador")
    public List<LogUtilizador> getLogUtilizadores() {
        return logUtilizadores;
    }

    public void setLogUtilizadores(List<LogUtilizador> logUtilizadores) {
        this.logUtilizadores = logUtilizadores;
    }

    @Transient
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    

}
