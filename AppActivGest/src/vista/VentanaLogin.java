package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLogin {

    private JTextField txtUsuario;
    private JButton botonCancelar;
    private JButton botonIniciarSesion;
    private JPasswordField txtPassword;
    private JPanel ventanaLoginJpanel;
    private JComboBox comboBoxUserAdmin;

    private boolean isAdmin;
    private VentanaPrincipal vp;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ActivGest - Login");
        frame.setContentPane(new VentanaLogin().ventanaLoginJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public VentanaLogin() {

        isAdmin = false;

        comboBoxUserAdmin.addItem("");
        comboBoxUserAdmin.addItem("Usuario");
        comboBoxUserAdmin.addItem("Administrador");

        botonIniciarSesion.setBorderPainted(false);
        botonIniciarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {

                if (isAdmin) {
                    String usuario = "administrador";
                    String contrasena = "administrador";

                    String password = new String(txtPassword.getPassword());

                    if (txtUsuario.getText().equals(usuario) && password.equals(contrasena)) {
                        vp = new VentanaPrincipal();

                    } else {

                        if (!txtUsuario.getText().equals(usuario)) {
                            JOptionPane.showMessageDialog(null, "El usuario es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                        } else if (!password.equals(contrasena)) {
                            JOptionPane.showMessageDialog(null, "La contraseña es incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    vp.setUser(true);
                    vp = new VentanaPrincipal();
                }
            }
        });


        // TODO diseño botones (iconos)
        // botonInicioSesion.setIcon(new ImagenIcon(getClass().getResource("../");


        comboBoxUserAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String opcionElegida = (String) comboBoxUserAdmin.getSelectedItem();
                if (opcionElegida != null) {
                    if (opcionElegida.equals("Administrador")) ;
                    isAdmin = true;
                } else {
                    ventanaLoginJpanel.revalidate();
                }
            }
        });
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            }
        });
    }


}
