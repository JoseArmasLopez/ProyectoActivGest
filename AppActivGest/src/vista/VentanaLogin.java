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


    public VentanaLogin() {

            botonIniciarSesion = new JButton("");
            botonIniciarSesion.setBorderPainted(false);
            botonIniciarSesion.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evento) {

                    String usuario = "administrador";
                    String contrasena = "administrador";

                    String password = new String(txtPassword.getPassword());

                    if (txtUsuario.getText().equals(usuario) && password.equals(contrasena)) {

                        // TODO Mostrar ventana

                    }else {

                        if(!txtUsuario.getText().equals(usuario)) {
                            JOptionPane.showMessageDialog(null, "El usuario es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                        }else if(!password.equals(contrasena)){
                            JOptionPane.showMessageDialog(null, "La contraseña es incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });




            // TODO diseño botones (iconos)
            // botonInicioSesion.setIcon(new ImagenIcon(getClass().getResource("../");




        }


}
