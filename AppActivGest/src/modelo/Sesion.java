package AppActivGest.src.modelo;

public class Sesion {

    // Máximo 5 dígitos
    private String hora;
    private String diaSemana;
    private String numActividad;
    private String dniUsuario;


    public Sesion() {
    }

    public Sesion(String hora, String diaSemana, String numActividad, String dniUsuario) {
        this.hora = hora;
        this.diaSemana = diaSemana;
        this.numActividad = numActividad;
        this.dniUsuario = dniUsuario;
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

    public String getNumActividad() {
        return numActividad;
    }

    public void setNumActividad(String numActividad) {
        this.numActividad = numActividad;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }
}
