package vista;

import controlador.ControladorBbDd;
import controlador.sqlite.SqliteConsulta;
import modelo.Actividad;
import modelo.Empleado;
import modelo.TablaModelo;
import modelo.Usuario;
import vista.TableModels.ActividadesTableModel;
import vista.TableModels.EmpleadosTableModel;
import vista.TableModels.UsuariosTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaTablesAcUsEm  {

    private JPanel ventanaTablesAcUsEmJpanel;
    private JTable tableAcUsEm;
    private JButton nuevaButton;
    private JButton atrasButton;

    private VentanaCRUD_AcUsEm crud_acUsEm;

    private List<Actividad> actividades;    // -> ¡CARGAR DESDE BASES DE DATOS!
    private List<Usuario> usuarios;     // -> ¡CARGAR DESDE BASES DE DATOS!
    private List<Empleado> empleados;   // -> ¡CARGAR DESDE BASES DE DATOS!

    private TablaModelo tablaModelo;


    public VentanaTablesAcUsEm(String tipo, String cc) {



        JFrame frame = new JFrame(tipo + " " + cc);
        frame.setContentPane(ventanaTablesAcUsEmJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        switch (tipo){
            case "Actividades":
                if(actividades.size() > 0){
                    cargarDatosEnTabla(tipo);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "List actividades vacío!");
                }
                break;
            case "Usuarios":
                if(usuarios.size() > 0){
                    cargarDatosEnTabla(tipo);
                }else {
                    javax.swing.JOptionPane.showMessageDialog(null, "List usuario vacío!");
                }
                break;
            case "Empleados":
                if(empleados.size() > 0){
                    cargarDatosEnTabla(tipo);
                }else {
                    javax.swing.JOptionPane.showMessageDialog(null, "List empleados vacío!");
                }
                break;
        }

        
        if (tipo.equalsIgnoreCase("Actividades") && cc.equalsIgnoreCase("Hegoalde")) {


            ControladorBbDd controladorBbDd = new ControladorBbDd(cc);

            SqliteConsulta sqliteConsulta = new SqliteConsulta(controladorBbDd.getConexion());

            sqliteConsulta.actividadesHegoaldeSqlite();

            tablaModelo = new TablaModelo(sqliteConsulta.getActividades());

            tableAcUsEm.setModel(tablaModelo);


        }

        nuevaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                crud_acUsEm = new VentanaCRUD_AcUsEm(tipo, "---", cc);


            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });
    }

    public void cargarDatosEnTabla(String tipo){
        switch (tipo){
            case "Actividades":
                tableAcUsEm.setModel(new ActividadesTableModel(actividades));
                break;
            case "Usuarios":
                tableAcUsEm.setModel(new UsuariosTableModel(usuarios));
                break;
            case "Empleados":
                tableAcUsEm.setModel(new EmpleadosTableModel(empleados));
                break;
        }
    }
}
