package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaSesiones {
    private JPanel ventanaSesionesJpanel;
    private JLabel fechaJlabel;
    private JLabel horarioJlabel;
    private JLabel respJlabel;
    private JTable FechaHorarioRespTable;
    private JButton atrasButton;

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
}
