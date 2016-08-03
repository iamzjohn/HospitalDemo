package org.mozdevz.grupo3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "doente", catalog = "hospital_db")
public class Doente extends Pessoa implements Serializable{
//    Long id;
    private String nomePai;
    private String nomeMae;
    private List<Doenca> doencas = new ArrayList<>();
    
    public Doente(){}

    public Doente(String nomePai, String nomeMae, String nome, String apelido, String tipoID, String nrID, Genero genero, Date dataNascimento, Contacto contacto, Endereco endereco) {
        super(nome, apelido, tipoID, nrID, genero, dataNascimento, contacto, endereco);
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
    }

    public Doente(String nome, String apelido, String tipoID, String nrID, Genero genero, Date dataNascimento) {
        super(nome, apelido, tipoID, nrID, genero, dataNascimento);
    }

//    @Id
//    @GenericGenerator(name = "gerador-chave", strategy = "increment")
//    @GeneratedValue(generator = "gerador-chave")
//    @Column(name = "id", unique = true, nullable = false)
//    @Override
//    public Long getId() {
//        return id;
//    }
//
//    @Override
//    public void setId(Long id) {
//        this.id = id;
//    }
    
    @Column(name = "nome_do_pai")
    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    @Column(name = "nome_da_mae")
    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "doenca_id")
    public List<Doenca> getDoencas() {
        return doencas;
    }

    public void setDoencas(List<Doenca> doencas) {
        this.doencas = doencas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.doencas);
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
