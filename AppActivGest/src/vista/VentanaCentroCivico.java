package vista;

import javax.swing.*;
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

    public VentanaCentroCivico(String centroCivico) {

        JFrame frame = new JFrame("ActivGest - " + centroCivico);
        frame.setContentPane(ventanaCCJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
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
        }

        empleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        usersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        activButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        metadatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}
