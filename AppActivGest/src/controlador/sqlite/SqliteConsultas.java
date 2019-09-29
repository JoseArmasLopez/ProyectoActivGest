package controlador.sqlite;

import modelo.Actividad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class SqliteConsultas {

    // Atributos
    private Connection connection;
    private ArrayList<Actividad> actividades;

    // Seccion constructor
    public SqliteConsultas(Connection connection) {
        this.connection = connection;
    }


    // Funciones
    public void actividadesHegoaldeSqlite() {

        Statement stmt = null;

        actividades = new ArrayList<Actividad>();

        try {

            System.out.println("Opened database successfully");

            stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM HEGOALDE");

            while (rs.next()) {
                String id = rs.getString("numeroactividad");
                String name = rs.getString("nombre");
                int numeromaxinvit = rs.getInt("numeromaxinvitado");
                String nombresal = rs.getString("nombresala");
                double coste = rs.getDouble("coste");
                Date fech = rs.getDate("fecha");
                String hor = rs.getString("horario");

                Actividad actividad = new Actividad(id, name, numeromaxinvit, nombresal, coste, fech, hor);

                this.actividades.add(actividad);

            }
            rs.close();
            stmt.close();
            this.connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operación realizada con éxito");


    }


    // Seccion getters
    public ArrayList<Actividad> getActividades() {
        return actividades;
    }



}
