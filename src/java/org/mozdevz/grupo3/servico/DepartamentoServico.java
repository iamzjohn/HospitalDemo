package org.mozdevz.grupo3.servico;

import java.util.List;
import org.mozdevz.grupo3.dao.DepartamentoDAO;
import org.mozdevz.grupo3.model.Departamento;

public class DepartamentoServico {
    public static final int OPERACAO_REALIZADA_COM_SUCESSO = 0;
    public static final int OPERACAO_FALHOU = 1;
    //---------------------------------------------------------

    private DepartamentoServico() {
    }

    public static Departamento criarDepartamento() {
        Departamento departamento = new Departamento();
//        consulta.setData(Utilitarios.agora());
        return departamento;
    }

    public static int total(){
        int resultadoOperacao = buscarTodos().size() + 1;       
        return resultadoOperacao;
    }
    public static int guardar(Departamento departamento) {
        int resultadoOperacao;
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        try {

            departamentoDAO.iniciarTransaccao();
            
            departamentoDAO.guardar(departamento);
            departamentoDAO.commit();
            resultadoOperacao = OPERACAO_REALIZADA_COM_SUCESSO;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            departamentoDAO.roolback();
            resultadoOperacao = OPERACAO_FALHOU;
        } finally {
            departamentoDAO.fecharSessao();
        }
        return resultadoOperacao;
    }

    public static int actualizar(Departamento departamento) {
        int resultadoOperacao;
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        try {
            departamentoDAO.iniciarTransaccao();
            departamentoDAO.actualizar(departamento);
            departamentoDAO.commit();
            resultadoOperacao = OPERACAO_REALIZADA_COM_SUCESSO;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            departamentoDAO.roolback();
            resultadoOperacao = OPERACAO_FALHOU;
        } finally {
            departamentoDAO.fecharSessao();
        }
        return resultadoOperacao;
    }

    public static Departamento buscarPorID(int id) {
        Departamento departamento = null;
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        try {
            departamento = departamentoDAO.buscarPorChavePrimaria(id);
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            departamentoDAO.fecharSessao();
        }
        return departamento;
    }
    

    public static List<Departamento> buscarTodos() {
        List<Departamento> departamentos = null;
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        try {
            departamentos = departamentoDAO.buscarTodos();
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            departamentoDAO.fecharSessao();
        }
        return departamentos;
    }
    

    public static List<Departamento> buscarPorDescricao(String descricao) {
        List<Departamento> departamentos = null;
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        try {
            departamentos = departamentoDAO.buscarPorDescricao(descricao);
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            departamentoDAO.fecharSessao();
        }
        return departamentos;
    }

}
