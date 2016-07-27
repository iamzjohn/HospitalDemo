/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mozdevz.grupo3.servico;

import java.util.ArrayList;
import java.util.List;
import org.mozdevz.grupo3.dao.LogUtilizadorDAO;
import org.mozdevz.grupo3.dao.UtilizadorDAO;
import org.mozdevz.grupo3.model.LogUtilizador;
import org.mozdevz.grupo3.model.Previlegio;
import org.mozdevz.grupo3.model.Utilizador;
import org.mozdevz.grupo3.util.Utilitarios;

/**
 *
 * @author Adelino José
 */
public class UtilizadorServico {

    public static final int OPERACAO_REALIZADA_COM_SUCESSO = 0;
    public static final int OPERACAO_FALHOU = 1;
    public static final int USUARIO_JA_EXISTE = 2;
    //---------------------------------------------------------

    private UtilizadorServico() {
    }

    public static Utilizador criarUtilizador(Previlegio previlegio) {
        Utilizador utilizador = new Utilizador();
        utilizador.setPrevilegio(previlegio);
        return utilizador;
    }

    public static int guardar(Utilizador utilizador) {
        int resultadoOperacao;
        UtilizadorDAO utilizadorDAO = new UtilizadorDAO();
        try {
            boolean utilizadorExiste = utilizadorDAO.utilizadorExiste(utilizador);
            if (utilizadorExiste == true) {
                resultadoOperacao = USUARIO_JA_EXISTE;
            } else {
                utilizadorDAO.iniciarTransaccao();

                Previlegio previlegio = utilizador.getPrevilegio();
                previlegio.getUtilizadores().add(utilizador);

                utilizadorDAO.guardar(utilizador);
                utilizadorDAO.commit();
                resultadoOperacao = OPERACAO_REALIZADA_COM_SUCESSO;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            utilizadorDAO.roolback();
            resultadoOperacao = OPERACAO_FALHOU;
        } finally {
            utilizadorDAO.fecharSessao();
        }
        return resultadoOperacao;
    }

    public static int actualizar(Utilizador utilizador) {
        int resultadoOperacao;
        UtilizadorDAO utilizadorDAO = new UtilizadorDAO();
        try {
            utilizadorDAO.iniciarTransaccao();
            utilizadorDAO.actualizarUtilizador(utilizador);
            utilizadorDAO.commit();
            resultadoOperacao = OPERACAO_REALIZADA_COM_SUCESSO;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            utilizadorDAO.roolback();
            resultadoOperacao = OPERACAO_FALHOU;
        } finally {
            utilizadorDAO.fecharSessao();
        }
        return resultadoOperacao;
    }

    public static Utilizador buscarPorID(int id) {
        Utilizador utilizador = null;
        UtilizadorDAO utilizadorDAO = new UtilizadorDAO();
        try {
            utilizador = utilizadorDAO.buscarPorChavePrimaria(id);
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            utilizadorDAO.fecharSessao();
        }
        return utilizador;
    }

    public static List<Utilizador> buscarTodos() {
        List<Utilizador> utilizadors = null;
        UtilizadorDAO utilizadorDAO = new UtilizadorDAO();
        try {
            utilizadorDAO = new UtilizadorDAO();
            utilizadors = utilizadorDAO.buscarTodos();
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            utilizadorDAO.fecharSessao();
        }
        return utilizadors;
    }

    public static Utilizador login(String usuario, String senha) {
        Utilizador utilizador = null;
        UtilizadorDAO utilizadorDAO = new UtilizadorDAO();
        try {
            utilizadorDAO = new UtilizadorDAO();
            utilizador = utilizadorDAO.buscarUtilizador(usuario, senha);
            if (utilizador != null) {
                LogUtilizadorDAO logUtilizadorDAO = new LogUtilizadorDAO(utilizadorDAO.getSessao());
                logUtilizadorDAO.iniciarTransaccao();

                LogUtilizador logUtilizador = new LogUtilizador();
                logUtilizador.setDataLogin(Utilitarios.agora());
                logUtilizador.setUtilizador(utilizador);
                utilizador.getLogUtilizadores().add(logUtilizador);

                logUtilizadorDAO.guardar(logUtilizador);
                logUtilizadorDAO.commit();
            }
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            utilizadorDAO.fecharSessao();
        }
        return utilizador;
    }

    public static List<LogUtilizador> buscarTodosLogs(int mes, int ano) {
        List<LogUtilizador> logsUtilizador = null;
        LogUtilizadorDAO logUtilizadorDAO = new LogUtilizadorDAO();
        try {
            logsUtilizador = logUtilizadorDAO.buscarTodosLogs(mes, ano);
            if (logsUtilizador == null) {
                logsUtilizador = new ArrayList<>();
            }
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            logUtilizadorDAO.fecharSessao();
        }
        return logsUtilizador;
    }

    public static List<LogUtilizador> buscarTodosLogs(Utilizador utilizador, int mes, int ano) {
        List<LogUtilizador> logsUtilizador = null;
        LogUtilizadorDAO logUtilizadorDAO = new LogUtilizadorDAO();
        try {
            logsUtilizador = logUtilizadorDAO.buscarTodosLogs(utilizador, mes, ano);
            if (logsUtilizador == null) {
                logsUtilizador = new ArrayList<>();
            }
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            logUtilizadorDAO.fecharSessao();
        }
        return logsUtilizador;
    }

    public static List<Utilizador> buscarPorUtilizador(String utilizador) {
        List<Utilizador> utilizadors = null;
        UtilizadorDAO utilizadorDAO = new UtilizadorDAO();
        try {
            utilizadors = utilizadorDAO.buscarPorUtilizador(utilizador);
            if (utilizadors == null) {
                utilizadors = new ArrayList<>();
            }
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            utilizadorDAO.fecharSessao();
        }
        return utilizadors;
    }

    public static List<Utilizador> buscarPorNomeApelido(String nomeOuApelido) {
        List<Utilizador> utilizadores = null;
        UtilizadorDAO utilizadorDAO = new UtilizadorDAO();
        try {
            utilizadores = utilizadorDAO.buscarPorNomeOuApelido(nomeOuApelido);
            if (utilizadores == null) {
                utilizadores = new ArrayList<>();
            }
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            utilizadorDAO.fecharSessao();
        }
        return utilizadores;
    }
}
