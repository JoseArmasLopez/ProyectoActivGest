package controlador.db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import controlador.ControladorBbDd;
import modelo.Actividad;
import modelo.Empleado;
import modelo.Sesion;
import modelo.Usuario;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;


public class DB4O {

    //---------------------------------------------------------------------DATOS-----------------------------------------------------------------------
    final static String BDIparralde = "CentroCivicoIparralde.yap";

    public DB4O() {
    }

    public void insertarActividad(Actividad eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDIparralde);

        //Guardar actividad
        baseDatos.store(eleccion);

        //Cerrar conexión
        baseDatos.close();

    }

    public Actividad obtenerActividad(Actividad eleccion) {
        //Abrimos la conexion
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDIparralde);

        Actividad actividad = null;

        //Obtener resultado
        ObjectSet result = baseDatos.queryByExample(eleccion);

        // Devolver actividad
        if (result.size() > 0) {
            actividad = (Actividad) result.next();
        }

        // Cerrar la conexión
        baseDatos.close();


        return actividad;
    }

    public ArrayList<Actividad> obtenerActividades(Actividad eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDIparralde);

        //Crear arraylist de empleados
        ArrayList<Actividad> arrayActividades = new ArrayList<>();

        //Obtener resultado
        ObjectSet consulta = baseDatos.queryByExample(eleccion);

        while (consulta.hasNext()) {
            Actividad actividad = (Actividad) consulta.next();

            if (actividad != null) {
                arrayActividades.add(actividad);
            }
        }

        //Cerrar conexión
        baseDatos.close();

        return arrayActividades;
    }

    public void modificarActividad(Actividad eleccion, Actividad nuevosDatos) {
        //Abrir la conexión
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDIparralde);

        //Obtener eleccion
        ObjectSet result = baseDatos.queryByExample(eleccion);

        //Recorremos la eleccion
        while (result.hasNext()) {
            //Obtener la actividad
            Actividad ac = (Actividad) result.next();

            // Nuevos datos
            ac.setNumactividad(nuevosDatos.getNumactividad() != null ? nuevosDatos.getNumactividad() : ac.getNumactividad());
            ac.setNombre(nuevosDatos.getNombre() != null ? nuevosDatos.getNombre() : ac.getNombre());
            ac.setNumeromaxinvitado(nuevosDatos.getNumeromaxinvitado() != 0 ? nuevosDatos.getNumeromaxinvitado() : ac.getNumeromaxinvitado());
            ac.setNombresala(nuevosDatos.getNombresala() != null ? nuevosDatos.getNombresala() : nuevosDatos.getNombresala());
            ac.setCurosAcademico(nuevosDatos.getCurosAcademico() != null ? nuevosDatos.getCurosAcademico() : nuevosDatos.getCurosAcademico());
            ac.setCoste(nuevosDatos.getCoste() != null ? nuevosDatos.getCoste() : nuevosDatos.getCoste());

            baseDatos.store(ac);

        }

        //Cerrar la conexión
        baseDatos.close();
    }

    public void borrarActividad(Actividad eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDIparralde);

        //Obtener resultado
        ObjectSet result = baseDatos.queryByExample(eleccion);


        while (result.hasNext()) {
            //Obtener actividad
            Actividad actividad = (Actividad) result.next();

            //Borrar actividad
            baseDatos.delete(actividad);
        }

        //Cerrar la conexión
        baseDatos.close();
    }

    public Empleado obtenerEmpleado(Empleado eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDIparralde);

        Empleado empleado = null;

        //Obtener el resultado
        ObjectSet result = baseDatos.queryByExample(eleccion);

        if (result.size() > 0) {
            empleado = (Empleado) result.next();
        }

        //Cerrar conexion
        baseDatos.close();

        return empleado;
    }

    public ArrayList<Empleado> obtenerEmpleados(Empleado eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDIparralde);

        //Crear arraylist de empleados
        ArrayList<Empleado> arrayEmpleados = new ArrayList<>();

        //Obtener resultado
        ObjectSet consulta = baseDatos.queryByExample(eleccion);

        while (consulta.hasNext()) {
            //Obtener empleado
            Empleado empleado = (Empleado) consulta.next();

            if (empleado != null) {
                arrayEmpleados.add(empleado);
            }
        }

        //Cerrar conexión
        baseDatos.close();

        return arrayEmpleados;
    }

    public void insertarEmpleado(Empleado eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDIparralde);

        //Guardar empleado
        baseDatos.store(eleccion);

        //Cerrar conexión
        baseDatos.close();

    }

    public void modificarEmpleado(Empleado eleccion, Empleado nuevosDatos) {
        //Abrir la conexión
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDIparralde);

        //Obtener eleccion
        ObjectSet consulta = baseDatos.queryByExample(eleccion);

        //Recorremos la eleccion
        while (consulta.hasNext()) {
            //Obtener el empleado
            Empleado emp = (Empleado) consulta.next();

            // Nuevos datos
            emp.setDni(nuevosDatos.getDni() != null ? nuevosDatos.getDni() : emp.getDni());
            emp.setNombre(nuevosDatos.getNombre() != null ? nuevosDatos.getNombre() : emp.getNombre());
            emp.setApellido1(nuevosDatos.getApellido1() != null ? nuevosDatos.getApellido1() : emp.getApellido1());
            emp.setApellido2(nuevosDatos.getApellido2() != null ? nuevosDatos.getApellido2() : emp.getApellido2());
            emp.setFechanac(nuevosDatos.getFechanac() != null ? nuevosDatos.getFechanac() : emp.getFechanac());
            emp.setFechacontract(nuevosDatos.getFechacontract() != null ? nuevosDatos.getFechacontract() : emp.getFechacontract());
            emp.setCargo(nuevosDatos.getCargo() != null ? nuevosDatos.getCargo() : emp.getCargo());
            emp.setNacionalidad(nuevosDatos.getNacionalidad() != null ? nuevosDatos.getNacionalidad() : emp.getNacionalidad());

            baseDatos.store(emp);

        }

        //Cerrar la conexión
        baseDatos.close();
    }

    public void borrarEmpleado(Empleado eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDIparralde);

        //Obtener resultado
        ObjectSet consulta = baseDatos.queryByExample(eleccion);


        while (consulta.hasNext()) {
            //Obtener empleado
            Empleado empleado = (Empleado) consulta.next();

            //Borrar empleado
            baseDatos.delete(empleado);
        }

        //Cerrar la conexión
        baseDatos.close();
    }

    public Usuario obtenerUsuario(Usuario eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDIparralde);

        Usuario usuario = null;

        //Obtener el resultado
        ObjectSet consulta = baseDatos.queryByExample(eleccion);

        if (consulta.size() > 0) {
            usuario = (Usuario) consulta.next();
        }

        //Cerrar conexion
        baseDatos.close();

        return usuario;
    }

    public ArrayList<Usuario> obtenerUsuarios(Usuario eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDIparralde);

        //Crear arraylist de usuarios
        ArrayList<Usuario> arrayUsuarios = new ArrayList<>();

        //Obtener resultado
        ObjectSet consulta = baseDatos.queryByExample(eleccion);

        while (consulta.hasNext()) {
            //Obtener usuario
            Usuario usuario = (Usuario) consulta.next();

            if (usuario != null) {
                arrayUsuarios.add(usuario);
            }
        }

        //Cerrar conexión
        baseDatos.close();

        return arrayUsuarios;
    }

    public void insertarUsuario(Usuario eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDIparralde);

        //Guardar usuario
        baseDatos.store(eleccion);

        //Cerrar conexión
        baseDatos.close();

    }

    public void modificarUsuario(Usuario eleccion, Usuario nuevosDatos) {
        //Abrir la conexión
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDIparralde);

        //Obtener eleccion
        ObjectSet consulta = baseDatos.queryByExample(eleccion);

        //Recorremos la eleccion
        while (consulta.hasNext()) {
            //Obtener el usuario
            Usuario usu = (Usuario) consulta.next();

            // Nuevos datos
            usu.setDni(nuevosDatos.getDni() != null ? nuevosDatos.getDni() : usu.getDni());
            usu.setNombre(nuevosDatos.getNombre() != null ? nuevosDatos.getNombre() : usu.getNombre());
            usu.setApellido1(nuevosDatos.getApellido1() != null ? nuevosDatos.getApellido1() : usu.getApellido1());
            usu.setApellido2(nuevosDatos.getApellido2() != null ? nuevosDatos.getApellido2() : usu.getApellido2());
            usu.setEdad(nuevosDatos.getEdad() != 0 ? nuevosDatos.getEdad() : usu.getEdad());
            usu.setProfesion(nuevosDatos.getProfesion() != null ? nuevosDatos.getProfesion() : usu.getProfesion());


            baseDatos.store(usu);

        }

        //Cerrar la conexión
        baseDatos.close();
    }

    public void borrarUsuario(Usuario eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDIparralde);

        //Obtener resultado
        ObjectSet consulta = baseDatos.queryByExample(eleccion);


        while (consulta.hasNext()) {
            //Obtener usuario
            Usuario usuario = (Usuario) consulta.next();

            //Borrar usuario
            baseDatos.delete(usuario);
        }

        //Cerrar la conexión
        baseDatos.close();
    }

    public Sesion obtenerSesion(Sesion eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDIparralde);

        Sesion sesion = null;

        //Obtener el resultado
        ObjectSet consulta = baseDatos.queryByExample(eleccion);

        if (consulta.size() > 0) {
            sesion = (Sesion) consulta.next();
        }

        //Cerrar conexion
        baseDatos.close();

        return sesion;
    }

    public ArrayList<Sesion> obtenerSesiones(Sesion eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDIparralde);

        //Crear arraylist de sesiones
        ArrayList<Sesion> arraySesiones = new ArrayList<>();

        //Obtener resultado
        ObjectSet consulta = baseDatos.queryByExample(eleccion);

        while (consulta.hasNext()) {
            //Obtener sesion
            Sesion sesion = (Sesion) consulta.next();

            if (sesion != null) {
                arraySesiones.add(sesion);
            }
        }

        //Cerrar conexión
        baseDatos.close();

        return arraySesiones;
    }

    public void insertarSesion(Sesion eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDIparralde);

        //Guardar sesion
        baseDatos.store(eleccion);

        //Cerrar conexión
        baseDatos.close();

    }

    public void modificarSesion(Sesion eleccion, Sesion nuevosDatos) {
        //Abrir la conexión
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDIparralde);

        //Obtener eleccion
        ObjectSet consulta = baseDatos.queryByExample(eleccion);

        //Recorremos la eleccion
        while (consulta.hasNext()) {
            //Obtener la sesion
            Sesion ses = (Sesion) consulta.next();

            // Nuevos datos
            ses.setHora(nuevosDatos.getHora() != null ? nuevosDatos.getHora() : ses.getHora());
            ses.setDiaSemana(nuevosDatos.getDiaSemana() != null ? nuevosDatos.getDiaSemana() : ses.getDiaSemana());

            baseDatos.store(ses);

        }

        //Cerrar la conexión
        baseDatos.close();
    }

    public static void borrarSesion(Sesion eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDIparralde);

        //Obtener resultado
        ObjectSet consulta = baseDatos.queryByExample(eleccion);


        while (consulta.hasNext()) {
            //Obtener sesion
            Sesion sesion = (Sesion) consulta.next();

            //Borrar sesion
            baseDatos.delete(sesion);
        }

        //Cerrar la conexión
        baseDatos.close();
    }


}



