package org.mozdevz.grupo3.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class UtilizadorId implements java.io.Serializable {

    private int id;
    private int previlegioId;

    public UtilizadorId() {
    }

    public UtilizadorId(int id, int previlegioId) {
        this.id = id;
        this.previlegioId = previlegioId;
    }

    @Column(name = "id", nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "previlegio_id", nullable = false)
    public int getPrevilegioId() {
        return this.previlegioId;
    }

    public void setPrevilegioId(int previlegioId) {
        this.previlegioId = previlegioId;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof UtilizadorId)) {
            return false;
        }
        UtilizadorId castOther = (UtilizadorId) other;

        return (this.getId() == castOther.getId())
                && (this.getPrevilegioId() == castOther.getPrevilegioId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getId();
        result = 37 * result + this.getPrevilegioId();

        return result;
    }

}
