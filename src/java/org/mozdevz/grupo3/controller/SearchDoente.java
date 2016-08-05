/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mozdevz.grupo3.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mozdevz.grupo3.model.Doente;
import org.mozdevz.grupo3.servico.DoenteServico;

/**
 *
 * @author zJohn
 */
@WebServlet(name = "SearchDoente", urlPatterns = {"/SearchDoente"})
public class SearchDoente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         RequestDispatcher view;
         view = request.getRequestDispatcher("/error.html");
        //Preciso saber a página que recebe paramentos para preencher aqui
        String descricao = (String) request.getParameter("nome");
        String escolhaTipo = (String) request.getParameter("medico_catch");
//        String dataDe = request.getParameter("");
//        String dataAte = request.getParameter("");
        
        if(escolhaTipo.isEmpty()){
             view = request.getRequestDispatcher("/error.html");
        }else if(escolhaTipo.equalsIgnoreCase("Nome_ou_apelido") || escolhaTipo.equalsIgnoreCase("Nome ou apelido")){
            request.setAttribute("Doentes", DoenteServico.buscarPorNomeOuApelido(descricao));
            request.setAttribute("total", DoenteServico.total());
            view = request.getRequestDispatcher("");
        }else if(escolhaTipo.equalsIgnoreCase("ID")){
            request.setAttribute("Doentes", DoenteServico.buscarPorIdentificacao(descricao));
            request.setAttribute("total", DoenteServico.total());
            view = request.getRequestDispatcher("");
        }
        view.forward(request, response);
        
    }
    
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
         processRequest(request, response);
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
