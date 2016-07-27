package org.mozdevz.grupo3.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class LogUtilizadorId implements java.io.Serializable {

    private int id;
    private int utilizadorId;
    private int utilizadorPrevilegioId;

    public LogUtilizadorId() {
    }

    public LogUtilizadorId(int id, int utilizadorId, int utilizadorPrevilegioId) {
        this.id = id;
        this.utilizadorId = utilizadorId;
        this.utilizadorPrevilegioId = utilizadorPrevilegioId;
    }

    @Column(name = "id", nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "utilizador_id", nullable = false)
    public int getUtilizadorId() {
        return this.utilizadorId;
    }

    public void setUtilizadorId(int utilizadorId) {
        this.utilizadorId = utilizadorId;
    }

    @Column(name = "utilizador_previlegio_id", nullable = false)
    public int getUtilizadorPrevilegioId() {
        return this.utilizadorPrevilegioId;
    }

    public void setUtilizadorPrevilegioId(int utilizadorPrevilegioId) {
        this.utilizadorPrevilegioId = utilizadorPrevilegioId;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof LogUtilizadorId)) {
            return false;
        }
        LogUtilizadorId castOther = (LogUtilizadorId) other;

        return (this.getId() == castOther.getId())
                && (this.getUtilizadorId() == castOther.getUtilizadorId())
                && (this.getUtilizadorPrevilegioId() == castOther.getUtilizadorPrevilegioId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getId();
        result = 37 * result + this.getUtilizadorId();
        result = 37 * result + this.getUtilizadorPrevilegioId();
        return result;
    }

}
