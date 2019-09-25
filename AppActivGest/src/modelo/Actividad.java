package modelo;

public class Actividad {

    private String numactividad;
    private String nombre;
    private int numeromaxinvitado;
    private String nombresala;
    private double coste;

    public Actividad() {
    }

    public Actividad(String numactividad, String nombre, int numeromaxinvitado, String nombresala, double coste) {
        this.numactividad = numactividad;
        this.nombre = nombre;
        this.numeromaxinvitado = numeromaxinvitado;
        this.nombresala = nombresala;
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

}
