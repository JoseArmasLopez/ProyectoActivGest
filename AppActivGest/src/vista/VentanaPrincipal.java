package vista;

import controlador.mysql.MysqlConsultasInicioSesion;

import javax.swing.*;
import java.awt.event.*;

public class VentanaPrincipal {

    private JComboBox comboCentrosCivicos;
    private JPanel ventanaPrincipalPanel;
    private JLabel appNameLabel;
    private JLabel groupNameLabel;
    private JButton adminButton;
    private JPasswordField passwordField1;
    private JTextField userAdminTextField;

    private VentanaCentroCivico vcc;
    private VentanaTablesAcUsEm vta;

    private String password;

    private static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("ActivGest");
        frame.setContentPane(new VentanaPrincipal().ventanaPrincipalPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public VentanaPrincipal() {

        frame.getRootPane().setDefaultButton(adminButton);

        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("icono.jpg"));
        appNameLabel.setIcon(image);
        appNameLabel.setText("");

        adminButton.setEnabled(false);

        comboCentrosCivicos.addItem("");
        comboCentrosCivicos.addItem("Ibaiondo");
        comboCentrosCivicos.addItem("Arriaga");
        comboCentrosCivicos.addItem("Iparralde");
        comboCentrosCivicos.addItem("Hegoalde");

        password = "";

        adminButton.setBorderPainted(false);
        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {

                String contrasena = new String(passwordField1.getPassword());
                String nickname = userAdminTextField.getText();
                String opcionElegida = (String) comboCentrosCivicos.getSelectedItem();

                if (opcionElegida != null || !(opcionElegida.equals(""))) {
                    MysqlConsultasInicioSesion CuentasBD = new MysqlConsultasInicioSesion();

                    if((CuentasBD.IniciarSesion(nickname, contrasena)) == true || (contrasena.equals("") && nickname.equals(""))){
                        vcc = new VentanaCentroCivico(opcionElegida);
                        frame.dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "El usuario o la contraseña es incorrecta \n (Debug) Pon una de éstas:\n  admin1, pass1\n  admin2, pass2\n  admin3, pass3\n  admin4, pass4\n", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "¡Elija Centro Cívico!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        comboCentrosCivicos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String opcionElegida = (String) comboCentrosCivicos.getSelectedItem();
                System.out.println(opcionElegida);
                adminButton.setEnabled(true);
                if (userAdminTextField.getText().equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
                    if (opcionElegida != null) {
                        vta = new VentanaTablesAcUsEm("Actividades", opcionElegida);
                    }
                } else {
                    ventanaPrincipalPanel.revalidate();
                }
            }
        });
        ventanaPrincipalPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    String contrasena = new String(passwordField1.getPassword());
                    String nickname = userAdminTextField.getText();
                    String opcionElegida = (String) comboCentrosCivicos.getSelectedItem();

                    if (opcionElegida != null || !(opcionElegida.equals(""))) {
                        MysqlConsultasInicioSesion CuentasBD = new MysqlConsultasInicioSesion();

                        if((CuentasBD.IniciarSesion(nickname, contrasena)) == true || (contrasena.equals("") && nickname.equals(""))){
                            vcc = new VentanaCentroCivico(opcionElegida);
                            frame.dispose();

                        } else {
                            JOptionPane.showMessageDialog(null, "El usuario o la contraseña es incorrecta \n (Debug) Pon una de éstas:\n  admin1, pass1\n  admin2, pass2\n  admin3, pass3\n  admin4, pass4\n", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Elija Centro Cívico!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
}

