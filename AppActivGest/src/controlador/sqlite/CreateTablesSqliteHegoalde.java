package controlador.sqlite;

import controlador.ControladorBbDd;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class CreateTablesSqliteHegoalde {

    public static void main(String[] args) throws SQLException {

        Connection c = conectorBd();

        //crearTablas(c);

        //insertarEmpleados(c);

        insertarActividades(c);

        //insertarUsuarios(c);


    }

    private static Connection conectorBd() {

        String url = "jdbc:sqlite:hegoalde.db";
        Connection conexion = null;

        try {

            Class.forName("org.sqlite.JDBC");

            conexion = DriverManager.getConnection(url);
            if (conexion != null) {
                System.out.println("Conectado");
            }
        } catch (Exception ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        }

        return conexion;
    }

    private static void crearTablas(Connection conexion) {

        String createEmpleados = "CREATE TABLE EMPLEADOS(" +
                "DNI VARCHAR(255) PRIMARY KEY NOT NULL," +
                "NOMBRE VARCHAR(255) NOT NULL," +
                "APELLIDO1 VARCHAR(255)," +
                "APELLIDO2 VARCHAR(255)," +
                "FECHACONTRACT VARCHAR(10)," +
                "FECHANAC VARCHAR(10)," +
                "NACIONALIDAD VARCHAR(20)," +
                "CARGO VARCHAR(255));";


        String createActividades = "CREATE TABLE ACTIVIDADES(" +
                "NUMACTIVIDAD VARCHAR(255) PRIMARY KEY NOT NULL," +
                "NOMBRE VARCHAR(255) NOT NULL," +
                "NUMEROMAXIMOINVITADO INT NOT NULL," +
                "NOMBRESALA VARCHAR(20)," +
                "CURSOACADEMICO VARCHAR (20)," +
                "COSTE DOUBLE," +
                "DNIEMPLEADO VARCHAR(255)," +
                "FOREIGN  KEY (DNIEMPLEADO) REFERENCES  EMPLEADOS(DNI));";

        //PROBLEMA CON TABLAS DNI Usuario sin tabla creada
        String createUsuarios = "CREATE TABLE USUARIOS(" +
                "DNI VARCHAR(9) PRIMARY KEY NOT NULL," +
                "NOMBRE VARCHAR(255) NOT NULL," +
                "APELLIDO1 VARCHAR(255)," +
                "APELLIDO2 VARCHAR(255)," +
                "EDAD INT," +
                "PROFESION VARCHAR (20));";

        String createSesion = "CREATE TABLE SESION(" +
                "IDSESION INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "HORA VARCHAR(5)," +
                "DIASEMANA VARCHAR(255)," +
                "NUMACTIVIDAD VARCHAR(255)," +
                "DNIUSUARIO VARCHAR(9)," +
                "FOREIGN KEY (NUMACTIVIDAD) REFERENCES ACTIVIDADES(NUMACTIVIDAD)," +
                "FOREIGN KEY (DNIUSUARIO) REFERENCES  USUARIOS(DNI));";

        //NOTAS:
        //DOS TIPOS DE FECHA LAS DE DÍAS TENDRÁN ÉSTE FORMATO: 25-04-2019 (10 DÍGITOS)
        //Y LAS DE HORAS TENDRÁN ÉSTE OTRO: 13:45 (5 DÍGITOS)
        try {
            PreparedStatement pst;
            try {
                System.out.println("*** Creando tabla empleados ***");

                assert conexion != null;
                pst = conexion.prepareStatement(createEmpleados);
                pst.executeUpdate();
                pst.close();

                System.out.println("*** Tabla empleados creada correctamente ***");
            } catch (Exception e) {
                System.out.println("*** Tabla empleados creada INCORRECTAMENTE ***");
                System.out.println(e.getMessage());
            }

            try {
                System.out.println("*** Creando tabla actividades ***");

                assert conexion != null;
                pst = conexion.prepareStatement(createActividades);
                pst.executeUpdate();
                pst.close();

                System.out.println("*** Tabla actividades creada correctamente ***");
            } catch (Exception e) {
                System.out.println("*** Tabla actividades creada INCORRECTAMENTE ***");
                System.out.println(e.getMessage());
            }

            try {
                System.out.println("*** Creando tabla usuarios ***");

                assert conexion != null;
                pst = conexion.prepareStatement(createUsuarios);
                pst.executeUpdate();
                pst.close();

                System.out.println("*** Tabla usuarios creada correctamente ***");
            } catch (Exception e) {
                System.out.println("*** Tabla usuarios creada INCORRECTAMENTE ***");
                System.out.println(e.getMessage());
            }

            try {
                System.out.println("*** Creando tabla sesion ***");

                assert conexion != null;
                pst = conexion.prepareStatement(createSesion);
                pst.executeUpdate();
                pst.close();

                System.out.println("*** Tabla sesion creada correctamente ***");
            } catch (Exception e) {
                System.out.println("*** Tabla sesion creada INCORRECTAMENTE ***");
                System.out.println(e.getMessage());
            }

            System.out.println("*** PROCESO DE CREACIÓN DE TABLAS FINALIZADO ****");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertarActividades(Connection con) {

        try {

            String query = "INSERT INTO actividades (numactividad,nombre,numeromaximoinvitado,"
                    + "nombresala,cursoacademico,coste) VALUES(?,?,?,?,?,?)";

            java.sql.Statement statement = con.createStatement();

            PreparedStatement ps;
            ps = con.prepareStatement(query);


            ps.setString(1, "1");
            ps.setString(2, "Padel");
            ps.setInt(3, 10);
            ps.setString(4, "Sala padel");
            ps.setString(5, "2018/2019");
            ps.setDouble(6, 20);


            ps.execute();
            ps.close();

            System.out.println("Datos insertados en actividades correctamente");


        } catch (SQLException e) {

            System.out.println("Error en la insercción de datos...");
            e.printStackTrace();
        }


    }

    private static void insertarUsuarios(Connection con) {

        try {

            String query = "INSERT INTO usuarios VALUES(?,?,?,?,?,?)";

            PreparedStatement ps;
            ps = con.prepareStatement(query);

            ps.setString(1, "44686144L");
            ps.setString(2, "Jose");
            ps.setString(3, "Armas");
            ps.setString(4, "López ");
            ps.setInt(5, 39);
            ps.setString(6, "conserje");

            ps.execute();
            ps.close();

            System.out.println("Datos insertados  en usuarios correctamente");


        } catch (SQLException e) {

            System.out.println("Error en la insercción de datos...");
            e.printStackTrace();
        }

    }

    private static void insertarEmpleados(Connection con) {

        try {

            String query = "INSERT INTO empleados VALUES (?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, "1");
            ps.setString(2, "Ander");
            ps.setString(3, "Pérez");
            ps.setString(4, "Pérez ");
            ps.setString(5, "01/10/2019");
            ps.setString(6, "04/02/1980");
            ps.setString(7,"Española");
            ps.setString(8, "Conserje");

            int row = ps.executeUpdate();

            // rows affected
            //System.out.println(row); //1

            ps.close();

            System.out.println("Datos insertados en empleados correctamente");


        } catch (SQLException e) {

            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();

        }


    }


}


