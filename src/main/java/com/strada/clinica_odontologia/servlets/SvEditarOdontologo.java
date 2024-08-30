package com.strada.clinica_odontologia.servlets;

import com.strada.clinica_odontologia.logica.Controlador;
import com.strada.clinica_odontologia.logica.Odontologo;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "SvEditarOdontologo", urlPatterns = {"/SvEditarOdontologo"})
public class SvEditarOdontologo extends HttpServlet {

    Controlador control = new Controlador();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_odontologo = Integer.parseInt(request.getParameter("id_odontologo"));

        Odontologo odontologo_editado = control.obtenerOdontologo(id_odontologo);

        HttpSession sesion_usuario = request.getSession();
        sesion_usuario.setAttribute("odontologo_editado", odontologo_editado);

        response.sendRedirect("editarOdontologos.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Odontologo odontologo_editado = (Odontologo) request.getSession().getAttribute("odontologo_editado");

        String nuevo_dni = request.getParameter("dni");
        String nuevo_nombre = request.getParameter("nombre");
        String nuevo_apellido = request.getParameter("apellidos");
        String nuevo_telefono = request.getParameter("telefono");
        String nueva_direccion = request.getParameter("direccion");

        String nueva_fecha_nac = request.getParameter("fecha_nac");
        // Formatea el parametro fecha_nac que viene en string en un tipo date
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ITALY);
        LocalDate localDate = LocalDate.parse(nueva_fecha_nac, dateTimeFormatter);
        Date nueva_fecha_nac_formateada = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        String nueva_especialidad = request.getParameter("especialidad");
        String nuevo_usuario = request.getParameter("nombre_usuario");

        odontologo_editado.setDni(nuevo_dni);
        odontologo_editado.setNombre(nuevo_nombre);
        odontologo_editado.setApellidos(nuevo_apellido);
        odontologo_editado.setTelefono(nuevo_telefono);
        odontologo_editado.setDireccion(nueva_direccion);
        odontologo_editado.setFecha_nac(nueva_fecha_nac_formateada);
        odontologo_editado.setEspecialidad(nueva_especialidad);

        control.editarOdontologo(odontologo_editado);

        response.sendRedirect("SvOdontologos");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
