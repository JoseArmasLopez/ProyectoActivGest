package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCRUD_AcUsEm {
    private JPanel ventanaCRUD_AcUsEmJpanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton sesionesButton;
    private JButton eliminarButton;
    private JButton saveButton;
    private JButton atrasButton;
    private JLabel jLabel6;
    private JLabel jLabel5;
    private JLabel jLabel4;
    private JLabel jLabel3;
    private JLabel jLabel2;
    private JLabel jLabel1;

    private VentanaSesiones ventanaSesiones;

    public VentanaCRUD_AcUsEm(String tipo, String nombreAcUsEm, String cc) {

        JFrame frame = new JFrame(nombreAcUsEm + " " + cc);
        frame.setContentPane(ventanaCRUD_AcUsEmJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        switch (tipo.toLowerCase()){
            case "empleados":
                jLabel1.setText("Nº Actividad");
                jLabel2.setText("Nombre");
                jLabel3.setText("Usuarios máximos");
                jLabel4.setText("Sala");
                jLabel5.setText("Curso");
                jLabel6.setText("Coste");
                break;
            case "usuarios":
                jLabel1.setText("DNI usuario");
                jLabel2.setText("Nombre");
                jLabel3.setText("Apellido 1");
                jLabel4.setText("Apellido 2");
                jLabel5.setText("Edad");
                jLabel6.setText("Profesión");
                break;
            case "actividades":
                jLabel1.setText("DNI empleado");
                jLabel2.setText("Nombre");
                jLabel3.setText("Apellido 1");
                jLabel4.setText("Fecha nacimiento");
                jLabel5.setText("Fecha contratación");
                jLabel6.setText("Cargo");
                break;
        }

        sesionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ventanaSesiones = new VentanaSesiones("---", cc);
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });
    }
}
