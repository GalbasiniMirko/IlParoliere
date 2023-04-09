package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimaPagina extends JFrame implements ActionListener {
    ImageIcon iconFrame = new ImageIcon("LogoProgettoGPO.png");
    JPanel panelPrimaPagina;
    JLabel labelTitolo;
    JButton btnGioca;
    JButton btnClassifica;

    JButton btnEsci;

    public PrimaPagina(){
        this.setTitle("Il Paroliere");
        this.setIconImage(iconFrame.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //il frame si chiuderà con il tasto in alto a destra
        this.setLayout(null);
        this.setBounds(250, 50, 1000, 700);

        labelTitolo = new JLabel();
        labelTitolo.setBounds(0, 0, 1000, 250);
        labelTitolo.setText("IL PAROLIERE");
        labelTitolo.setBackground(new Color(125, 125, 125));
        labelTitolo.setOpaque(true);
        labelTitolo.setForeground(new Color(0, 0, 0));   //imposta colore del testo
        labelTitolo.setFont(new Font("Comic Sans", Font.BOLD, 75));   //imposta il font e la grandezza del testo
        labelTitolo.setVerticalAlignment(JLabel.CENTER);   //imposta la posizione verticale del testo
        labelTitolo.setHorizontalAlignment(JLabel.CENTER);   //imposta la posizione orizzontale del testo

        btnGioca = new JButton();
        btnGioca.setBounds(150, 325, 250, 100);
        //btnGioca.addActionListener();
        btnGioca.setText("GIOCA!");
        btnGioca.setFocusable(false);
        btnGioca.setVerticalTextPosition(JButton.CENTER);
        btnGioca.setHorizontalTextPosition(JButton.CENTER);
        btnGioca.setFont(new Font("Comic Sans", Font.BOLD, 30));
        btnGioca.setForeground(Color.black);
        btnGioca.setBackground(Color.lightGray);

        btnClassifica = new JButton();
        btnClassifica.setBounds(600, 325, 250, 100);
        //btnClassifica.addActionListener();
        btnClassifica.setText("CLASSIFICA");
        btnClassifica.setFocusable(false);
        btnClassifica.setVerticalTextPosition(JButton.CENTER);
        btnClassifica.setHorizontalTextPosition(JButton.CENTER);
        btnClassifica.setFont(new Font("Comic Sans", Font.BOLD, 30));
        btnClassifica.setForeground(Color.black);
        btnClassifica.setBackground(Color.lightGray);

        btnEsci = new JButton();
        btnEsci.setBounds(425, 550, 150, 50);
        //btnEsci.addActionListener();
        btnEsci.setText("ESCI");
        btnEsci.setFocusable(false);
        btnEsci.setVerticalTextPosition(JButton.CENTER);
        btnEsci.setHorizontalTextPosition(JButton.CENTER);
        btnEsci.setFont(new Font("Comic Sans", Font.BOLD, 25));
        btnEsci.setForeground(Color.black);
        btnEsci.setBackground(Color.lightGray);

        panelPrimaPagina = new JPanel();
        panelPrimaPagina.setBackground(new Color(216, 112, 124));
        panelPrimaPagina.setBounds(0, 0, 1000, 700);
        panelPrimaPagina.setLayout(null);
        panelPrimaPagina.add(labelTitolo);
        panelPrimaPagina.add(btnGioca);
        panelPrimaPagina.add(btnClassifica);
        panelPrimaPagina.add(btnEsci);

        this.add(panelPrimaPagina);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
