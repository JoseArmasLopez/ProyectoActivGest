package vista;

import controlador.ControladorBbDd;
import controlador.db4o.DB4O;
import controlador.mysql.MysqlConsultas;
import controlador.sqlite.SqliteConsulta;
import modelo.Sesion;
import vista.TableModels.SesionesTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class VentanaSesiones {

    private JPanel ventanaSesionesJpanel;
    private JButton atrasButton;
    private JButton buttonEditar;
    private JScrollPane panelScroll;
    private JTable table1;

    private VentanaCRUD_AcUsEm crud_acUsEm;

    private ArrayList<Sesion> sesiones = new ArrayList<Sesion>(); // -> ¡CARGAR DESDE BASES DE DATOS!

    public VentanaSesiones(String cc) {

        JFrame frame = new JFrame("Sesiones "  + cc);
        frame.setContentPane(ventanaSesionesJpanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("../Imagenes/icono.jpg");
        frame.setIconImage(img.getImage());
        ventanaSesionesJpanel.setBackground(new Color(135, 206, 235));
        frame.setVisible(true);

        switch (cc){

            case "Hegoalde":

                cargarSesiones(cc);
                cargarDatosEnTabla(this.sesiones);

                break;
            case "Arriaga":

                Connection con = null;
                try {

                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/actigest", "root", "");

                } catch (Exception e) {
                    System.err.println("No se ha podido conectar a la base de datos Arriaga\n" + e.getMessage());
                }
                MysqlConsultas mysqlConsultas = new MysqlConsultas(con);

                sesiones = mysqlConsultas.LeerSesionesArriaga();


                cargarDatosEnTabla(sesiones);


                break;
            case "Ibaiondo":

                cargarSesiones(cc);
                cargarDatosEnTabla(this.sesiones);

                break;

            case "Iparralde":


                cargarSesionesIparralde();
                cargarDatosEnTabla(this.sesiones);

                break;


        }

        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });

        buttonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                crud_acUsEm = new VentanaCRUD_AcUsEm("sesiones", cc);

            }
        });

    }

    public void cargarDatosEnTabla(List<Sesion>sesionList){
        table1.setModel(new SesionesTableModel(sesionList));


    }

    // funcion que devuelve los datos de la bd a usuarios, actividades, empleados tanto de hegoalde como de ibaiondo
    public void cargarSesiones(String cc) {


        ControladorBbDd controladorBbDd = new ControladorBbDd(cc);
        SqliteConsulta sqliteConsulta = new SqliteConsulta(controladorBbDd.getConexion());

        sqliteConsulta.sesionesdeHegoalde();

        this.sesiones = sqliteConsulta.getSesiones();


    }

    public void cargarSesionesIparralde(){

        DB4O db4o = new DB4O();

        sesiones = db4o.obtenerSesiones();

    }
}
