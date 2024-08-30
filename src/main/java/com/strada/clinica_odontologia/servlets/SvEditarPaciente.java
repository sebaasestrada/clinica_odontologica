package com.strada.clinica_odontologia.servlets;

import com.strada.clinica_odontologia.logica.Controlador;
import com.strada.clinica_odontologia.logica.Paciente;
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

@WebServlet(name = "SvEditarPaciente", urlPatterns = {"/SvEditarPaciente"})
public class SvEditarPaciente extends HttpServlet {

    Controlador control = new Controlador();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_paciente = Integer.parseInt(request.getParameter("id_paciente"));

        Paciente paciente_editado = control.obtenerPaciente(id_paciente);

        HttpSession sesion_paciente = request.getSession();
        sesion_paciente.setAttribute("paciente_editado", paciente_editado);

        response.sendRedirect("editarPacientes.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Paciente paciente_editado = (Paciente) request.getSession().getAttribute("paciente_editado");

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

        boolean seguro_medico = Boolean.parseBoolean(request.getParameter("seguro_medico"));
        String tipo_sangre = request.getParameter("tipo_sangre");

        paciente_editado.setDni(nuevo_dni);
        paciente_editado.setNombre(nuevo_nombre);
        paciente_editado.setApellidos(nuevo_apellido);
        paciente_editado.setTelefono(nuevo_telefono);
        paciente_editado.setDireccion(nueva_direccion);
        paciente_editado.setFecha_nac(nueva_fecha_nac_formateada);
        paciente_editado.setTiene_OS(seguro_medico);
        paciente_editado.setTipo_sangre(tipo_sangre);

        control.editarPaciente(paciente_editado);

        response.sendRedirect("SvPacientes");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
