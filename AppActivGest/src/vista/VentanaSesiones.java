package vista;

import modelo.Sesion;
import vista.TableModels.SesionesTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaSesiones {
    private JPanel ventanaSesionesJpanel;
    private JTable FechaHorarioRespTable;
    private JButton atrasButton;
    private JButton buttonAlta;
    private JButton buttonEliminar;
    private JButton buttonActualizar;
    private JScrollPane panelScroll;
    private JTable table1;

    private List<Sesion> sesiones; // -> ¡CARGAR DESDE BASES DE DATOS!

    public VentanaSesiones(String nombreAcUsEm, String cc) {

        JFrame frame = new JFrame("Sesiones " + nombreAcUsEm + " " + cc);
        frame.setContentPane(ventanaSesionesJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });

    }
    public void cargarDatosEnTabla(){
        FechaHorarioRespTable.setModel(new SesionesTableModel(sesiones));
    }


}
