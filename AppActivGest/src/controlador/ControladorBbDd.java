package controlador;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ControladorBbDd {

    private Connection conexion;
    private String centro;

    public ControladorBbDd(String centro) {
        this.centro = centro;

        switch (this.centro) {

            case "hegoalde":

                try {

                    Class.forName("org.sqlite.JDBC");

                    this.conexion = DriverManager.getConnection("jdbc:sqlite:hegoalde.db");
                    if (conexion != null) {
                        System.out.println("Conectado");

                    }
                } catch (Exception ex) {
                    System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
                }

                break;
            case "iparralde":


            default:
        }
    }
}
