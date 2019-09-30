package controlador.sqlite;

import modelo.Actividad;
import modelo.Empleado;
import modelo.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
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
                    "nombresala, coste, fecha, horario, dniempleado FROM actividades");

            // accedo a las columnas de la tabla
            while (rs.next()) {

                String id = rs.getString("numactividad");
                String name = rs.getString("nombre");
                int numeromaxinvit = rs.getInt("numeromaximoinvitado");
                String nombresal = rs.getString("nombresala");
                double coste = rs.getDouble("coste");
                Date fech = rs.getDate("fecha");
                String hor = rs.getString("horario");
                String dni = rs.getString("dniempleado");

                Empleado empleado = new Empleado();
                empleado.setDni(dni);

                System.out.println(empleado.getDni());

                Actividad actividad = new Actividad(id, name, numeromaxinvit, nombresal, coste, fech, hor);
                actividad.setEmpleado(empleado);

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
    public void usuariosHegoaldeSqlite() {

        this.usuarios = new ArrayList<Usuario>();

        try {

            System.out.println("Base de datos abierta con éxito");

            // preparo la conexion y la ejecucion de la consulta
            stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT dni, nombre, apellido1, apellido2, edad FROM usuarios");

            // accedo a las columnas de la tabla
            while (rs.next()) {

                String dni = rs.getString("dni");
                String name = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                int edad = rs.getInt("edad");

                Usuario usuario = new Usuario(dni, name, apellido1, apellido2, edad);

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

    // funcion para de alta un empleado
    public void altaNuevoEmpleado(Empleado nuevoEmpleado){

        try {

            String query = "INSERT INTO empleados VALUES (?,?,?,?,?,?,?)";

            PreparedStatement ps = this.connection.prepareStatement(query);

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            ps.setString(1, nuevoEmpleado.getDni());
            ps.setString(2, nuevoEmpleado.getNombre());
            ps.setString(3, nuevoEmpleado.getApellido1());
            ps.setString(4, nuevoEmpleado.getApellido2());
            ps.setString(7, nuevoEmpleado.getCargo());

            int row = ps.executeUpdate();

            // rows affected
            System.out.println(row); //1

            ps.close();

            System.out.println("Nuevo empleado creado correctamente");


        } catch (SQLException e) {

            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());            e.printStackTrace();
        }catch (Exception e){

            e.printStackTrace();

        }




    }

    // funcion para dar de alta una actividad
    public void altaNuevaActividad(Actividad nuevaActividad){
        try {

            String query = "INSERT INTO actividades (numactividad,nombre,numeromaximoinvitado,"
                    + " nombresala,coste,fecha,horario,dniempleado,dniusuario ) VALUES(?,?,?,?,?,?,?,?,?)";

            java.sql.Statement statement = this.connection.createStatement();

            PreparedStatement ps;
            ps = this.connection.prepareStatement(query);

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());


            ps.setString(1, nuevaActividad.getNumactividad());
            ps.setString(2, nuevaActividad.getNombre());
            ps.setInt(3, nuevaActividad.getNumeromaxinvitado());
            ps.setString(4, nuevaActividad.getNombresala());
            ps.setDouble(5,nuevaActividad.getCoste());
            ps.setTimestamp(6, (Timestamp) nuevaActividad.getFecha());
            ps.setString(7, nuevaActividad.getHorario());


            ps.execute();
            ps.close();

            System.out.println("Datos insertados en actividades correctamente");


        } catch (SQLException e) {

            System.out.println("Error en la insercción de datos...");
            e.printStackTrace();
        }


    }

    //funcion para dar de alta un nuevo usuario
    public void altaNuevoUsuario(Usuario nuevoUsuario){



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

    // funcion para mostrar en una tabla(javaswing) los datos
    public  void tablaMostrarActividades(ArrayList<Actividad> acti){

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
        modelo.addColumn("EMPLEADO");

        for (Actividad act:acti
        ) {

            Object [] datos=new Object[8];//Crea un vector

            //para almacenar los valores del ResultSet
            datos[0]=act.getNumactividad();
            datos[1]=act.getNombre();
            datos[2]=act.getNumeromaxinvitado();
            datos[3]=act.getNombresala();
            datos[4]=act.getCoste();
            datos[5]=act.getFecha();
            datos[6]=act.getFecha();
            datos[7]=act.getEmpleado().getDni();

            //añado el modelo a la tabla
            modelo.addRow(datos);

            System.out.print("hola"+act.getNombre().toString());
        }

        //datos=null;//limpia los datos de el vector de la memoria

        JFrame f = new JFrame();
        f.setBounds(10, 10, 300, 200);
        f.getContentPane().add(new JScrollPane(tabla));
        f.setLocationRelativeTo(null);

        f.setVisible(true);
    }

    // funcion para mostrar en una tabla(javaswing) los datos
    public  void tablaMostrarUsuarios(ArrayList<Usuario> usuarios){

        DefaultTableModel modelo = new DefaultTableModel();
        JTable tabla = new JTable(modelo);

        //creo 3 columnas con sus etiquetas
        //estas son las columnas del JTable
        modelo.addColumn("DNI");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO1");
        modelo.addColumn("APELLIDO2");
        modelo.addColumn("EDAD");


        for (Usuario us:usuarios
        ) {

            Object [] datos=new Object[5];//Crea un vector

            //para almacenar los valores del ResultSet
            datos[0]=us.getDni();
            datos[1]=us.getNombre();
            datos[2]=us.getApellido1();
            datos[3]=us.getApellido2();
            datos[4]=us.getEdad();


            //añado el modelo a la tabla
            modelo.addRow(datos);

            System.out.print("hola"+us.getNombre().toString());
        }

        //datos=null;//limpia los datos de el vector de la memoria

        JFrame f = new JFrame();
        f.setBounds(10, 10, 300, 200);
        f.getContentPane().add(new JScrollPane(tabla));
        f.setLocationRelativeTo(null);

        f.setVisible(true);
    }


}
