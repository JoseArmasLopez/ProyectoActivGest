package controlador.mysql;

import modelo.Actividad;
import modelo.Empleado;
import modelo.Sesion;
import modelo.Usuario;

import java.sql.*;

import java.util.ArrayList;

public class MysqlConsultas {

    private Connection con = null;

    public MysqlConsultas(Connection con) {
        this.con = con;
    }//Constructor con la conexión.


    //Leer datos generales. (Devuelve TODOS los datos de cada tabla.)

    public ArrayList<Empleado> LeerEmpleadosArriaga(){

        ArrayList<Empleado> empleados = new ArrayList<>();

        try{


            String query = "SELECT * FROM EMPLEADOS";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next())
            {
                String DNI = resultSet.getString("DNI");
                String NOMBRE = resultSet.getString("NOMBRE");
                String APELLIDO1 = resultSet.getString("APELLIDO1");
                String APELLIDO2 = resultSet.getString("APELLIDO2");
                String FECHACONTRACT = resultSet.getString("FECHACONTRACT");
                String FECHANAC = resultSet.getString("FECHANAC");
                String NACIONALIDAD = resultSet.getString("NACIONALIDAD");
                String CARGO = resultSet.getString("CARGO");

                Empleado empleado = new Empleado(DNI, NOMBRE, APELLIDO1, APELLIDO2, FECHACONTRACT, FECHANAC, NACIONALIDAD, CARGO);
                System.out.println(DNI + NOMBRE + APELLIDO1 + APELLIDO2 + FECHACONTRACT + FECHANAC + NACIONALIDAD + CARGO);
                empleados.add(empleado);
            }

            resultSet.close();
            statement.close();

        }catch (Exception e) {
            System.err.println("Error al obtener los empleados de Arriaga."+e.getMessage());
        }


