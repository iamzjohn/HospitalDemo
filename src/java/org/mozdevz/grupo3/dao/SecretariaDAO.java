package org.mozdevz.grupo3.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.mozdevz.grupo3.model.Secretaria;

public class SecretariaDAO extends DAOAbstracto<Secretaria>{
    
    public SecretariaDAO(Session sessao) {
        super(sessao, Secretaria.class);
        ordenarResultados("id", DAOAbstracto.ORDEM_ASCENDENTE);
    }

    public SecretariaDAO() {
        super(Secretaria.class);
        ordenarResultados("id", DAOAbstracto.ORDEM_ASCENDENTE);
    }
    
    @Override
    public Secretaria buscarPorChavePrimaria(Object id) {
         return listarPorChavePrimaria("id", id);
    }
    
    public List<Secretaria> buscarPorNomeDoente(String nome) {
        Criteria criteriaSecretaria = sessao.createCriteria(Secretaria.class);
        criteriaSecretaria.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE));
        return criteriaSecretaria.list();
    }
    
   
    public List<Secretaria> buscarPorApelidoDoente(String nome) {
        Criteria criteriaSecretaria = sessao.createCriteria(Secretaria.class);
        criteriaSecretaria.add(Restrictions.like("apelido", nome, MatchMode.ANYWHERE));
        return criteriaSecretaria.list();
    }
    
    public Secretaria buscarPorNrIdentificacao(String idNumber) {
        Criteria criteriaSecretaria = sessao.createCriteria(Secretaria.class);
        criteriaSecretaria.add(Restrictions.eq("nr_id", idNumber));
        return (Secretaria) criteriaSecretaria.uniqueResult();
    }
    
    
}
