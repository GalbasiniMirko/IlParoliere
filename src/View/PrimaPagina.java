package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimaPagina extends JFrame implements ActionListener {
    ImageIcon iconFrame = new ImageIcon("LogoProgettoGPO.png");
    JPanel panelPrimaPagina;
    JPanel panelImpostazioni;

    //ELEMENTI COMNTENUTI NEL PRIMO PANEL
    JLabel labelTitolo;
    JButton btnGioca;
    JButton btnClassifica;
    JButton btnEsci;

    //ELEMENTI CONTENUTI NEL PANLE DELLE IMPOSTAZIONI DI GIOCO
    JLabel titolo;
    JLabel modalita;
    JLabel sceltadifficolta;
    JButton btnIniziamo;
    JButton btnIndietro;
    JRadioButton livelloFacile;
    JRadioButton livelloMedio;
    JRadioButton livelloDifficile;
    JTextField username;

    public PrimaPagina(){
        this.setTitle("Il Paroliere");
        this.setIconImage(iconFrame.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //il frame si chiuderà con il tasto in alto a destra
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.setBounds(250, 50, 1000, 700);

        //INIZIO ELEMENTI PANEL DELLA PRIMA PAGINA
        labelTitolo = new JLabel();
        labelTitolo.setBounds(0, 0, 1000, 250);
        labelTitolo.setText("IL PAROLIERE");
        labelTitolo.setBackground(new Color(125, 125, 125));
        labelTitolo.setOpaque(true);
        labelTitolo.setForeground(new Color(0, 0, 0));   //imposta colore del testo
        labelTitolo.setFont(new Font("Comic Sans", Font.BOLD, 45));   //imposta il font e la grandezza del testo
        labelTitolo.setVerticalAlignment(JLabel.CENTER);   //imposta la posizione verticale del testo
        labelTitolo.setHorizontalAlignment(JLabel.CENTER);   //imposta la posizione orizzontale del testo

        btnGioca = new JButton();
        btnGioca.setBounds(150, 325, 250, 100);
        btnGioca.addActionListener(this);
        btnGioca.setText("GIOCA!");
        btnGioca.setFocusable(false);
        btnGioca.setVerticalTextPosition(JButton.CENTER);
        btnGioca.setHorizontalTextPosition(JButton.CENTER);
        btnGioca.setFont(new Font("Comic Sans", Font.BOLD, 30));
        btnGioca.setForeground(Color.black);   //imposto colore testo
        btnGioca.setBackground(Color.lightGray);   //imposto colore di sfondo

        btnClassifica = new JButton();
        btnClassifica.setBounds(600, 325, 250, 100);
        btnClassifica.addActionListener(this);
        btnClassifica.setText("CLASSIFICA");
        btnClassifica.setFocusable(false);
        btnClassifica.setVerticalTextPosition(JButton.CENTER);
        btnClassifica.setHorizontalTextPosition(JButton.CENTER);
        btnClassifica.setFont(new Font("Comic Sans", Font.BOLD, 30));
        btnClassifica.setForeground(Color.black);
        btnClassifica.setBackground(Color.lightGray);

        btnEsci = new JButton();
        btnEsci.setBounds(425, 550, 150, 50);
        btnEsci.addActionListener(this);
        btnEsci.setText("ESCI");
        btnEsci.setFocusable(false);
        btnEsci.setVerticalTextPosition(JButton.CENTER);
        btnEsci.setHorizontalTextPosition(JButton.CENTER);
        btnEsci.setFont(new Font("Comic Sans", Font.BOLD, 25));
        btnEsci.setForeground(Color.black);
        btnEsci.setBackground(Color.lightGray);

        panelPrimaPagina = new JPanel();
        panelPrimaPagina.setBackground(new Color(216, 112, 124));
        panelPrimaPagina.setPreferredSize(new Dimension(1000, 700));
        panelPrimaPagina.setLayout(null);
        panelPrimaPagina.add(labelTitolo);
        panelPrimaPagina.add(btnGioca);
        panelPrimaPagina.add(btnClassifica);
        panelPrimaPagina.add(btnEsci);
        panelPrimaPagina.setVisible(true);

        //INIZIO ELEMENTI PANEL IMPOSTAZIONI
        titolo = new JLabel();
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

        livelloFacile = new JRadioButton("facile (5 x 5)");
        livelloFacile.setBounds(435,300,180,80);
        livelloFacile.setBackground(new Color(216, 112, 124));
        livelloFacile.setFont(new Font("Comic Sans", Font.BOLD, 20));
        livelloMedio =new JRadioButton("medio (4 x 4)");
        livelloMedio.setBounds(435,350,180,80);
        livelloMedio.setBackground(new Color(216, 112, 124));
        livelloMedio.setFont(new Font("Comic Sans", Font.BOLD, 20));
        livelloDifficile = new JRadioButton("difficile (3 x 3)");
        livelloDifficile.setBounds(435,400,180,80);
        livelloDifficile.setBackground(new Color(216, 112, 124));
        livelloDifficile.setFont(new Font("Comic Sans", Font.BOLD, 20));

        ButtonGroup group = new ButtonGroup();
        group.add(livelloFacile);
        group.add(livelloMedio);
        group.add(livelloDifficile);

        btnIniziamo = new JButton();
        btnIniziamo.setBounds(640, 550, 150, 50);
        btnIniziamo.addActionListener(this);
        btnIniziamo.setText("INIZIAMO");
        btnIniziamo.setFocusable(false);
        btnIniziamo.setVerticalTextPosition(JButton.CENTER);
        btnIniziamo.setHorizontalTextPosition(JButton.CENTER);
        btnIniziamo.setFont(new Font("Comic Sans", Font.BOLD, 20));
        btnIniziamo.setForeground(Color.black);
        btnIniziamo.setBackground(Color.lightGray);

        btnIndietro = new JButton();
        btnIndietro.setBounds(200, 550, 150, 50);
        btnIndietro.addActionListener(this);
        btnIndietro.setText("INDIETRO");
        btnIndietro.setFocusable(false);
        btnIndietro.setVerticalTextPosition(JButton.CENTER);
        btnIndietro.setHorizontalTextPosition(JButton.CENTER);
        btnIndietro.setFont(new Font("Comic Sans", Font.BOLD, 20));
        btnIndietro.setForeground(Color.black);
        btnIndietro.setBackground(Color.lightGray);

        panelImpostazioni = new JPanel();
        panelImpostazioni.setBackground(new Color(216, 112, 124));
        panelImpostazioni.setPreferredSize(new Dimension(1000, 700));
        panelImpostazioni.setLayout(null);
        panelImpostazioni.add(titolo);
        panelImpostazioni.add(modalita);
        panelImpostazioni.add(username);
        panelImpostazioni.add(sceltadifficolta);
        panelImpostazioni.add(livelloFacile);
        panelImpostazioni.add(livelloMedio);
        panelImpostazioni.add(livelloDifficile);
        panelImpostazioni.add(btnIniziamo);
        panelImpostazioni.add(btnIndietro);
        panelImpostazioni.setVisible(false);

        this.add(panelPrimaPagina);
        this.add(panelImpostazioni);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //controllo per capire quale tasto è stato cliccato
        if(e.getSource() == btnGioca){
            panelPrimaPagina.setVisible(false);
            panelImpostazioni.setVisible(true);

        }else if(e.getSource() == btnClassifica){
            panelPrimaPagina.setVisible(false);
            //Partita partita1 = new Partita();
            //partita1.inserisciDati();

        }else if(e.getSource() == btnEsci){
            //dichiarazione JOptionPane contenuto in una variabile memorizzare l'output generato dalla scelta dell'utente
            int scelta = JOptionPane.showConfirmDialog (null, "Sei sicuro di voler uscire?",
                    "Conferma Uscita", JOptionPane.YES_NO_OPTION);

            if(scelta == JOptionPane.YES_OPTION){   //controllo sul bottone che clicca l'utente nel JOptionPane
                this.dispose();   //nel caso l'utente clicca il bottone yes chiude il JFrame e chiude il programma
            }

        }else if(e.getSource() == btnIniziamo){
            this.dispose();
            FrameGioco frameGioco = new FrameGioco();

        }else if(e.getSource() == btnIndietro){
            panelImpostazioni.setVisible(false);
            panelPrimaPagina.setVisible(true);
        }
    }
}
