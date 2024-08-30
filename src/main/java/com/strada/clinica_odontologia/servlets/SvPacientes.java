package com.strada.clinica_odontologia.servlets;

import com.strada.clinica_odontologia.logica.Controlador;
import com.strada.clinica_odontologia.logica.Paciente;
import com.strada.clinica_odontologia.logica.Responsable;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "SvPacientes", urlPatterns = {"/SvPacientes"})
public class SvPacientes extends HttpServlet {

    Controlador control = new Controlador();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Paciente> listaPacientes = new ArrayList();
        listaPacientes = control.obtenerPacientes();

        HttpSession sesionUsuario = request.getSession();
        sesionUsuario.setAttribute("listaPacientes", listaPacientes);

        response.sendRedirect("pacientes.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Paciente nuevo_paciente = new Paciente();

        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");

        String fecha_nac = request.getParameter("fecha_nac");
        // Formatea el parametro fecha_nac que viene en string en un tipo date
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ITALY);
        LocalDate localDate = LocalDate.parse(fecha_nac, dateTimeFormatter);
        Date fecha_nac_formateada = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        boolean seguro_medico = Boolean.parseBoolean(request.getParameter("seguro_medico"));
        String tipo_sangre = request.getParameter("tipo_sangre");
        //Responsable responsable = request.getParameter("responsable");

        control.crearPaciente(dni, nombre, apellidos, telefono, direccion, fecha_nac_formateada, seguro_medico, tipo_sangre);

        response.sendRedirect("SvPacientes");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
