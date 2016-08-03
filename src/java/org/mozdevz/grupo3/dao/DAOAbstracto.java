package org.mozdevz.grupo3.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.mozdevz.grupo3.dao.configuracao.NewHibernateUtil;

/**
 *
 * @author Adelino José
 * @param <T> tipo de entidade
 */
public abstract class DAOAbstracto<T> {

    public static final int ORDEM_ASCENDENTE = 0;
    public static final int ORDEM_DESCENDENTE = 1;

    protected Session sessao;
    private final Class classeEntidade;
    private boolean ordenarResultados = false;
    private boolean ordemAscendente = false;
    protected String colunaParaOrdenacao;

    public DAOAbstracto(Class<T> classeEntidade) {
        this.classeEntidade = classeEntidade;
        abrirSessao();
    }

    public DAOAbstracto(Session sessao, Class<T> classeEntidade) {
        this.sessao = sessao;
        this.classeEntidade = classeEntidade;
    }

    public DAOAbstracto(Session sessao) {
        this.classeEntidade = null;
        this.sessao = sessao;
    }


    private void abrirSessao() {
        sessao = NewHibernateUtil.getSessionFactory().openSession();
    }

    public Session getSessao() {
        if (sessao.isOpen() == false) {
            abrirSessao();
        }
        return sessao;
    }

    public void iniciarTransaccao() {
        if (sessao.isOpen() == false) {
            abrirSessao();
        }
        this.sessao.beginTransaction();
    }

    public void fecharSessao() {
        if (sessao.isOpen() == true) {
            sessao.close();
        }
    }

    public void commit() {
        if (sessao.isOpen() == false) {
            abrirSessao();
        }
        this.sessao.getTransaction().commit();
    }

    public void roolback() {
        if (sessao.isOpen() == false) {
            abrirSessao();
        }
        this.sessao.getTransaction().rollback();
    }

    protected void ordenarResultados(String colunaOrdenacao, int tipoOrdenacao) {
        ordenarResultados = true;
        this.colunaParaOrdenacao = colunaOrdenacao;
        if (tipoOrdenacao == ORDEM_ASCENDENTE) {
            ordemAscendente = true;
        } else if (tipoOrdenacao == ORDEM_DESCENDENTE) {
            ordemAscendente = false;
        }
    }

    public void guardar(T entidade) {
        if (sessao.isOpen() == false) {
            abrirSessao();
        }
        sessao.saveOrUpdate(entidade);
    }

    public void actualizar(T entidade) {
        if (sessao.isOpen() == false) {
            abrirSessao();
        }
        sessao.merge(entidade);
    }

    public void remover(T entidade) {
        if (sessao.isOpen() == false) {
            abrirSessao();
        }
        sessao.delete(entidade);
    }

    public T buscarUnico() {
        if (sessao.isOpen() == false) {
            abrirSessao();
        }
        Criteria mCriteria = sessao.createCriteria(classeEntidade);

        T objecto = (T) mCriteria.uniqueResult();
        return objecto;
    }

    public List<T> buscarTodos() {
        if (sessao.isOpen() == false) {
            abrirSessao();
        }
        Criteria mCriteria = sessao.createCriteria(classeEntidade);
        if (ordenarResultados == true) {
            if (ordemAscendente) {
                mCriteria.addOrder(Order.asc(colunaParaOrdenacao));
            } else {
                mCriteria.addOrder(Order.desc(colunaParaOrdenacao));
            }
        }
        List<T> lista = (List<T>) mCriteria.list();
        return lista;
    }

    protected T listarPorChavePrimaria(String nomeChavePrimaria, Object valorChavePrimaria) {
        if (sessao.isOpen() == false) {
            abrirSessao();
        }
        Criteria mCriteria = sessao.createCriteria(classeEntidade);
        mCriteria.add(Restrictions.eq(nomeChavePrimaria, valorChavePrimaria));
        T objecto = (T) mCriteria.uniqueResult();
        return objecto;
    }

    public abstract T buscarPorChavePrimaria(Object id);
}
