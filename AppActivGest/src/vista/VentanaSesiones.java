package vista;

import modelo.Sesion;
import vista.TableModels.SesionesTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaSesiones {
    private JPanel ventanaSesionesJpanel;
    private JLabel fechaJlabel;
    private JLabel horarioJlabel;
    private JLabel respJlabel;
    private JTable FechaHorarioRespTable;
    private JButton atrasButton;

    private List<Sesion> sesiones; // -> ¡CARGAR DESDE BASES DE DATOS!

    public VentanaSesiones(String nombreAcUsEm, String cc) {
        JFrame frame = new JFrame("Sesiones " + nombreAcUsEm + " " + cc);
        frame.setContentPane(ventanaSesionesJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        if (sesiones.size() > 0){
            cargarDatosEnTabla();
        }else {
            javax.swing.JOptionPane.showMessageDialog(null, "List sesiones vacío!");
        }


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
