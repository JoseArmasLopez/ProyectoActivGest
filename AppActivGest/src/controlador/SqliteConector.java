package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
}
