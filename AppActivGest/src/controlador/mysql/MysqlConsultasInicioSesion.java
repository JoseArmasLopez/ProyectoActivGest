package controlador.mysql;

import java.sql.*;
import  java.time.format.DateTimeFormatter;
import  java.time.LocalDateTime;

public class MysqlConsultasInicioSesion {

    public boolean IniciarSesion(String nickName, String contraseña){
        boolean acceso = false;

        Connection con = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/actigest", "root", "");

        }catch (Exception e) {
            System.err.println("No se ha podido conectar a la base de datos Arriaga\n"+e.getMessage());
        }

        try{


            String query = "SELECT NICKNAME, CONTRASEÑA FROM CUENTAS WHERE NICKNAME = '" + nickName + "'";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next())
            {
                String nicknameBD = resultSet.getString("NICKNAME");
                String contraseñaBD = resultSet.getString("CONTRASEÑA");

                if(nickName.equals(nicknameBD) && contraseña.equals(contraseñaBD)){
                    acceso = true;
                }
            }

            resultSet.close();
            statement.close();

        }catch (Exception e) {
            System.err.println("No se ha encontrado la cuenta."+e.getMessage());
        }


        if (acceso == true){

            try {

                PreparedStatement preparedStatement;

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");
                LocalDateTime now = LocalDateTime.now();
                String fecha = dtf.format(now);


                String query = " INSERT INTO REGISTROS (FECHA, NICKNAMECUENTA)"
                        + " VALUES (?, ?)";
                preparedStatement = con.prepareStatement(query);

                preparedStatement.setString(1, fecha);
                preparedStatement.setString(2, nickName);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }



        return acceso;
    }
}
