package AppActivGest.src.modelo;

import java.util.ArrayList;
import java.util.Date;

public class Actividad {

    private String numactividad;
    private String nombre;
    private int numeromaxinvitado;
    private Double coste;

    private Empleado empleado;
    private ArrayList<Usuario> usuarioArrayList;

    public Actividad() {
    }

    public Actividad(String numactividad, String nombre, int numeromaxinvitado, Double coste) {
        this.numactividad = numactividad;
        this.nombre = nombre;
        this.numeromaxinvitado = numeromaxinvitado;
        this.coste = coste;

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

    public Double getCoste() {
        return coste;
    }

    public void setCoste(Double coste) {
        this.coste = coste;
    }


}

