package View;

import Control.Partita;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class PrimaPagina extends JFrame implements ActionListener, ComponentListener {
    ImageIcon iconFrame = new ImageIcon("LogoProgettoGPO.png");
    Dimension d;
    int difficoltà = 0;   //variabile usata per passare da questo frame al FrameGioco la dimensione della griglia in base alla difficoltà scelta dall'utente
    Partita partita1 = new Partita();

    //ELEMENTI CONTENUTI NELLA PAGINA INIZIALE
    JLabel labelTitolo;
    JPanel panelBtn1;
    RoundedButton btnGioca;
    RoundedButton btnClassifica;
    RoundedButton btnEsci;

    //ELEMENTI CONTENUTI NEL PANEL DELLE IMPOSTAZIONI DI GIOCO
    JLabel labelTitolo2;
    JLabel modalita;
    JLabel sceltadifficolta;
    RoundedButton btnIniziamo;
    RoundedButton btnIndietro;
    JRadioButton livelloFacile;
    JRadioButton livelloMedio;
    JRadioButton livelloDifficile;
    JTextField username;
    String nomeInserito;
    JPanel panelScelteUtente;
    JPanel panelBtn2;

    //ELEMENTI CONTENUTI NEL PANEL DELLA CLASSIFICA
    JLabel titoloClassifica;
    RoundedButton indietroClassifica;
    RoundedButton btnFacile;
    RoundedButton btnMedio;
    RoundedButton btnDifficile;
    JPanel panelBtnClassifica;
    JPanel panelClassifica;
    String[] nomeColonne = {"USERNAME", "DIFFICOLTA'", "PUNTEGGIO", "NUMERO PAROLE"};
    Object[][] data;
    DefaultTableModel modelTable;
    JTable tableClassifica;


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

        btnGioca = new RoundedButton("GIOCA!");
        btnGioca.setBounds(0, 25, 350, 150);
        btnGioca.addActionListener(this);
        btnGioca.setVerticalTextPosition(JButton.CENTER);
        btnGioca.setHorizontalTextPosition(JButton.CENTER);
        btnGioca.setFont(new Font("Comic Sans", Font.BOLD, 30));
        btnGioca.setForeground(Color.black);   //imposto colore testo
        btnGioca.setBackground(Color.lightGray);   //imposto colore di sfondo
        btnGioca.setBorder(null);

        btnClassifica = new RoundedButton("CLASSIFICA");
        btnClassifica.setBounds(750, 25, 350, 150);
        btnClassifica.addActionListener(this);
        btnClassifica.setVerticalTextPosition(JButton.CENTER);
        btnClassifica.setHorizontalTextPosition(JButton.CENTER);
        btnClassifica.setFont(new Font("Comic Sans", Font.BOLD, 30));
        btnClassifica.setForeground(Color.black);
        btnClassifica.setBackground(Color.lightGray);
        btnClassifica.setBorder(null);

        panelBtn1 = new JPanel();
        panelBtn1.setBackground(new Color(216, 112, 124));
        panelBtn1.setSize(1100, 200);
        posizionaJPanel(panelBtn1, 350);
        panelBtn1.setLayout(null);
        panelBtn1.add(btnGioca);
        panelBtn1.add(btnClassifica);
        panelBtn1.setVisible(true);

        btnEsci = new RoundedButton("ESCI");
        btnEsci.setSize(200, 75);
        posizioneJButton(btnEsci, 700);
        btnEsci.addActionListener(this);
        btnEsci.setVerticalTextPosition(JButton.CENTER);
        btnEsci.setHorizontalTextPosition(JButton.CENTER);
        btnEsci.setFont(new Font("Comic Sans", Font.BOLD, 25));
        btnEsci.setForeground(Color.black);
        btnEsci.setBackground(Color.lightGray);
        btnEsci.setBorder(null);
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

        nomeInserito = username.getText();

        sceltadifficolta = new JLabel();
        sceltadifficolta.setBounds(365, 100, 375, 70);
        sceltadifficolta.setText("Con quale difficoltà giochiamo?");
        sceltadifficolta.setForeground(new Color(0, 0, 0));
        sceltadifficolta.setFont(new Font("Comic Sans", Font.BOLD, 25));
        sceltadifficolta.setVerticalAlignment(JLabel.CENTER);

        livelloFacile = new JRadioButton("facile (7 x 7)");
        livelloFacile.setBounds(470, 165, 175, 40);
        livelloFacile.setBackground(new Color(216, 112, 124));
        livelloFacile.setFont(new Font("Comic Sans", Font.BOLD, 20));
        livelloFacile.addActionListener(this);
        livelloMedio =new JRadioButton("medio (6 x 6)");
        livelloMedio.setBounds(470, 205, 175, 40);
        livelloMedio.setBackground(new Color(216, 112, 124));
        livelloMedio.setFont(new Font("Comic Sans", Font.BOLD, 20));
        livelloMedio.addActionListener(this);
        livelloDifficile = new JRadioButton("difficile (5 x 5)");
        livelloDifficile.setBounds(470, 245, 175, 40);
        livelloDifficile.setBackground(new Color(216, 112, 124));
        livelloDifficile.setFont(new Font("Comic Sans", Font.BOLD, 20));
        livelloDifficile.addActionListener(this);

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

        btnIniziamo = new RoundedButton("INIZIAMO");
        btnIniziamo.setBounds(750, 25, 250, 100);
        btnIniziamo.addActionListener(this);
        btnIniziamo.setVerticalTextPosition(JButton.CENTER);
        btnIniziamo.setHorizontalTextPosition(JButton.CENTER);
        btnIniziamo.setFont(new Font("Comic Sans", Font.BOLD, 20));
        btnIniziamo.setForeground(Color.black);
        btnIniziamo.setBackground(Color.lightGray);
        btnIniziamo.setBorder(null);

        btnIndietro = new RoundedButton("INDIETRO");
        btnIndietro.setBounds(100, 25, 250, 100);
        btnIndietro.addActionListener(this);
        btnIndietro.setVerticalTextPosition(JButton.CENTER);
        btnIndietro.setHorizontalTextPosition(JButton.CENTER);
        btnIndietro.setFont(new Font("Comic Sans", Font.BOLD, 20));
        btnIndietro.setForeground(Color.black);
        btnIndietro.setBackground(Color.lightGray);
        btnIndietro.setBorder(null);

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

        btnFacile = new RoundedButton("FACILE");
        btnFacile.setBounds(0, 12, 200, 50);
        btnFacile.addActionListener(this);
        btnFacile.setVerticalTextPosition(JButton.CENTER);
        btnFacile.setFont(new Font("Comic Sans", Font.BOLD, 20));
        btnFacile.setForeground(Color.black);
        btnFacile.setBackground(Color.GRAY);
        btnFacile.setBorder(null);

        btnMedio = new RoundedButton("MEDIO");
        btnMedio.setBounds(300, 12, 200, 50);
        btnMedio.addActionListener(this);
        btnMedio.setVerticalTextPosition(JButton.CENTER);
        btnMedio.setFont(new Font("Comic Sans", Font.BOLD, 20));
        btnMedio.setForeground(Color.black);
        btnMedio.setBackground(Color.lightGray);
        btnMedio.setBorder(null);

        btnDifficile = new RoundedButton("DIFFICILE");
        btnDifficile.setBounds(600, 12, 200, 50);
        btnDifficile.addActionListener(this);
        btnDifficile.setVerticalTextPosition(JButton.CENTER);
        btnDifficile.setFont(new Font("Comic Sans", Font.BOLD, 20));
        btnDifficile.setForeground(Color.black);
        btnDifficile.setBackground(Color.lightGray);
        btnDifficile.setBorder(null);

        panelBtnClassifica = new JPanel();
        panelBtnClassifica.setBackground(new Color(255, 255, 255));
        //panelBtnClassifica.setBackground(new Color(216, 112, 124));
        panelBtnClassifica.setSize(800, 75);
        posizionaJPanel(panelBtnClassifica, 175);
        panelBtnClassifica.setLayout(null);
        panelBtnClassifica.add(btnFacile);
        panelBtnClassifica.add(btnMedio);
        panelBtnClassifica.add(btnDifficile);
        panelBtnClassifica.setVisible(false);

        panelClassifica = new JPanel();
        panelClassifica.setBackground(new Color(255, 255, 255));
        //panelClassifica.setBackground(new Color(216, 112, 124));
        panelClassifica.setSize(800, 400);
        posizionaJPanel(panelClassifica, 275);
        panelClassifica.setLayout(new BorderLayout());

        //====================| TABELLA STATISTICHE |====================
        data = partita1.visualizzaMiglioriF();
        modificaTabella(data);
        JScrollPane scrollTable = new JScrollPane(tableClassifica);   //oggetto che permette di scorrere la tabelal se diventa troppo grande
        panelClassifica.add(scrollTable, BorderLayout.CENTER);
        panelClassifica.setVisible(false);
        //===============================================================

        indietroClassifica = new RoundedButton("INDIETRO");
        indietroClassifica.setSize(200, 75);
        posizioneJButton(indietroClassifica, 700);
        indietroClassifica.addActionListener(this);
        indietroClassifica.setVerticalTextPosition(JButton.CENTER);
        indietroClassifica.setHorizontalTextPosition(JButton.CENTER);
        indietroClassifica.setFont(new Font("Comic Sans", Font.BOLD, 25));
        indietroClassifica.setForeground(Color.black);
        indietroClassifica.setBackground(Color.lightGray);
        indietroClassifica.setBorder(null);
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
        this.add(panelBtnClassifica);
        this.add(panelClassifica);
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
        }
        if(e.getSource() == btnClassifica){
            labelTitolo.setVisible(false);
            panelBtn1.setVisible(false);
            btnEsci.setVisible(false);

            titoloClassifica.setVisible(true);
            indietroClassifica.setVisible(true);
            panelClassifica.setVisible(true);
            panelBtnClassifica.setVisible(true);
        }
        if(e.getSource() == btnEsci){
            //dichiarazione JOptionPane contenuto in una variabile memorizzare l'output generato dalla scelta dell'utente
            int scelta = JOptionPane.showConfirmDialog (null, "Sei sicuro di voler uscire?",
                    "Conferma Uscita", JOptionPane.YES_NO_OPTION);

            if(scelta == JOptionPane.YES_OPTION){   //controllo sul bottone che clicca l'utente nel JOptionPane
                this.dispose();   //nel caso l'utente clicca il bottone yes chiude il JFrame e chiude il programma
            }

        }
        if(e.getSource() == btnIndietro){
            labelTitolo2.setVisible(false);
            panelScelteUtente.setVisible(false);
            panelBtn2.setVisible(false);

            labelTitolo.setVisible(true);
            panelBtn1.setVisible(true);
            btnEsci.setVisible(true);
        }
        if(e.getSource() == indietroClassifica){
            titoloClassifica.setVisible(false);
            indietroClassifica.setVisible(false);
            panelClassifica.setVisible(false);
            panelBtnClassifica.setVisible(false);

            labelTitolo.setVisible(true);
            panelBtn1.setVisible(true);
            btnEsci.setVisible(true);
        }
        if(e.getSource() == livelloFacile){
            difficoltà = 7;
        }else if(e.getSource() == livelloMedio){
            difficoltà = 6;
        }else if(e.getSource() == livelloDifficile){
            difficoltà = 5;
        }
        if(e.getSource() == btnIniziamo){
            if((difficoltà != 0) && !(username.getText()).equals("")){
                partita1.setUsername(nomeInserito);

                if(e.getSource() == livelloFacile){
                    partita1.setDifficoltà("facile");
                }else if(e.getSource() == livelloMedio){
                    partita1.setDifficoltà("medio");
                }else if(e.getSource() == livelloDifficile){
                    partita1.setDifficoltà("difficile");
                }
                FrameGioco frameGioco = new FrameGioco(difficoltà);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null,
                        "Username o Difficoltà non inseriti!",
                        "Errore Inserimento",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource() == btnFacile){
            btnFacile.setBackground(Color.GRAY);
            btnFacile.setEnabled(false);
            btnMedio.setBackground(Color.lightGray);
            btnMedio.setEnabled(true);
            btnDifficile.setBackground(Color.lightGray);
            btnDifficile.setEnabled(true);

            panelClassifica.removeAll();
            panelClassifica.revalidate();

            data = partita1.visualizzaMiglioriF();
            modificaTabella(data);
            JScrollPane scrollTable = new JScrollPane(tableClassifica);
            panelClassifica.add(scrollTable, BorderLayout.CENTER);
            panelClassifica.setVisible(true);
        }
        if(e.getSource() == btnMedio){
            btnMedio.setBackground(Color.GRAY);
            btnMedio.setEnabled(false);
            btnFacile.setBackground(Color.lightGray);
            btnFacile.setEnabled(true);
            btnDifficile.setBackground(Color.lightGray);
            btnDifficile.setEnabled(true);

            panelClassifica.removeAll();
            panelClassifica.revalidate();

            data = partita1.visualizzaMiglioriM();
            modificaTabella(data);
            JScrollPane scrollTable = new JScrollPane(tableClassifica);
            panelClassifica.add(scrollTable, BorderLayout.CENTER);
            panelClassifica.setVisible(true);
        }
        if(e.getSource() == btnDifficile){
            btnDifficile.setBackground(Color.GRAY);
            btnDifficile.setEnabled(false);
            btnFacile.setBackground(Color.lightGray);
            btnFacile.setEnabled(true);
            btnMedio.setBackground(Color.lightGray);
            btnMedio.setEnabled(true);

            panelClassifica.removeAll();
            panelClassifica.revalidate();

            data = partita1.visualizzaMiglioriD();
            modificaTabella(data);
            JScrollPane scrollTable = new JScrollPane(tableClassifica);
            panelClassifica.add(scrollTable, BorderLayout.CENTER);
            panelClassifica.setVisible(true);
        }
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

    //METODO RICHIAMATO PER CAMBIARE LA TABELLA QUANDO SI CLICCANO I BOTTONI SOPRA DI ESSA
    private void modificaTabella(Object[][] data){
        modelTable = new DefaultTableModel(data, nomeColonne);
        tableClassifica = new JTable(modelTable);

        //permette di prendere l'header della tableClassifica
        JTableHeader headerTable = tableClassifica.getTableHeader();
        //permette di richiamare un metodo che consente di modificare il font e background dell'heare della tableClassifica
        headerTable.setDefaultRenderer(new CustomHeaderRenderer());

        //permettono di prendere l'altezza dell'header della tableClassifica e modificarla a piacimento
        Dimension hHeader = headerTable.getPreferredSize();
        hHeader.height = 47;
        headerTable.setPreferredSize(hHeader);

        //permette di cambiare il font e grandezza delle parole contenute nella tabella
        Font font = new Font("Comic Sans", Font.PLAIN, 15);
        tableClassifica.getTableHeader().setFont(font);
        tableClassifica.setFont(font);

        //permette di centrare i contenuti delel celle all'interno di queste
        DefaultTableCellRenderer centraContenuto = new DefaultTableCellRenderer();
        centraContenuto.setHorizontalAlignment(SwingConstants.CENTER);
        tableClassifica.setDefaultRenderer(Object.class, centraContenuto);
        tableClassifica.setRowHeight(35);   //imposta l'altezza delle righe
    }

    //classe per cambiare colore e font ai componenti dell'header della tableClassifica
    private class CustomHeaderRenderer extends DefaultTableCellRenderer{
        public CustomHeaderRenderer(){
            this.setHorizontalAlignment(SwingConstants.CENTER);
            this.setForeground(Color.BLACK);
            this.setBackground(Color.ORANGE);
            this.setFont(new Font("Comic Sans", Font.BOLD, 15));
        }
    }
}
