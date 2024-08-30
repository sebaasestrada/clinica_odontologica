<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="componentes/header_inicio.jsp"%>
Alta Pacientes
<%@include file="componentes/header_final.jsp"%>
<%@include file="componentes/body_inicio.jsp"%>

<h2>Alta Pacientes</h2>
<h6>Esto es una prueba</h6>

<form class="user" action="SvPacientes" method="POST">
    <div class="form-group">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="dni"
                   placeholder="DNI">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombre"
                   placeholder="Nombre">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="apellidos"
                   placeholder="Apellidos">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="tel" class="form-control form-control-user" name="telefono"
                   placeholder="Teléfono">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="direccion"
                   placeholder="Dirección">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user" name="fecha_nac"
                   placeholder="Fecha de nacimiento">
        </div>
        <div class="col-sm-6 mb-3">
            ¿Tiene seguro contratado?
            <input type="checkbox" class="form-control form-control-user" name="seguro_medico">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="tipo_sangre"
                   placeholder="Tipo de sangre">
        </div>
    </div>
    <button class="btn btn-primary btn-user btn-block">
        Crear Odontólogo
    </button>
</form>

<%@include file="componentes/body_final.jsp"%>
