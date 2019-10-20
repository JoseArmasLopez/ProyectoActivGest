package controlador.sqlite;

import com.company.Main;
import modelo.TablaBD;

import javax.xml.validation.Schema;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MetadatoBd {

    //Atributos
    private Connection connection = null;
    private Statement st = null;
    private DatabaseMetaData metadatos = null;
    private ResultSetMetaData rsmetadatos = null;

    private ArrayList<TablaBD> metadatoBdList = new ArrayList<>();

    //Constructor
    public MetadatoBd(Connection connection) {
        this.connection = connection;

        TablaBD tablaBD;

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
            String[] tipos = {"TABLE"};
            ResultSet rst = this.metadatos.getTables(null, null, null, tipos);

            //Schemas
            String tabla = "";
            String schema = "";

            while (rst.next()) {

                tablaBD = new TablaBD();

                tabla = rst.getObject(3).toString();
                System.out.println("Nombre de Tabla: " + tabla);

                tablaBD.setNombre(tabla);

                //primary key si existe
                ResultSet rsp = this.metadatos.getPrimaryKeys(null, null, tabla);

                //System.out.println("hola");

                if (rsp.next())

                    // System.out.println("hola 2");

                    System.out.println(rsp.toString());
                    // System.out.println("Primary Key: " + rsp.getObject(4));
                    System.out.println("Primary Key: " + rsp.getString("COLUMN_NAME"));

                    //String pk = rsp.getString("COLUM_NAME");
                    //System.out.println(pk);
                    //tablaBD.setPk(pk);

                System.out.println(tablaBD.toString());
                rsp.close();

                ResultSet rsm = this.metadatos.getSchemas();
                System.out.println(rsm.toString());


                //columnas y tipos
                ResultSet rsc = metadatos.getColumns(null, null, tabla, null);
                while (rsc.next()) {
                    System.out.println("Columna " + rsc.getString(4));
                    System.out.println("Tipo " + rsc.getString(6));

                }

                rsc.close();

                metadatoBdList.add(tablaBD);

            }
            rst.close();
            /*ResultSetMetaData

             * Obteniendo Informacion sobre una consulta con un ResultSet

             */
            /*System.out.println("Obteniendo Informacion sobre una consulta con un ResultSet");

            ResultSet rs = st.executeQuery("select * from actividades");

            rsmetadatos = rs.getMetaData();

            //obteniendo numero de columnas

            int col = rsmetadatos.getColumnCount();

            System.out.println("Columnas: " + col);

            for (int i = 1; i <= col; i++) {

                System.out.println("Nombre de Columa: " + rsmetadatos.getColumnName(i));

                System.out.println("Tipo de Dato: " + rsmetadatos.getColumnTypeName(i));

                System.out.println("Pertenece a la tabla: " + rsmetadatos.getTableName(i) + "\n");

            }*/


        } catch (Exception e) {

            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);

        }


    }

    public DatabaseMetaData getMetadatos() {
        return metadatos;
    }

    public ArrayList<TablaBD> getMetadatoBdList() {
        return metadatoBdList;
    }

    public void setMetadatoBdList(ArrayList<TablaBD> metadatoBdList) {
        this.metadatoBdList = metadatoBdList;
    }
}
