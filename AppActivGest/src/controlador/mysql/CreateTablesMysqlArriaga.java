package controlador.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTablesMysqlArriaga {

    /*public static void main(String[] args) {

        Connection con = Conexion();
        CrearTablas(con);//REVISAR LA SEGUNDA CREACION DE TABLA

        InsertarEmpleados(con);
        InsertarActividad(con);
        InsertarUsuarios(con);

    }*/

    private static Connection Conexion(){
        Connection con = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/actigest", "root", "");
            System.out.println("Conexión establecida con arriaga correctamente.");

        }catch (Exception e) {
            System.err.println("No se ha podido conectar a la base de datos Arriaga\n"+e.getMessage());
        }

        return con;
    }

    private static void CrearTablas(Connection con){

        PreparedStatement preparedStatement = null;


        String createEmpleados = "CREATE TABLE EMPLEADOS(" +
                "DNI VARCHAR(255) PRIMARY KEY NOT NULL," +
                "NOMBRE VARCHAR(255) NOT NULL," +
                "APELLIDO1 VARCHAR(255)," +
                "APELLIDO2 VARCHAR(255)," +
                "FECHANAC DATE," +
                "CARGO VARCHAR(255));";


        String createActividades = "CREATE TABLE ACTIVIDADES(" +
                "NUMACTIVIDAD VARCHAR(255) PRIMARY KEY NOT NULL," +
                "NOMBRE VARCHAR(255) NOT NULL," +
                "NUMEROMAXIMOINVITADO INT NOT NULL," +
                "NOMBRESALA VARCHAR(255)," +
                "COSTE DOUBLE," +
                "FECHA DATE," +
                "HORARIO DATE," +
                "DNIEMPLEADO VARCHAR(255)," +
                "FOREIGN  KEY (DNIEMPLEADO) REFERENCES  EMPLEADOS(DNI));";

        //PROBLEMA CON TABLAS DNI Usuario sin tabla creada
        String createUsuarios = "CREATE TABLE USUARIOS(" +
                "DNI VARCHAR(9) PRIMARY KEY NOT NULL," +
                "NOMBRE VARCHAR(255) NOT NULL," +
                "APELLIDO1 VARCHAR(255)," +
                "APELLIDO2 VARCHAR(255)," +
                "EDAD INT," +
                "IDACTIVIDAD VARCHAR(255)," +
                "FOREIGN KEY (IDACTIVIDAD) REFERENCES ACTIVIDADES(NUMACTIVIDAD));";



        try{
            preparedStatement = con.prepareStatement(createEmpleados);
            preparedStatement.executeUpdate();

            System.out.println("Tabla empleados creada correctamente.");

        }catch (Exception e) {
            System.err.println("No se han podido crear la tabla empleados de Arriaga.\n"+e.getMessage());
        }


        try{
            preparedStatement = con.prepareStatement(createActividades);
            preparedStatement.executeUpdate();


            System.out.println("Tabla actividades creada correctamente.");

        }catch (Exception e) {
            System.err.println("No se han podido crear la tabla actividades de Arriaga.\n"+e.getMessage());
        }

        try{
            preparedStatement = con.prepareStatement(createUsuarios);
            preparedStatement.executeUpdate();


            System.out.println("Tabla usuarios creada correctamente.");

        }catch (Exception e) {
            System.err.println("No se han podido crear la tabla usuarios de Arriaga.\n"+e.getMessage());
        }





    }

    private static void InsertarEmpleados(Connection con){

        PreparedStatement preparedStatement;


        try {

            String query = " INSERT INTO EMPLEADOS (DNI, NOMBRE, APELLIDO1, APELLIDO2, FECHANAC, CARGO)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, "23665412N");
            preparedStatement.setString(2, "Pepito");
            preparedStatement.setString(3, "Rodriguez");
            preparedStatement.setString(4, "Escuela");
            preparedStatement.setString(5,"1985-05-14");
            preparedStatement.setString(6, "Supervisor");

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Datos insertados en empleados de arriaga correctamente.");


        } catch (SQLException e) {

            System.out.println("Error en la inserción de empleados en arriaga.");
            e.printStackTrace();
        }

    }

    private static void InsertarActividad(Connection con){

        PreparedStatement preparedStatement;

        try {

            String query = " INSERT INTO ACTIVIDADES (NUMACTIVIDAD, NOMBRE, NUMEROMAXIMOINVITADO, NOMBRESALA, COSTE, FECHA, HORARIO, DNIEMPLEADO)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, "001");
            preparedStatement.setString(2, "Esgrima");
            preparedStatement.setInt(3, 20);
            preparedStatement.setString(4, "Sala cinco norte");
            preparedStatement.setDouble(5,40);
            preparedStatement.setString(6, "1985-05-14 00:00:00");
            preparedStatement.setString(7, "2019-10-11 16:30:00");
            preparedStatement.setString(8, "23665412N");

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Datos insertados en actividad de arriaga correctamente.");


        } catch (SQLException e) {

            System.out.println("Error en la inserción de actividad en arriaga.");
            e.printStackTrace();
        }

    }

    private static void InsertarUsuarios(Connection con){

        PreparedStatement preparedStatement;


        try {

            String query = " INSERT INTO USUARIOS (DNI, NOMBRE, APELLIDO1, APELLIDO2, EDAD, IDACTIVIDAD)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, "54865452L");
            preparedStatement.setString(2, "Juanjo");
            preparedStatement.setString(3, "Pascual");
            preparedStatement.setString(4, "Ruiz");
            preparedStatement.setInt(5,25);
            preparedStatement.setString(6, "001");

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Datos insertados en usuarios de arriaga correctamente.");


        } catch (SQLException e) {

            System.out.println("Error en la inserción de usuarios en arriaga.");
            e.printStackTrace();
        }

    }

}
