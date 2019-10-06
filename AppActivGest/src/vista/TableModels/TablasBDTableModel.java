package vista.TableModels;

import modelo.TablaBD;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablasBDTableModel extends AbstractTableModel {

    private String[] columnas = {"Esquema", "Nombre", "PK", "Num cols",};
    private List<TablaBD> tablasBd;

    public TablasBDTableModel(List<TablaBD> tablasBd) {
        this.tablasBd = tablasBd;
    }

    @Override
    public int getRowCount() {
        return columnas.length;
    }

    @Override
    public int getColumnCount() {
        return tablasBd.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TablaBD tbd = tablasBd.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tbd.getEsquema();
            case 1:
                return tbd.getNombre();
            case 2:
                return tbd.getPk();
            case 3:
                return tbd.getNumCols();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
