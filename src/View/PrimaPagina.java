package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class PrimaPagina extends JFrame implements ActionListener, ComponentListener {
    ImageIcon iconFrame = new ImageIcon("LogoProgettoGPO.png");
    Dimension d;

    //ELEMENTI CONTENUTI NELLA PAGINA INIZIALE
    JLabel labelTitolo;
    JPanel panelBtn1;
    JButton btnGioca;
    JButton btnClassifica;
    JButton btnEsci;

    //ELEMENTI CONTENUTI NEL PANEL DELLE IMPOSTAZIONI DI GIOCO
    JLabel labelTitolo2;
    JLabel modalita;
    JLabel sceltadifficolta;
    JButton btnIniziamo;
    JButton btnIndietro;
    JRadioButton livelloFacile;
    JRadioButton livelloMedio;
    JRadioButton livelloDifficile;
    JTextField username;
    JPanel panelScelteUtente;
    JPanel panelBtn2;

    //ELEMENTI CONTENUTI NEL PANEL DELLA CLASSIFICA
    JLabel titoloClassifica;
    JButton indietroClassifica;


    public PrimaPagina(){
        this.setTitle("Il Paroliere");
        this.setIconImage(iconFrame.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //il frame si chiuderà con il tasto in alto a destra
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(216, 112, 124));
        d = getToolkit().getScreenSize();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);

        //INIZIO ELEMENTI PANEL DELLA PRIMA PAGINA
        labelTitolo = new JLabel();
        labelTitolo.setBounds(0, 0, d.width, 275);
        labelTitolo.setText("IL PAROLIERE");
        labelTitolo.setBackground(new Color(125, 125, 125));
        labelTitolo.setOpaque(true);
        labelTitolo.setForeground(new Color(0, 0, 0));   //imposta colore del testo
        labelTitolo.setFont(new Font("Comic Sans", Font.BOLD, 45));   //imposta il font e la grandezza del testo
        labelTitolo.setVerticalAlignment(JLabel.CENTER);   //imposta la posizione verticale del testo
        labelTitolo.setHorizontalAlignment(JLabel.CENTER);   //imposta la posizione orizzontale del testo
        labelTitolo.setVisible(true);

        btnGioca = new JButton();
        btnGioca.setBounds(0, 25, 350, 150);
        btnGioca.addActionListener(this);
        btnGioca.setText("GIOCA!");
        btnGioca.setVerticalTextPosition(JButton.CENTER);
        btnGioca.setHorizontalTextPosition(JButton.CENTER);
        btnGioca.setFont(new Font("Comic Sans", Font.BOLD, 30));
        btnGioca.setForeground(Color.black);   //imposto colore testo
        btnGioca.setBackground(Color.lightGray);   //imposto colore di sfondo

        btnClassifica = new JButton();
        btnClassifica.setBounds(750, 25, 350, 150);
        btnClassifica.addActionListener(this);
        btnClassifica.setText("CLASSIFICA");
        btnClassifica.setVerticalTextPosition(JButton.CENTER);
        btnClassifica.setHorizontalTextPosition(JButton.CENTER);
        btnClassifica.setFont(new Font("Comic Sans", Font.BOLD, 30));
        btnClassifica.setForeground(Color.black);
        btnClassifica.setBackground(Color.lightGray);

        panelBtn1 = new JPanel();
        panelBtn1.setBackground(new Color(216, 112, 124));
        panelBtn1.setSize(1100, 200);
        posizionaJPanel(panelBtn1, 350);
        panelBtn1.setLayout(null);
        panelBtn1.add(btnGioca);
        panelBtn1.add(btnClassifica);
        panelBtn1.setVisible(true);

        btnEsci = new JButton();
        btnEsci.setSize(200, 75);
        posizioneJButton(btnEsci, 700);
        btnEsci.addActionListener(this);
        btnEsci.setText("ESCI");
        btnEsci.setFocusable(false);
        btnEsci.setVerticalTextPosition(JButton.CENTER);
        btnEsci.setHorizontalTextPosition(JButton.CENTER);
        btnEsci.setFont(new Font("Comic Sans", Font.BOLD, 25));
        btnEsci.setForeground(Color.black);
        btnEsci.setBackground(Color.lightGray);
        btnEsci.setVisible(true);

        //INIZIO ELEMENTI PANEL IMPOSTAZIONI
        labelTitolo2 = new JLabel();
        labelTitolo2.setBounds(0, 0, d.width,  275);
        labelTitolo2.setText("IMPOSTAZIONI DI GIOCO");
        labelTitolo2.setBackground(new Color(125, 125, 125));
        labelTitolo2.setOpaque(true);
        labelTitolo2.setForeground(new Color(0, 0, 0));
        labelTitolo2.setFont(new Font("Comic Sans", Font.BOLD, 30));
        labelTitolo2.setVerticalAlignment(JLabel.CENTER);
        labelTitolo2.setHorizontalAlignment(JLabel.CENTER);
        labelTitolo2.setVisible(false);

        modalita = new JLabel();
        modalita.setBounds(455, 0, 200, 50);
        modalita.setBackground(new Color(255, 255, 255));
        modalita.setText("Come ti chiami?");
        modalita.setForeground(new Color(0, 0, 0));
        modalita.setFont(new Font("Comic Sans", Font.BOLD, 25));
        modalita.setVerticalAlignment(JLabel.CENTER);

        username = new JTextField();
        username.setBounds(450, 50, 200 , 30);
        username.setPreferredSize(new Dimension(250, 40));
        username.setFont(new Font("Comic Sans", Font.BOLD, 25));
        username.setForeground(new Color(0, 0, 0));
        username.setBackground(new Color(255, 255, 255));

        sceltadifficolta = new JLabel();
        sceltadifficolta.setBounds(365, 100, 375, 70);
        sceltadifficolta.setText("Con quale difficoltà giochiamo?");
        sceltadifficolta.setForeground(new Color(0, 0, 0));
        sceltadifficolta.setFont(new Font("Comic Sans", Font.BOLD, 25));
        sceltadifficolta.setVerticalAlignment(JLabel.CENTER);

        livelloFacile = new JRadioButton("facile (5 x 5)");
        livelloFacile.setBounds(470, 165, 175, 40);
        livelloFacile.setBackground(new Color(216, 112, 124));
        livelloFacile.setFont(new Font("Comic Sans", Font.BOLD, 20));
        livelloMedio =new JRadioButton("medio (4 x 4)");
        livelloMedio.setBounds(470, 205, 175, 40);
        livelloMedio.setBackground(new Color(216, 112, 124));
        livelloMedio.setFont(new Font("Comic Sans", Font.BOLD, 20));
        livelloDifficile = new JRadioButton("difficile (3 x 3)");
        livelloDifficile.setBounds(470, 245, 175, 40);
        livelloDifficile.setBackground(new Color(216, 112, 124));
        livelloDifficile.setFont(new Font("Comic Sans", Font.BOLD, 20));

        ButtonGroup group = new ButtonGroup();
        group.add(livelloFacile);
        group.add(livelloMedio);
        group.add(livelloDifficile);

        panelScelteUtente = new JPanel();
        //panelScelteUtente.setBackground(new Color(255, 255, 255));
        panelScelteUtente.setBackground(new Color(216, 112, 124));
        panelScelteUtente.setSize(1100, 325);
        posizionaJPanel(panelScelteUtente, 300);
        panelScelteUtente.setLayout(null);
        panelScelteUtente.add(modalita);
        panelScelteUtente.add(username);
        panelScelteUtente.add(sceltadifficolta);
        panelScelteUtente.add(livelloFacile);
        panelScelteUtente.add(livelloMedio);
        panelScelteUtente.add(livelloDifficile);
        panelScelteUtente.setVisible(false);

        btnIniziamo = new JButton();
        btnIniziamo.setBounds(750, 25, 250, 100);
        btnIniziamo.addActionListener(this);
        btnIniziamo.setText("INIZIAMO");
        btnIniziamo.setFocusable(false);
        btnIniziamo.setVerticalTextPosition(JButton.CENTER);
        btnIniziamo.setHorizontalTextPosition(JButton.CENTER);
        btnIniziamo.setFont(new Font("Comic Sans", Font.BOLD, 20));
        btnIniziamo.setForeground(Color.black);
        btnIniziamo.setBackground(Color.lightGray);

        btnIndietro = new JButton();
        btnIndietro.setBounds(100, 25, 250, 100);
        btnIndietro.addActionListener(this);
        btnIndietro.setText("INDIETRO");
        btnIndietro.setFocusable(false);
        btnIndietro.setVerticalTextPosition(JButton.CENTER);
        btnIndietro.setHorizontalTextPosition(JButton.CENTER);
        btnIndietro.setFont(new Font("Comic Sans", Font.BOLD, 20));
        btnIndietro.setForeground(Color.black);
        btnIndietro.setBackground(Color.lightGray);

        panelBtn2 = new JPanel();
        panelBtn2.setBackground(new Color(216, 112, 124));
        panelBtn2.setSize(1100, 150);
        posizionaJPanel(panelBtn2, 625);
        panelBtn2.setLayout(null);
        panelBtn2.add(btnIndietro);
        panelBtn2.add(btnIniziamo);
        panelBtn2.setVisible(false);

        //INIZIO ELEMENTI PANEL CLASSIFICA
        titoloClassifica = new JLabel();
        titoloClassifica.setBounds(0, 0, d.width,  150);
        titoloClassifica.setText("CLASSIFICA");
        titoloClassifica.setBackground(new Color(125, 125, 125));
        titoloClassifica.setOpaque(true);
        titoloClassifica.setForeground(new Color(0, 0, 0));
        titoloClassifica.setFont(new Font("Comic Sans", Font.BOLD, 30));
        titoloClassifica.setVerticalAlignment(JLabel.CENTER);
        titoloClassifica.setHorizontalAlignment(JLabel.CENTER);
        titoloClassifica.setVisible(false);

        indietroClassifica = new JButton();
        indietroClassifica.setSize(200, 75);
        posizioneJButton(indietroClassifica, 700);
        indietroClassifica.addActionListener(this);
        indietroClassifica.setText("ESCI");
        indietroClassifica.setFocusable(false);
        indietroClassifica.setVerticalTextPosition(JButton.CENTER);
        indietroClassifica.setHorizontalTextPosition(JButton.CENTER);
        indietroClassifica.setFont(new Font("Comic Sans", Font.BOLD, 25));
        indietroClassifica.setForeground(Color.black);
        indietroClassifica.setBackground(Color.lightGray);
        indietroClassifica.setVisible(false);

        //AGGIUNTA AL FRAME DEGLI ELEMENTI DELLA PRIMA PAGINA
        this.add(labelTitolo);
        this.add(panelBtn1);
        this.add(btnEsci);

        //AGGIUNTA AL FRAME DEGLI ELEMENTI DELLA SECONDA PAGINA
        this.add(labelTitolo2);
        this.add(panelScelteUtente);
        this.add(panelBtn2);

        //AGGIUNTA AL FRAME DEGLI ELEMENTI DELLA PAGINA CLASSIFICA
        this.add(titoloClassifica);
        this.add(indietroClassifica);

        this.setVisible(true);
    }

    //METODI ACTION LISTENER
    @Override
    public void actionPerformed(ActionEvent e) {
        //controllo per capire quale tasto è stato cliccato
        if(e.getSource() == btnGioca){
            labelTitolo.setVisible(false);
            panelBtn1.setVisible(false);
            btnEsci.setVisible(false);

            labelTitolo2.setVisible(true);
            panelScelteUtente.setVisible(true);
            panelBtn2.setVisible(true);

        }else if(e.getSource() == btnClassifica){
            labelTitolo.setVisible(false);
            panelBtn1.setVisible(false);
            btnEsci.setVisible(false);

            titoloClassifica.setVisible(true);
            indietroClassifica.setVisible(true);
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
            labelTitolo2.setVisible(false);
            panelScelteUtente.setVisible(false);
            panelBtn2.setVisible(false);

            labelTitolo.setVisible(true);
            panelBtn1.setVisible(true);
            btnEsci.setVisible(true);
        }else if(e.getSource() == indietroClassifica){
            titoloClassifica.setVisible(false);
            indietroClassifica.setVisible(false);

            labelTitolo.setVisible(true);
            panelBtn1.setVisible(true);
            btnEsci.setVisible(true);
        }
    }

    private void posizionaJPanel(JPanel p, int y) {
        int width = p.getWidth();
        int x = (d.width - width)/2;
        p.setLocation(x, y);
    }
    private void posizioneJButton(JButton b, int y) {
        int width = b.getWidth();
        int x = (d.width - width)/2;
        b.setLocation(x, y);
    }

    //METODI COMPONENT LISTENER
    @Override
    public void componentResized(ComponentEvent e) {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    @Override
    public void componentMoved(ComponentEvent e) {

    }
    @Override
    public void componentShown(ComponentEvent e) {

    }
    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
