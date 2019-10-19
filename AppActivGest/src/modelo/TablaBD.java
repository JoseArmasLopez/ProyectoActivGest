package modelo;

public class TablaBD {

    private String esquema;
    private String nombre;
    private String pk; //Primary Key
    private int numCols;

    public TablaBD() {
    }

    public TablaBD(String esquema, String nombre, String pk, int numCols) {
        this.esquema = esquema;
        this.nombre = nombre;
        this.pk = pk;
        this.numCols = numCols;
    }

    public String getEsquema() {
        return esquema;
    }

    public void setEsquema(String esquema) {
        this.esquema = esquema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public int getNumCols() {
        return numCols;
    }

    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }

    @Override
    public String toString() {
        return "TablaBD{" +
                "esquema='" + esquema + '\'' +
                ", nombre='" + nombre + '\'' +
                ", pk='" + pk + '\'' +
                ", numCols=" + numCols +
                '}';
    }
}
