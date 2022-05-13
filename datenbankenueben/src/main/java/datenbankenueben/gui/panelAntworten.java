package datenbankenueben.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class panelAntworten extends JPanel implements ActionListener {

    GridLayout gl = new GridLayout(7, 1, 50, 55);
    ArrayList<JButton> alleAntworten = new ArrayList<>();
    JButton btnRichtigeAntwort = new JButton();
    JButton btnNext = new JButton("Next");
    int check = 0;

    panelAntworten(){
        this.setLayout(gl);
        createbtn();
        btnNext.addActionListener(this);
        add(btnNext);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnNext){
            if(check == 0){
                if(panelStart.runde == 3){
                    myFrame.cardLayout.show(myFrame.panelCont, "4");
                }else{
                    enableAllButtons();
                    panelFrage.lblFrage.setText(panelFrage.getFrage());
                    panelStart.runde++;
                    myFrame.cardLayout.show(myFrame.panelCont, "2");
                    repaint();
                }
            }
        }
        for (int i = 0; i < alleAntworten.size(); i++) {
            if(e.getSource() == alleAntworten.get(i)){
                 check = JOptionPane.showConfirmDialog(null, "bist du dir sicher?!");
                if(check == 0){
                    alleAntworten.get(i).setBackground(Color.PINK);
                    disableAllButtons();
                }
            }
        }

    }

    public int placeRandom(){
        Random r = new Random();
        return r.nextInt(panelStart.anzahlSpieler);
    }

    public void createbtn(){
        int rand = placeRandom();
        for (int i = 0; i < panelStart.anzahlSpieler; i++) {
//            if(rand == i){
//                btnRichtigeAntwort.setText("Richtige Antwort");
//                add(btnRichtigeAntwort);
//            }
            alleAntworten.add(new JButton("test"));
//            alleAntworten.get(i).setOpaque(true);
//            alleAntworten.get(i).setBorderPainted(false);
//            alleAntworten.get(i).setBackground(Color.WHITE);
            alleAntworten.get(i).addActionListener(this);
            add(alleAntworten.get(i));
        }
    }

    public void disableAllButtons(){
        for (int i = 0; i < alleAntworten.size(); i++) {
            alleAntworten.get(i).setEnabled(false);
        }
    }

    public void enableAllButtons(){
        for (int i = 0; i < alleAntworten.size(); i++) {
            alleAntworten.get(i).setEnabled(true);
            alleAntworten.get(i).setBackground(null);
        }
    }
}
