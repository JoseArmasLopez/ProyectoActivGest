package vista;

import controlador.ControladorBbDd;
import controlador.db4o.DB4O;
import controlador.mysql.MysqlConsultas;
import controlador.sqlite.SqliteConsulta;
import modelo.Actividad;
import modelo.Empleado;
import modelo.TablaModelo;
import modelo.Usuario;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import vista.TableModels.ActividadesTableModel;
import vista.TableModels.EmpleadosTableModel;
import vista.TableModels.UsuariosTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VistaActividadesUsuario {
    private JPanel panelPrincipal;
    private JButton buttonAtrás;
    private JButton buttonImprimirImpreso;
    private JScrollPane scrollPane;
    private JTable table1;
    private final static Logger LOGGER = Logger.getLogger("mx.hash.impresionpdf.Impresor");

    private java.util.List<Actividad> actividades;    // -> ¡CARGAR DESDE BASES DE DATOS!
    private java.util.List<Usuario> usuarios;     // -> ¡CARGAR DESDE BASES DE DATOS!
    private List<Empleado> empleados;   // -> ¡CARGAR DESDE BASES DE DATOS!

    private TablaModelo tablaModelo;


    public VistaActividadesUsuario(String cc) {

        JFrame frame = new JFrame("ActivGest - Actividades " + cc);
        frame.setContentPane(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        switch (cc) {

            case ("Hegoalde"):

                cargarUsuariosActividadesEmpleadosSqliteHegoalde(cc);
                cargarDatosEnTabla();

                break;
            case ("Iparralde"):

                iparraldeDbo4CargarUsuariosActividades();
                cargarDatosEnTabla();
                break;

            case ("Arriaga"):

                CargarUsuariosActividadesEmpleadosMySQLArriaga();
                cargarDatosEnTabla();

                break;

            case ("Ibaiondo"):

                cargarUsuariosActividadesEmpleadosSqliteHegoalde(cc);
                cargarDatosEnTabla();
                break;
        }

        buttonAtrás.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                frame.dispose();

            }
        });
        buttonImprimirImpreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {
                    imprimir();
                } catch (PrinterException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }



    public void imprimir() throws PrinterException, IOException {
        // Indicamos el nombre del archivo Pdf que deseamos imprimir
        PDDocument document = PDDocument.load(new File("FormularioInscripcion.pdf"));

        //muestro en pdf el documento generado
        try {
            File path = new File ("FormularioInscripcion.pdf");
            Desktop.getDesktop().open(path);
        }catch (IOException ex) {
            ex.printStackTrace();
        }

        PrinterJob job = PrinterJob.getPrinterJob();

        LOGGER.log(Level.INFO, "Mostrando el dialogo de impresion");
        if (job.printDialog() == true) {
            job.setPageable(new PDFPageable(document));

            LOGGER.log(Level.INFO, "Imprimiendo documento");
            job.print();
        }
    }

    private void cargarDatosEnTabla() {

        if (actividades != null) {
            table1.setModel(new ActividadesTableModel(actividades));
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "List actividades vacío!");
        }


    }

    // funcion que devuelve los datos de la bd a usuarios, actividades, empleados tanto de hegoalde como de ibaiondo
    public void cargarUsuariosActividadesEmpleadosSqliteHegoalde(String cc) {


        ControladorBbDd controladorBbDd = new ControladorBbDd(cc);
        SqliteConsulta sqliteConsulta = new SqliteConsulta(controladorBbDd.getConexion());

        sqliteConsulta.actividadesHegoaldeSqlite();
        sqliteConsulta.empleadosHegoaldeSqlite();
        sqliteConsulta.usuariosHegoaldeSqlite();

        actividades = sqliteConsulta.getActividades();
        empleados = sqliteConsulta.getEmpleados();
        usuarios = sqliteConsulta.getUsuarios();



    }

    public void CargarUsuariosActividadesEmpleadosMySQLArriaga() {

        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/actigest", "root", "");

        } catch (Exception e) {
            System.err.println("No se ha podido conectar a la base de datos Arriaga\n" + e.getMessage());
        }

        MysqlConsultas mysqlConsultas = new MysqlConsultas(con);
        empleados = mysqlConsultas.LeerEmpleadosArriaga();
        usuarios = mysqlConsultas.LeerUsuariosArriaga();
        actividades = mysqlConsultas.LeerActividadesArriaga();

    }

    public void iparraldeDbo4CargarUsuariosActividades(){

        DB4O db4O = new DB4O();
        this.actividades = db4O.obtenerActividades();
        this.usuarios = db4O.obtenerUsuarios();
        this.empleados = db4O.obtenerEmpleados();


    }
}
