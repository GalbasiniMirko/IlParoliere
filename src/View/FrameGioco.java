package View;

import Control.Partita;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.Timer;


public class FrameGioco extends JFrame implements ActionListener {
    ImageIcon iconFrame = new ImageIcon("LogoProgettoGPO.png");
    Dimension d;
    Partita partita1 = new Partita();
    int dGriglia;   //serve per memorizzare la dimensione della griglia che viene passata dal precedente frame
    String parolaInserita;   //viene memorizzata la parola inserita dall'utente nel JTextField
    int contParole = 0;   //memorizza il numero di parole trovate dall'utente
    int pParola = 0;   //memorizza il punteggio della singola parola trovata dall'utente
    int punteggioTotale = 0;   //memorizza il punteggio totale delle parole trovate dall'utente
    String nomeUtente;   //serve per memorizzare lo username inserito dall'utente nel JFrame precedente e passato a questo
    String difficoltà;   //serve per memorizzare la difficoltà scelta dall'utente nel JFrame precedente e passato a questo
    Vector<String> paroleTrovate = new Vector<>(0, 1);   //array usato per salvare le parole già trovate e controllare se vengono trovate più di una volta

    JLabel labelTitolo;
    JLabel countdownLabel;
    Timer timer;
    int countdownSeconds;
    Boolean tempoScaduto = false;
    JPanel panelGriglia;
    char[][] matriceLettere;   //matrice char per generare random una serie di lettere da mettere nella griglia
    RoundedButton[][] bottoniGriglia;   //griglia di bottoni per il gioco
    JLabel labelParola;
    JTextField inputUtente;
    RoundedButton btnCercaParola;
    RoundedButton btnRefresh;
    RoundedButton btnTerminaPartita;
    JPanel panelCentro;

    JPanel panelTablePartita;
    String[] nomeColonne = {"PAROLA", "PUNTEGGIO"};
    Object[][] data;
    DefaultTableModel modelTable;
    JTable tableParole;

    public FrameGioco(int dimGriglia, String nUtente, String dif){
        this.setTitle("IL PAROLIERE");
        this.setIconImage(iconFrame.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //il frame si chiuderà con il tasto in alto a destra
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(255, 195, 149));
        d = getToolkit().getScreenSize();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);

        dGriglia = dimGriglia;
        nomeUtente = nUtente;
        difficoltà = dif;

        //JLABEL PER IL TITOLO IN ALTO
        labelTitolo = new JLabel();
        labelTitolo.setBounds(0, 0, d.width, 100);
        labelTitolo.setText(nomeUtente+", VEDIAMO DI COSA SEI CAPACE! ");
        labelTitolo.setBackground(new Color(255, 195, 149));
        labelTitolo.setOpaque(true);
        labelTitolo.setForeground(new Color(0, 0, 0));   //imposta colore del testo
        labelTitolo.setFont(new Font("Century Gothic", Font.BOLD, 25));
        labelTitolo.setVerticalAlignment(JLabel.CENTER);   //imposta la posizione verticale del testo
        labelTitolo.setHorizontalAlignment(JLabel.CENTER);   //imposta la posizione orizzontale del testo
        labelTitolo.setVisible(true);

        //JLABEL PER IL TEMPO RIMANENTE
        countdownLabel = new JLabel();
        countdownLabel.setBounds(0, 100, d.width, 75);
        countdownLabel.setBackground(new Color(255, 195, 149));
        countdownLabel.setOpaque(true);
        countdownLabel.setForeground(new Color(0, 0, 0));
        countdownLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
        countdownLabel.setVerticalAlignment(JLabel.CENTER);
        countdownLabel.setHorizontalAlignment(SwingConstants.CENTER);
        countdownLabel.setVisible(true);

        countdownSeconds = 300;   //5 minuti di tempo per trovare le parole
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int remainingSeconds = countdownSeconds;

