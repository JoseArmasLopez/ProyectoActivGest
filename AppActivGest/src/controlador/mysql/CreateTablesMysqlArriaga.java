package controlador.mysql;

import modelo.Actividad;
import modelo.Sesion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTablesMysqlArriaga {

    public static void main(String[] args) {

        Connection con = Conexion();

        MysqlConsultas mysqlConsultas = new MysqlConsultas(con);
        BorrarTablas(con);
        CrearTablas(con);
        InsertarEmpleados(con);
        InsertarActividad(con);
        InsertarUsuarios(con);
        InsertarSesiones(con);




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

    private static void BorrarTablas(Connection con){
        PreparedStatement preparedStatement;

        String borrarSesion =  "DROP TABLE IF EXISTS SESION";
        String borrarUsuarios =  "DROP TABLE IF EXISTS USUARIOS";
        String borrarActividades =  "DROP TABLE IF EXISTS ACTIVIDADES";
        String borrarEmpleados =  "DROP TABLE IF EXISTS EMPLEADOS";

        try{
            preparedStatement = con.prepareStatement(borrarSesion);
            preparedStatement.executeUpdate();

            System.out.println("Tabla sesion eliminada correctamente.");

        }catch (Exception e) {
            System.err.println("Error al eliminar la tabla sesión.");
            e.getMessage();
        }



        try{
            preparedStatement = con.prepareStatement(borrarUsuarios);
            preparedStatement.executeUpdate();

            System.out.println("Tabla usuarios eliminada correctamente.");

        }catch (Exception e) {
            System.err.println("Error al eliminar la tabla usuarios.");
            e.getMessage();
        }


        try{
            preparedStatement = con.prepareStatement(borrarActividades);
            preparedStatement.executeUpdate();

            System.out.println("Tabla actividades eliminada correctamente.");

        }catch (Exception e) {
            System.err.println("Error al eliminar la tabla actividades.");
            e.getMessage();
        }


        try{
            preparedStatement = con.prepareStatement(borrarEmpleados);
            preparedStatement.executeUpdate();

            System.out.println("Tabla empleados eliminada correctamente.");

        }catch (Exception e) {
            System.err.println("Error al eliminar la tabla empleados.");
            e.getMessage();
        }
    }

    private static void CrearTablas(Connection con){

        PreparedStatement preparedStatement = null;


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
                "FOREIGN  KEY (DNIEMPLEADO) REFERENCES  EMPLEADOS(DNI) ON DELETE SET NULL);";

        //PROBLEMA CON TABLAS DNI Usuario sin tabla creada
        String createUsuarios = "CREATE TABLE USUARIOS(" +
                "DNI VARCHAR(9) PRIMARY KEY NOT NULL," +
                "NOMBRE VARCHAR(255) NOT NULL," +
                "APELLIDO1 VARCHAR(255)," +
                "APELLIDO2 VARCHAR(255)," +
                "EDAD INT," +
                "PROFESION VARCHAR (20));";

        String createSesion = "CREATE TABLE SESION(" +
                "IDSESION INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                "HORA VARCHAR(5)," +
                "DIASEMANA VARCHAR(255)," +
                "NUMACTIVIDAD VARCHAR(255)," +
                "DNIUSUARIO VARCHAR(9)," +
                "FOREIGN KEY (NUMACTIVIDAD) REFERENCES ACTIVIDADES(NUMACTIVIDAD) ON DELETE CASCADE," +
                "FOREIGN KEY (DNIUSUARIO) REFERENCES  USUARIOS(DNI) ON DELETE CASCADE);";


        //NOTAS:
        //DOS TIPOS DE FECHA LAS DE DÍAS TENDRÁN ÉSTE FORMATO: 25-04-2019 (10 DÍGITOS)
        //Y LAS DE HORAS TENDRÁN ÉSTE OTRO: 13:45 (5 DÍGITOS)

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

        try{
            preparedStatement = con.prepareStatement(createSesion);
            preparedStatement.executeUpdate();


            System.out.println("Tabla sesión creada correctamente.");

        }catch (Exception e) {
            System.err.println("No se han podido crear la tabla sesión de Arriaga.\n"+e.getMessage());
        }



    }

    private static void InsertarEmpleados(Connection con){

        PreparedStatement preparedStatement;

        try {



            String query = " INSERT INTO EMPLEADOS (DNI, NOMBRE, APELLIDO1, APELLIDO2,FECHACONTRACT, FECHANAC, NACIONALIDAD, CARGO)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, "23665412N");
            preparedStatement.setString(2, "Pepito");
            preparedStatement.setString(3, "Rodriguez");
            preparedStatement.setString(4, "Escuela");
            preparedStatement.setString(5,"03-19-2005");
            preparedStatement.setString(6,"05-14-1985");
            preparedStatement.setString(7, "Española");
            preparedStatement.setString(8, "Monitor de esgrima");
            preparedStatement.execute();


            preparedStatement.setString(1, "54855695L");
            preparedStatement.setString(2, "Juanjo");
            preparedStatement.setString(3, "Ramirez");
            preparedStatement.setString(4, "Branson");
            preparedStatement.setString(5,"25-05-2008");
            preparedStatement.setString(6,"05-10-1995");
            preparedStatement.setString(7, "Francesa");
            preparedStatement.setString(8, "Conserje");
            preparedStatement.execute();

            preparedStatement.setString(1, "23366859L");
            preparedStatement.setString(2, "Alfonso");
            preparedStatement.setString(3, "Martín");
            preparedStatement.setString(4, "De la Vega");
            preparedStatement.setString(5,"22-03-2010");
            preparedStatement.setString(6,"11-11-1994");
            preparedStatement.setString(7, "Española");
            preparedStatement.setString(8, "Monitor de Kárate");
            preparedStatement.execute();

            preparedStatement.setString(1, "85799545N");
            preparedStatement.setString(2, "Manolo");
            preparedStatement.setString(3, "Gonzalez");
            preparedStatement.setString(4, "Soria");
            preparedStatement.setString(5,"27-08-2015");
            preparedStatement.setString(6,"15-12-1997");
            preparedStatement.setString(7, "Española");
            preparedStatement.setString(8, "Monitor de Yoga");
            preparedStatement.execute();

            preparedStatement.setString(1, "54688521N");
            preparedStatement.setString(2, "María");
            preparedStatement.setString(3, "Prado");
            preparedStatement.setString(4, "Gallardo");
            preparedStatement.setString(5,"05-06-2014");
            preparedStatement.setString(6,"01-04-1988");
            preparedStatement.setString(7, "Italiana");
            preparedStatement.setString(8, "Monitora de Atletísmo");
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

            String query = " INSERT INTO ACTIVIDADES (NUMACTIVIDAD, NOMBRE, NUMEROMAXIMOINVITADO, NOMBRESALA, CURSOACADEMICO, COSTE, DNIEMPLEADO)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, "001");
            preparedStatement.setString(2, "Esgrima");
            preparedStatement.setInt(3, 20);
            preparedStatement.setString(4, "Sala cinco norte");
            preparedStatement.setString(5,"2019-2020");
            preparedStatement.setDouble(6,60);
            preparedStatement.setString(7, "23665412N");
            preparedStatement.execute();

            preparedStatement.setString(1, "002");
            preparedStatement.setString(2, "Atletismo");
            preparedStatement.setInt(3, 25);
            preparedStatement.setString(4, "Sala tres norte");
            preparedStatement.setString(5,"2019-2020");
            preparedStatement.setDouble(6,40);
            preparedStatement.setString(7, "54688521N");
            preparedStatement.execute();

            preparedStatement.setString(1, "003");
            preparedStatement.setString(2, "Yoga");
            preparedStatement.setInt(3, 30);
            preparedStatement.setString(4, "Sala ocho norte");
            preparedStatement.setString(5,"2019-2020");
            preparedStatement.setDouble(6,30);
            preparedStatement.setString(7, "85799545N");
            preparedStatement.execute();

            preparedStatement.setString(1, "004");
            preparedStatement.setString(2, "Kárate");
            preparedStatement.setInt(3, 15);
            preparedStatement.setString(4, "Sala cuatro norte");
            preparedStatement.setString(5,"2019-2020");
            preparedStatement.setDouble(6,35);
            preparedStatement.setString(7, "23366859L");
            preparedStatement.execute();


            preparedStatement.close();

            System.out.println("Datos insertados en actividades de arriaga correctamente.");


        } catch (SQLException e) {

            System.out.println("Error en la inserción de actividad en arriaga.");
            e.printStackTrace();
        }

    }

    private static void InsertarUsuarios(Connection con){

        PreparedStatement preparedStatement;


        try {


            String query = " INSERT INTO USUARIOS (DNI, NOMBRE, APELLIDO1, APELLIDO2, EDAD, PROFESION)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, "54865452L");
            preparedStatement.setString(2, "Juanjo");
            preparedStatement.setString(3, "Pascual");
            preparedStatement.setString(4, "Ruiz");
            preparedStatement.setInt(5,25);
            preparedStatement.setString(6, "Picapedrero");
            preparedStatement.execute();

            preparedStatement.setString(1, "25466985L");
            preparedStatement.setString(2, "Federico");
            preparedStatement.setString(3, "Carrasco");
            preparedStatement.setString(4, "Abasolo");
            preparedStatement.setInt(5,33);
            preparedStatement.setString(6, "Programador");
            preparedStatement.execute();

            preparedStatement.setString(1, "23544698N");
            preparedStatement.setString(2, "Felipe");
            preparedStatement.setString(3, "Hervás");
            preparedStatement.setString(4, "Cardona");
            preparedStatement.setInt(5,28);
            preparedStatement.setString(6, "Jardinero");
            preparedStatement.execute();

            preparedStatement.setString(1, "54855216L");
            preparedStatement.setString(2, "Verónica");
            preparedStatement.setString(3, "Cuesta");
            preparedStatement.setString(4, "Fuente");
            preparedStatement.setInt(5,22);
            preparedStatement.setString(6, "Policía");
            preparedStatement.execute();


            preparedStatement.close();

            System.out.println("Datos insertados en usuarios de arriaga correctamente.");


        } catch (SQLException e) {

            System.out.println("Error en la inserción del usuario en arriaga.");
            e.printStackTrace();
        }

    }

    private static void InsertarSesiones(Connection con){

        PreparedStatement preparedStatement;


        try {



            String query = " INSERT INTO SESION (HORA, DIASEMANA, NUMACTIVIDAD, DNIUSUARIO)"
                    + " VALUES (?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, "16:30");
            preparedStatement.setString(2, "Miercoles");
            preparedStatement.setString(3, "001");
            preparedStatement.setString(4,"54865452L");
            preparedStatement.execute();

            preparedStatement.setString(1, "17:30");
            preparedStatement.setString(2, "Jueves");
            preparedStatement.setString(3, "002");
            preparedStatement.setString(4,"23544698N");
            preparedStatement.execute();

            preparedStatement.setString(1, "18:20");
            preparedStatement.setString(2, "Lunes");
            preparedStatement.setString(3, "002");
            preparedStatement.setString(4,"23544698N");
            preparedStatement.execute();

            preparedStatement.setString(1, "17:30");
            preparedStatement.setString(2, "Martes");
            preparedStatement.setString(3, "003");
            preparedStatement.setString(4,"23544698N");
            preparedStatement.execute();


            preparedStatement.close();

            System.out.println("Datos insertados en usuarios de arriaga correctamente.");


        } catch (SQLException e) {

            System.out.println("Error en la inserción de usuarios en arriaga.");
            e.printStackTrace();
        }

    }



}
