package controlador.sqlite;

import modelo.Actividad;
import modelo.Empleado;
import modelo.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class SqliteConsulta {

    // Atributos
    private Connection connection = null;
    private ArrayList<Actividad> actividades = new ArrayList<Actividad>();
    private ArrayList<Empleado> empleados;
    private ArrayList<Usuario> usuarios;
    private Statement stmt = null;

    // Seccion constructor
    public SqliteConsulta(Connection connection) {
        this.connection = connection;
    }

    // seccion funciones --------------------------->>>

    // funcion que devuelve todas las acctividades existentes
    public void actividadesHegoaldeSqlite() {

        try {

            System.out.println("Base de datos abierta con éxito");

            // preparo la conexion y la ejecucion de la consulta
            stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT numactividad, nombre,numeromaximoinvitado," +
                    "nombresala, coste, fecha, horario FROM actividades");

            // accedo a las columnas de la tabla
            while (rs.next()) {

                String id = rs.getString("numactividad");
                String name = rs.getString("nombre");
                int numeromaxinvit = rs.getInt("numeromaximoinvitado");
                String nombresal = rs.getString("nombresala");
                double coste = rs.getDouble("coste");
                Date fech = rs.getDate("fecha");
                String hor = rs.getString("horario");

                Actividad actividad = new Actividad(id, name, numeromaxinvit, nombresal, coste, fech, hor);

                this.actividades.add(actividad);

            }

            rs.close();
            stmt.close();


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operación realizada con éxito");

    }

    // funcion que da valor al atributo usuarios con los usuarios de una actividad concreta
    public void usuariosHegoaldeSqliteDeActividad(String idActividad) {

        this.empleados = new ArrayList<Empleado>();

        try {

            System.out.println("Base de datos abierta con éxito");

            // preparo la conexion y la ejecucion de la consulta
            stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios WHERE idactividad = "+ idActividad);

            // accedo a las columnas de la tabla
            while (rs.next()) {

                String dni = rs.getString("dni");
                String name = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                int edad = rs.getInt("edad");

                Usuario usuario = new Usuario(dni, name, apellido1, apellido2,edad);

                this.usuarios.add(usuario);

            }

            rs.close();
            stmt.close();


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operación realizada con éxito");

    }

    // funcion que da valor al atributo usuarios con los usuarios de una actividad concreta
    public void empleadosHegoaldeSqliteDeActividad(String dniempleado) {

        this.empleados = new ArrayList<Empleado>();

        try {

            System.out.println("Base de datos abierta con éxito");

            // preparo la conexion y la ejecucion de la consulta
            stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM empleados WHERE idactividad = "+ dniempleado);

            // accedo a las columnas de la tabla
            while (rs.next()) {

                String dni = rs.getString("dni");
                String name = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                int edad = rs.getInt("edad");

                Usuario usuario = new Usuario(dni, name, apellido1, apellido2,edad);

                this.usuarios.add(usuario);

            }

            rs.close();
            stmt.close();


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operación realizada con éxito");

    }

    // Seccion getters
    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public  void tablaMostrar(ArrayList<Actividad> acti){



        DefaultTableModel modelo = new DefaultTableModel();
        JTable tabla = new JTable(modelo);

        //creo 3 columnas con sus etiquetas
        //estas son las columnas del JTable
        modelo.addColumn("CODIGO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("MAXIMO");
        modelo.addColumn("SALA");
        modelo.addColumn("COSTE");
        modelo.addColumn("FECHA");
        modelo.addColumn("HORARIO");


        for (Actividad act:acti
        ) {

            Object [] datos=new Object[7];//Crea un vector

            //para almacenar los valores del ResultSet
            datos[0]=act.getNumactividad();
            datos[1]=act.getNombre();
            datos[2]=act.getNumeromaxinvitado();
            datos[3]=act.getNombresala();
            datos[4]=act.getCoste();
            datos[5]=act.getFecha();
            datos[6]=act.getHorario();

            //añado el modelo a la tabla
            modelo.addRow(datos);

            System.out.print("hola"+act.getNombre().toString());

        }



        // datos=null;//limpia los datos de el vector de la memoria



        JFrame f = new JFrame();
        f.setBounds(10, 10, 300, 200);
        f.getContentPane().add(new JScrollPane(tabla));
        f.setVisible(true);
    }


}
