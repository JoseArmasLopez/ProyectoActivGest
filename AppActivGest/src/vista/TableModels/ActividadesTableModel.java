package vista.TableModels;

import modelo.Actividad;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ActividadesTableModel extends AbstractTableModel {

    private String[] columnas = {"Num Actv", "Nombre", "Num Max Users", "Sala", "Curso", "Coste"};
    private List<Actividad> actividades;

    public ActividadesTableModel(List<Actividad> actividades) {
        this.actividades = actividades;

        System.out.println(actividades.size());

        System.out.println("Numero de actividades ...");
    }

    @Override
    public int getRowCount() {
        return actividades.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Actividad a = actividades.get(rowIndex);
        switch (columnIndex){
            case 0:
                return a.getNumactividad();
            case 1:
                return a.getNombre();
            case 2:
                return a.getNumeromaxinvitado();
            case 3:
                return a.getNombresala();
            case 4:
                return a.getcursoacademico();
            case 5:
                return a.getCoste();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
