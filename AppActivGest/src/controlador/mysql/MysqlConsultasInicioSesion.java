package controlador.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlConsultasInicioSesion {
    Connection con;

    public MysqlConsultasInicioSesion(Connection con) {
        this.con = con;
    }

    public boolean IniciarSesion(String nickName, String contraseña){
        boolean acceso = false;

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

        return acceso;
    }
}
