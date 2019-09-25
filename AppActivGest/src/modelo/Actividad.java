package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Actividad {

    private String numactividad;
    private String nombre;
    private int numeromaxinvitado;
    private String nombresala;
    private double coste;

    private Date fecha;
    private String horario;

    private Empleado empleado;
    private ArrayList<Usuario> usuarioArrayList;

    public Actividad() {
    }

    public Actividad(String numactividad, String nombre, int numeromaxinvitado, String nombresala, double coste,
                     Date fecha, String horario) {
        this.numactividad = numactividad;
        this.nombre = nombre;
        this.numeromaxinvitado = numeromaxinvitado;
        this.nombresala = nombresala;
        this.coste = coste;
        this.fecha = fecha;
        this.horario = horario;
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

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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
