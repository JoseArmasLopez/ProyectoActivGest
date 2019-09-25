package com.company;
import controlador.SqliteConector;

public class Main {

    public static void main(String[] args) {
	// write your code here

        SqliteConector sqliteConector = new SqliteConector();

        sqliteConector.connect();
        sqliteConector.close();



    }
}
