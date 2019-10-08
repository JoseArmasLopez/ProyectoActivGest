package vista;

import controlador.ControladorBbDd;
import controlador.sqlite.SqliteConsulta;
import modelo.Actividad;
import modelo.Empleado;
import modelo.TablaModelo;
import modelo.Usuario;
import vista.TableModels.ActividadesTableModel;
import vista.TableModels.EmpleadosTableModel;
import vista.TableModels.UsuariosTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class VentanaTablesAcUsEm {

    private JPanel ventanaTablesAcUsEmJpanel;
    private JTable tableAcUsEm;
    private JButton nuevaButton;
    private JButton atrasButton;
    private JScrollPane scrollPane; //importante tener un scrollPane para ver bien las tablas

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

        cargarDatosEjemplo(tipo);

        switch (cc) {

            case ("Hegoalde"):

                cargarUsuariosActividadesEmpleadosSqliteHegoalde(cc);
                cargarDatosEnTabla(tipo);

                break;
            case ("Iparralde"):

                //Crear una función dentro de esta clase para cargar los datos desde DB4O (Sheila)
                // -> Ver ejemplo más arriba en Hegoalde (Jose)
                cargarDatosEnTabla(tipo);

                break;
            case ("Ibaiondo"):

                //Crear una función dentro de esta clase para cargar los datos desde postgreESQL (?)
                // -> Ver ejemplo más arriba en Hegoalde (Jose)
                cargarDatosEnTabla(tipo);

                break;
            case ("Arriaga"):

                //Crear una función dentro de esta clase para cargar los datos desde mysql (Erick)
                // -> Ver ejemplo más arriba en Hegoalde (Jose)
                cargarDatosEnTabla(tipo);

                break;
        }

        nuevaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                crud_acUsEm = new VentanaCRUD_AcUsEm(tipo, cc, null);


            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });


        tableAcUsEm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String clave = "";
                switch (tipo) {
                    case "Actividades":
                        clave = (String) tableAcUsEm.getModel().getValueAt(tableAcUsEm.getSelectedRow(), 0);
                        for (Actividad actividad : actividades) {
                            if (actividad.getNumactividad().equalsIgnoreCase(clave)) {
                                crud_acUsEm = new VentanaCRUD_AcUsEm(tipo, cc, actividad);
                            }
                        }
                        break;
                    case "Usuarios":
                        clave = (String) tableAcUsEm.getModel().getValueAt(tableAcUsEm.getSelectedRow(), 0);
                        for (Usuario usuario : usuarios) {
                            if (usuario.getDni().equalsIgnoreCase(clave)) {
                                crud_acUsEm = new VentanaCRUD_AcUsEm(tipo, cc, usuario);
                            }
                        }
                        break;
                    case "Empleados":
                        clave = (String) tableAcUsEm.getModel().getValueAt(tableAcUsEm.getSelectedRow(), 0);
                        for (Empleado empleado : empleados) {
                            if (empleado.getDni().equalsIgnoreCase(clave)) {
                                crud_acUsEm = new VentanaCRUD_AcUsEm(tipo, cc, empleado);
                            }
                        }
                        break;
                }

            }
        });
    }

    private void cargarDatosEnTabla(String tipo) {
        switch (tipo) {
            case "Actividades":
                if (actividades != null) {
                    tableAcUsEm.setModel(new ActividadesTableModel(actividades));
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "List actividades vacío!");
                }
                break;
            case "Usuarios":
                if (usuarios != null) {
                    tableAcUsEm.setModel(new UsuariosTableModel(usuarios));
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "List usuario vacío!");
                }
                break;
            case "Empleados":
                if (empleados != null) {
                    tableAcUsEm.setModel(new EmpleadosTableModel(empleados));
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "List empleados vacío!");
                }
                break;
        }
    }

    // funcion que devuelve los datos de la bd a usuarios, actividades, empleados
    private void cargarUsuariosActividadesEmpleadosSqliteHegoalde(String cc) {

        ControladorBbDd controladorBbDd = new ControladorBbDd(cc);
        SqliteConsulta sqliteConsulta = new SqliteConsulta(controladorBbDd.getConexion());

        sqliteConsulta.actividadesHegoaldeSqlite();
        sqliteConsulta.empleadosHegoaldeSqlite();
        sqliteConsulta.usuariosHegoaldeSqlite();

        actividades = sqliteConsulta.getActividades();
        empleados = sqliteConsulta.getEmpleados();
        usuarios = sqliteConsulta.getUsuarios();


    }

    private void cargarDatosEjemplo(String tipo) {
        switch (tipo) {
            case "Actividades":
                actividades = new ArrayList<>();
                actividades.add(new Actividad("1", "Aquagym", 10, "gimnasia", "2019-2020", 50.0));
                actividades.add(new Actividad("2", "Patinaje", 15, "cancha", "2019-2020", 15.0));
                actividades.add(new Actividad("3", "Padel", 10, "pista", "2019-2020", 35.50));
                actividades.add(new Actividad("4", "Aerobic", 10, "sala2", "2019-2020", 26.50));
                break;
            case "Usuarios":
                usuarios = new ArrayList<>();
                usuarios.add(new Usuario("73245456", "Pedro", "Uriondo", "Rodriguez", 40, "profesor"));
                usuarios.add(new Usuario("71239390", "Lucas", "Delgado", "Mendez", 30, "camarero"));
                usuarios.add(new Usuario("72459880", "Jokin", "Urkiza", "Echebarria", 52, "mecanico"));
                usuarios.add(new Usuario("73245486", "Alvaro", "Garcia", "Martinez", 25, "informatico"));

                break;
            case "Empleados":
                empleados = new ArrayList<>();
                empleados.add(new Empleado("72737475", "Pablo", "Lopez", "Garcia", "01/02/1980", "02/03/2014", "oficial de control", "venezolana"));
                empleados.add(new Empleado("72737476", "Idoia", "Martinez", "Guinea", "12/06/1990", "06/10/2018", "socorrista", "española"));
                empleados.add(new Empleado("72737477", "Marta", "Basterra", "Imaz", "15/08/1983", "15/07/2013", "conserje", "española"));
                empleados.add(new Empleado("72737478", "Mikel", "Insagurbe", "Perez", "18/10/1975", "05/01/2000", "monitor", "española"));
                break;
        }
    }
}
