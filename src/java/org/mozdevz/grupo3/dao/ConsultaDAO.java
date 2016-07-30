package org.mozdevz.grupo3.dao;

import java.util.Calendar;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.mozdevz.grupo3.model.Consulta;
import org.mozdevz.grupo3.model.Doente;


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
    
    public List<Consulta> buscarTodasNumaData(Calendar diaInicio, Calendar diaFim, Doente doente) {
        Criteria criteriaConsulta = sessao.createCriteria(Consulta.class);
//        criteriaConsulta.add(Restrictions.eq("anulada", false));
        criteriaConsulta.add(Restrictions.eq("doenteId", doente.getId()));

        diaInicio.set(diaInicio.get(Calendar.YEAR), diaInicio.get(Calendar.MONDAY), diaInicio.get(Calendar.DATE),
                0, 0, 0);
        criteriaConsulta.add(Restrictions.ge("dataEmissao", diaInicio.getTime()));

        diaFim.set(diaFim.get(Calendar.YEAR), diaFim.get(Calendar.MONDAY), diaFim.get(Calendar.DATE),
                0, 0, 0);
        diaFim.add(Calendar.DAY_OF_YEAR, 1);
        criteriaConsulta.add(Restrictions.lt("dataEmissao", diaFim.getTime()));

        criteriaConsulta.addOrder(Order.desc("dataEmissao"));
        return criteriaConsulta.list();
    }
   
}
