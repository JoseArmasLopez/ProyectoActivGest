package vista;

import controlador.ControladorBbDd;
import controlador.sqlite.MetadatoBd;
import modelo.TablaBD;
import vista.TableModels.TablasBDTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

public class VentanaTablasBBDD {

    private JPanel ventanaTablasBBDDJpanel;
    private JLabel tablasLabel;
    private JTable tableTablasBD;
    private JButton buttonAtras;
    private JScrollPane scrollPane;

    private List<TablaBD> tablasBD; // -> ¡CARGAR DESDE BASES DE DATOS!

    public VentanaTablasBBDD(String nombBBDD, String cc) {

        JFrame frame = new JFrame(nombBBDD + " " + cc);
        frame.setContentPane(ventanaTablasBBDDJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ControladorBbDd controladorBbDd = new ControladorBbDd(cc);
        Connection connection = controladorBbDd.getConexion();
        MetadatoBd metadatoBd = new MetadatoBd(connection);

        tablasBD = metadatoBd.getMetadatoBdList();

        if(tablasBD.size() > 0){

            cargarDatosEnTabla();
        }else {
            javax.swing.JOptionPane.showMessageDialog(null, "List tablasBD vacío!");
        }

        buttonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });
    }

    public void cargarDatosEnTabla(){
        tableTablasBD.setModel(new TablasBDTableModel(tablasBD));
    }



}
