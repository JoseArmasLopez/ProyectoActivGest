package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Actividad {

    private String numactividad;
    private String nombre;
    private int numeromaxinvitado;
    private String nombresala;
    private String curosAcademico;
    private Double coste;

    private Empleado empleado;
    private ArrayList<Usuario> usuarioArrayList;

    public Actividad(int numactividad, String aquagym, String numeromaxinvitado, int gimnasia, String curosAcademico, double i) {
    }

    public Actividad(String numactividad, String nombre, int numeromaxinvitado, String nombresala, String
            curosAcademico, Double coste) {
        this.numactividad = numactividad;
        this.nombre = nombre;
        this.numeromaxinvitado = numeromaxinvitado;
        this.nombresala = nombresala;
        this.curosAcademico = curosAcademico;
        this.coste = coste;
    }

    public Actividad() {
    }

    public String getNumactividad() {
        return numactividad;
    }

    public void setNumactividad(String numactividad) {
        this.numactividad = numactividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeromaxinvitado() {
        return numeromaxinvitado;
    }

    public void setNumeromaxinvitado(int numeromaxinvitado) {
        this.numeromaxinvitado = numeromaxinvitado;
    }

    public String getNombresala() {
        return nombresala;
    }

    public void setNombresala(String nombresala) {
        this.nombresala = nombresala;
    }

    public String getcursoacademico() {
        return curosAcademico;
    }

    public void setCurosAcademico(String curosAcademico) {
        this.curosAcademico = curosAcademico;
    }

    public Double getCoste() {
        return coste;
    }

    public void setCoste(Double coste) {
        this.coste = coste;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public ArrayList<Usuario> getUsuarioArrayList() {
        return usuarioArrayList;
    }

    public void setUsuarioArrayList(ArrayList<Usuario> usuarioArrayList) {
        this.usuarioArrayList = usuarioArrayList;
    }


}
