package controlador.sqlite;

import com.company.Main;

import javax.xml.validation.Schema;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MetadatoBd {

    //Atributos
    private Connection connection = null;
    private Statement st = null;
    private DatabaseMetaData metadatos = null;
    private ResultSetMetaData rsmetadatos = null;

    //Constructor
    public MetadatoBd(Connection connection) {
        this.connection = connection;

        try {
            System.out.println("Obteniendo información de la base de datos Hegoalde");

            //obtengo los metadatos
            this.metadatos = this.connection.getMetaData();

            // nombre del producto
            System.out.println("Nombre de Producto: " + this.metadatos.getDatabaseProductName());

            //Version de producto
            System.out.println("Version de Producto: " + this.metadatos.getDatabaseProductVersion());

            //Nombre de driver
            System.out.println("Nombre de Driver: " + this.metadatos.getDriverName());

            //Version de driver
            System.out.println("Version de Driver: " + this.metadatos.getDriverVersion());

            //Tablas
            ResultSet rst = null;
            ResultSet rsc;
            rst = this.metadatos.getTables(null, null, null, null);
            String tabla = "";
    /*
            while (rst.next()) {
                tabla = rst.getObject(3).toString();
                System.out.println("Nombre de Tabla: " + tabla);
                //primary key si existe
                ResultSet rsp = this.metadatos.getPrimaryKeys(null, null,tabla);
                if (rsp.next())
                    System.out.println("Primary Key: " + rsp.getObject(4));
                rsp.close();

                //columnas y tipos
                rsc = metadatos.getColumns(null, null, tabla, null);
                while (rsc.next()) {
                    System.out.println("Columna " + rsc.getString(4));
                    System.out.println("Tipo " + rsc.getInt(5));
                }

                rsc.close();

            }
            rst.close();*/
            /*ResultSetMetaData

             * Obteniendo Informacion sobre una consulta con un ResultSet

             */
            System.out.println("Obteniendo Informacion sobre una consulta con un ResultSet");

            ResultSet rs = st.executeQuery("select * from actividades");

            rsmetadatos = rs.getMetaData();

            //obteniendo numero de columnas

            int col = rsmetadatos.getColumnCount();

            System.out.println("Columnas: " + col);

            for (int i = 1; i <= col; i++) {

                System.out.println("Nombre de Columa: " + rsmetadatos.getColumnName(i));

                System.out.println("Tipo de Dato: " + rsmetadatos.getColumnTypeName(i));

                System.out.println("Pertenece a la tabla: " + rsmetadatos.getTableName(i) + "\n");

            }

        } catch (Exception e) {

            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);

        }


    }


}
