package datenbankenueben.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class panelAntworten extends JPanel implements ActionListener {

    GridLayout gl = new GridLayout(7, 1, 50, 55);
    ArrayList<JButton> alleAntworten = new ArrayList<>();
    JButton btnNext = new JButton("Next");
    int check = 0;

    panelAntworten(){
        this.setLayout(gl);

        createbtn();
        btnNext.addActionListener(this);
        add(btnNext);
    }

    public void createbtn(){
        for (int i = 0; i < panelStart.anzahlSpieler; i++) {
            alleAntworten.add(new JButton("test"));
//            alleAntworten.get(i).setOpaque(true);
//            alleAntworten.get(i).setBorderPainted(false);
//            alleAntworten.get(i).setBackground(Color.WHITE);
            alleAntworten.get(i).addActionListener(this);
            add(alleAntworten.get(i));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnNext){
            if(check == 0){
                if(panelStart.runde == 3){
                    myFrame.cardLayout.show(myFrame.panelCont, "4");
                }else{
                    enableAllButtons();
                    panelStart.runde++;
                    myFrame.cardLayout.show(myFrame.panelCont, "2");
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
