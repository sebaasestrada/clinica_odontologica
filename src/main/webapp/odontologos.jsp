<%@page import="com.strada.clinica_odontologia.logica.Odontologo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="componentes/table_header_inicio.jsp" %>
Odontólogos
<%@include file="componentes/table_header_final.jsp" %>
<%@include file="componentes/table_body_inicio.jsp" %>

<h1 class="h3 mb-2 text-gray-800">Tabla odontólogos</h1>
<p class="mb-4">A continuación se visualizarán los odontólogos registrados en la base de datos: </p>

<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Odontólogos</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <!-- Comienzo de la tabla -->
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DNI</th>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Teléfono</th>
                        <th>Dirección</th>
                        <th>Fecha de nacimiento</th>
                        <th>Edad</th>
                        <th>Especialidad</th>                        
                        <th>Turnos</th>                        
                        <th>Horario</th>
                        <th>Usuario</th>
                        <th>Acción</th>                   
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Odontologo> listaOdontologos = (List) request.getSession().getAttribute("listaOdontologos");
                        for (Odontologo odonto : listaOdontologos) {
                    %>
                    <tr>
                        <td><%=odonto.getId()%></td>
                        <td><%=odonto.getDni()%></td>
                        <td><%=odonto.getNombre()%></td>
                        <td><%=odonto.getApellidos()%></td>
                        <td><%=odonto.getTelefono()%></td>
                        <td><%=odonto.getDireccion()%></td>
                        <td><%=odonto.getFecha_nac()%></td>
                        <td><%=odonto.getId()%></td>
                        <td><%=odonto.getEspecialidad()%></td>
                        <td><<%=odonto.getListaTurnos()%></td>
                        <td><%=odonto.getUnHorario()%></td>
                        <td><%=odonto.getUnUsuario()%></td>
                        <td style="display: flex; width: 230px;">

                            <form action="SvEditarOdontologo" method="GET">
                                <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-right: 5px"/>
                                <i class="fas fa-pencil-alt"></i> Editar
                                <input type="hidden" name="id_odontologo" value="<%=odonto.getId()%>" />
                            </form>

                            <form action="SvEliminarOdontologo" method="POST">
                                <button type="submit" class="btn btn-primary btn-user btn-block" style="background: #d62516; margin-left: 5px; width: 50%;"/>
                                <i class="fas fa-trash-alt"></i> Eliminar
                                <input type="hidden" name="id_odontologo" value="<%=odonto.getId()%>" />
                            </form>

                        </td>
                    </tr>
                    <% }%>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>DNI</th>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Teléfono</th>
                        <th>Dirección</th>
                        <th>Fecha de nacimiento</th>
                        <th>Edad</th>
                        <th>Especialidad</th>                                                
                        <th>Turnos</th>                        
                        <th>Horario</th>
                        <th>Usuario</th>
                        <th>Acción</th>
                    </tr>
                </tfoot>
                </tbody>
                <%@include file="componentes/table_body_final.jsp" %>
