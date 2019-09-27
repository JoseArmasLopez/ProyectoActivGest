package controlador.sqlite;

import modelo.Actividad;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqliteConector {

    private Connection conn = null;

    public SqliteConector() {
    }

    public void connect(){

        try {

            Class.forName("org.sqlite.JDBC");

            conn = DriverManager.getConnection("jdbc:sqlite:hegoalde.db");
            if (conn!=null) {
                System.out.println("Conectado");
            }
        }catch (Exception ex) {
            System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
        }
    }

    public void close(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SqliteConector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Actividad> actividadArrayList(){

        Statement stmt = null;

        ArrayList<Actividad>

        try {

            connect();

            System.out.println("Opened database successfully");

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM HEGOALDE" );

            while ( rs.next() ) {
                String id = rs.getString("numeroactividad");
                String  name = rs.getString("nombre");
                int numeromaxinvit   = rs.getInt("numeromaxinvitado");
                String  nombresal = rs.getString("nombresala");
                double coste = rs.getDouble("coste");
                Date fech = rs.getDate("fecha");
                String hor = rs.getString("horario");

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");

        return null;
    }



}
