package datenbankenueben.gui;
import datenbankenueben.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class panelStart extends JPanel implements ActionListener{

    JButton btnNeuerSpieler = new JButton("Hinzufügen!");
    JButton btnStart = new JButton("Start!");
    JPanel panelcont = new JPanel();
    ArrayList<JTextField> spielerFelder = new ArrayList<>();
    ArrayList<JLabel> spielernamen = new ArrayList<>();
    static int anzahlSpieler;
    static ArrayList<spieler> Spieler = new ArrayList<>();
    static spiel Spiel = new spiel("game", 3);
    static int runde = 1;
    static boolean ready = false;

    public panelStart(){
        this.setLayout(new BorderLayout());
        panelcont.setLayout(null);
        add(panelcont, BorderLayout.CENTER);

        wvSpieler();
        createAll();

        panelcont.add(btnNeuerSpieler);
        btnNeuerSpieler.setBounds(280, 400, 160, 30);
        btnNeuerSpieler.addActionListener(this);

        add(btnStart, BorderLayout.SOUTH);
        btnStart.setEnabled(false);
        btnStart.addActionListener(this);
        this.setVisible(true);
    }

    public void createAll(){
        int y = 75;
        for (int i = 0; i < anzahlSpieler; i++) {
            spielerFelder.add(new JTextField());
            panelcont.add(spielerFelder.get(i));
            spielerFelder.get(i).setBounds(60, y , 200, 30);

            spielernamen.add(new JLabel("Spieler "+(i+1)));
            panelcont.add(spielernamen.get(i));
            spielernamen.get(i).setBounds(60, y-30, 200, 30);

            y+=75;
        }
        repaint();
    }

    public void wvSpieler(){
        try {
            anzahlSpieler = Integer.parseInt(JOptionPane.showInputDialog("Wie viele Spieler möchten spielen? (Min 2 & Max. 5)"));
        } catch (Exception e ){
            JOptionPane.showMessageDialog(null, "Bitte gebe eine Zahl ein!");
            wvSpieler();
        }
        if(anzahlSpieler > 5){
            JOptionPane.showMessageDialog(null, "MAX 5 SPIELER!");
            wvSpieler();
        }
        if(anzahlSpieler < 2){
            JOptionPane.showMessageDialog(null, "MIN 2 SPIELER!");
            wvSpieler();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnNeuerSpieler){ // BUTTON UM ALLE NEUEN SPIELER HINZUZUFÜGEN!!!
            if(!checkifempty()){
                for (int i = 0; i < anzahlSpieler; i++) {
                    Spieler.add(new spieler(spielerFelder.get(i).getText()));
                }
                btnNeuerSpieler.setEnabled(false);
                btnStart.setEnabled(true);
                for (int i = 0; i < anzahlSpieler; i++) {
                    spielerFelder.get(i).setEnabled(false);
                    //dbinsert.spielerHinzufügen(Spieler.get(i).getName());  // WICHTIG !!!!!!!!!! WIEDER ENTKOMMENTIEREN.
                }
            }else{
                JOptionPane.showMessageDialog(null, "Bitte gib jedem Spieler einen Namen!");
            }
        }

        if(e.getSource() == btnStart){
            if(Spieler.size() == anzahlSpieler){
                myFrame.cardLayout.show(myFrame.panelCont, "2");
                ready = true;
            }else{
                JOptionPane.showMessageDialog(null, "Es fehlt was!");
            }
        }
    }

    public boolean checkifempty(){
        for (int i = 0; i < anzahlSpieler; i++) {
            if(spielerFelder.get(i).getText().equals("")) return true;
        }
        return false;
    }
}