        return empleados;
    }

    public ArrayList<Actividad> LeerActividadesArriaga(){

        ArrayList<Actividad> actividades = new ArrayList<>();

        try{


            String query = "SELECT * FROM ACTIVIDADES";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next())
            {
                String NUMACTIVIDAD = resultSet.getString("NUMACTIVIDAD");
                String NOMBRE = resultSet.getString("NOMBRE");
                int NUMEROMAXIMOINVITADO = resultSet.getInt("NUMEROMAXIMOINVITADO");
                String NOMBRESALA = resultSet.getString("NOMBRESALA");
                String CURSOACADEMICO = resultSet.getString("CURSOACADEMICO");
                Double COSTE = resultSet.getDouble("COSTE");
                String DNIEMPLEADO = resultSet.getString("DNIEMPLEADO");

                Actividad actividad = new Actividad(NUMACTIVIDAD, NOMBRE, NUMEROMAXIMOINVITADO, NOMBRESALA, CURSOACADEMICO, COSTE);
                actividades.add(actividad);
                System.out.println(NUMACTIVIDAD + NOMBRE + NUMEROMAXIMOINVITADO + NOMBRESALA + CURSOACADEMICO + COSTE);
            }

            resultSet.close();
            statement.close();

        }catch (Exception e) {
            System.err.println("Error al obtener las actividades de Arriaga."+e.getMessage());
        }


        return actividades;
    }

    public ArrayList<Usuario> LeerUsuariosArriaga(){

        ArrayList<Usuario> usuarios = new ArrayList<>();

        try{


            String query = "SELECT * FROM USUARIOS";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next())
            {
                String DNI = resultSet.getString("DNI");
                String NOMBRE = resultSet.getString("NOMBRE");
                String APELLIDO1 = resultSet.getString("APELLIDO1");
                String APELLIDO2 = resultSet.getString("APELLIDO2");
                int EDAD = resultSet.getInt("EDAD");
                String PROFESION = resultSet.getString("PROFESION");

                Usuario usuario = new Usuario(DNI, NOMBRE, APELLIDO1, APELLIDO2, EDAD, PROFESION);
                usuarios.add(usuario);
                System.out.println(DNI + NOMBRE + APELLIDO1 + APELLIDO2 + EDAD + PROFESION);
            }

            resultSet.close();
            statement.close();

        }catch (Exception e) {
            System.err.println("Error al obtener los Usuarios de Arriaga."+e.getMessage());
        }


        return usuarios;
    }

    public ArrayList<Sesion> LeerSesionesArriaga(){

        ArrayList<Sesion> sesiones = new ArrayList<>();

        try{


            String query = "SELECT * FROM SESION";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next())
            {

                String createSesion = "CREATE TABLE SESION(" +
                        "IDSESION INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                        "HORA VARCHAR(5)," +
                        "DIASEMANA VARCHAR(255)," +
                        "NUMACTIVIDAD VARCHAR(255)," +
                        "DNIUSUARIO VARCHAR(9)," +
                        "FOREIGN KEY (NUMACTIVIDAD) REFERENCES ACTIVIDADES(NUMACTIVIDAD)," +
                        "FOREIGN KEY (DNIUSUARIO) REFERENCES  USUARIOS(DNI));";
/*
                int IDSESION = resultSet.getInt("IDSESION");
                String HORA = resultSet.getString("HORA");
                String DIASEMANA = resultSet.getString("DIASEMANA");
                String NUMACTIVIDAD = resultSet.getString("NUMACTIVIDAD");
                String DNIUSUARIO = resultSet.getString("DNIUSUARIO");

                Sesion sesion = new Sesion(IDSESION, HORA, DIASEMANA, NUMACTIVIDAD, DNIUSUARIO);
                usuarios.add(sesion);
                System.out.println(DNI + NOMBRE + APELLIDO1 + APELLIDO2 + EDAD + PROFESION);

 */
                String HORA = resultSet.getString("HORA");
                String DIASEMANA = resultSet.getString("DIASEMANA");
                Sesion sesion = new Sesion(HORA, DIASEMANA);
                sesiones.add(sesion);
                System.out.println(HORA + DIASEMANA);

            }

            resultSet.close();
            statement.close();

        }catch (Exception e) {
            System.err.println("Error al obtener las sesiones de Arriaga."+e.getMessage());
        }


        return sesiones;
    }


    //Leer datos exactos. (Se envía la primary key y devuelve un objeto con todos los datos.)

    public Empleado LeerEmpleadoConcretoArriaga(String DNI){

        Empleado empleado = null;

        try{


            String query = "SELECT * FROM EMPLEADOS WHERE DNI = '" + DNI + "'";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                String DNIBusqueda = resultSet.getString("DNI");
                String NOMBRE = resultSet.getString("NOMBRE");
                String APELLIDO1 = resultSet.getString("APELLIDO1");
                String APELLIDO2 = resultSet.getString("APELLIDO2");
                String FECHACONTRACT = resultSet.getString("FECHACONTRACT");
                String FECHANAC = resultSet.getString("FECHANAC");
                String NACIONALIDAD = resultSet.getString("NACIONALIDAD");
                String CARGO = resultSet.getString("CARGO");

                empleado = new Empleado(DNIBusqueda, NOMBRE, APELLIDO1, APELLIDO2, FECHACONTRACT, FECHANAC, NACIONALIDAD, CARGO);
                System.out.println(DNIBusqueda + NOMBRE + APELLIDO1 + APELLIDO2 + FECHACONTRACT + FECHANAC + NACIONALIDAD + CARGO);
            }

            resultSet.close();
            statement.close();



        }catch (Exception e) {
            System.err.println("Error al buscar al empleado en Arriaga."+e.getMessage());
        }

        return empleado;
    }

    public Actividad LeerActividadConcretoArriaga(String NumActividad){

        Actividad actividad = null;

        try{


            String query = "SELECT * FROM ACTIVIDADES WHERE NUMACTIVIDAD = '" + NumActividad + "'";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next())
            {
                String NUMACTIVIDAD = resultSet.getString("NUMACTIVIDAD");
                String NOMBRE = resultSet.getString("NOMBRE");
                int NUMEROMAXIMOINVITADO = resultSet.getInt("NUMEROMAXIMOINVITADO");
                String NOMBRESALA = resultSet.getString("NOMBRESALA");
                String CURSOACADEMICO = resultSet.getString("CURSOACADEMICO");
                Double COSTE = resultSet.getDouble("COSTE");
                String DNIEMPLEADO = resultSet.getString("DNIEMPLEADO");

                actividad = new Actividad(NUMACTIVIDAD, NOMBRE, NUMEROMAXIMOINVITADO, NOMBRESALA, CURSOACADEMICO, COSTE);
                System.out.println(NUMACTIVIDAD + NOMBRE + NUMEROMAXIMOINVITADO + NOMBRESALA + CURSOACADEMICO + COSTE);
            }

            resultSet.close();
            statement.close();

        }catch (Exception e) {
            System.err.println("Error al obtener la actividad de Arriaga."+e.getMessage());
        }

        return actividad;
    }

    public Usuario LeerUsuarioConcretoArriaga(String DNI){

        Usuario usuario = null;

        try{


            String query = "SELECT * FROM USUARIOS WHERE DNI = '" + DNI + "'";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next())
            {
                String DNIBusqueda = resultSet.getString("DNI");
                String NOMBRE = resultSet.getString("NOMBRE");
                String APELLIDO1 = resultSet.getString("APELLIDO1");
                String APELLIDO2 = resultSet.getString("APELLIDO2");
                int EDAD = resultSet.getInt("EDAD");
                String PROFESION = resultSet.getString("PROFESION");

                usuario = new Usuario(DNIBusqueda, NOMBRE, APELLIDO1, APELLIDO2, EDAD, PROFESION);
                System.out.println(DNIBusqueda + NOMBRE + APELLIDO1 + APELLIDO2 + EDAD + PROFESION);
            }

            resultSet.close();
            statement.close();

        }catch (Exception e) {
            System.err.println("Error al obtener el usuario de Arriaga."+e.getMessage());
        }

        return usuario;
    }

    public Sesion LeerSesionConcretoArriaga(String IDSESION){

        Sesion sesion = null;

        try{


            String query = "SELECT * FROM SESION WHERE IDSESION = '" + IDSESION + "'";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next())
            {

                String createSesion = "CREATE TABLE SESION(" +
                        "IDSESION INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                        "HORA VARCHAR(5)," +
                        "DIASEMANA VARCHAR(255)," +
                        "NUMACTIVIDAD VARCHAR(255)," +
                        "DNIUSUARIO VARCHAR(9)," +
                        "FOREIGN KEY (NUMACTIVIDAD) REFERENCES ACTIVIDADES(NUMACTIVIDAD)," +
                        "FOREIGN KEY (DNIUSUARIO) REFERENCES  USUARIOS(DNI));";

                String HORA = resultSet.getString("HORA");
                String DIASEMANA = resultSet.getString("DIASEMANA");
                sesion = new Sesion(HORA, DIASEMANA);
                System.out.println(HORA + DIASEMANA);

            }

            resultSet.close();
            statement.close();

        }catch (Exception e) {
            System.err.println("Error al obtener la sesion de Arriaga."+e.getMessage());
        }

        return sesion;
    }

    public ArrayList<Sesion> LeerSesionesDeUnUsuario(Usuario usuario){
        ArrayList<Sesion> sesiones = new ArrayList<>();

        try{


            String query = "SELECT * FROM SESION WHERE DNIUSUARIO = '" + usuario.getDni() + "'";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next())
            {


                String HORA = resultSet.getString("HORA");
                String DIASEMANA = resultSet.getString("DIASEMANA");
                Sesion sesion = new Sesion(HORA, DIASEMANA);
                sesiones.add(sesion);
                System.out.println(HORA + DIASEMANA);

            }

            resultSet.close();
            statement.close();

        }catch (Exception e) {
            System.err.println("Error al obtener las sesiones del usuario " + usuario.getNombre() + " Arriaga."+e.getMessage());
        }


        return sesiones;
    }//SESIONES, sigue faltando la clave foránea en la clase!!!

    public ArrayList<Actividad> LeerActividadesDeUnEmpleado(Empleado empleado){

        ArrayList<Actividad> actividades = new ArrayList<>();

        try{


            String query = "SELECT * FROM EMPLEADOS WHERE DNI = '" + empleado.getDni() + "'";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next())
            {
                String NUMACTIVIDAD = resultSet.getString("NUMACTIVIDAD");
                String NOMBRE = resultSet.getString("NOMBRE");
                int NUMEROMAXIMOINVITADO = resultSet.getInt("NUMEROMAXIMOINVITADO");
                String NOMBRESALA = resultSet.getString("NOMBRESALA");
                String CURSOACADEMICO = resultSet.getString("CURSOACADEMICO");
                Double COSTE = resultSet.getDouble("COSTE");
                String DNIEMPLEADO = resultSet.getString("DNIEMPLEADO");

                Actividad actividad = new Actividad(NUMACTIVIDAD, NOMBRE, NUMEROMAXIMOINVITADO, NOMBRESALA, CURSOACADEMICO, COSTE);
                actividades.add(actividad);
                System.out.println(NUMACTIVIDAD + NOMBRE + NUMEROMAXIMOINVITADO + NOMBRESALA + CURSOACADEMICO + COSTE);
            }

            resultSet.close();
            statement.close();

        }catch (Exception e) {
            System.err.println("Error al obtener las actividades de Arriaga."+e.getMessage());
        }


        return actividades;
    }



    //Insertar. (Llamadas que sirven para registrar nuevos datos en las tablas.)

    public void InsertarEmpleadoArriaga(Empleado empleado){
        PreparedStatement preparedStatement;


        try {

            String query = " INSERT INTO EMPLEADOS (DNI, NOMBRE, APELLIDO1, APELLIDO2,FECHACONTRACT, FECHANAC, NACIONALIDAD, CARGO)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, empleado.getDni());
            preparedStatement.setString(2, empleado.getNombre());
            preparedStatement.setString(3, empleado.getApellido1());
            preparedStatement.setString(4, empleado.getApellido2());
            preparedStatement.setString(5,empleado.getFechacontract());
            preparedStatement.setString(6,empleado.getFechanac());
            preparedStatement.setString(7, empleado.getNacionalidad());
            preparedStatement.setString(8, empleado.getCargo());

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Empleado insertado correctamente en Arriaga.");


        } catch (SQLException e) {

            System.out.println("Error al insertar el empleado en Arriaga.");
            e.printStackTrace();
        }
    }

    public void InsertarActividadesArriaga(Actividad actividad, Empleado empleadoResponsable){
        PreparedStatement preparedStatement;


        try {

            String query = " INSERT INTO ACTIVIDADES (NUMACTIVIDAD, NOMBRE, NUMEROMAXIMOINVITADO, NOMBRESALA, CURSOACADEMICO, COSTE, DNIEMPLEADO)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, actividad.getNumactividad());
            preparedStatement.setString(2, actividad.getNombre());
            preparedStatement.setInt(3, actividad.getNumeromaxinvitado());
            preparedStatement.setString(4, actividad.getNombresala());
            preparedStatement.setString(5,actividad.getCurosAcademico());
            preparedStatement.setDouble(6,actividad.getCoste());
            preparedStatement.setString(7, empleadoResponsable.getDni());

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Actividad insertada correctamente en Arriaga.");


        } catch (SQLException e) {

            System.out.println("Error al insertar la actividad en Arriaga.");
            e.printStackTrace();
        }
    }

    public void InsertarUsuarioArriaga(Usuario usuario){
        PreparedStatement preparedStatement;


        try {


            String query = " INSERT INTO USUARIOS (DNI, NOMBRE, APELLIDO1, APELLIDO2, EDAD, PROFESION)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, usuario.getDni());
            preparedStatement.setString(2, usuario.getNombre());
            preparedStatement.setString(3, usuario.getApellido1());
            preparedStatement.setString(4, usuario.getApellido2());
            preparedStatement.setInt(5,usuario.getEdad());
            preparedStatement.setString(6, usuario.getProfesion());

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Usuario insertado correctamente en Arriaga.");


        } catch (SQLException e) {

            System.out.println("Error al insetar el usuario en Arriaga.");
            e.printStackTrace();
        }

    }

    public void InsertarSesion(Usuario usuario, Actividad actividad, Sesion sesion){
        PreparedStatement preparedStatement;


        try {


            String query = " INSERT INTO SESION (HORA, DIASEMANA, NUMACTIVIDAD, DNIUSUARIO)"
                    + " VALUES (?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, sesion.getHora());
            preparedStatement.setString(2, sesion.getDiaSemana());
            preparedStatement.setString(3, actividad.getNumactividad());
            preparedStatement.setString(4,usuario.getDni());

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Sesion insertada correctamente en Arriaga.");


        } catch (SQLException e) {

            System.out.println("Error al insetar la sesión en Arriaga.");
            e.printStackTrace();
        }
    }


    //Eliminar.

    public void EliminarEmpleadoArriaga(Empleado empleadoAEliminar){
        PreparedStatement preparedStatement;


        try {

            String query =  "DELETE FROM EMPLEADOS WHERE DNI = '" + empleadoAEliminar.getDni() + "'";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Empleado eliminado correctamente de Arriaga.");


        } catch (SQLException e) {

            System.out.println("Error al eliminar al empleado de Arriaga.");
            e.printStackTrace();
        }


    }

    public void EliminarActividadArriaga(Actividad actividadAEliminar){

        PreparedStatement preparedStatement;

        try {

            String query =  "DELETE FROM ACTIVIDADES WHERE NUMACTIVIDAD = '" + actividadAEliminar.getNumactividad() + "'";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Actividad eliminada correctamente de Arriaga y sesiones canceladas.");


        } catch (SQLException e) {

            System.out.println("Error al eliminar la actividad de Arriaga.");
            e.printStackTrace();
        }


    }

    public void EliminarUsuarioArriaga(Usuario usuarioAEliminar){

        PreparedStatement preparedStatement;

        try {

            String query =  "DELETE FROM USUARIOS WHERE DNI = '" + usuarioAEliminar.getDni() + "'";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Usuario eliminado correctamente de Arriaga y sesiones canceladas.");


        } catch (SQLException e) {

            System.out.println("Error al eliminar el usuario de Arriaga.");
            e.printStackTrace();
        }

    }

    public void EliminarSesionArriaga(Sesion sesion){
        PreparedStatement preparedStatement;

        try {

            String query =  "DELETE FROM SESION WHERE IDSESION = '" + sesion.getID() + "'";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Sesión eliminada correctamente de Arriaga.");


        } catch (SQLException e) {

            System.out.println("Error al eliminar la sesión de Arriaga.");
            e.printStackTrace();
        }

    }
    





    //ACTUALIZAR

    public void ActualizarEmpleadoArriaga(Empleado empleado){
        try{
            String query = "UPDATE EMPLEADOS" +
                    " set DNI = '"+ empleado.getDni()+"'"+
                    ",NOMBRE = '" +empleado.getNombre()+"'"+
                    ",APELLIDO1 = '"+ empleado.getApellido1()+"'"+
                    ",APELLIDO2 = '"+ empleado.getApellido2()+"'"+
                    ",FECHACONTRACT = '"+empleado.getFechacontract()+"'"+
                    ",FECHANAC = '"+empleado.getFechanac()+"'"+
                    ",NACIONALIDAD = '" + empleado.getNacionalidad()+"'"+
                    ",CARGO = '"+empleado.getCargo()+"'"+
                    " where DNI = '" + empleado.getDni() + "'";

            PreparedStatement preparedStatement;
            preparedStatement = this.con.prepareStatement(query);

            preparedStatement.executeUpdate();
            preparedStatement.close();


        }catch (Exception e) {
            System.err.println("Error al modificar al empleado.");
            e.getMessage();
        }

    }

    public void ActualizarActividad(Actividad actividad){
        try{
            String query = "UPDATE actividades" +
                    "set NUMACTIVIDAD = '"+actividad.getNumactividad()+"'"+
                    ",NOMBRE = '" +actividad.getNombre()+"'"+
                    ",NUMEROMAXIMOINVITADO = '"+ actividad.getNumeromaxinvitado()+"'"+
                    ",NOMBRESALA = '"+ actividad.getNombresala()+"'"+
                    ",CURSOACADEMICO = '"+actividad.getCurosAcademico()+"'"+
                    ",COSTE = '"+actividad.getCoste()+"'"+
                    ",DNIEMPLEADO = '"+actividad.getEmpleado().getDni()+"'"+
                    " where NUMACTIVIDAD = '" + actividad.getNumactividad()+"'";

            PreparedStatement preparedStatement;
            preparedStatement = this.con.prepareStatement(query);

            preparedStatement.executeUpdate();
            preparedStatement.close();


        }catch (Exception e) {
            System.err.println("Error al modificar al empleado.");
            e.getMessage();
        }
    }

    public void ActualizarUsuario(Usuario usuario){
        try{

            String query = "UPDATE usuarios" +
                    "set DNI = '"+usuario.getDni()+"'"+
                    ",NOMBRE = '" +usuario.getNombre()+"'"+
                    ",APELLIDO1 = '"+ usuario.getApellido1()+"'"+
                    ",APELLIDO2 = '"+ usuario.getApellido2()+"'"+
                    ",EDAD = '"+usuario.getEdad()+"'"+
                    ",PROFESION = '"+usuario.getProfesion()+"'"+
                    " where DNI = '" + usuario.getDni()+"'";

            PreparedStatement preparedStatement;
            preparedStatement = this.con.prepareStatement(query);

            preparedStatement.executeUpdate();
            preparedStatement.close();


        }catch (Exception e) {
            System.err.println("Error al modificar al usuario.");
            e.getMessage();
        }
    }

    public void ActualizarSesion(Sesion sesion){
        try{


            String query = "UPDATE sesion" +
                    "set IDSESION = '"+sesion.getID()+"'"+
                    ",HORA = '" +sesion.getHora()+"'"+
                    ",DIASEMANA = '"+ sesion.getDiaSemana()+"'"+
                    ",NUMACTIVIDAD = '"+ sesion.getIDActividad()+"'"+
                    ",DNIUSUARIO = '"+sesion.getDNIUsuario()+"'"+
                    " where IDSESION = '" + sesion.getID()+"'";

            PreparedStatement preparedStatement;
            preparedStatement = this.con.prepareStatement(query);

            preparedStatement.executeUpdate();
            preparedStatement.close();


        }catch (Exception e) {
            System.err.println("Error al modificar la sesión.");
            e.getMessage();
        }
    }
}
