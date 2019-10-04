package vista;

import controlador.ControladorBbDd;
import controlador.sqlite.SqliteConsulta;
import modelo.TablaModelo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaTablesAcUsEm extends JFrame{
    private JPanel ventanaTablesAcUsEmJpanel;
    private JTable tableAcUsEm;
    private JButton nuevaButton;
    private JButton atrasButton;

    private VentanaCRUD_AcUsEm crud_acUsEm;

    public VentanaTablesAcUsEm(String tipo, String cc) {

        JFrame frame = new JFrame(tipo + " " + cc);
        frame.setContentPane(ventanaTablesAcUsEmJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        if ( tipo.equalsIgnoreCase("hegoalde") && cc.equalsIgnoreCase("actividades")){

            ControladorBbDd controladorBbDd = new ControladorBbDd(cc);

            controladorBbDd.getConexion();

            SqliteConsulta sqliteConsulta = new SqliteConsulta(controladorBbDd.getConexion());

            sqliteConsulta.actividadesHegoaldeSqlite();

            TablaModelo modelo = new TablaModelo(sqliteConsulta.getActividades());

            tableAcUsEm = new JTable();

            tableAcUsEm.setModel(modelo);


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
