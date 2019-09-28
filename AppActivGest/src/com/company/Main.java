package com.company;
import controlador.ControladorBbDd;
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

        SqliteConsulta sqliteConsulta = new SqliteConsulta(conexionBd);

        sqliteConsulta.actividadesHegoaldeSqlite();


        sqliteConsulta.tablaMostrar(sqliteConsulta.getActividades());



    }
}
