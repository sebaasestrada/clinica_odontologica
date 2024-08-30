<%@page import="com.strada.clinica_odontologia.logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="componentes/table_header_inicio.jsp" %>
Usuarios
<%@include file="componentes/table_header_final.jsp" %>
<%@include file="componentes/table_body_inicio.jsp" %>

<h1 class="h3 mb-2 text-gray-800">Tabla usuarios</h1>
<p class="mb-4">A continuación se visualizarán los usuarios registrados en la base de datos: </p>

<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <!-- Comienzo de la tabla -->
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre paciente</th>
                        <th>Rol</th>
                        <th>Acción</th>                        
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Usuario> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");
                        for (Usuario usu : listaUsuarios) {
                    %>
                    <tr>
                        <td><%= usu.getId_usuario()%></td>
                        <td><%= usu.getNombre_usuario()%></td>
                        <td><%= usu.getRol()%></td>
                        <td style="display: flex; width: 230px;">

                            <form action="SvEditarUsuario" method="GET">
                                <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-right: 5px"/>
                                <i class="fas fa-pencil-alt"></i> Editar
                                <input type="hidden" name="id_usuario" value="<%=usu.getId_usuario()%>" />
                            </form>
                            
                            <form action="SvEliminarUsuario" method="POST">
                                <button type="submit" class="btn btn-primary btn-user btn-block" style="background: #d62516; margin-left: 5px; width: 50%;"/>
                                <i class="fas fa-trash-alt"></i> Eliminar
                                <input type="hidden" name="id_usuario" value="<%=usu.getId_usuario()%>" />
                            </form>

                        </td>
                    </tr>
                    <% }%>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Nombre de usuario</th>
                        <th>Rol</th>
                        <th>Acción</th>
                    </tr>
                </tfoot>
                </tbody>
                <%@include file="componentes/table_body_final.jsp" %>
