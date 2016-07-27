package org.mozdevz.grupo3.dao;

import org.hibernate.Session;
import org.mozdevz.grupo3.model.Consulta;


public class ConsultaDAO extends DAOAbstracto<Consulta>{
    
    public ConsultaDAO(Session sessao) {
        super(sessao, Consulta.class);
        ordenarResultados("id", DAOAbstracto.ORDEM_ASCENDENTE);
    }

    public ConsultaDAO() {
        super(Consulta.class);
        ordenarResultados("id", DAOAbstracto.ORDEM_ASCENDENTE);
    }

    @Override
    public Consulta buscarPorChavePrimaria(Object id) {
        return listarPorChavePrimaria("id", id);
    }
}
