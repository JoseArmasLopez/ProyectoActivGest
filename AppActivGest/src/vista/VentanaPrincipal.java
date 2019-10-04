package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal {
    private JComboBox comboCentrosCivicos;
    private JPanel ventanaPrincipalPanel;
    private JLabel appNameLabel;
    private JLabel groupNameLabel;
    private VentanaCentroCivico vcc;

    public static void main(String[] args) {

        JFrame frame = new JFrame("ActivGest - Inicio");
        frame.setContentPane(new VentanaPrincipal().ventanaPrincipalPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public VentanaPrincipal() {

        comboCentrosCivicos.addItem("");
        comboCentrosCivicos.addItem("Arriaga");
        comboCentrosCivicos.addItem("Iparralde");
        comboCentrosCivicos.addItem("Hegoalde");

        comboCentrosCivicos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String opcionElegida = (String) comboCentrosCivicos.getSelectedItem();
                System.out.println(opcionElegida);
                if(opcionElegida != null){
                    vcc = new VentanaCentroCivico(opcionElegida);
                } else {
                    ventanaPrincipalPanel.revalidate();
                }

            }
        });
    }
}
