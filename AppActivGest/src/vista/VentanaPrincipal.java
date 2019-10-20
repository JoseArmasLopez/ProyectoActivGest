package vista;

import controlador.ControladorBbDd;
import controlador.db4o.DB4O;
import controlador.mysql.MysqlConsultas;
import controlador.mysql.MysqlConsultasInicioSesion;
import controlador.sqlite.SqliteConsulta;
import modelo.Actividad;
import modelo.Empleado;
import modelo.TablaModelo;
import modelo.Usuario;
import vista.TableModels.ActividadesTableModel;
import vista.TableModels.EmpleadosTableModel;
import vista.TableModels.UsuariosTableModel;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class VentanaPrincipal {

    private JComboBox comboCentrosCivicos;
    private JPanel ventanaPrincipalPanel;
    private JLabel appNameLabel;
    private JLabel groupNameLabel;
    private JButton adminButton;
    private JPasswordField passwordField1;
    private JTextField userAdminTextField;
    private JButton buttonUsuario;

    private VentanaCentroCivico vcc;
    private VentanaTablesAcUsEm vta;

    private static JFrame frame;
    private String opcionElegida;

    private VistaActividadesUsuario vistaActividadesUsuario;





    public static void main(String[] args) {

        frame = new JFrame("ActivGest");
        frame.setContentPane(new VentanaPrincipal().ventanaPrincipalPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("../Imagenes/icono.jpg");
        frame.setIconImage(img.getImage());
        frame.setVisible(true);

    }



    public VentanaPrincipal() {


        frame.getRootPane().setDefaultButton(adminButton);

        appNameLabel.setText("");

        adminButton.setEnabled(false);
        userAdminTextField.setEditable(false);
        passwordField1.setEditable(false);

        comboCentrosCivicos.addItem("");
        comboCentrosCivicos.addItem("Ibaiondo");
        comboCentrosCivicos.addItem("Arriaga");
        comboCentrosCivicos.addItem("Iparralde");
        comboCentrosCivicos.addItem("Hegoalde");

        adminButton.setBorderPainted(false);
        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {

                String contrasena = new String(passwordField1.getPassword());
                String nickname = userAdminTextField.getText();
                opcionElegida = (String) comboCentrosCivicos.getSelectedItem();

                if (opcionElegida != null && !(opcionElegida.equals(""))) {
                    MysqlConsultasInicioSesion CuentasBD = new MysqlConsultasInicioSesion();

                    if((CuentasBD.IniciarSesion(nickname, contrasena)) || (contrasena.equals("") && nickname.equals(""))){
                        vcc = new VentanaCentroCivico(opcionElegida);
                        ventanaPrincipalPanel.revalidate();

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
                opcionElegida = (String) comboCentrosCivicos.getSelectedItem();
                System.out.println(opcionElegida);

                adminButton.setEnabled(true);
                userAdminTextField.setEditable(true);
                passwordField1.setEditable(true);
            }
        });
        ventanaPrincipalPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    String contrasena = new String(passwordField1.getPassword());
                    String nickname = userAdminTextField.getText();
                    opcionElegida = (String) comboCentrosCivicos.getSelectedItem();

                    if (opcionElegida != null && !(opcionElegida.equals(""))) {
                        MysqlConsultasInicioSesion CuentasBD = new MysqlConsultasInicioSesion();

                        if((CuentasBD.IniciarSesion(nickname, contrasena)) || (contrasena.equals("") && nickname.equals(""))){
                            vcc = new VentanaCentroCivico(opcionElegida);
                            ventanaPrincipalPanel.revalidate();

                        } else {
                            JOptionPane.showMessageDialog(null, "El usuario o la contraseña es incorrecta \n (Debug) Pon una de éstas:\n  admin1, pass1\n  admin2, pass2\n  admin3, pass3\n  admin4, pass4\n", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Elija Centro Cívico!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        buttonUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (opcionElegida != null && !opcionElegida.equals("")) {

                    vistaActividadesUsuario = new VistaActividadesUsuario(opcionElegida);

                    //vta = new VentanaTablesAcUsEm("Actividades", opcionElegida, true);
                } else {
                    ventanaPrincipalPanel.revalidate();
                }
            }
        });
    }




}

