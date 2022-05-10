package datenbankenueben.gui;

import datenbankenueben.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panelFrage extends JPanel implements ActionListener {

    private JLabel lblFrage = new JLabel();
    private JButton btnNext = new JButton(" Nächster ");
    private JLabel lblSpieler = new JLabel();
    private JLabel lblRunde = new JLabel();
    private int spieler = 1;
    int frage = 1;
    int rund = 1;


    panelFrage(){
        this.setLayout(null);

        lblRunde.setText("Runde: "+panelStart.runde);
        lblRunde.setBounds(300, 20, 200, 50);
        //add(lblRunde);

        lblSpieler.setText("Spieler: "+spieler);
        lblSpieler.setBounds(50, 20, 200, 50);
        add(lblSpieler);

        lblFrage.setText("HIER KOMMT EINE FRAGE HIN");
        lblFrage.setBounds(50,50,300,50);
        add(lblFrage);

        btnNext.setBounds(60, 300, 200, 30);
        btnNext.addActionListener(this);
        add(btnNext);
        getFrage();
        setVisible(true);
    }

    public static void getFrage(){
        System.out.println(dbselect.getFrage(1));

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext){
            if(spieler < panelStart.anzahlSpieler){
                spieler++;
                lblSpieler.setText("Spieler: "+spieler);
            }
            if(spieler == panelStart.anzahlSpieler){
                btnNext.setText("Runde Beenden");
                spieler++;
            }else if(spieler > panelStart.anzahlSpieler){
                spieler = 1;
                lblSpieler.setText("Spieler: "+spieler);
                btnNext.setText("Nächster");
                repaint();
                myFrame.cardLayout.show(myFrame.panelCont, "3");
            }
            repaint();
        }
    }
}
