package datenbankenueben.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class panelStart extends JPanel implements ActionListener{
    JButton btnNeuerSpieler = new JButton("Hinzufügen!");
    JButton btnStart = new JButton("Start!");
    //GridBagLayout gridBagLayout = new GridBagLayout();
    JPanel panelcont = new JPanel();


    ArrayList<JPanel> spielerFelder = new ArrayList<>();
    ArrayList<JTextField> spielernamen = new ArrayList<>();

    public panelStart(){
        this.setLayout(new BorderLayout());

        panelcont.setLayout(null);
        add(panelcont, BorderLayout.CENTER);

        createAllLabels();

        panelcont.add(btnNeuerSpieler);
        btnNeuerSpieler.setBounds(280, 400, 160, 30);
        btnNeuerSpieler.addActionListener(this);

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

    public void createAllLabels(){
        int x = 0;
        int y = 75;
        int width = 500;
        int height = 55;
        for (int i = 0; i < 4; i++) {
//            spielerFelder.add(new JPanel());
//            panelcont.add(spielerFelder.get(i));
//            spielerFelder.get(i).setBounds(x, (y) , width,height);
//            spielerFelder.get(i).setBackground(Color.lightGray);

            spielernamen.add(new JTextField());
            panelcont.add(spielernamen.get(i));
            spielernamen.get(i).setBounds(60, y-5, 200, 30);

            y+=75;
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnNeuerSpieler){
            if(!spielernamen.get(0).getText().equals("")){
                String halo = spielernamen.get(0).getText();
                System.out.println(halo);
            }else{

            }

        }

    }
}
