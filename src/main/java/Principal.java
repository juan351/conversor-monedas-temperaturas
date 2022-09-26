import conversorMonedas.controllers.ConvertirMonedas;
import conversorMonedas.models.Moneda;
import conversorMonedas.models.TipoMoneda;
import conversorTemperaturas.controllers.ConvertirTemperatura;
import conversorTemperaturas.models.Temperatura;
import conversorTemperaturas.models.TipoTemperatura;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Principal extends javax.swing.JFrame{

    private JTabbedPane conversorMonedas;
    private JTextField campoMoneda1;
    private JButton convertirButton;
    private JComboBox boxMoneda1;
    private JButton convertirTemperaturaButton;
    private JComboBox boxMoneda2;
    private JTextField campoMoneda2;
    private JComboBox boxTemperatura1;
    private JComboBox boxTemperatura2;
    private JTextField campoTemperatura1;
    private JTextField campoTemperatura2;
    private JLabel errorLabel;

    public Principal() {
        initComponents();
        convertirButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                errorLabel.setText("");

                if (campoMoneda1.getText().isEmpty()){
                    campoMoneda1.setText("1");
                }

                Moneda moneda1 = new Moneda(TipoMoneda.valueOf((String) boxMoneda1.getSelectedItem()), Double.valueOf(campoMoneda1.getText()));
                Moneda moneda2 = new Moneda(TipoMoneda.valueOf((String) boxMoneda2.getSelectedItem()), 0.0);

                try {
                    Moneda monedaConvertida = ConvertirMonedas.convertir(moneda1,moneda2);

                    campoMoneda2.setText(monedaConvertida.getValor().toString());

                }catch (Exception ex){
                    errorLabel.setText(ex.getMessage());
                }

            }
        });
        convertirTemperaturaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (campoTemperatura1.getText().isEmpty()){
                    campoTemperatura1.setText("1");
                }

                Temperatura temperatura1 = new Temperatura(TipoTemperatura.valueOf(((String) boxTemperatura1.getSelectedItem()).substring(1)), Double.valueOf(campoTemperatura1.getText()));
                Temperatura temperatura2 = new Temperatura(TipoTemperatura.valueOf(((String) boxTemperatura2.getSelectedItem()).substring(1)), 0.0);

                Temperatura temperaturaConvertida = ConvertirTemperatura.convertir(temperatura1,temperatura2);

                campoTemperatura2.setText(temperaturaConvertida.getValor().toString());
            }
        });
    }


    private void initComponents(){


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conversores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(conversorMonedas)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)

                        )
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(conversorMonedas)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)

                        )
        );



        pack();

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable(){
           public void run() {
               new Principal().setVisible(true);
           }
        });
    }


}
