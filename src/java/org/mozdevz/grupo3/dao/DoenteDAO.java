package org.mozdevz.grupo3.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.mozdevz.grupo3.model.Doente;

public class DoenteDAO extends DAOAbstracto<Doente>{
    
    
    public DoenteDAO(Session sessao) {
        super(sessao, Doente.class);
        ordenarResultados("id", DAOAbstracto.ORDEM_ASCENDENTE);
    }

    public DoenteDAO() {
        super(Doente.class);
        ordenarResultados("id", DAOAbstracto.ORDEM_ASCENDENTE);
    }
    
    @Override
    public Doente buscarPorChavePrimaria(Object id) {
         return listarPorChavePrimaria("id", id);
    }
    
    public List<Doente> buscarPorNomeDoente(String nome) {
        Criteria criteriaDoente = sessao.createCriteria(Doente.class);
        criteriaDoente.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE));
        return criteriaDoente.list();
    }
    
   
    public List<Doente> buscarPorApelidoDoente(String nome) {
        Criteria criteriaDoente = sessao.createCriteria(Doente.class);
        criteriaDoente.add(Restrictions.like("apelido", nome, MatchMode.ANYWHERE));
        return criteriaDoente.list();
    }
    
    public List<Doente> buscarPorNomeApelidoDoente(String nomeOuApelido) {
        Criteria criteriaDoente = sessao.createCriteria(Doente.class);
        Criterion criterionNome = Restrictions.like("nome", nomeOuApelido, MatchMode.ANYWHERE);
        Criterion criterionApelido = Restrictions.like("apelido", nomeOuApelido, MatchMode.ANYWHERE);
        LogicalExpression expressaoOU = Restrictions.or(criterionNome, criterionApelido);
        criteriaDoente.add(expressaoOU);
        return criteriaDoente.list();
    }
    
    public Doente buscarPorNrIdentificacao(String idNumber) {
        Criteria criteriaDoente = sessao.createCriteria(Doente.class);
        criteriaDoente.add(Restrictions.eq("nr_id", idNumber));
        return (Doente) criteriaDoente.uniqueResult();
    }
    
//    public List<Vd> buscarTodasNaoAnuladas(Cliente cliente, Calendar diaInicio, Calendar diaFim) {
//        Criteria criteriaVD = sessao.createCriteria(Vd.class);
//        criteriaVD.add(Restrictions.eq("anulada", false));
//        criteriaVD.add(Restrictions.eq("clienteId", cliente.getId()));
//
//        diaInicio.set(diaInicio.get(Calendar.YEAR), diaInicio.get(Calendar.MONDAY), diaInicio.get(Calendar.DATE),
//                0, 0, 0);
//        criteriaVD.add(Restrictions.ge("dataEmissao", diaInicio.getTime()));
//
//        diaFim.set(diaFim.get(Calendar.YEAR), diaFim.get(Calendar.MONDAY), diaFim.get(Calendar.DATE),
//                0, 0, 0);
//        diaFim.add(Calendar.DAY_OF_YEAR, 1);
//        criteriaVD.add(Restrictions.lt("dataEmissao", diaFim.getTime()));
//
//        criteriaVD.addOrder(Order.desc("dataEmissao"));
//        return criteriaVD.lisxt();
//    }
    
}
