package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLogin {


    private JTextField txtUsuario;
    private JButton botonCancelar;
    private JButton botonIniciarSesion;
    private JPasswordField txtPassword;
    private JPanel panel;


    public VentanaLogin() {

        // Poner icono ventana
        Image icon = new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage();

        panel.setBackground(Color.cyan);

        JFrame frame = new JFrame("ActivGest - " + "Intranet");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        botonIniciarSesion = new JButton("");
        botonIniciarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {

                String usuario = "administrador";
                String contrasena = "administrador";

                String password = new String(txtPassword.getPassword());

                if (txtUsuario.getText().equals(usuario) && password.equals(contrasena)) {


                    // TODO Mostrar ventana

                } else {

                    if (!txtUsuario.getText().equals(usuario)) {
                        JOptionPane.showMessageDialog(null, "El usuario es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (!password.equals(contrasena)) {
                        JOptionPane.showMessageDialog(null, "La contraseña es incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });




        // TODO diseño botones (iconos)
        // botonInicioSesion.setIcon(new ImagenIcon(getClass().getResource("../");


    }


}
