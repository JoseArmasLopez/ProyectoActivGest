package AppActivGest.src.controlador;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import modelo.Actividad;
import modelo.Empleado;
import modelo.Usuario;

import java.sql.Date;

public class DB4O {

    final static String BDCentrosCivicos = "DBCentrosCivicos.yap";

    private ObjectContainer rootContainer;

    // Abrir la base de datos
    ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDCentrosCivicos);

    modelo.Empleado e1 = new modelo.Empleado("73747576A", "Maider", "Guinea", "Martinez", new Date(1978, 11, 21),
            new Date(2012, 10, 11), "oficial de control");
    



    public static boolean guardarEmpleado(modelo.Empleado empl) {

        // Abrimos conexión
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDCentrosCivicos);
        // Guardamos el empleado
        db.store(empl);
        javax.swing.JOptionPane.showMessageDialog(null, "Guardado");
        // Cerramos el empleado
        db.close();
        return true;

    }

    public static boolean modificarEmpleado(modelo.Empleado empl, modelo.Empleado datos) {

        // Abrimos conexión
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDCentrosCivicos);

        // Obtenemos el resultado
        ObjectSet result = db.queryByExample(empl);

        // Recorremos el resultado
        while (result.hasNext()) {
            // Obtener empleado
            modelo.Empleado e = (modelo.Empleado) result.next();

            // Indicamos los nuevos datos del empleado
            e.setDni(datos.getDni());
            e.setNombre(datos.getNombre());
            e.setApellido1(datos.getApellido1());
            e.setApellido2(datos.getApellido2());
            e.setFechanac(datos.getFechanac());
            e.setFechacontract(datos.getFechacontract());
            e.setCargo(datos.getCargo());

            javax.swing.JOptionPane.showMessageDialog(null, "Modificado");
            db.store(e);
        }


        return true;
    }


    public static boolean eliminarEmpleado(Empleado emple) {

        //Abrimos los conexion
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDCentrosCivicos);

        //Obtenemos el resultado
        ObjectSet result = db.queryByExample(emple);

        //Recorremos el resultado
        while (result.hasNext()) {
            //Obtenemos Empleado
            modelo.Empleado e = (modelo.Empleado) result.next();

            //Borramos el empleado
            db.delete(e);
        }

        //Cerramos la bd
        db.close();

        return true;
    }


    // Obtener Empleado concreto
    public static Empleado visualizarEmpleado(Empleado empl) {
        //Abrimos la conexion
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDCentrosCivicos);

        Empleado empleado = null;

        //Obtenemos el resultado
        ObjectSet result = db.queryByExample(empl);

        if (result.size() > 0) {
            empleado = (Empleado) result.next();
        }

        //Cerramos la conexion
        db.close();

        return empleado;
    }

    public static boolean guardarActividad(modelo.Actividad actividad) {

        // Abrimos conexión
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDCentrosCivicos);
        // Guardamos la actividad
        db.store(actividad);
        javax.swing.JOptionPane.showMessageDialog(null, "Guardado");
        // Cerramos la actividad
        db.close();
        return true;

    }

    public static boolean modificarActividad(modelo.Actividad actividad, modelo.Actividad datos) {

        // Abrimos conexión
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDCentrosCivicos);

        // Obtenemos el resultado
        ObjectSet result = db.queryByExample(actividad);

        // Recorremos el resultado
        while (result.hasNext()) {
            // Obtener actividad
            modelo.Actividad acti = (Actividad) result.next();

            // Indicamos los nuevos datos de la actividad
            acti.setNumactividad(datos.getNumactividad());
            acti.setNombre(datos.getNombre());
            acti.setNumeromaxinvitado(datos.getNumeromaxinvitado());
            acti.setNombresala(datos.getNombresala());
            acti.setCoste(datos.getCoste());

            javax.swing.JOptionPane.showMessageDialog(null, "Modificado");
            db.store(acti);
        }


        return true;
    }


    public static boolean eliminarActividad(Actividad actividad) {

        //Abrimos los conexion
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDCentrosCivicos);

        //Obtenemos el resultado
        ObjectSet result = db.queryByExample(actividad);

        //Recorremos el resultado
        while (result.hasNext()) {
            //Obtenemos actividad
            Actividad acti = (Actividad) result.next();

            //Borramos actividad
            db.delete(acti);
        }

        //Cerramos la bd
        db.close();

        return true;
    }


    // Obtener un actividad
    public static Actividad visualizarActividad(Actividad actividad) {
        //Abrimos la conexion
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDCentrosCivicos);

        Actividad acti = null;

        //Obtenemos el resultado
        ObjectSet result = db.queryByExample(actividad);

        if (result.size() > 0) {
            acti = (Actividad) result.next();
        }

        //Cerramos la conexion
        db.close();

        return acti;
    }

    public static boolean guardarUsuario(modelo.Usuario usuario) {

        // Abrimos conexión
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDCentrosCivicos);
        // Guardamos el usuario
        db.store(usuario);
        javax.swing.JOptionPane.showMessageDialog(null, "Guardado");
        // Cerramos el usuario
        db.close();
        return true;

    }

    public static boolean modificarUsuario(modelo.Usuario usuario, modelo.Usuario datos) {

        // Abrimos conexión
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDCentrosCivicos);

        // Obtenemos el resultado
        ObjectSet result = db.queryByExample(usuario);

        // Recorremos el resultado
        while (result.hasNext()) {
            // Obtener usuario
             modelo.Usuario u = (modelo.Usuario) result.next();

            // Indicamos los nuevos datos del usuario
            u.setDni(datos.getDni());
            u.setNombre(datos.getNombre());
            u.setApellido1(datos.getApellido1());
            u.setApellido2(datos.getApellido2());
            u.setEdad(datos.getEdad());

            javax.swing.JOptionPane.showMessageDialog(null, "Modificado");
            db.store(u);
        }


        return true;
    }


    public static boolean eliminarUsuario(modelo.Usuario usuario) {

        //Abrimos los conexion
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDCentrosCivicos);

        //Obtenemos el resultado
        ObjectSet result = db.queryByExample(usuario);

        //Recorremos el resultado
        while (result.hasNext()) {
            //Obtenemos usuario
            modelo.Usuario u = (modelo.Usuario) result.next();

            //Borramos usuario
            db.delete(u);
        }

        //Cerramos la bd
        db.close();

        return true;
    }


    // Obtener un usuario
    public static Usuario visualizarUsuario(Usuario usuario) {
        //Abrimos la conexion
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDCentrosCivicos);

        modelo.Usuario u = null;

        //Obtenemos el resultado
        ObjectSet result = db.queryByExample(usuario);

        if (result.size() > 0) {
            u = (Usuario) result.next();
        }

        //Cerramos la conexion
        db.close();

        return u;
    }

}