package org.mozdevz.grupo3.servico;

import java.util.List;
import org.mozdevz.grupo3.dao.DoenteDAO;
import org.mozdevz.grupo3.model.Doente;


public class DoenteServico {
    public static final int OPERACAO_REALIZADA_COM_SUCESSO = 0;
    public static final int OPERACAO_FALHOU = 1;
    //---------------------------------------------------------

    private DoenteServico() {
    }

    public static Doente criarMedico() {
        Doente doente = new Doente();
//        consulta.setData(Utilitarios.agora());
        return doente;
    }
    
    
    public static int total(){
        int resultadoOperacao = buscarTodos().size() + 1;       
        return resultadoOperacao;
    }
    public static int guardar(Doente doente) {
        int resultadoOperacao;
        DoenteDAO doenteDAO = new DoenteDAO();
        try {

            doenteDAO.iniciarTransaccao();
            
            doenteDAO.guardar(doente);
            doenteDAO.commit();
            resultadoOperacao = OPERACAO_REALIZADA_COM_SUCESSO;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            doenteDAO.roolback();
            resultadoOperacao = OPERACAO_FALHOU;
        } finally {
            doenteDAO.fecharSessao();
        }
        return resultadoOperacao;
    }

    public static int actualizar(Doente doente) {
        int resultadoOperacao;
        DoenteDAO doenteDAO = new DoenteDAO();
        try {
            doenteDAO.iniciarTransaccao();
            doenteDAO.actualizar(doente);
            doenteDAO.commit();
            resultadoOperacao = OPERACAO_REALIZADA_COM_SUCESSO;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            doenteDAO.roolback();
            resultadoOperacao = OPERACAO_FALHOU;
        } finally {
            doenteDAO.fecharSessao();
        }
        return resultadoOperacao;
    }

    public static Doente buscarPorID(int id) {
        Doente doente = null;
        DoenteDAO doenteDAO = new DoenteDAO();
        try {
            doente = doenteDAO.buscarPorChavePrimaria(id);
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            doenteDAO.fecharSessao();
        }
        return doente;
    }
    
    public static Doente buscarPorIdentificacao(String id) {
        Doente doente = null;
        DoenteDAO doenteDAO = new DoenteDAO();
        try {
            doente = doenteDAO.buscarPorNrIdentificacao(id);
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            doenteDAO.fecharSessao();
        }
        return doente;
    }

    public static List<Doente> buscarTodos() {
        List<Doente> doentes = null;
        DoenteDAO doenteDAO = new DoenteDAO();
        try {
            doentes = doenteDAO.buscarTodos();
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            doenteDAO.fecharSessao();
        }
        return doentes;
    }
    
    public static List<Doente> buscarPorNome(String nome) {
        List<Doente> doentes = null;
        DoenteDAO doenteDAO = new DoenteDAO();
        try {
            doentes = doenteDAO.buscarPorNomeDoente(nome);
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            doenteDAO.fecharSessao();
        }
        return doentes;
    }
    
    public static List<Doente> buscarPorApelido(String apelido) {
        List<Doente> doentes = null;
        DoenteDAO doenteDAO = new DoenteDAO();
        try {
            doentes = doenteDAO.buscarPorApelidoDoente(apelido);
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            doenteDAO.fecharSessao();
        }
        return doentes;
    }
    
    public static List<Doente> buscarPorNomeOuApelido(String nomeOuApelido) {
        List<Doente> doentes = null;
        DoenteDAO doenteDAO = new DoenteDAO();        
        try {
            doentes = doenteDAO.buscarPorNomeApelidoDoente(nomeOuApelido);
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            doenteDAO.fecharSessao();
        }
        return doentes;
    }
}
