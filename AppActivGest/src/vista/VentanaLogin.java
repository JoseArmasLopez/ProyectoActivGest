package vista;

import controlador.mysql.MysqlConsultasInicioSesion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaLogin {

    private JTextField txtUsuario;
    private JButton botonCancelar;
    private JButton botonIniciarSesion;
    private JPasswordField txtPassword;
    private JPanel ventanaLoginJpanel;
    private JComboBox comboBoxUserAdmin;

    private boolean isAdmin;
    private VentanaPrincipal vp;
    private static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("ActivGest - Login");
        frame.setContentPane(new VentanaLogin().ventanaLoginJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public VentanaLogin() {

        isAdmin = false;
        frame.getRootPane().setDefaultButton(botonIniciarSesion);

        comboBoxUserAdmin.addItem("");
        comboBoxUserAdmin.addItem("Usuario");
        comboBoxUserAdmin.addItem("Administrador");

        //NUEVO Éste código es para que empezar como usuario de manera predeterminada.
        comboBoxUserAdmin.setSelectedIndex(1);
        txtUsuario.setEditable(false);
        txtPassword.setEditable(false);

        botonIniciarSesion.setBorderPainted(false);

        botonIniciarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {

                if (isAdmin) {

                    String contrasena = new String(txtPassword.getPassword());
                    String nickname = txtUsuario.getText();

                    MysqlConsultasInicioSesion CuentasBD = new MysqlConsultasInicioSesion();

                    if((CuentasBD.IniciarSesion(nickname, contrasena)) == true || (contrasena.equals("") && nickname.equals(""))){
                        vp = new VentanaPrincipal();
                        frame.dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "El usuario o la contraseña es incorrecta \n (Debug) Pon una de éstas:\n  admin1, pass1\n  admin2, pass2\n  admin3, pass3\n  admin4, pass4\n", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    vp = new VentanaPrincipal();
                    vp.setUser(true);
                    frame.dispose();
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
                    if (opcionElegida.equals("Administrador")){
                        txtUsuario.setEditable(true);
                        txtPassword.setEditable(true);
                        isAdmin = true;
                    } else if (opcionElegida.equals("Usuario")) {
                        txtUsuario.setEditable(false);
                        txtPassword.setEditable(false);
                    }
                } else {
                    ventanaLoginJpanel.revalidate();
                }
            }
        });

        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(-1);
            }
        });
        ventanaLoginJpanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    if (isAdmin) {

                        String contrasena = new String(txtPassword.getPassword());
                        String nickname = txtUsuario.getText();

                        MysqlConsultasInicioSesion CuentasBD = new MysqlConsultasInicioSesion();

                        if((CuentasBD.IniciarSesion(nickname, contrasena)) == true || (contrasena.equals("") && nickname.equals(""))){
                            vp = new VentanaPrincipal();
                            frame.dispose();

                        } else {
                            JOptionPane.showMessageDialog(null, "El usuario o la contraseña es incorrecta \n (Debug) Pon una de éstas:\n  admin1, pass1\n  admin2, pass2\n  admin3, pass3\n  admin4, pass4\n", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        vp = new VentanaPrincipal();
                        vp.setUser(true);
                        frame.dispose();
                    }
                }
            }
        });
    }



}
