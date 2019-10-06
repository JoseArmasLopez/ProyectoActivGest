package controlador.sqlite;

import modelo.*;

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
    private ArrayList<Sesion> sesionesUsuario;
    private Statement stmt = null;

    // Seccion constructor
    public SqliteConsulta(Connection connection) {
        this.connection = connection;
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


    // *****************   seccion funciones de consultas *********************************************

    // funcion que da valor al atributo actividades con lo que se obtiene todas las actividades
    public void actividadesHegoaldeSqlite() {

        try {

            System.out.println("Base de datos abierta con éxito");

            // preparo la conexion y la ejecucion de la consulta
            stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT numactividad, nombre,numeromaximoinvitado," +
                    "nombresala,cursoacademico,coste FROM actividades");

            // accedo a las columnas de la tabla
            while (rs.next()) {

                String id = rs.getString("numactividad");
                String name = rs.getString("nombre");
                int numeromaxinvit = rs.getInt("numeromaximoinvitado");
                String nombresal = rs.getString("nombresala");
                String cursoAcademic = rs.getString("cursoacademico");
                double coste = rs.getDouble("coste");



                Actividad actividad = new Actividad(id,name,numeromaxinvit,nombresal,cursoAcademic,coste);


                this.actividades.add(actividad);

            }

            rs.close();
            stmt.close();


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,e.getMessage());
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Operación realizada con éxito");

    }

    // funcion que da valor al atributo sesionesUsuario (sesiones de un usuario)
    public void sesionesHegoaldeSqliteDeUnUsuario(Usuario usuario){

        try {

            System.out.println("Base de datos abierta con éxito");

            // preparo la conexion y la ejecucion de la consulta
            stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT  hora, diasemana from " +
                    "sesiones where dniusuario =  "+ usuario.getDni());

            // accedo a las columnas de la tabla
            while (rs.next()) {

                String hora = rs.getString("hora");
                String dia = rs.getString("diasemana");

                Sesion sesion = new Sesion(hora, dia);


                this.usuarios.add(usuario);

            }

            rs.close();
            stmt.close();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operación realizada con éxito");
        JOptionPane.showMessageDialog(null, "Operación realizada con éxito");


    }

    // funcion que da valor al atributo usuarios con lo que se obtiene todos los usuarios
    public void usuariosHegoaldeSqlite() {

        this.usuarios = new ArrayList<Usuario>();

        try {

            System.out.println("Base de datos abierta con éxito");

            // preparo la conexion y la ejecucion de la consulta
            stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT dni, nombre, apellido1, apellido2,edad, profesion FROM usuarios");

            // accedo a las columnas de la tabla
            while (rs.next()) {

                String dni = rs.getString("dni");
                String name = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                int edad = rs.getInt("edad");
                String profesion = rs.getString("profesion");

                Usuario usuario = new Usuario(dni, name, apellido1, apellido2, edad, profesion);

                this.usuarios.add(usuario);

            }

            rs.close();
            stmt.close();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Operación realizada con éxito");

    }

    // funcion que da valor al atributo empleados con lo que se obtiene todos los empleados
    public void empleadosHegoaldeSqlite() {

        this.empleados = new ArrayList<Empleado>();

        try {

            System.out.println("Base de datos abierta con éxito");

            // preparo la conexion y la ejecucion de la consulta
            stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT dni, nombre, apellido1, apellido2, fechanac,fechacontract" +
                    ", nacionalidad, cargo FROM empleados");

            // accedo a las columnas de la tabla
            while (rs.next()) {

                String dni = rs.getString("dni");
                String name = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String edad = rs.getString("fechanac");
                String fechacontractact = rs.getString("fechacontract");
                String nacionalidad = rs.getString("nacionalidad");
                String cargo = rs.getString("cargo");

                Empleado empleado = new Empleado(dni,name,apellido1,apellido2,edad,fechacontractact,nacionalidad,cargo);

                this.empleados.add(empleado);

            }

            rs.close();
            stmt.close();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Operación realizada con éxito");

    }

    // funcion para consultar las actividades de un empleado
    public void actividadesDeUnEmpleado(Empleado empleado){

        try {

            System.out.println("Base de datos abierta con éxito");

            // preparo la conexion y la ejecucion de la consulta
            stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT  nombre from " +
                    "actividades where dniempleado =  "+ empleado.getDni());

            // accedo a las columnas de la tabla
            while (rs.next()) {

                String name = rs.getString("nombre");

                Actividad actividad = new Actividad();
                actividad.setNombre(name);
                actividad.setEmpleado(empleado);


                this.actividades.add(actividad);

            }

            rs.close();
            stmt.close();


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,e.getMessage());
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Operación realizada con éxito");


    }

    // funcion para de alta un empleado
    public void altaNuevoEmpleado(Empleado nuevoEmpleado){

        try {

            String query = "INSERT INTO empleados VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement ps = this.connection.prepareStatement(query);

            ps.setString(1,nuevoEmpleado.getDni());
            ps.setString(2,nuevoEmpleado.getNombre());
            ps.setString(3,nuevoEmpleado.getApellido1());
            ps.setString(4,nuevoEmpleado.getApellido2());
            ps.setString(5, nuevoEmpleado.getFechacontract());
            ps.setString(6,nuevoEmpleado.getFechanac());
            ps.setString(7,nuevoEmpleado.getNacionalidad());
            ps.setString(8, nuevoEmpleado.getCargo());

            int row = ps.executeUpdate();
            ps.close();

            if (row == 0){

                JOptionPane.showMessageDialog(null, "No se ha insertado ningún dato");
            }else{

                JOptionPane.showMessageDialog(null, "Empleado dado de alta correctamente");
            }




        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    // funcion para dar de alta una actividad
    public void altaNuevaActividad(Actividad nuevaActividad){
        try {

            String query = "INSERT INTO actividades (numactividad,nombre,numeromaximoinvitado,"
                    + " nombresala,cursoacademico,coste) VALUES(?,?,?,?,?,?)";

            java.sql.Statement statement = this.connection.createStatement();

            PreparedStatement ps;
            ps = this.connection.prepareStatement(query);


            ps.setString(1, nuevaActividad.getNumactividad());
            ps.setString(2, nuevaActividad.getNombre());
            ps.setInt(3, nuevaActividad.getNumeromaxinvitado());
            ps.setString(4, nuevaActividad.getNombresala());
            ps.setString(5, nuevaActividad.getCurosAcademico());
            ps.setDouble(6,nuevaActividad.getCoste());


            int row = ps.executeUpdate();
            ps.close();

            if (row == 0){

                JOptionPane.showMessageDialog(null, "No se ha insertado ningún dato");
            }else{

                JOptionPane.showMessageDialog(null, "Actividad dada de alta correctamente");
            }




        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null,e.getMessage());

            System.out.println("Error en la insercción de datos...");
            e.printStackTrace();
        }


    }

    //funcion para dar de alta un nuevo usuario
    public void altaNuevoUsuario(Usuario nuevoUsuario){

        try {

            String query = "INSERT INTO usuarios VALUES(?,?,?,?,?,?)";

            PreparedStatement ps;
            ps = this.connection.prepareStatement(query);

            ps.setString(1, nuevoUsuario.getDni());
            ps.setString(2, nuevoUsuario.getNombre());
            ps.setString(3, nuevoUsuario.getApellido1());
            ps.setString(4, nuevoUsuario.getApellido2());
            ps.setInt(5, nuevoUsuario.getEdad());
            ps.setString(6, nuevoUsuario.getProfesion());

            int row = ps.executeUpdate();
            ps.close();

            if (row == 0){

                JOptionPane.showMessageDialog(null, "No se ha insertado ningún dato");
            }else{

                JOptionPane.showMessageDialog(null, "Usuario dado de alta correctamente");
            }




        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null,e.getMessage());

            System.out.println("Error en la insercción de datos...");
            e.printStackTrace();
        }


    }

    // funcion para eliminar una actividad
    public void eliminarActividad(String id) {
        try {

            String query = "DELETE FROM ACTIVIDADES where numactividad = " + id;

            PreparedStatement ps;
            ps = this.connection.prepareStatement(query);

            int row = ps.executeUpdate();
            ps.close();

            if(row==0){
                JOptionPane.showMessageDialog(null, "No se ha eliminado ningún campo");
            }else{
                System.out.println("Actividad eliminada correctamente");
                JOptionPane.showMessageDialog(null, "Actividad eliminada");
            }

        } catch (SQLException e) {

            System.out.println("Error ...");
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    // funcion para eliminar un empleado
    public void eliminarEmpleado(String id) {
        try {

            String query = "DELETE FROM empleados where dni = " + id;

            PreparedStatement ps;
            ps = this.connection.prepareStatement(query);

            int r = ps.executeUpdate();
            ps.close();

            if(r == 0){

                JOptionPane.showMessageDialog(null, "No se ha eliminado ningún campo de la bd");


            }else{

                JOptionPane.showMessageDialog(null, " Empleado eliminado correctamente");
            }



        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    // funcion para eliminar un usuario
    public void eliminarUsuario(String id) {
        try {

            String query = "DELETE  FROM usuarios where DNI = " + id;

            PreparedStatement ps;
            ps = this.connection.prepareStatement(query);

            int r = ps.executeUpdate();
            ps.close();

            if (r==0){

                JOptionPane.showMessageDialog(null, " No se ha modificado la bd");
            }else{

                JOptionPane.showMessageDialog(null, "Eliminado Usuario correctamente");
            }



        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());


        }
    }

    // ***** update table *************

    // funcion que actualiza una actividad
    public void actualizarActividad ( Actividad actividad){

        try {

            String query = "UPDATE actividades set numactividad = "+ actividad.getNumactividad()+",nombre = "
                    +actividad.getNombre()+",numeromaximoinvitado = "+ actividad.getNumeromaxinvitado() + ",nombresala = "+
             actividad.getNombresala() +",cursoacademico = "+actividad.getCurosAcademico() + ",coste = "+actividad.getCoste()+
                    ",dniempleado = " + actividad.getEmpleado().getDni() +" where dniempleado = " + actividad.getNumactividad();

            PreparedStatement ps;
            ps = this.connection.prepareStatement(query);

            ps.execute();
            ps.close();

            System.out.println("Actividad actualizada correctamente");
            JOptionPane.showInputDialog("Actividad actualizada correctamente");


        } catch (SQLException e) {

            System.out.println("Error ...");
            e.printStackTrace();
        }



    }

    // funcion que actualiza un usuario
    public void actualizarUsuario ( Usuario usuario){

        try {

            String query = "UPDATE usuarios set dni = "+ usuario.getDni()+",nombre = "
                    +usuario.getNombre()+",apellido1 = "+ usuario.getApellido1() + ",apellido2 = "+
                    usuario.getApellido2() +",edad = "+usuario.getEdad() + ",profesion = "+usuario.getProfesion()+
                    "where dni = "+usuario.getDni();

            PreparedStatement ps;
            ps = this.connection.prepareStatement(query);

            ps.execute();
            ps.close();

            System.out.println("Usuario actualizado correctamente");
            JOptionPane.showInputDialog("Usuario actualizado correctamente");


        } catch (SQLException e) {

            System.out.println("Error ...");
            e.printStackTrace();
        }



    }

    // funcion que actualiza un empleado
    public void actualizarEmpleado ( Empleado empleado){

        try {

            String query = "UPDATE empleados set dni = "+ empleado.getDni()+",nombre = "
                    +empleado.getNombre()+",apellido1 = "+ empleado.getApellido1() + ",apellido2 = "+
                    empleado.getApellido2() +" ,fechacontract = "+empleado.getFechacontract() + ",fechanac = "+empleado.getFechanac()+
                    ",nacionalidad = " + empleado.getNacionalidad()+" ,cargo = "+empleado.getCargo() +" where dni = " + empleado.getDni();

            PreparedStatement ps;
            ps = this.connection.prepareStatement(query);

            ps.execute();
            ps.close();

            System.out.println("Empleado actualizado correctamente");
            JOptionPane.showInputDialog("Empleado actualizado correctamente");


        } catch (SQLException e) {

            System.out.println("Error ...");
            e.printStackTrace();
        }



    }

    //************* seccion funciones de tablas *************************************************

    // funcion para mostrar en una tabla(javaswing) los datos
    public  void tablaMostrarActividades(ArrayList<Actividad> acti, JTable tabla){
















    }

    // funcion para mostrar en una tabla(javaswing) los datos
    public  void tablaActividadesDeUnUsuario(ArrayList<Usuario> usuarios){

        DefaultTableModel modelo = new DefaultTableModel();
        JTable tabla = new JTable(modelo);

        //creo 3 columnas con sus etiquetas
        //estas son las columnas del JTable
        modelo.addColumn("DNI");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO1");
        modelo.addColumn("APELLIDO2");
        modelo.addColumn("EDAD");
        modelo.addColumn("PROFESION");


        for (Usuario us:usuarios
        ) {

            Object [] datos=new Object[5];//Crea un vector

            //para almacenar los valores del ResultSet
            datos[0]=us.getDni();
            datos[1]=us.getNombre();
            datos[2]=us.getApellido1();
            datos[3]=us.getApellido2();
            datos[4]=us.getEdad();
            datos[5]=us.getProfesion();


            //añado el modelo a la tabla
            modelo.addRow(datos);

            System.out.print("hola"+us.getNombre().toString());
        }

        //datos=null;//limpia los datos de el vector de la memoria

        JFrame f = new JFrame();
        f.setBounds(10, 10, 300, 200);
        f.getContentPane().add(new JScrollPane(tabla));
        f.setLocationRelativeTo(null);
        f.setTitle("USUARIOS HEGOALDE");

        f.setVisible(true);
    }

    // funcion para mostrar en una tabla(javaswing) los datos
    public  void tablaMostrarEmpleados(ArrayList<Empleado> empleados){

        DefaultTableModel modelo = new DefaultTableModel();
        JTable tabla = new JTable(modelo);

        JButton boton = new JButton();
        boton.setLocation(null);

        //creo 3 columnas con sus etiquetas
        //estas son las columnas del JTable
        modelo.addColumn("DNI");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO1");
        modelo.addColumn("APELLIDO2");
        modelo.addColumn("NACIMIENTO");
        modelo.addColumn("FECHA CONTRATO");
        modelo.addColumn("CARGO");


        for (Empleado us:empleados
        ) {

            Object [] datos=new Object[7];//Crea un vector

            //para almacenar los valores del ResultSet
            datos[0]=us.getDni();
            datos[1]=us.getNombre();
            datos[2]=us.getApellido1();
            datos[3]=us.getApellido2();
            datos[4]=us.getFechanac();
            datos[5]=us.getFechacontract();
            datos[6]=us.getCargo();


            //añado el modelo a la tabla
            modelo.addRow(datos);

            System.out.print("hola"+us.getNombre().toString());
        }

        //datos=null;//limpia los datos de el vector de la memoria

        JFrame f = new JFrame();
        f.setBounds(10, 10, 300, 200);
        f.getContentPane().add(new JScrollPane(tabla));
        f.setLocationRelativeTo(null);

        f.setTitle("EMPLEADOS HEGOALDE");
        f.add(boton);

        f.setVisible(true);
    }








}
