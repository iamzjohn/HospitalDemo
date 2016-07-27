package org.mozdevz.grupo3.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.mozdevz.grupo3.model.Departamento;

public class DepartamentoDAO extends DAOAbstracto<Departamento>{

        
    public DepartamentoDAO(Session sessao) {
        super(sessao, Departamento.class);
        ordenarResultados("id", DAOAbstracto.ORDEM_ASCENDENTE);
    }

    public DepartamentoDAO() {
        super(Departamento.class);
        ordenarResultados("id", DAOAbstracto.ORDEM_ASCENDENTE);
    }

    @Override
    public Departamento buscarPorChavePrimaria(Object id) {
        return listarPorChavePrimaria("id", id);
    }
    
    
    public List<Departamento> buscarPorDescricao(String descricao) {
        Criteria criteriaDepartamento = sessao.createCriteria(Departamento.class);
        criteriaDepartamento.add(Restrictions.like("descricao", descricao, MatchMode.ANYWHERE));
        return criteriaDepartamento.list();
    }
}
