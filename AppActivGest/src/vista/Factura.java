package vista;

import modelo.Usuario;
import org.apache.pdfbox.pdmodel.PDDocument;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Factura {

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTable table1;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JScrollPane scrollPane;
    private JPanel panelPrincipal;
    private JButton buttonFacturar;
    private JButton atrásButton;

    private ArrayList<Usuario> usuarioArrayList;

    public Factura() {

        JFrame frame = new JFrame("Factura - ");

        frame.setContentPane(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("../Imagenes/icono.jpg");
        frame.setIconImage(img.getImage());
        frame.setBackground(new Color(0, 206, 209));
        frame.setVisible(true);

        ArrayList<Usuario> arrayListUsuarios = new ArrayList<>();

        atrásButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                frame.dispose();

            }
        });

        buttonFacturar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"La factura se ha faturado correctamente");
            }
        });

    }


}
