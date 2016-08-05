<%-- 
    Document   : ListaPacientes
    Created on : Aug 5, 2016, 7:05:28 PM
    Author     : zJohn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Pacientes</title>
    </head>   
    <div id="procurar_paciente">

            <h2 class="boldadoPersonalizado">
              Doentes <span class="label label-info" style="font-size: 14px">Total: <%= out.total; =%> </span>   
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
                 <% List tiposIds = (List)request.getAttribute("tipo_id");
                                        for(int i  = 0; i < tiposIds.size(); i++){
                                            Pessoa pessoa = (Pessoa)tiposIds.get(i);
                                            out.print("<option value=\""+pessoa.getTipoID()+"\">"+pessoa.getTipoID()+"</option>");
                                        }
                                        %>
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
        </script>
    
</html>
