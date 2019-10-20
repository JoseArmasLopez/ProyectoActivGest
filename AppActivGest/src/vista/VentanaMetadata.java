package vista;

import controlador.ControladorBbDd;
import controlador.sqlite.MetadatoBd;
import controlador.sqlite.SqliteConsulta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

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
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("../Imagenes/icono.jpg");
        frame.setIconImage(img.getImage());
        ventanaMetadataJpanel.setBackground(new Color(135, 206, 235));
        frame.setVisible(true);

        ControladorBbDd controladorBbDd = new ControladorBbDd(cc);

        Connection connection = controladorBbDd.getConexion();

        MetadatoBd metadatoBd = new MetadatoBd(connection);

        try{

            textFieldNombre.setText(metadatoBd.getMetadatos().getDatabaseProductName());
            textFieldDriver.setText(metadatoBd.getMetadatos().getDriverName());
            textFieldURL.setText(metadatoBd.getMetadatos().getDriverVersion());
            textFieldUsuario.setText(metadatoBd.getMetadatos().getSchemaTerm());

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


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
