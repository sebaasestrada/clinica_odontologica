package com.strada.clinica_odontologia.servlets;

import com.strada.clinica_odontologia.logica.Controlador;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEliminarOdontologo", urlPatterns = {"/SvEliminarOdontologo"})
public class SvEliminarOdontologo extends HttpServlet {
    
    Controlador control = new Controlador();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_odontologo_eliminado = Integer.parseInt(request.getParameter("id_odontologo"));
        
        control.eliminarOdontologo(id_odontologo_eliminado);
        
        response.sendRedirect("SvOdontologos");
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
}
