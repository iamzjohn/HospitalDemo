/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mozdevz.grupo3.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mozdevz.grupo3.model.Utilizador;
import org.mozdevz.grupo3.servico.UtilizadorServico;

/**
 *
 * @author Fausio
 */

@WebServlet(name = "Utilizador", urlPatterns = {"/Utilizador"})
public class UtilizadorServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomeRecebido=request.getParameter("nome");
        String passwordRecebido=request.getParameter("segredo");
        String previlegioRecebido=request.getParameter("user[role]");
        
        //Validacao do Nome
        if(nomeRecebido==null||nomeRecebido.trim().isEmpty() || nomeRecebido.length()<2){
            //Esta vazio ou o tamando e' demasiado menor para um nome
            request.getRequestDispatcher("/administracaoVersaoHTML.html");
            
        }else{
            //Pequena validacao do password :(, tendo em conta que nao temos restricoes
            if(passwordRecebido==null || passwordRecebido.trim().isEmpty()|| passwordRecebido.length()<2){
                 //Esta vazio ou o tamando e' demasiado menor para um nome
            request.getRequestDispatcher("/administracaoVersaoHTML.html");
            }else{
                  Utilizador u=new Utilizador();
                  u.setUsuario(nomeRecebido);
                  u.setSenha(passwordRecebido);
                 int teste = UtilizadorServico.guardar(u);
                 
                 if(teste==0){
                   response.setContentType("text/html");
                  response.getWriter().print("<h2>Dados gravados</h2>");
                 
                 }else{
                     if(teste==2){
                      response.setContentType("text/html");
                  response.getWriter().print("<h2>O utilizador ja existe</h2>");
                
                     }
                     else{
                         if(teste==1){
                           response.setContentType("text/html");
                          response.getWriter().print("<h2>ERRO!</h2>");
                     
                         
                         }else{
                              response.setContentType("text/html");
                          response.getWriter().print("<h2>Nao sabemos o problema!</h2>");
                         
                         }
                         
                     
                     }
                 
                 
                 }
                
                  //Inseriu com Sucesso
                //Validacao do radio button
                   if(previlegioRecebido=="Secretario"){
                       //Insercao de um novo Secretario
                   
                   }else{
                       if(previlegioRecebido=="Enfermeiro"){
                          //Insercao de um  novo Enfermeiro
                       }else{
                           //Insercao de um novo administrador
                       }
                   
                   
                   }
            }
        }
        
    }

   
}
