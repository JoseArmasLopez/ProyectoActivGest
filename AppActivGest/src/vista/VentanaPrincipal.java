package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal {

    private JComboBox comboCentrosCivicos;
    private JPanel ventanaPrincipalPanel;
    private JLabel appNameLabel;
    private JLabel groupNameLabel;
    private JButton intranetButton;
    private VentanaCentroCivico vcc;

    private boolean isUser;
    private VentanaTablesAcUsEm vta;

    public VentanaPrincipal() {

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

