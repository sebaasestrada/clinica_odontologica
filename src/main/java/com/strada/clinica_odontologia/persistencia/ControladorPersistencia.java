package com.strada.clinica_odontologia.persistencia;

import com.strada.clinica_odontologia.logica.Odontologo;
import com.strada.clinica_odontologia.logica.Paciente;
import com.strada.clinica_odontologia.logica.Usuario;
import com.strada.clinica_odontologia.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorPersistencia {

    HorarioJpaController horaJPA = new HorarioJpaController();
    OdontologoJpaController odontoJPA = new OdontologoJpaController();
    PacienteJpaController pacienteJPA = new PacienteJpaController();
    PersonaJpaController personaJPA = new PersonaJpaController();
    ResponsableJpaController responsableJPA = new ResponsableJpaController();
    SecretarioJpaController secretarioJPA = new SecretarioJpaController();
    TurnoJpaController turnoJPA = new TurnoJpaController();
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();

    
    /* USUARIOS */
    
    public void crearUsuario(Usuario usu) {
        usuarioJPA.create(usu);
    }

    public Usuario obtenerUsuario(int id_usuario) {
        return usuarioJPA.findUsuario(id_usuario);
    }

    public ArrayList<Usuario> obtenerUsuarios() {
        ArrayList listaUsuarios = new ArrayList(usuarioJPA.findUsuarioEntities());
        return listaUsuarios;
    }

    public void editarUsuario(Usuario usuario_editado) {
        try {
            usuarioJPA.edit(usuario_editado);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarUsuario(int id_usuario) {
        try {
            usuarioJPA.destroy(id_usuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /* ODONTOLOGOS */

    public void crearOdontologo(Odontologo odonto) {
        odontoJPA.create(odonto);
    }

    public Odontologo obtenerOdontologo(int id_odontologo) {
        return odontoJPA.findOdontologo(id_odontologo);
    }

    public ArrayList<Odontologo> obtenerOdontologos() {
        ArrayList listaOdontologos = new ArrayList(odontoJPA.findOdontologoEntities());
        return listaOdontologos;
    }

    public void editarOdontologo(Odontologo odontologo_editado) {
        try {
            odontoJPA.edit(odontologo_editado);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarOdontologo(int id_odontologo) {
        try {
            odontoJPA.destroy(id_odontologo);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /* PACIENTES */

    public void crearPaciente(Paciente pacien) {
        pacienteJPA.create(pacien);
    }

    public Paciente obtenerPaciente(int id_paciente) {
        return pacienteJPA.findPaciente(id_paciente);
    }

    public List<Paciente> obtenerPacientes() {
        return pacienteJPA.findPacienteEntities();
    }

    public void editarPaciente(Paciente paciente_editado) {
        try {
            pacienteJPA.edit(paciente_editado);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarPaciente(int id_paciente) {
        try {
            pacienteJPA.destroy(id_paciente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
