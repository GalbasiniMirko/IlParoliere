package View;

import javax.swing.*;
import java.awt.*;

public class PrimaPagina extends JFrame {

    ImageIcon iconFrame = new ImageIcon("LogoProgettoGPO.png");
    JPanel panelPrimaPagina;
    JLabel labelTitolo;
    JButton btnGioca;
    JButton btnClassifica;
    //eventualmente fare un bottone per uscire sotto questi due

    public PrimaPagina(){
        this.setTitle("Il Paroliere");
        this.setIconImage(iconFrame.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //il frame si chiuderà con il tasto in alto a destra
        this.setLayout(null);
        this.setBounds(250, 50, 1000, 700);

        labelTitolo = new JLabel();
        labelTitolo.setText("IL PAROLIERE");
        labelTitolo.setForeground(new Color(0, 0, 0));   //imposta colore del testo
        labelTitolo.setFont(new Font("Comic Sans", Font.BOLD, 50));   //imposta il font e la grandezza del testo
        labelTitolo.setVerticalAlignment(JLabel.TOP);   //imposta la posizione verticale del testo
        labelTitolo.setHorizontalAlignment(JLabel.CENTER);   //imposta la posizione orizzontale del testo

        btnGioca = new JButton();
        btnGioca.setBounds(200, 200, 100, 100);
        btnGioca.setText("GIOCA!");
        btnGioca.setFocusable(false);
        btnGioca.setVerticalTextPosition(JButton.CENTER);
        btnGioca.setHorizontalTextPosition(JButton.CENTER);

        btnClassifica = new JButton();
        btnClassifica.setBounds(400, 200, 100, 100);
        btnClassifica.setText("CLASSIFICA");
        btnGioca.setFocusable(false);
        btnClassifica.setVerticalTextPosition(JButton.CENTER);
        btnClassifica.setHorizontalTextPosition(JButton.CENTER);

        panelPrimaPagina = new JPanel();
        panelPrimaPagina.setBackground(new Color(216, 112, 124));
        panelPrimaPagina.setBounds(0, 0, 1000, 700);
        panelPrimaPagina.setVisible(true);
        panelPrimaPagina.add(btnGioca);
        panelPrimaPagina.add(btnClassifica);
        panelPrimaPagina.add(labelTitolo);

        this.add(panelPrimaPagina);
        this.setVisible(true);
    }
}
