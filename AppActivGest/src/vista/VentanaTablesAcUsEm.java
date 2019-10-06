package vista;

import controlador.ControladorBbDd;
import controlador.sqlite.SqliteConsulta;
import modelo.TablaModelo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaTablesAcUsEm  {

    private JPanel ventanaTablesAcUsEmJpanel;
    private JTable tableAcUsEm;
    private JButton nuevaButton;
    private JButton atrasButton;

    private VentanaCRUD_AcUsEm crud_acUsEm;
    private TablaModelo tablaModelo;

    public VentanaTablesAcUsEm(String tipo, String cc) {
        
        JFrame frame = new JFrame(tipo + " " + cc);
        frame.setContentPane(ventanaTablesAcUsEmJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        if (tipo.equalsIgnoreCase("Actividades") && cc.equalsIgnoreCase("Hegoalde")) {

            ControladorBbDd controladorBbDd = new ControladorBbDd(cc);

            SqliteConsulta sqliteConsulta = new SqliteConsulta(controladorBbDd.getConexion());

            sqliteConsulta.actividadesHegoaldeSqlite();

            tablaModelo = new TablaModelo(sqliteConsulta.getActividades());

            // ojo!!! no se puede inicializar tableAcusem porque al hacerla desde la GUI se anularía
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
}
