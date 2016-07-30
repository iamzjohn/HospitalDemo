package org.mozdevz.grupo3.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
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
    
    public List<Medico> buscarPorNomeDoente(String nome) {
        Criteria criteriaMedico = sessao.createCriteria(Medico.class);
        criteriaMedico.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE));
        return criteriaMedico.list();
    }
    
   
    public List<Medico> buscarPorApelidoDoente(String nome) {
        Criteria criteriaMedico = sessao.createCriteria(Medico.class);
        criteriaMedico.add(Restrictions.like("apelido", nome, MatchMode.ANYWHERE));
        return criteriaMedico.list();
    }
    
    public Medico buscarPorNrIdentificacao(String idNumber) {
        Criteria criteriaMedico = sessao.createCriteria(Medico.class);
        criteriaMedico.add(Restrictions.eq("nr_id", idNumber));
        return (Medico) criteriaMedico.uniqueResult();
    }
}
