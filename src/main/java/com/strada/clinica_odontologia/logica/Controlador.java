package com.strada.clinica_odontologia.logica;

import com.strada.clinica_odontologia.persistencia.ControladorPersistencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controlador {

    ControladorPersistencia controlPersis = new ControladorPersistencia();

    /* USUARIOS */
    public boolean comprobarCredenciales(String nombre_usuario, String contrasenia) {

        boolean resultado_credenciales = false;
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios = controlPersis.obtenerUsuarios();

        for (Usuario usu : listaUsuarios) {
            if (usu.getNombre_usuario().equals(nombre_usuario)) {
                if (usu.getContrasenia().equals(contrasenia)) {
                    resultado_credenciales = true;
                }
            }
        }
        return resultado_credenciales;
    }

    // Crea nuevos usuarios en la base de datos
    public void crearUsuario(String nombre_usuario, String contrasenia, String rol) {
        Usuario usu = new Usuario();
        usu.setNombre_usuario(nombre_usuario);
        usu.setContrasenia(contrasenia);
        usu.setRol(rol);
        controlPersis.crearUsuario(usu);
    }

    // Obtiene un usuario de la base de datos
    public Usuario obtenerUsuario(int id_usuario) {
        return controlPersis.obtenerUsuario(id_usuario);
    }

    // Obtiene todos los usuarios de la base de datos
    public List<Usuario> obtenerUsuarios() {
        return controlPersis.obtenerUsuarios();
    }

    // Actualiza usuarios en la base de datos
    public void editarUsuario(Usuario usuario_editado) {
        controlPersis.editarUsuario(usuario_editado);
    }

    // Elimina usuarios de la base de datos
    public void eliminarUsuario(int id_usuario) {
        controlPersis.eliminarUsuario(id_usuario);
    }

    /* ODONTOLOGOS */
    // Crea nuevos usuarios en la base de datos
    public void crearOdontologo(String dni, String nombre, String apellidos, String telefono, String direccion, Date fecha_nac, String especialidad) {
        Odontologo odonto = new Odontologo();
        odonto.setDni(dni);
        odonto.setNombre(nombre);
        odonto.setApellidos(apellidos);
        odonto.setTelefono(telefono);
        odonto.setDireccion(direccion);
        odonto.setFecha_nac(fecha_nac);
        odonto.setEspecialidad(especialidad);
        controlPersis.crearOdontologo(odonto);
    }

    // Obtiene un odontologo de la base de datos
    public Odontologo obtenerOdontologo(int id_odontologo) {
        return controlPersis.obtenerOdontologo(id_odontologo);
    }

    // Obtiene todos los odontologos de la base de datos
    public List<Odontologo> obtenerOdontologos() {
        return controlPersis.obtenerOdontologos();
    }

    // Actualiza odontologos en la base de datos
    public void editarOdontologo(Odontologo odontologo_editado) {
        controlPersis.editarOdontologo(odontologo_editado);
    }

    // Elimina odontologos de la base de datos
    public void eliminarOdontologo(int id_odontologo) {
        controlPersis.eliminarOdontologo(id_odontologo);
    }

    /* PACIENTES */
    // Crea nuevos pacientes en la base de datos
    public void crearPaciente(String dni, String nombre, String apellidos, String telefono, String direccion, Date fecha_nac, boolean obra_social, String tipo_sangre) {
        Paciente pacien = new Paciente();
        pacien.setDni(dni);
        pacien.setNombre(nombre);
        pacien.setApellidos(apellidos);
        pacien.setTelefono(telefono);
        pacien.setDireccion(direccion);
        pacien.setFecha_nac(fecha_nac);
        pacien.setTiene_OS(obra_social);
        pacien.setTipo_sangre(tipo_sangre);
        //pacien.setUnResponsable(responsable);
        controlPersis.crearPaciente(pacien);
    }

    // Obtiene un paciente de la base de datos
    public Paciente obtenerPaciente(int id_paciente) {
        return controlPersis.obtenerPaciente(id_paciente);
    }

    // Obtiene todos los pacientes de la base de datos
    public List<Paciente> obtenerPacientes() {
        return controlPersis.obtenerPacientes();
    }

    // Actualiza pacientes en la base de datos
    public void editarPaciente(Paciente paciente_editado) {
        controlPersis.editarPaciente(paciente_editado);
    }

    // Elimina pacientes de la base de datos
    public void eliminarPaciente(int id_paciente) {
        controlPersis.eliminarPaciente(id_paciente);
    }

}
