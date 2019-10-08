package vista;

import com.db4o.Db4o;
import controlador.ControladorBbDd;
import controlador.mysql.MysqlConsultas;
import controlador.sqlite.SqliteConsulta;
import modelo.Actividad;
import modelo.Empleado;
import modelo.TablaModelo;
import modelo.Usuario;
import vista.TableModels.ActividadesTableModel;
import vista.TableModels.EmpleadosTableModel;
import vista.TableModels.UsuariosTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class VentanaTablesAcUsEm  {

    private JPanel ventanaTablesAcUsEmJpanel;
    private JTable tableAcUsEm;
    private JButton nuevaButton;
    private JButton atrasButton;
    private JScrollPane scrollPane;//importante tener un scrollPane para ver bien las tablas

    private VentanaCRUD_AcUsEm crud_acUsEm;

    private List<Actividad> actividades;    // -> ¡CARGAR DESDE BASES DE DATOS!
    private List<Usuario> usuarios;     // -> ¡CARGAR DESDE BASES DE DATOS!
    private List<Empleado> empleados;   // -> ¡CARGAR DESDE BASES DE DATOS!

    private TablaModelo tablaModelo;


    public VentanaTablesAcUsEm(String tipo, String cc) {

        JFrame frame = new JFrame(tipo + " " + cc);
        frame.setContentPane(ventanaTablesAcUsEmJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        switch (cc){

            case("Hegoalde"):

                cargarUsuariosActividadesEmpleadosSqliteHegoalde(cc);
                cargarDatosEnTabla(tipo);

                break;
            case("Iparralde"):


                cargarUsuariosActividadesEmpleadosDB4OIparralde(cc);
                cargarDatosEnTabla(tipo);

                break;

            case("Arriaga"):
                CargarUsuariosActividadesEmpleadosMySQLArriaga();
                cargarDatosEnTabla(tipo);

                break;
        }





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

    public void cargarDatosEnTabla(String tipo){
        switch (tipo){
            case "Actividades":
                if(actividades.size() > 0){
                    tableAcUsEm.setModel(new ActividadesTableModel(actividades));
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "List actividades vacío!");
                }
                break;
            case "Usuarios":
                if(usuarios.size() > 0){
                    tableAcUsEm.setModel(new UsuariosTableModel(usuarios));
                }else {
                    javax.swing.JOptionPane.showMessageDialog(null, "List usuario vacío!");
                }
                break;
            case "Empleados":
                if(empleados.size() > 0){
                    tableAcUsEm.setModel(new EmpleadosTableModel(empleados));
                }else {
                    javax.swing.JOptionPane.showMessageDialog(null, "List empleados vacío!");
                }
                break;
        }
    }

    // funcion que devuelve los datos de la bd a usuarios, actividades, empleados
    public void cargarUsuariosActividadesEmpleadosSqliteHegoalde(String cc){

        ControladorBbDd controladorBbDd = new ControladorBbDd(cc);
        SqliteConsulta sqliteConsulta = new SqliteConsulta(controladorBbDd.getConexion());

        sqliteConsulta.actividadesHegoaldeSqlite();
        sqliteConsulta.empleadosHegoaldeSqlite();
        sqliteConsulta.usuariosHegoaldeSqlite();

        actividades = sqliteConsulta.getActividades();
        empleados = sqliteConsulta.getEmpleados();
        usuarios = sqliteConsulta.getUsuarios();



    }


    public void CargarUsuariosActividadesEmpleadosMySQLArriaga(){

        Connection con = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/actigest", "root", "");

        }catch (Exception e) {
            System.err.println("No se ha podido conectar a la base de datos Arriaga\n"+e.getMessage());
        }

        MysqlConsultas  mysqlConsultas = new MysqlConsultas(con);
        empleados = mysqlConsultas.LeerEmpleadosArriaga();
        usuarios = mysqlConsultas.LeerUsuariosArriaga();
        actividades = mysqlConsultas.LeerActividadesArriaga();

    }

    public void cargarUsuariosActividadesEmpleadosDB4OIparralde(String cc){

    



    }
}
