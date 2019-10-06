package modelo;

public class Multa {

    private String codigo;
    private String descripcion;
    private String fecha;
    private double coste;

    public Multa() {
    }

    public Multa(String codigo, String descripcion, String fecha, double coste) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.coste = coste;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }
}
