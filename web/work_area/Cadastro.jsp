<%-- 
    Document   : Cadastro
    Created on : Jul 25, 2016, 9:43:20 PM
    Author     : zJohn
--%>
<%@page import="org.mozdevz.grupo3.model.Medico"%>
<%@page import="org.mozdevz.grupo3.model.Doenca"%>
<%@page import="org.mozdevz.grupo3.model.Pessoa"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Marcação de Consulta</title>
        <link rel="stylesheet" type="text/css" href="assets/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="assets/css/estilo.css" />
    </head>
    <body>
        <div class="container">
            <div class="page_title">
                <h2>
                    Marcação de Consulta
                    <span class="pull-right">Ficha nr: <% 
                        List ficha = (List)request.getAttribute("nr_ficha");
                        out.print(ficha.get(0)); 
                        %></span>
                </h2>
            </div>
            <div>
                <form class="form-horizontal" method="post" action="">
                    <h3>Dados do Paciente</h3>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Nome: </label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="nome" placeholder="Nome">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Apelido: </label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="apelido"placeholder="Äpelido">
                        </div>
                    </div>
                    <div class="form-group novo_tipo" >
                        <label class="col-sm-3 control-label">Outro Tipo : </label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="tipo_id_writen" placeholder="Nova Categoria">
                        </div>
                    </div>
                    <div class="form-group antigo_tipo">
                        <label class="col-sm-3 control-label">Tipo ID : </label>
                        <div class="col-sm-9">
                            <select class="form-control" id="categoria" name="tipo_id" style="width: 500px;">
                                <%
                                    List tiposIds = (List)request.getAttribute("tipo_id");
                                    for(int i  = 0; i < tiposIds.size(); i++){
                                        Pessoa pessoa = (Pessoa)tiposIds.get(i);
                                        out.print("<option value=\""+pessoa.getTipoID()+"\">"+pessoa.getTipoID()+"</option>");
                                    }
                                %>
                            </select>
                            <input type="checkbox" name="outro_tipo" id="outro_tipo"> Novo/Outro Tipo de Documento
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Nr do ID: </label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="nr_id" placeholder="Número">
                        </div>
                    </div>
                    <div class="form-group antigo_tipo">
                        <label class="col-sm-3 control-label">Genero : </label>
                        <div class="col-sm-9">
                            <select class="form-control" name="tipo_id" style="width: 500px;">
                                <option value="MASCULINO">Masculino</option>
                                <option value="FEMENINO">Femenino</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Data de Nascimento: </label>
                        <div class="col-sm-9">
                            <input type="date" class="form-control" name="data_nascimento" placeholder="Data de Nascimento">
                        </div>
                    </div>
                    
                    <h3>Contacto do Pacientes</h3>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Email: </label>
                        <div class="col-sm-9">
                            <input type="email" class="form-control" name="email" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Númeor de Celular1: </label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="nr_celular1" placeholder="Número de Celular">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Númeor de Celular2: </label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="nr_celular2" placeholder="Número de Celular">
                        </div>
                    </div>
                    
                    <h3>Residência</h3>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">País: </label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="pais" placeholder="Pais">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Provincia: </label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="provincia" placeholder="Provincia">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Cidade:  </label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="cidade" placeholder="Cidade">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Rua: </label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="rua" placeholder="Rua">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Quarteirão: </label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="quarteirao" placeholder="Quarteirão">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Número da Casa: </label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="nr_casa" placeholder="Número da Casa">
                        </div>
                    </div>
                    
                    <h3>Dados Sobre Parentes próximos</h3>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Nome Completo: </label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="nome_parente" placeholder="Nome Completo">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Posição parental(irmão/primo/etc): </label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="grau_parente" placeholder="Posição Parental">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Número de Celular 1: </label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="nr_celular1_parente" placeholder="Número de Telefone">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Número de Celular 2: </label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="nr_celular2_parente" placeholder="Número de Telefone">
                        </div>
                    </div>
                    
                    <h3>Dados sobre Doencas Cronicas ou que o doente seja portador</h3>
                    <div class="form-group nova_doenca" >
                        <label class="col-sm-3 control-label">Outra doença : </label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="outra_doenca_writen" placeholder="Doença">
                        </div>
                    </div>
                    <div class="form-group antiga_doenca">
                        <label class="col-sm-3 control-label">Doença : </label>
                        <div class="col-sm-9">
                            <select class="form-control" id="categoria" name="doenca_select" style="width: 500px;">
                                <%
                                    List doencas = (List)request.getAttribute("doencas");
                                    for(int i  = 0; i < doencas.size(); i++){
                                        Doenca doenca = (Doenca)doencas.get(i);
                                        out.print("<option value=\""+doenca.getDescricao()+"\">"+doenca.getDescricao()+"</option>");
                                    }                               
                                %>
                            </select>
                            <input type="checkbox" name="chk_nova_doenca" id="chk_nova_doenca"> Novo/Outro Tipo de Doença
                        </div>
                    </div>
                    
                            
                    <h3>Dados sobre a consulta</h3>
                    <div class="form-group antiga_doenca">
                        <label class="col-sm-3 control-label">Medico : </label>
                        <div class="col-sm-9">
                            <select class="form-control" name="medico_catch" style="width: 500px;">
                                <%
                                    List medicos = (List)request.getAttribute("medicos");
                                    for(int i  = 0; i < medicos.size(); i++){
                                        Medico medico = (Medico)medicos.get(i);
                                        out.print("<option value=\""+medico.getNome()+"\">"+medico.getApelido().toUpperCase() +"- " + medico.getNome()+"</option>");
                                    }                               
                                %>
                            </select>
                        </div>
                    </div>
                    <div class="form-group nova_doenca" >
                        <label class="col-sm-3 control-label">Hora da Consulta: </label>
                        <div class="col-sm-9">
                            <input type="time" class="form-control" name="hora_marcada" placeholder="Hora">
                        </div>
                    </div>
                            
                            
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button type="submit" class="btn btn-success">Seguinte</button>
                            <!--<a href="<?php echo base_url('produtos'); ?>" class="btn btn-info">Voltar</a>-->
                        </div>
                    </div>
                    
                    
                </form>
            </div>
        </div>
        
        <script type="text/javascript" src="assets/js/jquery.min.js" ></script>
        <script type="text/javascript" src="'assets/bootstrap/js/bootstrap.min.js" ></script>
        <script type="text/javascript">
            $(function () {
                $(".novo_tipo").hide();
                $("#outro_tipo").change(function () {
                    if ($(this).is(":checked")) {
                        $(".novo_tipo").show();
                        $(".antigo_tipo").hide();
                    } else {
                        $(".novo_tipo").hide();
                        $(".antigo_tipo").show();
                    }
                });
                
                $(".nova_doenca").hide();
                $("#chk_nova_doenca").change(function () {
                    if ($(this).is(":checked")) {
                        $(".nova_doenca").show();
                        $(".antiga_doenca").hide();
                    } else {
                        $(".nova_doenca").hide();
                        $(".antiga_doenca").show();
                    }
                });
                
            });
        </script>

    </body>
</html>