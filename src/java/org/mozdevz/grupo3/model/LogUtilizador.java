package org.mozdevz.grupo3.model;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "log_utilizador", catalog = "hospital_db"
)
public class LogUtilizador implements java.io.Serializable {

    private LogUtilizadorId id;
    private Utilizador utilizador;
    private Date dataLogin;

    public LogUtilizador() {
        id = new LogUtilizadorId();
    }

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
        @AttributeOverride(name = "utilizadorId", column = @Column(name = "utilizador_id", nullable = false)),
        @AttributeOverride(name = "utilizadorPrevilegioId", column = @Column(name = "utilizador_previlegio_id", nullable = false))})
    public LogUtilizadorId getId() {
        return this.id;
    }

    public void setId(LogUtilizadorId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "utilizador_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "utilizador_previlegio_id", referencedColumnName = "previlegio_id", nullable = false, insertable = false, updatable = false)})
    public Utilizador getUtilizador() {
        return this.utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        id.setUtilizadorPrevilegioId(utilizador.getPrevilegio().getId());
        id.setUtilizadorId(utilizador.getId().getId());
        this.utilizador = utilizador;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_login", length = 19)
    public Date getDataLogin() {
        return this.dataLogin;
    }

    public void setDataLogin(Date dataLogin) {
        this.dataLogin = dataLogin;
    }
}
