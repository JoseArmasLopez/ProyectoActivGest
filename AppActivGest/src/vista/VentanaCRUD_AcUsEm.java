package vista;

import com.db4o.Db4o;
import controlador.ControladorBbDd;
import controlador.db4o.DB4O;
import controlador.sqlite.SqliteConsulta;
import modelo.Actividad;
import modelo.Empleado;
import modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

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


        // creo conexion bd
        ControladorBbDd controladorBbDd = new ControladorBbDd(cc);
        //obtengo el driver de la Bd
        Connection conexion = controladorBbDd.getConexion();
        // procedo a hacer la consulta
        SqliteConsulta sqliteConsulta = new SqliteConsulta(conexion);



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

        }



        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

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


            }
        });


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                System.out.println(tipo);

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


                            if(cc.equalsIgnoreCase("Iparralde")){

                                System.out.println(cc);

                                DB4O db4O = new DB4O();
                                db4O.insertarActividad(nuevaActividad);

                            }

                            //sqliteConsulta.altaNuevaActividad(nuevaActividad);

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
                }


            }

        });


        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
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
    public void conexionBdPrepararConsulta(){


    }
}
