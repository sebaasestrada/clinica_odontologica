package com.strada.clinica_odontologia.servlets;

import com.strada.clinica_odontologia.logica.Controlador;
import com.strada.clinica_odontologia.logica.Odontologo;
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

@WebServlet(name = "SvOdontologos", urlPatterns = {"/SvOdontologos"})
public class SvOdontologos extends HttpServlet {

    Controlador control = new Controlador();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Odontologo> listaOdontologos = new ArrayList();
        listaOdontologos = control.obtenerOdontologos();

        HttpSession sesionUsuario = request.getSession();
        sesionUsuario.setAttribute("listaOdontologos", listaOdontologos);

        response.sendRedirect("odontologos.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Odontologo nuevo_odontologo = new Odontologo();

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
        
        String especialidad = request.getParameter("especialidad");

        control.crearOdontologo(dni, nombre, apellidos, telefono, direccion, fecha_nac_formateada, especialidad);

        response.sendRedirect("SvOdontologos");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
