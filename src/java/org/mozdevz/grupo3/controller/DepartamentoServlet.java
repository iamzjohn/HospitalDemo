/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mozdevz.grupo3.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mozdevz.grupo3.model.Departamento;
import org.mozdevz.grupo3.servico.DepartamentoServico;

/**
 *
 * @author Fausio
 */
@WebServlet(name = "Departamento", urlPatterns = {"/Departamento"})
public class DepartamentoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     String nomeDepartamento=request.getParameter("nome");
     //Adicao de um certo departamento
     Departamento d=new Departamento();
     d.setDescricao(nomeDepartamento);
     int e=DepartamentoServico.guardar(d);
     if(e==0){
       response.setContentType("text/html");
       response.getWriter().print("<h2>Dados gravados</h2>");
     }else{
          if(e==1){
            //Problemas
            response.setContentType("text/html");
            response.getWriter().print("<h2>Erro!</h2>");
          }
          
          
     
     }
     
     //Falta a adicao dos medicos do departamento!
     
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
