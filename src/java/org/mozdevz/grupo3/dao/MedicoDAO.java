package org.mozdevz.grupo3.dao;

import org.hibernate.Session;
import org.mozdevz.grupo3.model.Medico;

public class MedicoDAO extends DAOAbstracto<Medico>{
    
    public MedicoDAO(Session sessao) {
        super(sessao, Medico.class);
        ordenarResultados("id", DAOAbstracto.ORDEM_ASCENDENTE);
    }

    public MedicoDAO() {
        super(Medico.class);
        ordenarResultados("id", DAOAbstracto.ORDEM_ASCENDENTE);
    }
    
    @Override
    public Medico buscarPorChavePrimaria(Object id) {
         return listarPorChavePrimaria("id", id);
    }
    
}
