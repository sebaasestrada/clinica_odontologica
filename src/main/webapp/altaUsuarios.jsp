<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="componentes/header_inicio.jsp"%>
Alta Usuarios
<%@include file="componentes/header_final.jsp"%>
<%@include file="componentes/body_inicio.jsp"%>

<h2>Alta Usuarios</h2>
<h6>Esto es una prueba</h6>

<form class="user" action="SvUsuarios" method="POST">
    <div class="form-group">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombre_usuario"
                   placeholder="Nombre de usuario" required>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" name="contrasenia"
                   placeholder="Contraseña" required>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="rol"
                   placeholder="Rol" required>
        </div>
    </div>
    <button type="submit" class="btn btn-primary btn-user btn-block">
        Crear Usuario
    </button>
</form>

<%@include file="componentes/body_final.jsp"%>
