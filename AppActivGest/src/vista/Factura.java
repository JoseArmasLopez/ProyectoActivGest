package vista;

import controlador.ControladorBbDd;
import controlador.sqlite.SqliteConsulta;
import modelo.Actividad;
import modelo.Sesion;
import modelo.Usuario;
import org.apache.pdfbox.pdmodel.PDDocument;
import vista.TableModels.ActividadesTableModel;
import vista.TableModels.SesionesTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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




    private ArrayList<Actividad> actividades = new ArrayList<>();
    private ArrayList<Sesion> sesions = new ArrayList<>();
    private ArrayList<Actividad> actividadesAfacturar = new ArrayList<>();

    double total = 0;
    double iva = 0;

    public Factura(String cc, String dniUsuario) {

        JFrame frame = new JFrame("Factura - "+dniUsuario);

     
        frame.setContentPane(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("../Imagenes/icono.jpg");
        frame.setIconImage(img.getImage());
        frame.setBackground(new Color(0, 206, 209));
        frame.setVisible(true);

        cargarUsuariosActividadesEmpleadosSqliteHegoalde(cc,dniUsuario);

        for (Sesion s:sesions) {


            ControladorBbDd controladorBbDd = new ControladorBbDd(cc);
            SqliteConsulta sqliteConsulta = new SqliteConsulta(controladorBbDd.getConexion());

            Actividad actividadAFacturar = sqliteConsulta.actividadesHegoaldeSqlitePorNumActividad(s.getIDActividad());

            actividadesAfacturar.add(actividadAFacturar);

        }

        for (Actividad a:actividadesAfacturar
             ) {

            double c = a.getCoste();
            total = total + c;

        }

        iva = total *0.21;

        double subtotal = total -iva;

        textField1.setText(dniUsuario);

        Date d = new Date();

        textField2.setText(d.toString());
        textField3.setText("Factura Nº 3");

        textField4.setText(Double.toString(subtotal));
        textField5.setText(Double.toString(iva));
        textField6.setText(Double.toString(total));



        table1.setModel(new ActividadesTableModel(actividadesAfacturar));



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

    public void cargarUsuariosActividadesEmpleadosSqliteHegoalde(String cc, String dni) {


        ControladorBbDd controladorBbDd = new ControladorBbDd(cc);
        SqliteConsulta sqliteConsulta = new SqliteConsulta(controladorBbDd.getConexion());

        sqliteConsulta.sesionesdeHegoaldeDeUnUsuario(dni);




        sesions = sqliteConsulta.getSesiones();





    }


}
