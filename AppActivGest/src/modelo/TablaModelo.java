package modelo;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

public class TablaModelo implements TableModel {

    private List<Actividad> actividades;

    public TablaModelo(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    @Override
    public int getRowCount() {
        return actividades.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int i) {
        String titulo = null;

       switch (i){
           case 0:
               titulo = "CODIGO";
               break;
           case 1:
               titulo = "NOMBRE";
               break;
           case 2:
               titulo = "MAXIMO";
               break;
           case 3:
               titulo = "SALA";
               break;
           case 4:
               titulo = "CURSO";
               break;
           case 5:
               titulo = "COSTE";
               break;

       }
       return titulo;

    }

    @Override
    public Class<?> getColumnClass(int i) {
        return null;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return i1!= 0;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Actividad act = actividades.get(i);
        String titulo = null;

        switch (i1){

            case 0:
                titulo = act.getNumactividad();
                break;
            case 1:
                titulo = act.getNombre();
                break;
            case 2:
                titulo = String.valueOf(act.getNumeromaxinvitado());
                break;
            case 3:
                titulo = act.getNombresala();
                break;
            case 4:
                titulo = act.getCurosAcademico();
                break;
            case 5:
                titulo = Double.toString(act.getCoste());
                break;


        }


        return titulo;

    }

    @Override
    public void setValueAt(Object o, int i, int i1) {

        Actividad act = actividades.get(i);

        switch (i1){

            case 0:
                act.setNumactividad(o.toString());
                break;
            case 1:
                act.setNombre(o.toString());
                break;
            case 2:
                act.setNumeromaxinvitado(Integer.valueOf(o.toString()));
                break;
            case 3:
                act.setNombresala(o.toString());
                break;
            case 4:
                act.setCurosAcademico(o.toString());
                break;
            case 5:
                act.setCoste(Double.parseDouble(o.toString()));
                break;


        }

    }

    @Override
    public void addTableModelListener(TableModelListener tableModelListener) {

    }

    @Override
    public void removeTableModelListener(TableModelListener tableModelListener) {

    }
}
