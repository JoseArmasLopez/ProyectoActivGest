package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMetadata {
    private JTextField textFieldNombre;
    private JTextField textFieldDriver;
    private JTextField textFieldURL;
    private JTextField textFieldUsuario;
    private JPanel ventanaMetadataJpanel;
    private JLabel nombreBDLabel;
    private JLabel driverLabel;
    private JLabel urlLabel;
    private JLabel usuarioLabel;
    private JButton buttonTablas;
    private JButton buttonAtras;

    private VentanaTablasBBDD tablasBBDD;

    public VentanaMetadata(String nombBBDD, String cc) {

        JFrame frame = new JFrame(nombBBDD + " " + cc);
        frame.setContentPane(ventanaMetadataJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        buttonTablas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tablasBBDD = new VentanaTablasBBDD(nombBBDD, cc);
            }
        });
        buttonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });
    }
}
