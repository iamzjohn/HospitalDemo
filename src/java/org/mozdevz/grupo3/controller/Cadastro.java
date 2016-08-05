package org.mozdevz.grupo3.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mozdevz.grupo3.model.Consulta;
import org.mozdevz.grupo3.model.Contacto;
import org.mozdevz.grupo3.model.Doenca;
import org.mozdevz.grupo3.model.Doente;
import org.mozdevz.grupo3.model.Endereco;
import org.mozdevz.grupo3.model.Genero;
import org.mozdevz.grupo3.model.Medico;
import org.mozdevz.grupo3.model.Parente;
import org.mozdevz.grupo3.model.Secretaria;
import org.mozdevz.grupo3.servico.ConsultaServico;
import org.mozdevz.grupo3.servico.MedicoServico;
import org.mozdevz.grupo3.util.Utilitarios;

@WebServlet(name = "Cadastro", urlPatterns = {"/cadastrar"})
public class Cadastro extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Dados sobre o Doente or DADOS PESSOAIS 
            String nome = request.getParameter("nome");
            String apelido = request.getParameter("apelido");
            String outroTipo = request.getParameter("tipo_id_writen");
            String idType;
            if (outroTipo == null || outroTipo.equals("")) {
                idType = request.getParameter("tipo_id");
            } else {
                idType = outroTipo;
            }

            String nr_id = request.getParameter("nr_id");
            String genero = request.getParameter("genero");
            String dtNascimento = request.getParameter("data_nascimento");
            Date dataNascimento = null;
            try {
                dataNascimento = sdf.parse(dtNascimento);
            } catch (ParseException ex) {
                Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
            }

            Doente doente = new Doente(nome, apelido, idType, nr_id, Genero.FEMENINO, dataNascimento);

            if (genero.equalsIgnoreCase("masculino")) {
                doente.setGenero(Genero.MASCULINO);
            } else {
                doente.setGenero(Genero.FEMENINO);
            }

//        DADOS RELEVANTES AO CONTACTO PESSOAL 
            String email = request.getParameter("email");
            String nrCelular1 = request.getParameter("nr_celular1");
            String nrCelular2 = request.getParameter("nr_celular2");
            Contacto contacto = new Contacto(email, nrCelular1, nrCelular2);
            doente.setContacto(contacto);

//        DADOS SOBRE ENDEREÇO
            String pais = request.getParameter("pais");
            String provincia = request.getParameter("provincia");
            String cidade = request.getParameter("cidade");
            String rua = request.getParameter("rua");
            String quarteirao = request.getParameter("quarteirao");
            String casa_nr = request.getParameter("nr_casa");
            Endereco endereco = new Endereco(pais, provincia, cidade, rua, quarteirao, casa_nr);
            doente.setEndereco(endereco);

//        DADOS SOBRE PARENTES 
            String nomeParente = request.getParameter("nome_parente");
            String grauParente = request.getParameter("grau_parente");
            String nrCelular1Parente = request.getParameter("nr_celular1_parente");
            String nrCelular2Parente = request.getParameter("nr_celular2_parente");
            Parente parente = new Parente(nomeParente, grauParente, nrCelular1Parente, nrCelular2Parente);
            doente.getParentes().add(parente);

            System.out.println("DADOS REGISTADOS COM SUCESSO");

//      DADOS PROFISSIONAIS
            String profissao = request.getParameter("profissao_selected");
            Medico medico = new Medico();
            Secretaria secretaria = new Secretaria();
            if (profissao.equalsIgnoreCase("medico")) {
                medico.getTipoID();
            } else {
                secretaria.getTipoID();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            RequestDispatcher view;
            view = request.getRequestDispatcher("recepcaoVersaoHTML.html");
            view.forward(request, response);

        }
        //Falta a classe que insere na base de dados o dado profissional

//       DADOS SOBRE DOENCAS 
//      Dados ainda não colocados no formulario para serem inseridos
/*        String doenca_writen = request.getParameter("outra_doenca_writen");
        String doencaString = "";
        if(doenca_writen == null || doenca_writen.equals("")){
            doencaString = request.getParameter("doenca_select");
        }else{
            doencaString = doenca_writen;
        }
        Doenca doenca = new Doenca(doencaString);
         */
//        DADOS SOBRE CONSULTA
        /*        String idMedico = request.getParameter("medico_catch");
        Medico medico = MedicoServico.buscarPorID(Integer.parseInt(idMedico));
        String horaConsulta = request.getParameter("hora_marcada");
        Date hora = null;
        
        try {
            hora = sdf.parse(horaConsulta);
        } catch (ParseException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Consulta consulta = new Consulta(Utilitarios.agora(), hora, null, medico, doente);
        
        ConsultaServico.guardar(consulta);

        response.sendRedirect("/sucesso");

         */
//        DEVERA, BUSCAR MEDICO, CRIAR SERVETS E RESPONSE DE CADA UMA DELAS, SE ESTIVER CERTO LIMPA
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
