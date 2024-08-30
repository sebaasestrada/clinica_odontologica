<%@page import="com.strada.clinica_odontologia.logica.Odontologo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="componentes/header_inicio.jsp"%>
Editar Odontólogos
<%@include file="componentes/header_final.jsp"%>
<%@include file="componentes/body_inicio.jsp"%>

<% Odontologo odontologo_editado = (Odontologo) request.getSession().getAttribute("odontologo_editado");%>

<h2><%=odontologo_editado.getNombre()%> <%=odontologo_editado.getApellidos()%></h2>
<h6>Aquí puede realizar cambios en los odontólogos.</h6>

<form class="user" action="SvEditarOdontologo" method="POST">
    <div class="form-group">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="dni"
                   placeholder="DNI" value="<%=odontologo_editado.getDni()%>" required>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombre"
                   placeholder="Nombre" value="<%=odontologo_editado.getNombre()%>" required>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="apellidos"
                   placeholder="Apellidos" value="<%=odontologo_editado.getApellidos()%>" required>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="telefono"
                   placeholder="Teléfono" value="<%=odontologo_editado.getTelefono()%>" required>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="direccion"
                   placeholder="Dirección" value="<%=odontologo_editado.getDireccion()%>" required>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user" name="fecha_nac"
                   placeholder="Fecha de nacimiento" value="<%=odontologo_editado.getFecha_nac()%>" required>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="especialidad"
                   placeholder="Especialidad" value="<%=odontologo_editado.getEspecialidad()%>" required>
        </div>
        <div class="col-sm-6 mb-3">
            @<input type="text" class="form-control form-control-user" name="nombre_usuario"
                   placeholder="Nombre de usuario" value="<%=odontologo_editado.getUnUsuario()%>" required>
        </div>
    </div>
    <button type="submit" class="btn btn-primary btn-user btn-block">
        Guardar cambios
    </button>
</form>

<%@include file="componentes/body_final.jsp"%>
