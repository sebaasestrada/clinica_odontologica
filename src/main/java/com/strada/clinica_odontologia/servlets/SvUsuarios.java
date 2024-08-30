package com.strada.clinica_odontologia.servlets;

import com.strada.clinica_odontologia.logica.Controlador;
import com.strada.clinica_odontologia.logica.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {

    Controlador control = new Controlador();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Usuario> listaUsuarios = new ArrayList();
        listaUsuarios = control.obtenerUsuarios();
        
        HttpSession sesionUsuario = request.getSession();
        sesionUsuario.setAttribute("listaUsuarios", listaUsuarios);
        
        response.sendRedirect("usuarios.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre_usuario = request.getParameter("nombre_usuario");
        String contrasenia = request.getParameter("contrasenia");
        String rol = request.getParameter("rol");

        control.crearUsuario(nombre_usuario, contrasenia, rol);

        response.sendRedirect("SvUsuarios");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
