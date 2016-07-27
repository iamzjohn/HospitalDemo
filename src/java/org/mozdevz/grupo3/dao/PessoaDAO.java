package org.mozdevz.grupo3.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.mozdevz.grupo3.model.Doenca;
import org.mozdevz.grupo3.model.Pessoa;

public class PessoaDAO extends DAOAbstracto<Pessoa> {

   public PessoaDAO(Session sessao) {
        super(sessao, Pessoa.class);
        ordenarResultados("id", DAOAbstracto.ORDEM_ASCENDENTE);
    }

    public PessoaDAO() {
        super(Pessoa.class);
        ordenarResultados("id", DAOAbstracto.ORDEM_ASCENDENTE);
    }

    @Override
    public Pessoa buscarPorChavePrimaria(Object id) {
        return listarPorChavePrimaria("id", id);
    }
    
    public List<Pessoa> buscarIDs(){
        Criteria criteriaPessoas = sessao.createCriteria(Pessoa.class);
        criteriaPessoas.setProjection(Projections.distinct(Projections.property("tipo_id")));
//        criteriaPessoas.add(Restrictions.);
        
        return criteriaPessoas.list();
    }
    
    public List<Doenca> buscarDoencas(){
        Criteria criteriaDoencas = sessao.createCriteria(Doenca.class);
        criteriaDoencas.setProjection(Projections.distinct(Projections.property("descricao")));
//        criteriaPessoas.add(Restrictions.);
        
        return criteriaDoencas.list();
    }

    public List<Pessoa> buscarPorNomeOuApelido(String nomeOuApelido) {
        Criteria criteriaUtilizador = sessao.createCriteria(Pessoa.class);
        Criterion criterionNome = Restrictions.like("nome", nomeOuApelido, MatchMode.ANYWHERE);
        Criterion criterionUsuario = Restrictions.like("apelido", nomeOuApelido, MatchMode.ANYWHERE);
        criteriaUtilizador.add(Restrictions.or(criterionNome, criterionUsuario));
        return criteriaUtilizador.list();
    }
}
