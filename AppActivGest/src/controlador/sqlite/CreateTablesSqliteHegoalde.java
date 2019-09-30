package controlador.sqlite;

import controlador.ControladorBbDd;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class CreateTablesSqliteHegoalde {

    public static void main(String[] args) throws SQLException {

        Connection c = conectorBd();

        crearTablas(c);

        insertarEmpleados(c);

        insertarActividades(c);

        insertarUsuarios(c);


    }

    private static  Connection conectorBd() {

        String url = "jdbc:sqlite:hegoalde.db";
        Connection conexion = null;

        try {

            Class.forName("org.sqlite.JDBC");

            conexion = DriverManager.getConnection(url);
            if (conexion!=null) {
                System.out.println("Conectado");
            }
        }catch (Exception ex) {
            System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
        }

        return conexion;
    }

    private static void crearTablas(Connection conexion) {

        String createActividades = "Create table actividades("
                + "numactividad text primary key not null,"
                + "nombre text not null,"
                + "numeromaximoinvitado int not null,"
                + "nombresala text,"
                + "coste double,"
                + "fecha DATETIME DEFAULT CURRENT_TIMESTAMP,"
                + "horario DATETIME DEFAULT CURRENT_TIMESTAMP,"
                + "dniempleado text,"
                + "dniusuario text,"
                + "FOREIGN KEY (dniempleado) REFERENCES empleados(dni),"
                + "FOREIGN KEY (dniusuario) REFERENCES usuarios(dni)"
                + ")";

        String createEmpleados = "Create table empleados("
                + "dni text primary key not null,"
                + "nombre text not null,"
                + "apellido1 text,"
                + "apellido2 text,"
                + "fechanac DATETIME DEFAULT CURRENT_TIMESTAMP,"
                + "fechacontract DATETIME DEFAULT CURRENT_TIMESTAMP,"
                + "cargo texto"
                + ")";


        String createUsuarios = "Create table usuarios("
                + "dni text primary key not null,"
                + "nombre text not null,"
                + "apellido1 text,"
                + "apellido2 text,"
                + "edad int,"
                + "idactividad text," +
                "  FOREIGN KEY (idactividad) references actividades(numactividad)"
                + ")";
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

            System.out.println("*** PROCESO DE CREACIÓN DE TABLAS FINALIZADO ****");





        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertarActividades(Connection con){

        try {

            String query = "INSERT INTO actividades (numactividad,nombre,numeromaximoinvitado,"
                    + " nombresala,coste,fecha,horario,dniempleado,dniusuario ) VALUES(?,?,?,?,?,?,?,?,?)";

            java.sql.Statement statement = con.createStatement();

            PreparedStatement ps;
            ps = con.prepareStatement(query);

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());


            ps.setString(1, "1");
            ps.setString(2, "Padel");
            ps.setInt(3, 10);
            ps.setString(4, "Sala padel");
            ps.setString(5, "10 ");
            ps.setTimestamp(6, timestamp);
            ps.setString(7, "08:00 - 09:00");
            ps.setString(8, "44686144L");
            ps.setString(9, "Oscar");

            ps.execute();
            ps.close();

            System.out.println("Datos insertados en actividades correctamente");


        } catch (SQLException e) {

            System.out.println("Error en la insercción de datos...");
            e.printStackTrace();
        }



    }

    private static void insertarUsuarios(Connection con){

        try {

            String query = "INSERT INTO usuarios VALUES(?,?,?,?,?,?)";

            PreparedStatement ps;
            ps = con.prepareStatement(query);

            ps.setString(1, "44686144L");
            ps.setString(2, "Jose");
            ps.setString(3, "Armas");
            ps.setString(4, "López ");
            ps.setInt(5,39);
            ps.setString(6, "1");

            ps.execute();
            ps.close();

            System.out.println("Datos insertados  en usuarios correctamente");


        } catch (SQLException e) {

            System.out.println("Error en la insercción de datos...");
            e.printStackTrace();
        }

    }

    private static void insertarEmpleados(Connection con){

        try {

            String query = "INSERT INTO empleados VALUES (?,?,?,?,?,?,?)";


            PreparedStatement ps = con.prepareStatement(query);

            System.out.println(ps);

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());


            ps.setString(1, "1");
            ps.setString(2, "Ander");
            ps.setString(3, "Pérez");
            ps.setString(4, "Pérez ");
            ps.setTimestamp(5, timestamp);
            ps.setTimestamp(6, timestamp);
            ps.setString(7, "Conserje");

            int row = ps.executeUpdate();

            // rows affected
            System.out.println(row); //1

            ps.close();

            System.out.println("Datos insertados en empleados correctamente");


        } catch (SQLException e) {

            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());            e.printStackTrace();
        }catch (Exception e){

            e.printStackTrace();

        }



    }



}


