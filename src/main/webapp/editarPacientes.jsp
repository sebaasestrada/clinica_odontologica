<%@page import="com.strada.clinica_odontologia.logica.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="componentes/header_inicio.jsp"%>
Editar Pacientes
<%@include file="componentes/header_final.jsp"%>
<%@include file="componentes/body_inicio.jsp"%>

<% Paciente paciente_editado = (Paciente) request.getSession().getAttribute("paciente_editado");%>

<h2><%=paciente_editado.getNombre()%> <%=paciente_editado.getApellidos()%></h2>
<h6>Aquí puede realizar cambios en los pacientes.</h6>

<form class="user" action="SvEditarPaciente" method="POST">
    <div class="form-group">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="dni"
                   placeholder="DNI" value="<%=paciente_editado.getDni()%>" required>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombre"
                   placeholder="Nombre" value="<%=paciente_editado.getNombre()%>" required>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="apellidos"
                   placeholder="Apellidos" value="<%=paciente_editado.getApellidos()%>" required>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="tel" class="form-control form-control-user" name="telefono"
                   placeholder="Teléfono" value="<%=paciente_editado.getTelefono()%>" required>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="direccion"
                   placeholder="Dirección" value="<%=paciente_editado.getDireccion()%>" required>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user" name="fecha_nac"
                   placeholder="Fecha de nacimiento" value="<%=paciente_editado.getFecha_nac()%>" required>
        </div>
        <div class="col-sm-6 mb-3">
            ¿Seguro médico?
            <input type="checkbox" class="form-control form-control-user" name="seguro_medico"
                   value="<%=paciente_editado.isTiene_OS()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="tipo_sangre"
                   placeholder="Tipo de sangre" value="<%=paciente_editado.getTipo_sangre()%>" required>
        </div>
    </div>
    <button type="submit" class="btn btn-primary btn-user btn-block">
        Guardar cambios
    </button>
</form>

<%@include file="componentes/body_final.jsp"%>
