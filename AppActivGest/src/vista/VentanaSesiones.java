package vista;

import controlador.ControladorBbDd;
import controlador.sqlite.SqliteConsulta;
import modelo.Sesion;
import vista.TableModels.SesionesTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaSesiones {

    private JPanel ventanaSesionesJpanel;
    private JButton atrasButton;
    private JButton buttonEditar;
    private JScrollPane panelScroll;
    private JTable table1;

    private VentanaCRUD_AcUsEm crud_acUsEm;

    private ArrayList<Sesion> sesiones = new ArrayList<Sesion>(); // -> ¡CARGAR DESDE BASES DE DATOS!

    public VentanaSesiones( String cc) {

        JFrame frame = new JFrame("Sesiones "  + cc);
        frame.setContentPane(ventanaSesionesJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



        switch (cc){


            case "Hegoalde":


                ControladorBbDd controladorBbDd = new ControladorBbDd(cc);

                SqliteConsulta sqliteConsulta = new SqliteConsulta(controladorBbDd.getConexion());

                sqliteConsulta.sesionesdeHegoalde();
                this.sesiones = sqliteConsulta.getSesiones();

                cargarDatosEnTabla(this.sesiones);

                break;
            case "Arriaga":


                break;
            case "Ibaiondo":


                break;

            case "Iparralde":



                break;


        }

        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });



        buttonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                crud_acUsEm = new VentanaCRUD_AcUsEm("sesiones", cc);

            }
        });
    }


    public void cargarDatosEnTabla(List<Sesion>sesionList){
        table1.setModel(new SesionesTableModel(sesionList));
    }


}
