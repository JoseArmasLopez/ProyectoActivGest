package vista.TableModels;

import modelo.Usuario;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class UsuariosTableModel extends AbstractTableModel {

    private String[] columnas = {"DNI", "Nombre", "Apellido1", "Apellido2", "Edad", "Profesión"};
    private List<Usuario> usuarios;

    public UsuariosTableModel(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario u = usuarios.get(rowIndex);
        switch (columnIndex){
            case 0:
                return u.getDni();
            case 1:
                return u.getNombre();
            case 2:
                return u.getApellido1();
            case 3:
                return u.getApellido2();
            case 4:
                return u.getEdad();
            case 5:
                return u.getProfesion();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
