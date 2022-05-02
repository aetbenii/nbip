package datenbankenueben.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class panelStart extends JPanel{

    private CardLayout cardLayout;



    JButton btnNeuerSpieler;
    JButton btnStart = new JButton("Start!");
    //GridBagLayout gridBagLayout = new GridBagLayout();
    JPanel panelcont = new JPanel();


    ArrayList<JLabel> spielerFelder = new ArrayList<>();

    public panelStart(){
        this.setLayout(new BorderLayout());

        spielerFelder.add(new JLabel("neuer spieler"));
        panelcont.setLayout(null);
        add(panelcont, BorderLayout.CENTER);
        panelcont.add(spielerFelder.get(0));
        spielerFelder.get(0).setBounds(50,50,380,75);
        spielerFelder.get(0).setOpaque(true);
        spielerFelder.get(0).setBackground(Color.gray);


        add(btnStart, BorderLayout.SOUTH);
        btnStart.setOpaque(true);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnStart){
                    myFrame.cardLayout.show(myFrame.panelCont, "2");
                }
            }
        });

        this.setVisible(true);
    }
}
