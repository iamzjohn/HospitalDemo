/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mozdevz.grupo3.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.mozdevz.grupo3.model.Utilizador;

/**
 *
 * @author Francisco Joshua
 */
public class UtilizadorDAO extends DAOAbstracto<Utilizador> {

    public UtilizadorDAO(Session sessao) {
        super(sessao, Utilizador.class);
        ordenarResultados("id.id", DAOAbstracto.ORDEM_ASCENDENTE);
    }

    public UtilizadorDAO() {
        super(Utilizador.class);
        ordenarResultados("id.id", DAOAbstracto.ORDEM_ASCENDENTE);
    }

    @Override
    public Utilizador buscarPorChavePrimaria(Object id) {
        return listarPorChavePrimaria("id.id", id);
    }

    public Utilizador buscarUtilizador(String utilizador, String senha) {
        Criteria criteriaUtilizador = sessao.createCriteria(Utilizador.class);
        criteriaUtilizador.add(Restrictions.eq("usuario", utilizador));
        criteriaUtilizador.add(Restrictions.eq("senha", senha));
        return (Utilizador) criteriaUtilizador.uniqueResult();
    }

    public boolean utilizadorExiste(Utilizador utilizador) {
        Criteria criteriaUtilizador = sessao.createCriteria(Utilizador.class);
        criteriaUtilizador.add(Restrictions.eq("usuario", utilizador.getUsuario()));
        return !criteriaUtilizador.list().isEmpty();
    }

    public List<Utilizador> buscarPorUtilizador(String utilizador) {
        Criteria criteriaUtilizador = sessao.createCriteria(Utilizador.class);
        criteriaUtilizador.add(Restrictions.like("usuario", utilizador, MatchMode.ANYWHERE));
        return criteriaUtilizador.list();
    }

    public List<Utilizador> buscarPorNomeOuApelido(String nomeOuApelido) {
        Criteria criteriaUtilizador = sessao.createCriteria(Utilizador.class);
        Criterion criterionNome = Restrictions.like("nome", nomeOuApelido, MatchMode.ANYWHERE);
        Criterion criterionUsuario = Restrictions.like("usuario", nomeOuApelido, MatchMode.ANYWHERE);
        criteriaUtilizador.add(Restrictions.or(criterionNome, criterionUsuario));
        return criteriaUtilizador.list();
    }

    public void actualizarUtilizador(Utilizador utilizador) {
        Query query = sessao.createQuery("UPDATE Utilizador SET usuario = :novo_usuario, senha = :nova_senha WHERE id.id = :utilizador_id AND id.previlegioId = :previlegio_id");
        query.setParameter("novo_usuario", utilizador.getUsuario());
        query.setParameter("nova_senha", utilizador.getSenha());
        query.setParameter("utilizador_id", utilizador.getId().getId());
        query.setParameter("previlegio_id", utilizador.getId().getPrevilegioId());
        query.executeUpdate();
    }
}
