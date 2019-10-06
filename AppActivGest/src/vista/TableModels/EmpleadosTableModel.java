package vista.TableModels;

import modelo.Empleado;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EmpleadosTableModel extends AbstractTableModel {

    private String[] columnas = {"DNI", "Nombre", "Apellido1", "Fecha Nac", "Fecha Contrat", "Cargo"};
    private List<Empleado> empleados;

    public EmpleadosTableModel(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public int getRowCount() {
        return empleados.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Empleado e = empleados.get(rowIndex);

        System.out.println(rowIndex);
        System.out.println(columnIndex);

        switch (columnIndex){
            case 0:
                return e.getDni();
            case 1:
                return e.getNombre();
            case 2:
                return e.getApellido1();
            case 3:
                return e.getFechanac();
            case 4:
                return e.getFechacontract();
            case 5:
                return e.getCargo();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
