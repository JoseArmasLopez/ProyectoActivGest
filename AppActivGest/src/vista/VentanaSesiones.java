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
    private JButton buttonAlta;
    private JButton buttonEliminar;
    private JButton buttonActualizar;
    private JScrollPane panelScroll;
    private JTable table1;

    private ArrayList<Sesion> sesiones = new ArrayList<Sesion>(); // -> ¡CARGAR DESDE BASES DE DATOS!

    public VentanaSesiones( String cc) {

        JFrame frame = new JFrame("Sesiones "  + cc);
        frame.setContentPane(ventanaSesionesJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        System.out.println(cc);

        switch (cc){


            case "Hegoalde":

                System.out.println("1");

                ControladorBbDd controladorBbDd = new ControladorBbDd(cc);
                System.out.println("1");
                SqliteConsulta sqliteConsulta = new SqliteConsulta(controladorBbDd.getConexion());
                System.out.println("2");
                sqliteConsulta.sesionesdeHegoalde();
                this.sesiones = sqliteConsulta.getSesiones();
                System.out.println(sesiones.size());
                cargarDatosEnTabla(this.sesiones);

                break;


        }

        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });

    }
    public void cargarDatosEnTabla(List<Sesion>sesionList){
        table1.setModel(new SesionesTableModel(sesionList));
    }


}