            public void run() {
                int minutes = remainingSeconds / 60;
                int seconds = remainingSeconds % 60;
                String timeString = String.format("Tempo rimanente: %02d:%02d", minutes, seconds);
                SwingUtilities.invokeLater(() -> {
                    countdownLabel.setText(timeString);
                });
                remainingSeconds--;
                if(remainingSeconds < 0) {
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(null, "Il timer è scaduto!");
                        inputUtente.setEditable(false);
                        btnRefresh.setEnabled(false);
                        tempoScaduto = true;
                    });
                    timer.cancel();
                    timer = null;
                }
            }
        }, 0, 1000);

        //GRIGLIA LETTERE
        panelGriglia = new JPanel();
        panelGriglia.setBackground(new Color(255, 195, 149));
        //panelGriglia.setBackground(new Color(255, 255, 255));
        panelGriglia.setSize(600, 400);
        panelGriglia.setLocation(50, 240);
        panelGriglia.setLayout(new GridLayout(dimGriglia,dimGriglia,5,5));

        matriceLettere = new char[dimGriglia][dimGriglia];
        int numerocelle = dimGriglia * dimGriglia;
        int percentualeVocali = (int) (numerocelle * 0.3);
        int contatoreVocali = 0;
        Random random = new Random();
        while (contatoreVocali <percentualeVocali) {
            contatoreVocali = 0;
            for (int i = 0; i < dimGriglia; i++) {
                for (int j = 0; j < dimGriglia; j++) {
                    matriceLettere[i][j] = Character.toUpperCase((char) (random.nextInt(26) + 'a'));
                    if (trovaVocale(matriceLettere[i][j])) {
                        contatoreVocali++;
                    }
                }
            }
        }

        //CODICE PER STAMPARE NELLA CONSOLE LA MATRICE
        for (int i = 0; i < dimGriglia; i++) {
            for (int j = 0; j < dimGriglia; j++) {
                System.out.print(matriceLettere[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();

        bottoniGriglia = new RoundedButton[dimGriglia][dimGriglia];
        for(int i=0; i<dimGriglia; i++){
            for (int j=0; j<dimGriglia; j++){
                bottoniGriglia[i][j] = new RoundedButton(String.valueOf(matriceLettere[i][j]));
                bottoniGriglia[i][j].setFont(new Font("Century Gothic", Font.BOLD, 30));
                if(dimGriglia == 7){
                    bottoniGriglia[i][j].setSize(77,48);
                }else if(dimGriglia == 6){
                    bottoniGriglia[i][j].setSize(90,56);
                }else if(dimGriglia == 5){
                    bottoniGriglia[i][j].setSize(108,68);
                }
                //bottoniGriglia[i][j].addActionListener(this);
                bottoniGriglia[i][j].setEnabled(false);    //opzionale perché togliendo l'ActionListener i bottoni non fanno nulla
                bottoniGriglia[i][j].setForeground(new Color(0, 0, 0));
                bottoniGriglia[i][j].setBackground(Color.white);
                bottoniGriglia[i][j].setBorder(null);
                panelGriglia.add(bottoniGriglia[i][j]);
            }
        }
        panelGriglia.setVisible(true);

        btnRefresh = new RoundedButton("Refresh");
        btnRefresh.setSize(150, 50);
        btnRefresh.setLocation(275, 700);
        btnRefresh.addActionListener(this);
        btnRefresh.setFocusable(false);
        btnRefresh.setEnabled(true);
        btnRefresh.setVerticalTextPosition(JButton.CENTER);
        btnRefresh.setHorizontalTextPosition(JButton.CENTER);
        btnRefresh.setFont(new Font("Century Gothic", Font.BOLD, 25));
        btnRefresh.setForeground(Color.black);
        btnRefresh.setBackground(new Color(245, 245, 200));
        btnRefresh.setBorder(null);
        btnRefresh.setVisible(true);

        panelCentro = new JPanel();
        panelCentro.setBackground(new Color(255, 195, 149));
        //panelCentro.setBackground(new Color(255, 255, 255));
        panelCentro.setSize(350, 510);
        panelCentro.setLocation(725, 240);
        panelCentro.setLayout(null);

        labelParola = new JLabel();
        labelParola.setSize(310, 50);
        posizionaJLabel(panelCentro, labelParola, 140);
        labelParola.setBackground(new Color(255, 255, 255));
        labelParola.setText("Inserisci la parola trovata: ");
        labelParola.setForeground(new Color(0, 0, 0));
        labelParola.setFont(new Font("Century Gothic", Font.BOLD, 20));
        labelParola.setVerticalAlignment(JLabel.CENTER);

        inputUtente = new JTextField();
        inputUtente.setSize(200 , 30);
        posizionaJTextField(panelCentro, inputUtente, 190);
        inputUtente.setPreferredSize(new Dimension(250, 40));
        inputUtente.setFont(new Font("Century Gothic", Font.BOLD, 25));
        inputUtente.setForeground(new Color(0, 0, 0));
        inputUtente.setBackground(new Color(255, 255, 255));

        btnCercaParola = new RoundedButton("Cerca");
        btnCercaParola.setSize(105, 50);
        posizioneJButton(panelCentro, btnCercaParola, 230);
        btnCercaParola.addActionListener(this);
        btnCercaParola.setFocusable(false);
        btnCercaParola.setVerticalTextPosition(JButton.CENTER);
        btnCercaParola.setHorizontalTextPosition(JButton.CENTER);
        btnCercaParola.setFont(new Font("Century Gothic", Font.BOLD, 25));
        btnCercaParola.setForeground(Color.black);
        btnCercaParola.setBackground(new Color(245, 245, 200));
        btnCercaParola.setBorder(null);
        btnCercaParola.setVisible(true);

        btnTerminaPartita = new RoundedButton("Termina partita");
        btnTerminaPartita.setSize(215, 50);
        posizioneJButton(panelCentro, btnTerminaPartita, 460);
        btnTerminaPartita.addActionListener(this);
        btnTerminaPartita.setFocusable(false);
        btnTerminaPartita.setVerticalTextPosition(JButton.CENTER);
        btnTerminaPartita.setHorizontalTextPosition(JButton.CENTER);
        btnTerminaPartita.setFont(new Font("Century Gothic", Font.BOLD, 25));
        btnTerminaPartita.setForeground(Color.black);
        btnTerminaPartita.setBackground(new Color(245, 245, 200));
        btnTerminaPartita.setBorder(null);
        btnTerminaPartita.setVisible(true);

        panelCentro.add(labelParola);
        panelCentro.add(inputUtente);
        panelCentro.add(btnCercaParola);
        panelCentro.add(btnTerminaPartita);
        panelCentro.setVisible(true);

        panelTablePartita = new JPanel();
        panelTablePartita.setBackground(new Color(255, 195, 149));
        //panelTablePartita.setBackground(new Color(255, 255, 255));
        panelTablePartita.setSize(325, 510);
        panelTablePartita.setLocation(1150, 240);
        panelTablePartita.setLayout(new BorderLayout());

        //====================| TABELLA PAROLE/PUNTEGGIO |====================
        modelTable = new DefaultTableModel(data, nomeColonne);
        tableParole = new JTable(modelTable);
        tableParole.setEnabled(false);

        //permette di prendere l'header della tableClassifica
        JTableHeader headerTable = tableParole.getTableHeader();
        //permette di richiamare un metodo che consente di modificare il font e background dell'header della tableClassifica
        //headerTable.setDefaultRenderer(new CustomHeaderRenderer());

        //permettono di prendere l'altezza dell'header della tableClassifica e modificarla a piacimento
        Dimension hHeader = headerTable.getPreferredSize();
        hHeader.height = 47;
        headerTable.setPreferredSize(hHeader);

        //permette di cambiare il font e grandezza delle parole contenute nella tabella
        Font fontHeader = new Font("Century Gothic", Font.PLAIN, 15);
        tableParole.getTableHeader().setFont(fontHeader);
        tableParole.getTableHeader().setBackground(Color.orange);
        Font font = new Font("Century Gothic", Font.PLAIN, 15);
        tableParole.setFont(font);

        //permette di centrare i contenuti delel celle all'interno di queste
        DefaultTableCellRenderer centraContenuto = new DefaultTableCellRenderer();
        centraContenuto.setHorizontalAlignment(SwingConstants.CENTER);
        tableParole.setDefaultRenderer(Object.class, centraContenuto);
        tableParole.setRowHeight(35);   //imposta l'altezza delle righe
        JScrollPane scrollTable = new JScrollPane(tableParole);   //oggetto che permette di scorrere la tabelal se diventa troppo grande
        panelTablePartita.add(scrollTable, BorderLayout.CENTER);
        panelTablePartita.setVisible(true);
        //====================================================================

        this.add(labelTitolo);
        this.add(countdownLabel);
        this.add(panelGriglia);
        this.add(btnRefresh);
        this.add(panelCentro);
        this.add(panelTablePartita);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnTerminaPartita) {
            if(tempoScaduto){
                partita1.setUsername(nomeUtente);
                partita1.setDifficoltà(difficoltà);
                partita1.setPunteggio(punteggioTotale);
                partita1.setNumeroParole(contParole);
                partita1.inserisciDati();

                this.dispose();
                PrimaPagina primaPagina = new PrimaPagina();
            }else{
                int scelta = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler terminare la partita?" +
                                "\nI dati non verranno salvati",
                        "Termina Partita", JOptionPane.YES_NO_OPTION);

                if (scelta == JOptionPane.YES_OPTION) {
                    this.dispose();
                    PrimaPagina primaPagina = new PrimaPagina();
                }
            }
        }
        if(e.getSource() == btnRefresh) {
            if (timer != null) {
                timer.cancel();
                timer = null;
            }

            FrameGioco frameGioco = new FrameGioco(dGriglia, nomeUtente, difficoltà);
            this.dispose();
        }
        if(e.getSource() == btnCercaParola){
            if(!(inputUtente.getText().equals(""))){
                parolaInserita = inputUtente.getText();

                //CERCARE PAROLA NEL DB
                if(cercaParolaGriglia(matriceLettere, parolaInserita)){
                    if(cercaParolaDB()){
                        //controllo se la parola è già stata trovata
                        if(!paroleTrovate.contains(parolaInserita)){
                            paroleTrovate.addElement(parolaInserita);
                            contParole++;
                            pParola = parolaInserita.length();
                            punteggioTotale = punteggioTotale + pParola;
                            modelTable.addRow(new Object[]{parolaInserita, pParola});
                            tableParole.setModel(modelTable);
                            inputUtente.setText("");
                        }else{
                            JOptionPane.showMessageDialog(null, "Parola già trovata!", "Errore", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "La parola non è presente :(");
                        contParole++;
                        modelTable.addRow(new Object[]{parolaInserita, 0});
                        tableParole.setModel(modelTable);
                        inputUtente.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "La parola non è presente :(");
                    inputUtente.setText("");
                }

                //CERCARE PAROLA NEL FILE
                /*if(cercaParolaGriglia(matriceLettere, parolaInserita)){
                    if(cercaParolaFile(parolaInserita)){
                        JOptionPane.showMessageDialog(null, "La parola è presente");
                        modelTable.addRow(new Object[]{parolaInserita, "ciao"});
                        tableClassifica.setModel(modelTable);
                        inputUtente.setText("");
                    }else{
                        JOptionPane.showMessageDialog(null, "La parola non è presente nel file :(");
                        modelTable.addRow(new Object[]{parolaInserita, 0});
                        tableClassifica.setModel(modelTable);
                        inputUtente.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog( null,
                            "Parola non presente nella griglia",
                            "WOW",
                            JOptionPane.ERROR_MESSAGE);
                }*/
            }
        }
    }

    private void posizionaJLabel(JPanel p, JLabel l, int y) {
        int wPanel = p.getWidth();
        int wLabel = l.getWidth();
        int x = (wPanel - wLabel)/2;
        l.setLocation(x, y);
    }
    private void posizionaJTextField(JPanel p, JTextField tf, int y) {
        int wPanel = p.getWidth();
        int wTextField = tf.getWidth();
        int x = (wPanel - wTextField)/2;
        tf.setLocation(x, y);
    }
    private void posizioneJButton(JPanel p, JButton b, int y) {
        int wPanel = p.getWidth();
        int width = b.getWidth();
        int x = (wPanel - width)/2;
        b.setLocation(x, y);
    }

    public static boolean cercaParolaGriglia(char[][] griglia, String parola) {
        int righe = griglia.length;
        int colonne = griglia[0].length;

        //Scorri ogni cella della griglia
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                //Se la cella corrente contiene la prima lettera della parola
                if(griglia[i][j] == parola.charAt(0)) {
                    //Controlla se la parola è presente partendo da questa cella
                    if(trovaParolaGriglia(griglia, parola, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean trovaParolaGriglia(char[][] griglia, String parola, int riga, int colonna, int indice) {
        //Se l'indice ha raggiunto la lunghezza della parola, significa che la parola è stata trovata
        if (indice == parola.length()) {
            return true;
        }

        int righe = griglia.length;
        int colonne = griglia[0].length;

        //Verifica se le coordinate sono valide e la cella corrente contiene la lettera corrispondente all'indice
        if(riga >= 0 && riga < righe && colonna >= 0 && colonna < colonne && griglia[riga][colonna] == parola.charAt(indice)) {
            //Controlla la parola ricorsivamente in tutte le direzioni (su, giù, sinistra, destra)
            return trovaParolaGriglia(griglia, parola, riga-1, colonna, indice+1) //Su
                    || trovaParolaGriglia(griglia, parola, riga+1, colonna, indice+1) //Giù
                    || trovaParolaGriglia(griglia, parola, riga, colonna-1, indice+1) //Sinistra
                    || trovaParolaGriglia(griglia, parola, riga, colonna+1, indice+1); //Destra
        }

        return false;
    }

    public Boolean cercaParolaDB(){
        //se la parola esiste ripulisce solo la casella di testo altrimenti mostra la finestra dicendo che la parola non esiste nel database
       if(partita1.controllaParolaNelDatabase(parolaInserita)){
            inputUtente.setText("");
            return true;
        }else{
            return false;
        }
    }
    private static boolean trovaVocale(char c) {

        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static boolean cercaParolaFile(String parola) {
        try(BufferedReader br = new BufferedReader(new FileReader("src/Main/fileParole.txt"))){
            String linea ;
            while((linea = br.readLine()) != null){ //continua a cercare finchè non arriva alla fine
                if(linea.contains(parola)){ //se la linea contiene la parola ritorna vero
                    return true; // La parola è stata trovata
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return false; // La parola non è stata trovata

    }

    //classe per cambiare colore e font ai componenti dell'header della tableClassifica
    /*private class CustomHeaderRenderer extends DefaultTableCellRenderer{
        public CustomHeaderRenderer(){
            this.setHorizontalAlignment(SwingConstants.CENTER);
            this.setForeground(Color.BLACK);
            this.setBackground(Color.ORANGE);
            this.setFont(new Font("Comic Sans", Font.BOLD, 15));
        }
    }*/
}
