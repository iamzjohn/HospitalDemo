/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mozdevz.grupo3.dao;


import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.mozdevz.grupo3.model.LogUtilizador;
import org.mozdevz.grupo3.model.Utilizador;
import org.mozdevz.grupo3.util.DateExpression;

/**
 *
 * @author Francisco Joshua
 */
public class LogUtilizadorDAO extends DAOAbstracto<LogUtilizador> {

    public LogUtilizadorDAO() {
        super(LogUtilizador.class);
        ordenarResultados("dataLogin", DAOAbstracto.ORDEM_DESCENDENTE);
    }

    public LogUtilizadorDAO(Session sessao) {
        super(sessao, LogUtilizador.class);
        ordenarResultados("dataLogin", DAOAbstracto.ORDEM_DESCENDENTE);
    }

    @Override
    public LogUtilizador buscarPorChavePrimaria(Object id) {
        return listarPorChavePrimaria("id.id", id);
    }

    public List<LogUtilizador> buscarTodos(Utilizador utilizador) {
        Criteria criteriaLogUtilizador = sessao.createCriteria(LogUtilizador.class);
        criteriaLogUtilizador.add(Restrictions.eq("utilizador", utilizador));
        criteriaLogUtilizador.addOrder(Order.desc("dataLogin"));
        return criteriaLogUtilizador.list();
    }

    public List<LogUtilizador> buscarTodosLogs(int mes, int ano) {
        Criteria criteriaLogUtilizador = sessao.createCriteria(LogUtilizador.class);
        criteriaLogUtilizador.add(DateExpression.monthEq("dataLogin", mes));
        criteriaLogUtilizador.add(DateExpression.yearEq("dataLogin", ano));
        criteriaLogUtilizador.addOrder(Order.desc("dataLogin"));
        return criteriaLogUtilizador.list();
    }

    public List<LogUtilizador> buscarTodosLogs(Utilizador utilizador, int mes, int ano) {
        Criteria criteriaLogUtilizador = sessao.createCriteria(LogUtilizador.class);
        criteriaLogUtilizador.add(Restrictions.eq("utilizador", utilizador));
        criteriaLogUtilizador.add(DateExpression.monthEq("dataLogin", mes));
        criteriaLogUtilizador.add(DateExpression.yearEq("dataLogin", ano));
        criteriaLogUtilizador.addOrder(Order.desc("dataLogin"));
        return criteriaLogUtilizador.list();
    }
}
