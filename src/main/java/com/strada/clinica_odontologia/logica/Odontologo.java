package com.strada.clinica_odontologia.logica;

import java.io.Serializable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Odontologo extends Persona implements Serializable {

    private String especialidad;
    @OneToMany(mappedBy = "odonto")
    private List<Turno> listaTurnos;
    @OneToOne
    private Horario unHorario;
    @OneToOne
    private Usuario unUsuario;

    public Odontologo() {
    }

    public Odontologo(String especialidad, List<Turno> listaTurnos, Horario unHorario, Usuario unUsuario, int id, String dni, String nombre, String apellidos, String telefono, String direccion, Date fecha_nac) {
        super(id, dni, nombre, apellidos, telefono, direccion, fecha_nac);
        this.especialidad = especialidad;
        this.listaTurnos = listaTurnos;
        this.unHorario = unHorario;
        this.unUsuario = unUsuario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    public Horario getUnHorario() {
        return unHorario;
    }

    public void setUnHorario(Horario unHorario) {
        this.unHorario = unHorario;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

}
