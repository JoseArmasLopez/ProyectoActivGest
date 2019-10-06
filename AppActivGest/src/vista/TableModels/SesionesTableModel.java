package vista.TableModels;

import modelo.Sesion;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class SesionesTableModel extends AbstractTableModel {

    private String[] columnas = {"Fecha", "Horario", "Responsable"};
    private List<Sesion> sesiones;

    public SesionesTableModel(List<Sesion> sesiones) {
        this.sesiones = sesiones;
    }

    @Override
    public int getRowCount() {
        return columnas.length;
    }

    @Override
    public int getColumnCount() {
        return sesiones.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sesion s = sesiones.get(rowIndex);
        switch (columnIndex){
            case 0:
                return s.getDiaSemana();
            case 1:
                return s.getHora();
            case 2:
                return s.getActividad().getEmpleado();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
