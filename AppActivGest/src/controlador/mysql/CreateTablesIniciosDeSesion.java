package controlador.mysql;

import java.sql.*;
import java.util.ArrayList;

public class CreateTablesIniciosDeSesion {

    public static void main(String[] args) {
        //Puesta en marcha (Crear todas las tablas y sesiones.)

        Connection con = Conexion();
        BorrarTablas(con);
        CrearTablaCuentas(con);
        CrearTablaRegistros(con);
        InsertarDatosIniciales(con);
    }

    private static void BorrarTablas(Connection con){
        PreparedStatement preparedStatement;

        String borrarCuentas =  "DROP TABLE IF EXISTS CUENTAS";
        String borrarRegistros =  "DROP TABLE IF EXISTS REGISTROS";

        try{
            preparedStatement = con.prepareStatement(borrarCuentas);
            preparedStatement.executeUpdate();

            System.out.println("Tabla cuentas eliminada correctamente.");

        }catch (Exception e) {
            System.err.println("Error al eliminar la tabla cuentas.");
            e.getMessage();
        }


        try{
            preparedStatement = con.prepareStatement(borrarRegistros);
            preparedStatement.executeUpdate();

            System.out.println("Tabla registros eliminada correctamente.");

        }catch (Exception e) {
            System.err.println("Error al eliminar la tabla registros.");
            e.getMessage();
        }


    }

    private static Connection Conexion(){
        Connection con = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/actigest", "root", "");

        }catch (Exception e) {
            System.err.println("No se ha podido conectar a la base de datos Arriaga\n"+e.getMessage());
        }

        return con;
    }

    private static void CrearTablaCuentas(Connection con){

        PreparedStatement preparedStatement = null;


        String createCuentas = "CREATE TABLE CUENTAS(" +
                "NICKNAME VARCHAR(255) PRIMARY KEY NOT NULL," +
                "CONTRASEÑA VARCHAR(255) NOT NULL," +
                "TIPO INTEGER(1));";

        try{
            preparedStatement = con.prepareStatement(createCuentas);
            preparedStatement.executeUpdate();

            System.out.println("Tabla cuentas creada correctamente.");

        }catch (Exception e) {
            System.err.println("No se han podido crear la tabla cuentas.\n"+e.getMessage());
        }

    }

    private static void CrearTablaRegistros(Connection con){

        PreparedStatement preparedStatement = null;


        String createRegistros = "CREATE TABLE REGISTROS(" +
                "IDREGISTRO INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                "FECHA VARCHAR(255) NOT NULL," +
                "NICKNAMECUENTA VARCHAR(255)," +
                "FOREIGN  KEY (NICKNAMECUENTA) REFERENCES  CUENTAS(NICKNAME));";

        try{
            preparedStatement = con.prepareStatement(createRegistros);
            preparedStatement.executeUpdate();

            System.out.println("Tabla registros creada correctamente.");

        }catch (Exception e) {
            System.err.println("No se han podido crear la tabla registros.\n"+e.getMessage());
        }

    }

    private static void InsertarDatosIniciales(Connection con){
        PreparedStatement preparedStatement;

        try {

            String query = " INSERT INTO CUENTAS (NICKNAME, CONTRASEÑA, TIPO)"
                    + " VALUES (?, ?, ?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, "admin1");
            preparedStatement.setString(2, "pass1");
            preparedStatement.setInt(3, 1);
            preparedStatement.execute();

            preparedStatement.setString(1, "admin2");
            preparedStatement.setString(2, "pass2");
            preparedStatement.setInt(3, 1);
            preparedStatement.execute();

            preparedStatement.setString(1, "admin3");
            preparedStatement.setString(2, "pass3");
            preparedStatement.setInt(3, 1);
            preparedStatement.execute();

            preparedStatement.setString(1, "admin4");
            preparedStatement.setString(2, "pass4");
            preparedStatement.setInt(3, 1);
            preparedStatement.execute();


            preparedStatement.close();

            System.out.println("Datos insertados en Cuentas correctamente.");


        } catch (SQLException e) {

            System.out.println("Error en la inserción de cuentas.");
            e.printStackTrace();
        }

    }



}
