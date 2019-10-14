package modelo;

public class Sesion {

    private String hora;
    private String diaSemana;
    private String DNIUsuario;
    private String IDActividad;
    private int ID;//Ésta solo es para poder gestionar de manera única las sesiones.

    public Sesion(String hora, String diaSemana, String DNIUsuario, String IDActividad) {
        this.hora = hora;
        this.diaSemana = diaSemana;
        this.DNIUsuario = DNIUsuario;
        this.IDActividad = IDActividad;
    }

    private Actividad actividad;
    private Usuario usuario;

    public Sesion() {
    }

    public Sesion(String hora, String diaSemana) {
        this.hora = hora;
        this.diaSemana = diaSemana;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDNIUsuario() {
        return DNIUsuario;
    }

    public void setDNIUsuario(String DNIUsuario) {
        this.DNIUsuario = DNIUsuario;
    }

    public String getIDActividad() {
        return IDActividad;
    }

    public void setIDActividad(String IDActividad) {
        this.IDActividad = IDActividad;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
