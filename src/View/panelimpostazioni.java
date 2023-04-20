package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panelimpostazioni extends JPanel implements ActionListener {
    JLabel titolo;
    JLabel modalita;
    JLabel sceltadifficolta;
    JButton avanti;
    JButton indietro;
    JRadioButton facile;
    JRadioButton medio;
    JRadioButton difficile;
    JTextField username;
    frameGioco frameGioco;
    panelPrimaPagina ;


    public panelimpostazioni(){
        this.setBackground(new Color(216, 112, 124));
        this.setPreferredSize(new Dimension(1000, 700));
        //this.setBounds(0, 0, 1000, 700);
        this.setLayout(null);

        titolo= new JLabel();
        titolo.setBounds(0, 0, 1000,  100);
        titolo.setText("IMPOSTAZIONI DI GIOCO");
        titolo.setBackground(new Color(125, 125, 125));
        titolo.setOpaque(true);
        titolo.setForeground(new Color(0, 0, 0));
        titolo.setFont(new Font("Comic Sans", Font.BOLD, 30));
        titolo.setVerticalAlignment(JLabel.CENTER);
        titolo.setHorizontalAlignment(JLabel.CENTER);

        modalita = new JLabel();
        modalita.setBounds(0, 100, 1000, 70);
        modalita.setText("come ti chiami ?");
        modalita.setForeground(new Color(0, 0, 0));
        modalita.setFont(new Font("Comic Sans", Font.BOLD, 25));
        modalita.setVerticalAlignment(JLabel.CENTER);
        modalita.setHorizontalAlignment(JLabel.CENTER);

        username = new JTextField();
        username.setBounds(400,190,200 ,30);
        username.setPreferredSize(new Dimension(250,40));
        username.setFont(new Font("Comic Sans", Font.BOLD, 25));
        username.setForeground(new Color(0, 0, 0));
        username.setBackground(new Color(255 ,255,255));

        sceltadifficolta = new JLabel();
        sceltadifficolta.setBounds(0, 230, 1000, 70);
        sceltadifficolta.setText("a che difficoltà giochiamo?");
        sceltadifficolta.setForeground(new Color(0, 0, 0));
        sceltadifficolta.setFont(new Font("Comic Sans", Font.BOLD, 25));
        sceltadifficolta.setVerticalAlignment(JLabel.CENTER);
        sceltadifficolta.setHorizontalAlignment(JLabel.CENTER);

        facile = new JRadioButton("facile");
        facile.setBounds(455,300,150,80);
        facile.setBackground(new Color(216, 112, 124));
        facile.setFont(new Font("Comic Sans", Font.BOLD, 20));
        medio =new JRadioButton("medio");
        medio.setBounds(455,350,150,80);
        medio.setBackground(new Color(216, 112, 124));
        medio.setFont(new Font("Comic Sans", Font.BOLD, 20));
        difficile = new JRadioButton("difficile");
        difficile.setBounds(455,400,150,80);
        difficile.setBackground(new Color(216, 112, 124));
        difficile.setFont(new Font("Comic Sans", Font.BOLD, 20));

        ButtonGroup group = new ButtonGroup();
        group.add(facile);
        group.add(medio);
        group.add(difficile);

        avanti = new JButton();
        avanti.setBounds(640, 550, 150, 50);
        avanti.setText("INIZIAMO");
        avanti.setFocusable(false);
        avanti.setVerticalTextPosition(JButton.CENTER);
        avanti.setHorizontalTextPosition(JButton.CENTER);
        avanti.setFont(new Font("Comic Sans", Font.BOLD, 20));
        avanti.setForeground(Color.black);
        avanti.setBackground(Color.lightGray);

        indietro= new JButton();
        indietro.setBounds(200, 550, 150, 50);
        indietro.setText("INDIETRO");
        indietro.setFocusable(false);
        indietro.setVerticalTextPosition(JButton.CENTER);
        indietro.setHorizontalTextPosition(JButton.CENTER);
        indietro.setFont(new Font("Comic Sans", Font.BOLD, 20));
        indietro.setForeground(Color.black);
        indietro.setBackground(Color.lightGray);


        frameGioco = new frameGioco();
        panelPrimaPagina = new PrimaPagina();

        this.add(titolo);
        this.add(modalita);
        this.add(username);
        this.add(sceltadifficolta);
        this.add(facile);
        this.add(medio);
        this.add(difficile);
        this.add(avanti);
        this.add(indietro);
        this.add(frameGioco);
        this.add(PrimaPagina);
        this.setVisible(false);
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == avanti){
            this.setVisible(false);
            frameGioco.setVisible(true);
        }else if(e.getSource() == indietro){
            this.setVisible(false);
            PrimaPagina.setVisible(true);

        }
    }
}
