package org.mozdevz.grupo3.servico;

import java.util.List;
import org.mozdevz.grupo3.dao.MedicoDAO;
import org.mozdevz.grupo3.model.Medico;

public class MedicoServico {
    public static final int OPERACAO_REALIZADA_COM_SUCESSO = 0;
    public static final int OPERACAO_FALHOU = 1;
    //---------------------------------------------------------

    private MedicoServico() {
    }

    public static Medico criarUtilizador() {
        Medico medico = new Medico();
//        consulta.setData(Utilitarios.agora());
        return medico;
    }

    public static int total(){
        int resultadoOperacao = buscarTodos().size() + 1;       
        return resultadoOperacao;
    }
    public static int guardar(Medico medico) {
        int resultadoOperacao;
        MedicoDAO medicoDAO = new MedicoDAO();
        try {

            medicoDAO.iniciarTransaccao();
            
            medicoDAO.guardar(medico);
            medicoDAO.commit();
            resultadoOperacao = OPERACAO_REALIZADA_COM_SUCESSO;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            medicoDAO.roolback();
            resultadoOperacao = OPERACAO_FALHOU;
        } finally {
            medicoDAO.fecharSessao();
        }
        return resultadoOperacao;
    }

    public static int actualizar(Medico medico) {
        int resultadoOperacao;
        MedicoDAO medicoDAO = new MedicoDAO();
        try {
            medicoDAO.iniciarTransaccao();
            medicoDAO.actualizar(medico);
            medicoDAO.commit();
            resultadoOperacao = OPERACAO_REALIZADA_COM_SUCESSO;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            medicoDAO.roolback();
            resultadoOperacao = OPERACAO_FALHOU;
        } finally {
            medicoDAO.fecharSessao();
        }
        return resultadoOperacao;
    }

    public static Medico buscarPorID(int id) {
        Medico medico = null;
        MedicoDAO medicoDAO = new MedicoDAO();
        try {
            medico = medicoDAO.buscarPorChavePrimaria(id);
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            medicoDAO.fecharSessao();
        }
        return medico;
    }

    public static List<Medico> buscarTodos() {
        List<Medico> medicos = null;
        MedicoDAO medicoDAO = new MedicoDAO();
        try {
            medicos = medicoDAO.buscarTodos();
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            medicoDAO.fecharSessao();
        }
        return medicos;
    }
}
