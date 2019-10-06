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

import static controlador.ControladorBbDd.obtenerDb4o;

public class DB4O {

    //---------------------------------------------------------------------DATOS-----------------------------------------------------------------------



    Actividad actividad1 = new Actividad(1,"Aquagym","gimnasia",10,"2019-2020",50.0);
    Actividad actividad2 = new Actividad("2","Patinaje",15,"cancha","2019-2020",15.0);
    Actividad actividad3 = new Actividad("3","Padel",10,"pista","2019-2020",35.50);
    Actividad actividad4 = new Actividad("4","Aerobic",10,"sala2","2019-2020",26.50);

    Empleado empleado1 = new Empleado("72737475", "Pablo", "Lopez", "Garcia", "01/02/1980", "02/03/2014", "oficial de control", "venezolana");
    Empleado empleado2 = new Empleado("72737476", "Idoia", "Martinez", "Guinea", "12/06/1990", "06/10/2018", "socorrista", "española");
    Empleado empleado3  = new Empleado("72737477", "Marta", "Basterra", "Imaz", "15/08/1983", "15/07/2013", "conserje", "española");
    Empleado empleado4  = new Empleado("72737478", "Mikel", "Insagurbe", "Perez", "18/10/1975", "05/01/2000", "monitor", "española");

    Usuario usuario1 = new Usuario("73245456", "Pedro", "Uriondo", "Rodriguez", 40, "profesor");
    Usuario usuario2 = new Usuario("71239390", "Lucas", "Delgado", "Mendez", 30, "camarero");
    Usuario usuario3 = new Usuario("72459880", "Jokin", "Urkiza", "Echebarria", 52, "mecanico");
    Usuario usuario4 = new Usuario("73245456", "Alvaro", "Garcia", "Martinez", 25, "informatico");

    Sesion sesion1 = new Sesion("15:30", "Lunes");
    Sesion sesion2 = new Sesion("10:00", "Jueves");
    Sesion sesion3 = new Sesion("18:00", "Miercoles");
    Sesion sesion4 = new Sesion("9:00", "Sabado");


    /**
     * Obtener actividad
     *
     * @param eleccion para realizar la busqueda
     * @return la actividad que se ha elegido
     */
    public static Actividad obtenerActividad(Actividad eleccion) {
        //Abrimos la conexion
        ObjectContainer baseDatos = obtenerDb4o();

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

    /**
     * Obtener actividades
     *
     * @param eleccion para realizar la busqueda
     * @return array de actividades
     */
    public static ArrayList<Actividad> obtenerActividades(Actividad eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = obtenerDb4o();

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

    /**
     * Insertar actividad
     *
     * @param eleccion insertar actividad
     */
    public static void insertarActividad(Actividad eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = obtenerDb4o();

        //Guardar actividad
        baseDatos.store(eleccion);

        //Cerrar conexión
        baseDatos.close();

    }


    /**
     * Modificar la actividad
     *
     * @param eleccion    la actividad a modificar
     * @param nuevosDatos cambios
     */
    public static void modificarActividad(Actividad eleccion, Actividad nuevosDatos) {
        //Abrir la conexión
        ObjectContainer baseDatos = obtenerDb4o();

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

    /**
     * Borrar actividad
     *
     * @param eleccion actividad a eliminar
     */
    public static void borrarActividad(Actividad eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = obtenerDb4o();

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

    /**
     * Obtener empleado
     *
     * @param eleccion para realizar la busqueda
     * @return el empleado que se ha elegido
     */
    public static Empleado obtenerEmpleado(Empleado eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = obtenerDb4o();

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


    /**
     * Obtener Empleados
     *
     * @param eleccion para realizar la busqueda
     * @return array de empleados
     */
    public static ArrayList<Empleado> obtenerEmpleados(Empleado eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = obtenerDb4o();

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

    /**
     * Insertar empleado
     *
     * @param eleccion insertar empleado
     */
    public static void insertarEmpleado(Empleado eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = obtenerDb4o();

        //Guardar empleado
        baseDatos.store(eleccion);

        //Cerrar conexión
        baseDatos.close();

    }


    /**
     * Modificar el empleado
     *
     * @param eleccion    el empleado a modificar
     * @param nuevosDatos cambios
     */
    public static void modificarEmpleado(Empleado eleccion, Empleado nuevosDatos) {
        //Abrir la conexión
        ObjectContainer baseDatos = obtenerDb4o();

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
            emp.setFechacontract(nuevosDatos.getFechacontract()  != null ? nuevosDatos.getFechacontract() : emp.getFechacontract());
            emp.setCargo(nuevosDatos.getCargo() != null ? nuevosDatos.getCargo() : emp.getCargo());
            emp.setNacionalidad(nuevosDatos.getNacionalidad() != null ? nuevosDatos.getNacionalidad() : emp.getNacionalidad());

            baseDatos.store(emp);

        }

        //Cerrar la conexión
        baseDatos.close();
    }

    /**
     * Borrar modificar
     *
     * @param eleccion empleado a eliminar
     */
    public static void borrarEmpleado(Empleado eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = obtenerDb4o();

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


    /**
     * Obtener Usuario
     *
     * @param eleccion para realizar la busqueda
     * @return el usuario
     */
    public static Usuario obtenerUsuario(Usuario eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = obtenerDb4o();

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


    /**
     * Obtener usuarios
     *
     * @param eleccion para realizar la busqueda
     * @return array de usuarios
     */
    public static ArrayList<Usuario> obtenerUsuarios(Usuario eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = obtenerDb4o();

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

    /**
     * Insertar usuario
     *
     * @param eleccion insertar usuario
     */
    public static void insertarUsuario(Usuario eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = obtenerDb4o();

        //Guardar usuario
        baseDatos.store(eleccion);

        //Cerrar conexión
        baseDatos.close();

    }


    /**
     * Modificar el usuario
     *
     * @param eleccion    el usuario a modificar
     * @param nuevosDatos cambios
     */
    public static void modificarUsuario(Usuario eleccion, Usuario nuevosDatos) {
        //Abrir la conexión
        ObjectContainer baseDatos = obtenerDb4o();

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

    /**
     * Borrar usuario
     *
     * @param eleccion usuario a eliminar
     */
    public static void borrarUsuario(Usuario eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = obtenerDb4o();

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


    /**
     * Obtener sesion
     *
     * @param eleccion para realizar la busqueda
     * @return la sesion
     */
    public static Sesion obtenerSesion(Sesion eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = obtenerDb4o();

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


    /**
     * Obtener sesiones
     *
     * @param eleccion para realizar la busqueda
     * @return array de sesiones
     */
    public static ArrayList<Sesion> obtenerSesiones(Sesion eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = obtenerDb4o();

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

    /**
     * Insertar sesion
     *
     * @param eleccion insertar sesion
     */
    public static void insertarSesion(Sesion eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = obtenerDb4o();

        //Guardar sesion
        baseDatos.store(eleccion);

        //Cerrar conexión
        baseDatos.close();

    }


    /**
     * Modificar la sesion
     *
     * @param eleccion    la sesion a modificar
     * @param nuevosDatos cambios
     */
    public static void modificarSesion(Sesion eleccion, Sesion nuevosDatos) {
        //Abrir la conexión
        ObjectContainer baseDatos = obtenerDb4o();

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

    /**
     * Borrar sesion
     *
     * @param eleccion sesion a eliminar
     */
    public static void borrarSesion(Sesion eleccion) {
        //Abrir la conexión
        ObjectContainer baseDatos = obtenerDb4o();

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



