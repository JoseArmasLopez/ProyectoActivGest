package controlador.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CreateTablesSqliteHegoalde {

    public static void main(String[] args) {

        SqliteConector conexion = new SqliteConector();

        conexion.connect();

        Connection conn = conexion.getConn();

        String createActividades = "Create table actividades("
                + "numactividad text primary key not null,"
                + "nombre text not null,"
                + "numeromaximoinvitado int not null,"
                + "nombresala text,"
                + "coste double,"
                + "fecha date,"
                + "horario date,"
                + "dniempleado text references empleados(dni),"
                + "dniusuario text references usuarios(dni)"
                + ")";

        String createEmpleados = "Create table empleados("
                + "dni text primary key not null,"
                + "nombre text not null,"
                + "apellido1 text,"
                + "apellido2 text,"
                + "fechacontract date,"
                + "cargo texto"
                + ")";


        String createUsuarios = "Create table usuarios("
                + "dni text primary key not null,"
                + "nombre text not null,"
                + "apellido1 text,"
                + "apellido2 text,"
                + "edad int,"
                + "idactividad text references actividades(numactividad)"
                + ")";
        try {
            PreparedStatement pst;
            try {
                System.out.println("*** Creando tabla empleados ***");

                pst = conn.prepareStatement(createEmpleados);
                pst.executeUpdate();
                pst.close();

                System.out.println("*** Tabla empleados creada correctamente ***");
            } catch (Exception e) {
                System.out.println("*** Tabla empleados creada INCORRECTAMENTE ***");
                System.out.println(e.getMessage());
            }

            try {
                System.out.println("*** Creando tabla actividades ***");

                pst = conn.prepareStatement(createActividades);
                pst.executeUpdate();
                pst.close();

                System.out.println("*** Tabla actividades creada correctamente ***");
            } catch (Exception e) {
                System.out.println("*** Tabla actividades creada INCORRECTAMENTE ***");
                System.out.println(e.getMessage());
            }


            try {
                System.out.println("*** Creando tabla usuarios ***");

                pst = conn.prepareStatement(createUsuarios);
                pst.executeUpdate();
                pst.close();

                System.out.println("*** Tabla usuarios creada correctamente ***");
            } catch (Exception e) {
                System.out.println("*** Tabla usuarios creada INCORRECTAMENTE ***");
                System.out.println(e.getMessage());
            }

            System.out.println("*** PROCESO DE CREACIÓN DE TABLAS FINALIZADO ****");


            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


