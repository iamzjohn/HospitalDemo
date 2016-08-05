<%-- 
    Document   : Recepcao
    Created on : Aug 5, 2016, 6:20:02 PM
    Author     : zJohn
--%>

<%@page import="org.mozdevz.grupo3.model.Medico"%>
<%@page import="org.mozdevz.grupo3.model.Doenca"%>
<%@page import="org.mozdevz.grupo3.model.Pessoa"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
       <title>Grupo 3 Ninjas Hospital</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--Bootstrap CSS -->
        <!-- <link rel="stylesheet" href="assets/bootstrap_4/bower_components/bootstrap/dist/css/bootstrap.min.css"> -->

        <link rel="stylesheet" type="text/css" href="assets/bootstrap/css/bootstrap.min.css" />
        
        <!--CSS Customizado -->
        <link rel="stylesheet" href="assets/css/style.css"> 
   </head>
   <body>
   <section>
           <nav class="navbar navbar-light  boldado navbar-full" style="background-color: #e3f2fd;">
                <a class="navbar-brand" href="#">Hospital</a>
               <ul class="nav navbar-nav">
                   <li class="nav-item active">
                      <a class="nav-link" href="#">Início<span class="sr-only">(current)</span></a>
                  </li>
             <li class="nav-item">
                     <a class="nav-link" href="#">Actividade</a>
               </li>
           <li class="nav-item">
                  <a class="nav-link" href="#">A Equipe</a>
            </li>
           <li class="nav-item">
               <a class="nav-link" href="#">Sobre</a>
         </li>
         </ul>
    
           <form class="form-inline pull-right">
                 <input class="form-control" type="text" placeholder="Pesquisar">
                <button class="btn btn-outline-success" type="submit">Pesquisar</button>
           </form>
           </nav>
    </section>
    <section id="recepcao" >
          <div class="section-content">
               <div class="container">
                   <div class="col-sm-10">
                      <div id="Texto-de-descricao">
                          <h2 class="boldado">Bem vindo Caro Recepcionista</h2>
                          <p class="fonteDescription">Abaixo estão as funcionalidades dísponiveis para o seu trabalho, esperamos que fique satisfeito!</p>
                     </div>
                   </div> 
               </div>
          </div>  
       
      </section><br>


      <div class="container">

          <div id="marcacao_consulta">
            
          
            <div class="page_title">
                <h2 class="boldadoPersonalizado">
                    Marcação de Consulta
                    <span class="pull-right">Ficha nr: 
                    <% 
                      List ficha = (List)request.getAttribute("nr_ficha");
                      out.print(ficha.get(0)); 
                    %>
                    </span>
                </h2>
            </div>

            <div>
                
                <form class="form-horizontal" method="post" action="/HospitalDemo/cadastrar">
                  <div class="panel-group" id="accordion">

                  <div class="panel panel-default">
                    <div class="panel-heading">
                      <h3 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                          Dados do Paciente
                        </a>
                      </h3>
                    </div>

                    <div id="collapseOne" class="panel-collapse collapse in">
                      <div class="panel-body">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Nome: </label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" name="nome" placeholder="Nome">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Apelido: </label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" name="apelido"placeholder="Apelido">
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
                                        <% List tiposIds = (List)request.getAttribute("tipo_id");
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
                                <select class="form-control" name="genero" style="width: 500px;">
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

                      </div>
                    </div>
                  </div>

                    
                  
                  <div class="panel panel-default">
                    <div class="panel-heading">
                      <h3 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                          Contacto do Pacientes
                        </a>
                      </h3>
                    </div>

                    <div id="collapseTwo" class="panel-collapse collapse">
                      <div class="panel-body">

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Email: </label>
                            <div class="col-sm-9">
                                <input type="email" class="form-control" name="email" placeholder="Email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Número de Celular1: </label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" name="nr_celular1" placeholder="Número de Celular">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Número de Celular2: </label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" name="nr_celular2" placeholder="Número de Celular">
                            </div>
                        </div>
                      </div>
                    </div>
                  </div>


                    <div class="panel panel-default">
                      <div class="panel-heading">
                        <h3 class="panel-title">
                          <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                            Residência
                          </a>
                        </h3>
                      </div>

                    <div id="collapseThree" class="panel-collapse collapse">
                      <div class="panel-body">

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
                            <label class="col-sm-3 control-label">Rua/Avenida: </label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" name="rua" placeholder="Rua">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Quarteirão: </label>
                            <div class="col-sm-9">
                                <input type="number" min="1" class="form-control" name="quarteirao" placeholder="Quarteirão">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Número da Casa: </label>
                            <div class="col-sm-9">
                                <input type="number" min="1" class="form-control" name="nr_casa" placeholder="Número da Casa">
                            </div>
                        </div>
                      </div>
                    </div>
                  </div>
                    

                  <div class="panel panel-default">
                      <div class="panel-heading">
                        <h3 class="panel-title">
                          <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
                            Dados Sobre Parentes próximos
                          </a>
                        </h3>
                      </div>

                    <div id="collapseFour" class="panel-collapse collapse">
                      <div class="panel-body">

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

                        </div>
                    </div>
                  </div>
                    

                    <div class="panel panel-default">
                      <div class="panel-heading">
                        <h3 class="panel-title">
                          <a data-toggle="collapse" data-parent="#accordion" href="#collapseFive">
                            Dados sobre Doencas Cronicas ou que o doente seja portador
                          </a>
                        </h3>
                      </div>
                    
                    <div id="collapseFive" class="panel-collapse collapse">
                      <div class="panel-body">

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

                    </div>
                    </div>
                  </div>


                  <div class="panel panel-default">
                      <div class="panel-heading">
                        <h3 class="panel-title">
                          <a data-toggle="collapse" data-parent="#accordion" href="#collapseSix">
                            Dados sobre a consulta
                          </a>
                        </h3>
                      </div>
                    <div id="collapseSix" class="panel-collapse collapse">
                      <div class="panel-body">

                    <div class="form-group">
                        <label class="col-sm-3 control-label">Medico : </label>
                        <div class="col-sm-9">
                            <select class="form-control" name="medico_catch" style="width: 500px;">
                                    <% List medicos = (List)request.getAttribute("medicos");
                                    for(int i  = 0; i < medicos.size(); i++){
                                        Medico medico = (Medico)medicos.get(i);
                                        out.print("<option value=\""+medico.getId()+"\">"+medico.getApelido().toUpperCase() +"- " + medico.getNome()+"</option>");
                                    }   
                                    %>                            
                            </select>
                        </div>
                    </div>
                    <div class="form-group" >
                        <label class="col-sm-3 control-label">Hora da Consulta: </label>
                        <div class="col-sm-9">
                            <input type="time" class="form-control" name="hora_marcada" placeholder="Hora">
                        </div>
                    </div>
                    </div>
                    </div>
                  </div>
                  </div>
                            
                  <div class="form-group ">
                    <div class="col-sm-offset-3 col-sm-9 pull-right">
                        <button type="submit" class="btn btn-success pull-right">Gravar</button>
                        <button type="reset" class="btn btn-danger pull-right">Cancelar</button>
                    </div>
                  </div>        
                </form>
            </div>

          </div>

              <hr>

          <div id="procurar_paciente">

            <h2 class="boldadoPersonalizado">
              Doentes <span class="label label-info" style="font-size: 14px">Total: </span>   
            </h2>
            <p>    
                <form method="post" action="/HospitalDemo/SearchDoente" >
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="input-group">
                        <input type="text" name="search-value" placeholder="Descrição" class="form-control">
                        <select class="form-control" name="medico_catch" style="width: 500px;">
                                <option value="Nome_ou_apelido">Nome ou Apelido</option>
                                <option value="ID">ID</option>
                                <!--<option value="">Nr de Telefone</option>-->
                            </select>
                        <span class="input-group-btn">
                          <button class="btn btn-default " type="button">Procurar</button>
                        </span>
                      </div>
                    </div>
                  </div>
                </form>  
            </p>
            
            <table class="table table-striped table-bordered table-condensed">
            <thead>
                <tr>
                    <th style="text-align: center;">Número</th>
                    <th style="text-align: center;">Código</th>
                    <th style="text-align: center;">Nome do Doente</th>
                    <th style="text-align: center;">Nr Telefone</th>
                    <th style="text-align: center;">Pais</th>
                    <th style="text-align: center;">Cidade</th>
                    <th style="text-align: center;">Acções</th>
                </tr>
            </thead>
            <tbody>
                    <tr>
                      <td style="text-align: center;"></td>
                      <td style="text-align: center;"></td>                  
                      <td style="text-align: center;"></td>
                      <td style="text-align: center;"></td>
                      <td style="text-align: center;"></td>
                      <td style="text-align: center;"></td>
                      <td style="text-align: center;">
                      <a href="" class = "btn btn-primary">
                        <span class="glyphicon glyphicon-list"></span>
                      </a>
                      </td>
                      
                    </tr>
                      
            </tbody>
            </table>

          </div>


      </div>
      <footer>
               <nav class="navbar navbar-full navbar-light bg-faded" style="background-color: #e3f2fd;">
               <a class="navbar-brand boldado" href="#">Hospital</a>
                 <ul class="nav navbar-nav boldado">
                         <li class="nav-item">
                          <a class="nav-link" href="#">Parceiros</a>
                         </li>
                      <li class="nav-item">
                         <a class="nav-link" href="#">Siga-nos</a>
                        </li>
                    <li class="nav-item">
                  <a class="nav-link" href="#">Agradecimentos</a>
                </li>
            </ul>
       <p class="pull-xs-right pull-right boldado display-5">@Uncopyright 2016</p> 
          </nav>
      </footer>

       <script type="text/javascript" src="assets/js/jquery.min.js" ></script>
        <script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js" ></script>
        <script src="assets/bootstrap_4/bower_components/jquery/dist/jquery.min.js"></script> 
        <script src="assets/bootstrap_4/bower_components/bootstrap/js/src/carousel.js"></script> 
        <script src="assets/bootstrap_4/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>


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