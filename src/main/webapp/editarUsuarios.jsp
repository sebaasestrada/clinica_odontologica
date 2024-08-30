<%@page import="com.strada.clinica_odontologia.logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="componentes/header_inicio.jsp"%>
Editar Usuarios
<%@include file="componentes/header_final.jsp"%>
<%@include file="componentes/body_inicio.jsp"%>

<% Usuario usuario_editado = (Usuario) request.getSession().getAttribute("usuario_editado");%>

<h2>@<%=usuario_editado.getNombre_usuario()%></h2>
<h6>Aquí puede realizar cambios en los usuarios.</h6>

<form class="user" action="SvEditarUsuario" method="POST">
    <div class="form-group">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombre_usuario"
                   placeholder="Nombre de usuario" value="<%=usuario_editado.getNombre_usuario()%>" required>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" name="contrasenia"
                   placeholder="Contraseña" value="<%=usuario_editado.getContrasenia()%>" required>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="rol"
                   placeholder="Rol" value="<%=usuario_editado.getRol()%>" required>
        </div>
    </div>
    <button type="submit" class="btn btn-primary btn-user btn-block">
        Guardar cambios
    </button>
</form>

<%@include file="componentes/body_final.jsp"%>
