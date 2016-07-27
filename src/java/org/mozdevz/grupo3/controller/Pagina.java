/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mozdevz.grupo3.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mozdevz.grupo3.servico.ConsultaServico;
import org.mozdevz.grupo3.servico.GeradorCodigosServico;
import org.mozdevz.grupo3.servico.MedicoServico;
import org.mozdevz.grupo3.servico.PessoaServico;

/**
 *
 * @author zJohn
 */
public class Pagina extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         RequestDispatcher view;
         view = request.getRequestDispatcher("error.html");
         view.forward(request, response);
    }

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
//        processRequest(request, response);

        RequestDispatcher view;
//        
//        String username = request.getParameter("username");
//        String senha = request.getParameter("password");
//        
//        Utilizador user = UtilizadorServico.login(username, senha);
//        if(user != null){
//            request.setAttribute("usuario", user);
            request.setAttribute("nr_ficha", GeradorCodigosServico.gerarCodigo(GeradorCodigosServico.DOENTE, ConsultaServico.total()));
            request.setAttribute("tipo_id", PessoaServico.buscarTiposDocumentos());
            request.setAttribute("doencas", PessoaServico.buscarDoencas());
            request.setAttribute("medicos", MedicoServico.buscarTodos());
            
            view = request.getRequestDispatcher("Cadastro.jsp");
//        }else{
//            view = request.getRequestDispatcher("error.html");
//        }
        
        view.forward(request, response);
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
