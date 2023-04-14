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
    JTextField username;

    public panelimpostazioni(){
        this.setBackground(new Color(216, 112, 124));
        this.setBounds(0, 0, 1000, 700);
        this.setLayout(null);

        titolo= new JLabel();
        titolo.setBounds(0, 0, 1000, 80);
        titolo.setText("IMPOSTAZIONI DI GIOCO");
        titolo.setBackground(new Color(125, 125, 125));
        titolo.setOpaque(true);
        titolo.setForeground(new Color(0, 0, 0));
        titolo.setFont(new Font("Comic Sans", Font.BOLD, 30));
        titolo.setVerticalAlignment(JLabel.CENTER);
        titolo.setHorizontalAlignment(JLabel.CENTER);

        modalita = new JLabel();
        modalita.setBounds(0, 80, 1000, 50);
        modalita.setText("come ti chiami amo?");
        modalita.setForeground(new Color(0, 0, 0));
        modalita.setFont(new Font("Comic Sans", Font.BOLD, 25));
        modalita.setVerticalAlignment(JLabel.CENTER);
        modalita.setHorizontalAlignment(JLabel.CENTER);

        username = new JTextField();
        username.setBounds(400,150,200 ,30);
        username.setPreferredSize(new Dimension(250,40));
        username.setFont(new Font("Comic Sans", Font.BOLD, 25));
        username.setForeground(new Color(0, 0, 0));
        username.setBackground(new Color(255 ,255,255));

        sceltadifficolta = new JLabel();
        sceltadifficolta.setBounds(0, 80, 1000, 50);
        sceltadifficolta.setText("a che difficoltà giochiamo teso?");
        sceltadifficolta.setForeground(new Color(0, 0, 0));
        sceltadifficolta.setFont(new Font("Comic Sans", Font.BOLD, 25));
        sceltadifficolta.setVerticalAlignment(JLabel.CENTER);
        sceltadifficolta.setHorizontalAlignment(JLabel.CENTER);

        this.add(titolo);
        this.add(modalita);
        this.add(username);
        this.add(sceltadifficolta);
        this.setVisible(false);
     }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
