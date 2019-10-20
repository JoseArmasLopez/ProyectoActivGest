package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCentroCivico {
    private JPanel ventanaCCJpanel;
    private JButton empleButton;
    private JButton usersButton;
    private JButton activButton;
    private JButton metadatosButton;
    private JLabel nombreCCJlabel;
    private JLabel direJlabel;
    private JLabel telfJlabel;
    private JLabel munipJlabel;
    private JButton atrasButton;
    private JButton sesionesButton;

    private VentanaTablesAcUsEm tablesAcUsEm;
    private VentanaMetadata vmtd;

    private VentanaSesiones ventanaSesiones;

    public VentanaCentroCivico(String centroCivico) {

        JFrame frame = new JFrame("ActivGest - " + centroCivico);
        frame.setContentPane(ventanaCCJpanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("../Imagenes/icono.jpg");
        frame.setIconImage(img.getImage());
        ventanaCCJpanel.setBackground(new Color(135, 206, 235));
        frame.setVisible(true);

        switch (centroCivico.toLowerCase()){
            case "arriaga":
                nombreCCJlabel.setText("CC. Arriaga");
                direJlabel.setText("Fco. Javier de Landaburu 9");
                telfJlabel.setText("945 16 16 16");
                munipJlabel.setText("Vitoria - Gasteiz");
                break;
            case "iparralde":
                nombreCCJlabel.setText("CC. Iparralde");
                direJlabel.setText("Zuberoa Pza 1");
                telfJlabel.setText("945 16 17 50");
                munipJlabel.setText("Vitoria - Gasteiz");
                break;
            case "hegoalde":
                nombreCCJlabel.setText("CC. Hegoalde");
                direJlabel.setText("Alberto Schommer 10");
                telfJlabel.setText("945 16 18 80");
                munipJlabel.setText("Vitoria - Gasteiz");
                break;
            case "ibaiondo":
                nombreCCJlabel.setText("CC. Ibaiondo");
                direJlabel.setText("Calle Ibaiondo 10");
                telfJlabel.setText("945 16 18 80");
                munipJlabel.setText("Vitoria - Gasteiz");
                break;
        }

        empleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tablesAcUsEm = new VentanaTablesAcUsEm("Empleados", centroCivico, false);
            }
        });

        usersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tablesAcUsEm = new VentanaTablesAcUsEm("Usuarios", centroCivico, false);
            }
        });

        activButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tablesAcUsEm = new VentanaTablesAcUsEm("Actividades", centroCivico, false);
            }
        });

        metadatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nomBBDD = "";
                switch (centroCivico.toLowerCase()){
                    case "arriaga":
                        nomBBDD = "MySQL";
                        break;
                    case "iparralde":
                        nomBBDD = "DB4O";
                        break;
                    case "hegoalde":
                        nomBBDD = "SQLite";
                        break;
                }
                vmtd = new VentanaMetadata(nomBBDD, centroCivico);
            }
        });

        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });

        sesionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ventanaSesiones = new VentanaSesiones(centroCivico);
            }
        });
    }
}
