package org.mozdevz.grupo3.servico;

import java.util.List;
import org.mozdevz.grupo3.dao.PessoaDAO;
import org.mozdevz.grupo3.model.Doenca;
import org.mozdevz.grupo3.model.Pessoa;


public class PessoaServico {
    public static List<Pessoa> buscarTiposDocumentos() {
        List<Pessoa> pessoas = null;
        PessoaDAO pessoaDAO = new PessoaDAO();
        try {
            pessoas = pessoaDAO.buscarIDs();
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            pessoaDAO.fecharSessao();
        }
        return pessoas;
    }

    public static List<Doenca> buscarDoencas() {
        List<Doenca> doencas = null;
        PessoaDAO pessoaDAO = new PessoaDAO();
        try {
            doencas = pessoaDAO.buscarDoencas();
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        } finally {
            pessoaDAO.fecharSessao();
        }
        return doencas;
    }
}
