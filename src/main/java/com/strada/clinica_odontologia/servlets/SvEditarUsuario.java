package com.strada.clinica_odontologia.servlets;

import com.strada.clinica_odontologia.logica.Controlador;
import com.strada.clinica_odontologia.logica.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "SvEditarUsuario", urlPatterns = {"/SvEditarUsuario"})
public class SvEditarUsuario extends HttpServlet {

    Controlador control = new Controlador();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));

        Usuario usuario_editado = control.obtenerUsuario(id_usuario);

        HttpSession sesion_usuario = request.getSession();
        sesion_usuario.setAttribute("usuario_editado", usuario_editado);

        response.sendRedirect("editarUsuarios.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usuario_editado = (Usuario) request.getSession().getAttribute("usuario_editado");

        String nuevo_nombre_usuario = request.getParameter("nombre_usuario");
        String nueva_contrasenia = request.getParameter("contrasenia");
        String nuevo_rol = request.getParameter("rol");

        usuario_editado.setNombre_usuario(nuevo_nombre_usuario);
        usuario_editado.setContrasenia(nueva_contrasenia);
        usuario_editado.setRol(nuevo_rol);

        control.editarUsuario(usuario_editado);

        response.sendRedirect("SvUsuarios");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
