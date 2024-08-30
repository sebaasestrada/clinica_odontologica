<%@page import="com.strada.clinica_odontologia.logica.Paciente"%>
<%@page import="com.strada.clinica_odontologia.logica.Odontologo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="componentes/table_header_inicio.jsp" %>
Pacientes
<%@include file="componentes/table_header_final.jsp" %>
<%@include file="componentes/table_body_inicio.jsp" %>

<h1 class="h3 mb-2 text-gray-800">Tabla pacientes</h1>
<p class="mb-4">A continuación se visualizarán los pacientes registrados en la base de datos: </p>

<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Pacientes</h6>
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
                        <th>Seguro médico</th>                        
                        <th>Tipo de sangre</th>                        
                        <th>Responsable</th>
                        <th>Turnos</th>
                        <th>Acción</th>                           
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Paciente> listaPacientes = (List) request.getSession().getAttribute("listaPacientes");
                        for (Paciente pacien : listaPacientes) {
                    %>
                    <tr>
                        <td><%=pacien.getId()%></td>
                        <td><%= pacien.getDni()%></td>
                        <td><%= pacien.getNombre()%></td>
                        <td><%= pacien.getApellidos()%></td>
                        <td><%= pacien.getTelefono()%></td>
                        <td><%= pacien.getDireccion()%></td>
                        <td><%= pacien.getFecha_nac()%></td>
                        <td><%= pacien.getId()%></td>
                        <td><%= pacien.isTiene_OS()%></td>
                        <td><%= pacien.getTipo_sangre()%></td>
                        <td><%= pacien.getUnResponsable()%></td>
                        <td><%= pacien.getListaTurnos()%></td>
                        <td style="display: flex; width: 230px;">

                            <form action="SvEditarPaciente" method="GET">
                                <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-right: 5px"/>
                                <i class="fas fa-pencil-alt"></i> Editar
                                <input type="hidden" name="id_paciente" value="<%=pacien.getId()%>" />
                            </form>

                            <form action="SvEliminarPaciente" method="POST">
                                <button type="submit" class="btn btn-primary btn-user btn-block" style="background: #d62516; margin-left: 5px; width: 50%;"/>
                                <i class="fas fa-trash-alt"></i> Eliminar
                                <input type="hidden" name="id_paciente" value="<%=pacien.getId()%>" />
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
