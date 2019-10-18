package vista;

import controlador.ControladorBbDd;
import controlador.db4o.DB4O;
import controlador.mysql.MysqlConsultas;
import controlador.sqlite.SqliteConsulta;
import modelo.Actividad;
import modelo.Empleado;
import modelo.Sesion;
import modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class VentanaCRUD_AcUsEm {

    private JPanel ventanaCRUD_AcUsEmJpanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton sesionesButton;
    private JButton eliminarButton;
    private JButton saveButton;
    private JButton atrasButton;
    private JLabel jLabel6;
    private JLabel jLabel5;
    private JLabel jLabel4;
    private JLabel jLabel3;
    private JLabel jLabel2;
    private JLabel jLabel1;
    private JButton actualizarButon;
    private JButton buscarButton;

    private VentanaSesiones ventanaSesiones;


    public VentanaCRUD_AcUsEm(String tipo, String cc) {

        JFrame frame = new JFrame(tipo + " " + cc);
        frame.setContentPane(ventanaCRUD_AcUsEmJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //MySQL
        Connection con = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/actigest", "root", "");

        } catch (Exception e) {
            System.err.println("No se ha podido conectar a la base de datos Arriaga\n" + e.getMessage());
        }
        MysqlConsultas mysqlConsultas = new MysqlConsultas(con);

        // creo conexion bd
        ControladorBbDd controladorBbDd = new ControladorBbDd(cc);
        //obtengo el driver de la Bd
        Connection conexion = controladorBbDd.getConexion();
        // procedo a hacer la consulta
        SqliteConsulta sqliteConsulta = new SqliteConsulta(conexion);

        // aqui se pone texto en los labels
        switch (tipo.toLowerCase()) {
            case "actividades":
                jLabel1.setText("Nº Actividad");
                jLabel2.setText("Nombre");
                jLabel3.setText("Usuarios máximos");
                jLabel4.setText("Sala");
                jLabel5.setText("Curso");
                jLabel6.setText("Coste");


                break;
            case "usuarios":
                jLabel1.setText("DNI usuario");
                jLabel2.setText("Nombre");
                jLabel3.setText("Apellido 1");
                jLabel4.setText("Apellido 2");
                jLabel5.setText("Edad");
                jLabel6.setText("Profesión");


                break;
            case "empleados":
                jLabel1.setText("DNI empleado");
                jLabel2.setText("Nombre");
                jLabel3.setText("Apellido 1");
                jLabel4.setText("Fecha nacimiento");
                jLabel5.setText("Fecha contratación");
                jLabel6.setText("Cargo");

                break;

            case "sesiones":

                jLabel1.setText("Id Sesión");
                jLabel2.setText("Hora");
                jLabel3.setText("Día semana");
                jLabel4.setText("Nº Actividad");
                jLabel5.setText("Dni Usuario");
                jLabel6.setText("Observaciones");

                break;

        }

        // evento que acontece en eliminar button
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                switch (cc) {

                    case ("Hegoalde"):
                        switch (tipo) {

                            case ("Actividades"):

                                if (textField1.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca el campo id");

                                    vaciarTextFields();


                                } else {


                                    sqliteConsulta.eliminarActividad(textField1.getText());

                                    vaciarTextFields();
                                }


                                break;
                            case ("Usuarios"):

                                if (textField1.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca el campo id");

                                    vaciarTextFields();


                                } else {


                                    sqliteConsulta.eliminarUsuario(textField1.getText());

                                    vaciarTextFields();
                                }


                                break;

                            case ("Empleados"):

                                if (textField1.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca el campo id");

                                    vaciarTextFields();


                                } else {


                                    sqliteConsulta.eliminarEmpleado(textField1.getText());

                                    vaciarTextFields();
                                }

                                break;

                        }
                        break;
                    case ("Iparralde"):

                        break;
                    case ("Arriaga"):

                        switch (tipo) {
                            case ("Actividades"):
                                if (textField1.getText().equalsIgnoreCase("")) {
                                    JOptionPane.showMessageDialog(null, "Error, introduzca el campo id");
                                    vaciarTextFields();
                                } else {
                                    mysqlConsultas.EliminarActividadArriaga(textField1.getText());
                                    vaciarTextFields();
                                }
                                break;

                            case ("Usuarios"):
                                if (textField1.getText().equalsIgnoreCase("")) {
                                    JOptionPane.showMessageDialog(null, "Error, introduzca el campo id");
                                    vaciarTextFields();
                                } else {
                                    mysqlConsultas.EliminarUsuarioArriaga(textField1.getText());
                                    vaciarTextFields();
                                }
                                break;

                            case ("Empleados"):
                                if (textField1.getText().equalsIgnoreCase("")) {
                                    JOptionPane.showMessageDialog(null, "Error, introduzca el campo id");
                                    vaciarTextFields();
                                } else {
                                    mysqlConsultas.EliminarEmpleadoArriaga(textField1.getText());
                                    vaciarTextFields();
                                }
                                break;
                        }

                        break;
                    case ("Ibaiondo"):

                        switch (tipo) {

                            case ("Actividades"):

                                if (textField1.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca el campo id");

                                    vaciarTextFields();


                                } else {


                                    sqliteConsulta.eliminarActividad(textField1.getText());

                                    vaciarTextFields();
                                }


                                break;
                            case ("Usuarios"):

                                if (textField1.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca el campo id");

                                    vaciarTextFields();


                                } else {


                                    sqliteConsulta.eliminarUsuario(textField1.getText());

                                    vaciarTextFields();
                                }


                                break;

                            case ("Empleados"):

                                if (textField1.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca el campo id");

                                    vaciarTextFields();


                                } else {


                                    sqliteConsulta.eliminarEmpleado(textField1.getText());

                                    vaciarTextFields();
                                }

                                break;

                        }

                        break;
                }


            }
        });

        // evento que acontece en guardar button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                System.out.println(tipo);

                switch (cc) {

                    case ("Hegoalde"):

                        switch (tipo) {
                            case "Actividades":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva actividad
                                    Actividad nuevaActividad = new Actividad(textField1.getText(), textField2.getText(), Integer.parseInt(textField3.getText())
                                            , textField4.getText(), textField5.getText(), Double.parseDouble(textField6.getText()));


                                    sqliteConsulta.altaNuevaActividad(nuevaActividad);

                                    vaciarTextFields();

                                }
                                break;

                            case "Usuarios":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva actividad
                                    Usuario nuevoUsuario = new Usuario(textField1.getText(), textField2.getText(), textField3.getText()
                                            , textField4.getText(), Integer.parseInt(textField5.getText()), textField6.getText());


                                    sqliteConsulta.altaNuevoUsuario(nuevoUsuario);

                                    vaciarTextFields();
                                }
                                break;
                            case "Empleados":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva actividad
                                    Empleado nuevoEmpleado = new Empleado();
                                    nuevoEmpleado.setDni(textField1.getText());
                                    nuevoEmpleado.setNombre(textField2.getText());
                                    nuevoEmpleado.setApellido1(textField3.getText());
                                    nuevoEmpleado.setFechanac(textField4.getText());
                                    nuevoEmpleado.setFechacontract(textField5.getText());
                                    nuevoEmpleado.setCargo(textField6.getText());


                                    sqliteConsulta.altaNuevoEmpleado(nuevoEmpleado);

                                    vaciarTextFields();
                                }


                                break;

                            case "sesiones":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva sesion
                                    Sesion nuevaSesion = new Sesion(Integer.parseInt(textField1.getText()), textField2.getText(), textField3.getText()
                                            , textField4.getText(), textField5.getText());



                                    vaciarTextFields();

                                }


                                break;
                        }

                        break;
                    case ("Iparralde"):

                        switch (tipo) {
                            case "Actividades":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva actividad
                                    Actividad nuevaActividad = new Actividad(textField1.getText(), textField2.getText(), Integer.parseInt(textField3.getText())
                                            , textField4.getText(), textField5.getText(), Double.parseDouble(textField6.getText()));

                                    DB4O db4O = new DB4O();
                                    db4O.insertarActividad(nuevaActividad);

                                    vaciarTextFields();

                                }
                                break;

                            case "Usuarios":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva actividad
                                    Usuario nuevoUsuario = new Usuario(textField1.getText(), textField2.getText(), textField3.getText()
                                            , textField4.getText(), Integer.parseInt(textField5.getText()), textField6.getText());

                                    DB4O db4O = new DB4O();
                                    db4O.insertarUsuario(nuevoUsuario);

                                    vaciarTextFields();
                                }
                                break;
                            case "Empleados":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva actividad
                                    Empleado nuevoEmpleado = new Empleado();
                                    nuevoEmpleado.setDni(textField1.getText());
                                    nuevoEmpleado.setNombre(textField2.getText());
                                    nuevoEmpleado.setApellido1(textField3.getText());
                                    nuevoEmpleado.setFechanac(textField4.getText());
                                    nuevoEmpleado.setFechacontract(textField5.getText());
                                    nuevoEmpleado.setCargo(textField6.getText());


                                    DB4O db4O = new DB4O();
                                    db4O.insertarEmpleado(nuevoEmpleado);

                                    vaciarTextFields();
                                }

                                break;

                            case "sesiones":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva sesion
                                    Sesion nuevaSesion = new Sesion(Integer.parseInt(textField1.getText()), textField2.getText(), textField3.getText()
                                            , textField4.getText(), textField5.getText());



                                    vaciarTextFields();

                                }


                                break;
                        }

                        break;
                    case ("Ibaiondo"):

                        switch (tipo) {
                            case "Actividades":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva actividad
                                    Actividad nuevaActividad = new Actividad(textField1.getText(), textField2.getText(), Integer.parseInt(textField3.getText())
                                            , textField4.getText(), textField5.getText(), Double.parseDouble(textField6.getText()));


                                    sqliteConsulta.altaNuevaActividad(nuevaActividad);

                                    vaciarTextFields();

                                }
                                break;

                            case "Usuarios":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva actividad
                                    Usuario nuevoUsuario = new Usuario(textField1.getText(), textField2.getText(), textField3.getText()
                                            , textField4.getText(), Integer.parseInt(textField5.getText()), textField6.getText());


                                    sqliteConsulta.altaNuevoUsuario(nuevoUsuario);

                                    vaciarTextFields();
                                }
                                break;
                            case "Empleados":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva actividad
                                    Empleado nuevoEmpleado = new Empleado();
                                    nuevoEmpleado.setDni(textField1.getText());
                                    nuevoEmpleado.setNombre(textField2.getText());
                                    nuevoEmpleado.setApellido1(textField3.getText());
                                    nuevoEmpleado.setFechanac(textField4.getText());
                                    nuevoEmpleado.setFechacontract(textField5.getText());
                                    nuevoEmpleado.setCargo(textField6.getText());


                                    sqliteConsulta.altaNuevoEmpleado(nuevoEmpleado);

                                    vaciarTextFields();
                                }


                                break;

                            case "sesiones":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva sesion
                                    Sesion nuevaSesion = new Sesion(Integer.parseInt(textField1.getText()), textField2.getText(), textField3.getText()
                                            , textField4.getText(), textField5.getText());



                                    vaciarTextFields();

                                }


                                break;
                        }

                        break;
                    case ("Arriaga"):
                        switch (tipo) {
                            case ("Actividades"):
                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {
                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");
                                } else {
                                    Actividad nuevaActividad = new Actividad(textField1.getText(), textField2.getText(), Integer.parseInt(textField3.getText()), textField4.getText(), textField5.getText(), Double.parseDouble(textField6.getText()));
                                    mysqlConsultas.InsertarActividadesArriagaPROVISIONAL(nuevaActividad);
                                    vaciarTextFields();
                                }
                                break;

                            case ("Usuarios"):


                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {
                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");
                                } else {
                                    // creo una nueva actividad
                                    Usuario nuevoUsuario = new Usuario(textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(), Integer.parseInt(textField5.getText()), textField6.getText());
                                    mysqlConsultas.InsertarUsuarioArriaga(nuevoUsuario);
                                    vaciarTextFields();
                                }
                                break;

                            case ("Empleados"):
                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") || textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") || textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {
                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");
                                } else {

                                    // creo una nueva actividad
                                    Empleado nuevoEmpleado = new Empleado();
                                    nuevoEmpleado.setDni(textField1.getText());
                                    nuevoEmpleado.setNombre(textField2.getText());
                                    nuevoEmpleado.setApellido1(textField3.getText());
                                    nuevoEmpleado.setFechanac(textField4.getText());
                                    nuevoEmpleado.setFechacontract(textField5.getText());
                                    nuevoEmpleado.setCargo(textField6.getText());
                                    mysqlConsultas.InsertarEmpleadoArriaga(nuevoEmpleado);
                                    vaciarTextFields();
                                }
                                break;
                        }

                        break;


                }


            }

        });

        // evento que acontece en volver a la ventana anterior
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });


        //MODIFICAR.
        actualizarButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                switch (cc) {

                    case ("Hegoalde"):

                        switch (tipo) {
                            case "Actividades":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva actividad
                                    Actividad nuevaActividad = new Actividad(textField1.getText(), textField2.getText(), Integer.parseInt(textField3.getText())
                                            , textField4.getText(), textField5.getText(), Double.parseDouble(textField6.getText()));


                                    sqliteConsulta.actualizarActividad(nuevaActividad);

                                    vaciarTextFields();

                                }
                                break;

                            case "Usuarios":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva actividad
                                    Usuario nuevoUsuario = new Usuario(textField1.getText(), textField2.getText(), textField3.getText()
                                            , textField4.getText(), Integer.parseInt(textField5.getText()), textField6.getText());


                                    sqliteConsulta.actualizarUsuario(nuevoUsuario);

                                    vaciarTextFields();
                                }
                                break;
                            case "Empleados":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva actividad
                                    Empleado nuevoEmpleado = new Empleado();
                                    nuevoEmpleado.setDni(textField1.getText());
                                    nuevoEmpleado.setNombre(textField2.getText());
                                    nuevoEmpleado.setApellido1(textField3.getText());
                                    nuevoEmpleado.setFechanac(textField4.getText());
                                    nuevoEmpleado.setFechacontract(textField5.getText());
                                    nuevoEmpleado.setCargo(textField6.getText());


                                    sqliteConsulta.actualizarEmpleado(nuevoEmpleado);

                                    vaciarTextFields();
                                }


                                break;
                        }

                        break;
                    case ("Iparralde"):

                        switch (tipo) {
                            case "Actividades":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva actividad
                                    Actividad nuevaActividad = new Actividad(textField1.getText(), textField2.getText(), Integer.parseInt(textField3.getText())
                                            , textField4.getText(), textField5.getText(), Double.parseDouble(textField6.getText()));

                                    DB4O db4O = new DB4O();
                                    db4O.insertarActividad(nuevaActividad);

                                    vaciarTextFields();

                                }
                                break;

                            case "Usuarios":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva actividad
                                    Usuario nuevoUsuario = new Usuario(textField1.getText(), textField2.getText(), textField3.getText()
                                            , textField4.getText(), Integer.parseInt(textField5.getText()), textField6.getText());

                                    DB4O db4O = new DB4O();
                                    db4O.insertarUsuario(nuevoUsuario);

                                    vaciarTextFields();
                                }
                                break;
                            case "Empleados":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva actividad
                                    Empleado nuevoEmpleado = new Empleado();
                                    nuevoEmpleado.setDni(textField1.getText());
                                    nuevoEmpleado.setNombre(textField2.getText());
                                    nuevoEmpleado.setApellido1(textField3.getText());
                                    nuevoEmpleado.setFechanac(textField4.getText());
                                    nuevoEmpleado.setFechacontract(textField5.getText());
                                    nuevoEmpleado.setCargo(textField6.getText());


                                    DB4O db4O = new DB4O();
                                    db4O.insertarEmpleado(nuevoEmpleado);

                                    vaciarTextFields();
                                }


                                break;
                        }

                        break;
                    case ("Ibaiondo"):

                        switch (tipo) {
                            case "Actividades":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva actividad
                                    Actividad nuevaActividad = new Actividad(textField1.getText(), textField2.getText(), Integer.parseInt(textField3.getText())
                                            , textField4.getText(), textField5.getText(), Double.parseDouble(textField6.getText()));


                                    sqliteConsulta.actualizarActividad(nuevaActividad);

                                    vaciarTextFields();

                                }
                                break;

                            case "Usuarios":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva actividad
                                    Usuario nuevoUsuario = new Usuario(textField1.getText(), textField2.getText(), textField3.getText()
                                            , textField4.getText(), Integer.parseInt(textField5.getText()), textField6.getText());


                                    sqliteConsulta.actualizarUsuario(nuevoUsuario);

                                    vaciarTextFields();
                                }
                                break;
                            case "Empleados":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") ||
                                        textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") ||
                                        textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {

                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");

                                    vaciarTextFields();


                                } else {


                                    // creo una nueva actividad
                                    Empleado nuevoEmpleado = new Empleado();
                                    nuevoEmpleado.setDni(textField1.getText());
                                    nuevoEmpleado.setNombre(textField2.getText());
                                    nuevoEmpleado.setApellido1(textField3.getText());
                                    nuevoEmpleado.setFechanac(textField4.getText());
                                    nuevoEmpleado.setFechacontract(textField5.getText());
                                    nuevoEmpleado.setCargo(textField6.getText());


                                    sqliteConsulta.actualizarEmpleado(nuevoEmpleado);

                                    vaciarTextFields();
                                }


                                break;
                        }

                        break;
                    case ("Arriaga"):
                        switch (tipo) {
                            case "Actividades":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") || textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") || textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {
                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");
                                } else {
                                    Actividad nuevaActividad = new Actividad(textField1.getText(), textField2.getText(), Integer.parseInt(textField3.getText()), textField4.getText(), textField5.getText(), Double.parseDouble(textField6.getText()));
                                    mysqlConsultas.ActualizarActividad(nuevaActividad);
                                    vaciarTextFields();
                                }
                                break;

                            case "Usuarios":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") || textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") || textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {
                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");
                                } else {
                                    Usuario nuevoUsuario = new Usuario(textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(), Integer.parseInt(textField5.getText()), textField6.getText());
                                    mysqlConsultas.ActualizarUsuario(nuevoUsuario);
                                    vaciarTextFields();
                                }
                                break;
                            case "Empleados":

                                if (textField1.getText().equalsIgnoreCase("") || textField2.getText().equalsIgnoreCase("") || textField3.getText().equalsIgnoreCase("") || textField4.getText().equalsIgnoreCase("") || textField5.getText().equalsIgnoreCase("") || textField6.getText().equalsIgnoreCase("")) {
                                    JOptionPane.showMessageDialog(null, "Error, introduzca todos los campos");
                                } else {
                                    // creo una nueva actividad
                                    Empleado nuevoEmpleado = new Empleado();
                                    nuevoEmpleado.setDni(textField1.getText());
                                    nuevoEmpleado.setNombre(textField2.getText());
                                    nuevoEmpleado.setApellido1(textField3.getText());
                                    nuevoEmpleado.setApellido2("NULL");
                                    nuevoEmpleado.setFechanac(textField4.getText());
                                    nuevoEmpleado.setFechacontract(textField5.getText());
                                    nuevoEmpleado.setCargo(textField6.getText());

                                    mysqlConsultas.ActualizarEmpleadoArriaga(nuevoEmpleado);
                                    vaciarTextFields();
                                }


                                break;
                        }


                        break;


                }

            }
        });
    }

    // funcion para vaciar los Jlabels
    public void vaciarTextFields() {

        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");

    }

    //funcion para preparar la consulta hegoalde/ibaiondo
    public void conexionBdPrepararConsulta() {


    }
}
