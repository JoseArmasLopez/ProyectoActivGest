package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal {

    private JComboBox comboCentrosCivicos;
    private JPanel ventanaPrincipalPanel;
    private JLabel appNameLabel;
    private JLabel groupNameLabel;
    private JButton entrarButton;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private VentanaCentroCivico vcc;

    private boolean isUser;
    private VentanaTablesAcUsEm vta;

    private boolean isAdmin;

    public VentanaPrincipal() {

        isAdmin = false;
        JFrame frame = new JFrame("ActivGest - Elegir CC");
        frame.setContentPane(ventanaPrincipalPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        comboCentrosCivicos.addItem("");
        comboCentrosCivicos.addItem("Ibaiondo");
        comboCentrosCivicos.addItem("Arriaga");
        comboCentrosCivicos.addItem("Iparralde");
        comboCentrosCivicos.addItem("Hegoalde");

        entrarButton.setBorderPainted(false);
        entrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {

                if (isAdmin) {
                    String usuario = "administrador";
                    String contrasena = "administrador";

                    String password = new String(passwordField1.getPassword());

                    if (textField1.getText().equals(usuario) && password.equals(contrasena)) {
                        // TODO Ventana CC


                    } else {

                        if (!textField1.getText().equals(usuario)) {
                            JOptionPane.showMessageDialog(null, "El usuario es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                        } else if (!password.equals(contrasena)) {
                            JOptionPane.showMessageDialog(null, "La contraseña es incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {

                }
            }
        });
        comboCentrosCivicos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String opcionElegida = (String) comboCentrosCivicos.getSelectedItem();
                System.out.println(opcionElegida);
                if(opcionElegida != null){
                    if(!isUser){
                        vcc = new VentanaCentroCivico(opcionElegida); //TODO: IMPLEMENTAR CON LOGIN USUARIO
                    } else {
                        vta = new VentanaTablesAcUsEm("Actividades", opcionElegida);
                    }
                } else {
                    ventanaPrincipalPanel.revalidate();
                }
            }
        });

        }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }
}

