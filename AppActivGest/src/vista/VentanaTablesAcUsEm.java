package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaTablesAcUsEm {
    private JPanel ventanaTablesAcUsEmJpanel;
    private JTable tableAcUsEm;
    private JButton nuevaButton;
    private JButton atrasButton;

    private VentanaCRUD_AcUsEm crud_acUsEm;

    public VentanaTablesAcUsEm(String tipo, String cc) {

        JFrame frame = new JFrame(tipo + " " + cc);
        frame.setContentPane(ventanaTablesAcUsEmJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);




        nuevaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                crud_acUsEm = new VentanaCRUD_AcUsEm(tipo, "---", cc);


            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });
    }
}
