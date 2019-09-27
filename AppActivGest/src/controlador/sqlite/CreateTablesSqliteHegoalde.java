package controlador.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CreateTablesSqliteHegoalde {

    public static void main(String[] args) {

        SqliteConector conexion = new SqliteConector();

        conexion.connect();

        Connection conn = conexion.getConn();

        String createCategory = "Create table Category("
                + "id text primary key not null,"
                + "name text not null,"
                + "deliverday int not null,"
                + "isdelete bit not null"
                + ")";

        String createCustomer = "Create table Customer("
                + "id text primary key not null,"
                + "name text not null,"
                + "email text not null,"
                + "phone text not null,"
                + "address text not null,"
                + "isdelete boolean not null"
                + ")";


        String createOrder = "Create table Order("
                + "id text primary key not null,"
                + "custid text references Category(id) no null,"
                + "catid text references Customer(id) not null,"
                + "orderdate date not null,"
                + "delieverdate date not null,"
                + "description text not null,"
                + "requirement text not null,"
                + "price int not null,"
                + "image text not null,"
                + "product text not null,"
                + "state text not null,"
                + ")";
        try {
            PreparedStatement pst;
            try {
                System.out.println("*** Create table Category");

                pst = conn.prepareStatement(createCategory);
                pst.executeUpdate();
                pst.close();

                System.out.println("*** Category created Successfully");
            } catch (Exception e) {
                System.out.println("*** Failed to create Category");
                System.out.println(e.getMessage());
            }

            try {
                System.out.println("*** Create table Customer");

                pst = conn.prepareStatement(createCustomer);
                pst.executeUpdate();
                pst.close();

                System.out.println("*** Customer created Successfully");
            } catch (Exception e) {
                System.out.println("*** Failed to create Customer");
                System.out.println(e.getMessage());
            }


            try {
                System.out.println("*** Create table Order");

                pst = conn.prepareStatement(createOrder);
                pst.executeUpdate();
                pst.close();

                System.out.println("*** Order created successsfully");
            } catch (Exception e) {
                System.out.println("*** Failed to create Order");
                System.out.println(e.getMessage());
            }

            System.out.println("*** COMPLETE CREATING TABLE PROCESS ****");


            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


