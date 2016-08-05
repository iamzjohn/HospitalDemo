/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mozdevz.grupo3.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mozdevz.grupo3.servico.MedicoServico;
import org.mozdevz.grupo3.servico.DoenteServico;
import org.mozdevz.grupo3.model.Doente;
import org.mozdevz.grupo3.model.Medico;

/**
 *
 * @author Fausio
 */
public class PesquisarRecepcionista extends HttpServlet {

  //Este Servlet responde a qualquer requisicao feita na barra de menu do recepcionista
  //Procura um doente ou medico

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String dadoPesquisado= request.getParameter("Pesquisar");
      Doente temporario;
      Medico medicoTemporario;
      boolean encontrado=false;
      //Apenas pesquisa pessoas que ja estao Cadastradas neste caso:
  
    List<Doente> doentes = null;
    List <Medico> medicos=null;
    
    //Caso dos doentes(Primeiro PESQUISAR POR NOME):
    doentes=DoenteServico.buscarPorNome(dadoPesquisado);
    for(int i=0;i<doentes.size();i++){
           temporario=doentes.get(i);
           if(temporario.getNome().equalsIgnoreCase(dadoPesquisado)){
               //Encontrado , hora de visualizar
                 encontrado=true;
                 response.setContentType("text/html");
                 response.getWriter().print("<h2>Doente Encontrado!</h2><br>");
                 response.getWriter().print("<h3>Nome:"+dadoPesquisado+"</h2><br><h3>Apelido:"+temporario.getApelido()+"<h3><br>");
                 response.getWriter().print("<h3>ID:"+temporario.getNrID()+"</h2><br><h3>Contacto:"+temporario.getContacto()+"<h3><br>");
                 break; 
           }
           
             
    }
     //Caso dos doentes(Segundo PESQUISAR POR APELIDO):
    doentes=DoenteServico.buscarPorNome(dadoPesquisado);
    for(int i=0;i<doentes.size();i++){
           temporario=doentes.get(i);
           if(temporario.getApelido().equalsIgnoreCase(dadoPesquisado)){
               //Encontrado , hora de visualizar
                 encontrado=true;
                 response.setContentType("text/html");
                 response.getWriter().print("<h2>Doente Encontrado!</h2><br>");
                 response.getWriter().print("<h3>Nome:"+dadoPesquisado+"</h2><br><h3>Apelido:"+temporario.getApelido()+"<h3><br>");
                 response.getWriter().print("<h3>ID:"+temporario.getNrID()+"</h2><br><h3>Contacto:"+temporario.getContacto()+"<h3><br>");
                 break; 
           }
            
             
    }
      
     //Agora caso dos Medicos(por nome):
     medicos=MedicoServico.buscarTodos();
     for(int i=0;i<medicos.size();i++){
         medicoTemporario=medicos.get(i);
            if(medicoTemporario.getNome().equalsIgnoreCase(dadoPesquisado)){
               //Encontrado , hora de visualizar
                 encontrado=true;
                 response.setContentType("text/html");
                 response.getWriter().print("<h2>Medico Encontrado!</h2><br>");
                 response.getWriter().print("<h3>Nome:"+dadoPesquisado+"</h2><br><h3>Apelido:"+medicoTemporario.getApelido()+"<h3><br>");
                 response.getWriter().print("</h2><br><h3>Contacto:"+medicoTemporario.getContacto()+"<h3><br>");
 
           }
        break; 
     
     
     }
      //Agora caso dos Medicos(por apelido):
     medicos=MedicoServico.buscarTodos();
     for(int i=0;i<medicos.size();i++){
         medicoTemporario=medicos.get(i);
            if(medicoTemporario.getApelido().equalsIgnoreCase(dadoPesquisado)){
               //Encontrado , hora de visualizar
                 encontrado=true;
                 response.setContentType("text/html");
                 response.getWriter().print("<h2>Medico Encontrado!</h2><br>");
                 response.getWriter().print("<h3>Nome:"+dadoPesquisado+"</h2><br><h3>Apelido:"+medicoTemporario.getApelido()+"<h3><br>");
                 response.getWriter().print("</h2><br><h3>Contacto:"+medicoTemporario.getContacto()+"<h3><br>");
                 break; 
           }
        
     
     
     }
     
     if(!encontrado){
           response.setContentType("text/html");
      response.getWriter().print("<h2>O dado pesquisado nao foi encontrado</h2><br>");
     
     }
     
      
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
