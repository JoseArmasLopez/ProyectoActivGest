package controlador.mysql;

import modelo.Empleado;
import modelo.Usuario;

import java.sql.*;

import java.util.ArrayList;

public class MysqlConsultas {
    private Connection con = null;

    public MysqlConsultas(Connection con) {
        this.con = con;
    }//Constructor con la conexión.


    //Leer
    /*
    public ArrayList<Empleado> leerEmpleadosArriaga(){

        ArrayList<Empleado> empleados = new ArrayList<>();

        try{


            String query = "SELECT * FROM EMPLEADOS";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next())
            {




                String dni = resultSet.getString("dni");
                String nombre = resultSet.getString("nombre");
                String apellido1 = resultSet.getString("apellido1");
                String apellido2 = resultSet.getString("apellido2");
                Date fechaNac = resultSet.getDate("fechanac");
                String cargo = resultSet.getString("cargo");

                Empleado empleado = new Empleado(dni, nombre, apellido1, apellido2, fechaNac, cargo);//¿NUEVO CONSTRUCTOR?
                empleados.add(empleado);
            }

            resultSet.close();
            statement.close();

        }catch (Exception e) {
            System.err.println("Error al obtener los Usuarios de Arriaga."+e.getMessage());
        }


        return empleados;
    }

     */


    public ArrayList<Usuario> leerUsuariosArriaga(){

        ArrayList<Usuario> usuarios = new ArrayList<>();

        try{


            String query = "SELECT * FROM USUARIOS";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next())
            {
                String dni = resultSet.getString("dni");
                String nombre = resultSet.getString("nombre");
                String apellido1 = resultSet.getString("apellido1");
                String apellido2 = resultSet.getString("apellido2");
                int edad = resultSet.getInt("edad");
                String idactividad = resultSet.getString("idactividad");

                Usuario usuario = new Usuario(dni, nombre, apellido1, apellido2, edad);
                usuarios.add(usuario);
            }

            resultSet.close();
            statement.close();

        }catch (Exception e) {
            System.err.println("Error al obtener los Usuarios de Arriaga."+e.getMessage());
        }


        return usuarios;
    }
}
