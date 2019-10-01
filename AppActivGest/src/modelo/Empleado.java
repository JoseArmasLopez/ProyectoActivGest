package modelo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Empleado {

    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String fechanac;
    private String fechacontract;
    private String cargo;
    private String nacionalidad;

    private ArrayList<Actividad>actividadArrayList;

    public Empleado() {
    }

    public Empleado(String dni, String nombre, String apellido1, String apellido2, String fechanac, String fechacontract,
                    String cargo, String nacionalidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechanac = fechanac;
        this.fechacontract = fechacontract;
        this.cargo = cargo;
        this.nacionalidad = nacionalidad;
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

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public String getFechacontract() {
        return fechacontract;
    }

    public void setFechacontract(String fechacontract) {
        this.fechacontract = fechacontract;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public ArrayList<Actividad> getActividadArrayList() {
        return actividadArrayList;
    }

    public void setActividadArrayList(ArrayList<Actividad> actividadArrayList) {
        this.actividadArrayList = actividadArrayList;
    }
}
