package modelo;

import java.sql.Date;
import java.util.ArrayList;

public class Empleado {

    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechanac;
    private Date fechacontract;
    private String cargo;

    private ArrayList<Actividad>actividadArrayList;

    public Empleado() {
    }

    public Empleado(String dni, String nombre, String apellido1, String apellido2, Date fechanac, Date fechacontract, String cargo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechanac = fechanac;
        this.fechacontract = fechacontract;
        this.cargo = cargo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public Date getFechacontract() {
        return fechacontract;
    }

    public void setFechacontract(Date fechacontract) {
        this.fechacontract = fechacontract;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public ArrayList<Actividad> getActividadArrayList() {
        return actividadArrayList;
    }

    public void setActividadArrayList(ArrayList<Actividad> actividadArrayList) {
        this.actividadArrayList = actividadArrayList;
    }
}
