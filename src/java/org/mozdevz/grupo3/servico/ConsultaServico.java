package org.mozdevz.grupo3.servico;

import java.util.List;
import org.mozdevz.grupo3.dao.ConsultaDAO;
import org.mozdevz.grupo3.model.Consulta;
import org.mozdevz.grupo3.util.Utilitarios;

public class ConsultaServico {
    
    public static final int OPERACAO_REALIZADA_COM_SUCESSO = 0;
    public static final int OPERACAO_FALHOU = 1;
    //---------------------------------------------------------

    private ConsultaServico() {
    }

    public static Consulta criarUtilizador() {
        Consulta consulta = new Consulta();
        consulta.setData(Utilitarios.agora());
        return consulta;
    }

    public static int total(){
        int resultadoOperacao = buscarTodos().size() + 1;       
        return resultadoOperacao;
    }
    public static int guardar(Consulta consulta) {
        int resultadoOperacao;
        ConsultaDAO consultaDAO = new ConsultaDAO();
        try {

            consultaDAO.iniciarTransaccao();
            
            consultaDAO.guardar(consulta);
            consultaDAO.commit();
            resultadoOperacao = OPERACAO_REALIZADA_COM_SUCESSO;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            consultaDAO.roolback();
            resultadoOperacao = OPERACAO_FALHOU;
        } finally {
            consultaDAO.fecharSessao();
        }
        return resultadoOperacao;
    }

    public static int actualizar(Consulta consulta) {
        int resultadoOperacao;
        ConsultaDAO consultaDAO = new ConsultaDAO();
        try {
            consultaDAO.iniciarTransaccao();
            consultaDAO.actualizar(consulta);
            consultaDAO.commit();
            resultadoOperacao = OPERACAO_REALIZADA_COM_SUCESSO;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            consultaDAO.roolback();
            resultadoOperacao = OPERACAO_FALHOU;
        } finally {
            consultaDAO.fecharSessao();
        }
        return resultadoOperacao;
    }

    public static Consulta buscarPorID(int id) {
        Consulta consulta = null;
        ConsultaDAO consultaDAO = new ConsultaDAO();
        try {
            consulta = consultaDAO.buscarPorChavePrimaria(id);
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            consultaDAO.fecharSessao();
        }
        return consulta;
    }

    public static List<Consulta> buscarTodos() {
        List<Consulta> consultas = null;
        ConsultaDAO consultaDAO = new ConsultaDAO();
        try {
            consultas = consultaDAO.buscarTodos();
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            consultaDAO.fecharSessao();
        }
        return consultas;
    }
}
