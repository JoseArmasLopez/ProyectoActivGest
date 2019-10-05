package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaTablasBBDD {
    private JPanel ventanaTablasBBDDJpanel;
    private JLabel tablasLabel;
    private JTable tableTablasBD;
    private JButton buttonAtras;

    public VentanaTablasBBDD(String nombBBDD, String cc) {

        JFrame frame = new JFrame(nombBBDD + " " + cc);
        frame.setContentPane(ventanaTablasBBDDJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        buttonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });
    }
}
