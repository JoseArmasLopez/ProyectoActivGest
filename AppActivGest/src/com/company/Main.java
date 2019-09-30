package com.company;
import controlador.ControladorBbDd;
import controlador.sqlite.MetadatoBd;
import controlador.sqlite.SqliteConsulta;
import modelo.Actividad;

import java.sql.Connection;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        ControladorBbDd controladorBbDd = new ControladorBbDd("hegoalde");

        Connection conexionBd = null;

        conexionBd = controladorBbDd.getConexion();

        //MetadatoBd metadatoBd = new MetadatoBd(conexionBd);

        SqliteConsulta sqliteConsulta = new SqliteConsulta(conexionBd);

        sqliteConsulta.actividadesHegoaldeSqlite();

        for (Actividad  a:sqliteConsulta.getActividades()
             ) {
             System.out.println("Hola JOse: " + a.getEmpleado().getDni());
        }

        sqliteConsulta.tablaMostrar(sqliteConsulta.getActividades());



    }
}
