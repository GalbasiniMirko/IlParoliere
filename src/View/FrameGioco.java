package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class FrameGioco extends JFrame implements ActionListener {
    ImageIcon iconFrame = new ImageIcon("LogoProgettoGPO.png");
    Dimension d;

    JLabel labelTitolo;
    JLabel countdownLabel;
    Timer timer;
    int countdownSeconds;
    JPanel panelGriglia;
    JButton[] bottoniGriglia;
    JLabel labelParola;
    JTextField inputUtente;
    JButton btnRefresh;
    JButton btnTerminaPartita;
    JPanel panelDestra;

    public FrameGioco(){
        this.setTitle("IL PAROLIERE");
        this.setIconImage(iconFrame.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //il frame si chiuderà con il tasto in alto a destra
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(216, 112, 124));
        d = getToolkit().getScreenSize();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);

        //JLABEL PER IL TITOLO IN ALTO
        labelTitolo = new JLabel();
        labelTitolo.setBounds(0, 0, d.width, 100);
        labelTitolo.setText("VEDIAMO DI COSA SEI CAPACE! ");
        labelTitolo.setBackground(new Color(125, 125, 125));
        labelTitolo.setOpaque(true);
        labelTitolo.setForeground(new Color(0, 0, 0));   //imposta colore del testo
        labelTitolo.setFont(new Font("Comic Sans", Font.BOLD, 25));
        labelTitolo.setVerticalAlignment(JLabel.CENTER);   //imposta la posizione verticale del testo
        labelTitolo.setHorizontalAlignment(JLabel.CENTER);   //imposta la posizione orizzontale del testo
        labelTitolo.setVisible(true);

        //JLABEL PER IL TEMPO RIMANENTE
        countdownLabel = new JLabel();
        countdownLabel.setBounds(0, 100, d.width, 75);
        countdownLabel.setBackground(new Color(125, 125, 125));
        countdownLabel.setOpaque(true);
        countdownLabel.setForeground(new Color(0, 0, 0));
        countdownLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
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
                if (remainingSeconds < 0) {
                    SwingUtilities.invokeLater(() -> {
                        countdownLabel.setText("Tempo scaduto!");
                    });
                    timer.cancel();
                }
            }
        }, 0, 1000);

        //GRIGLIA LETTERE
        panelGriglia = new JPanel();
        panelGriglia.setBackground(new Color(216, 112, 124));
        //panelGriglia.setBackground(new Color(255, 255, 255));
        panelGriglia.setSize(700, 500);
        panelGriglia.setLocation(50, 240);
        panelGriglia.setLayout(new GridLayout(6,6,10,10));

        bottoniGriglia = new JButton[36];
        for (int i = 0; i < bottoniGriglia.length; i++) {
            bottoniGriglia[i] = new JButton();
            bottoniGriglia[i].setText("lettera 9");
            bottoniGriglia[i].setFont(new Font("Comic Sans", Font.BOLD, 30));
            bottoniGriglia[i].setSize(116,83);
            bottoniGriglia[i].addActionListener(this);
            bottoniGriglia[i].setForeground(Color.black);
            bottoniGriglia[i].setBackground(Color.lightGray);
            panelGriglia.add(bottoniGriglia[i]);
        }

        String lettere = "";
        Random rand = new Random();
        for (int i = 0; i < bottoniGriglia.length; i++) {
            //Genera un numero casuale compreso tra 0 e 25, corrispondenti alle lettere minuscole dell'alfabeto
            int numeroCasuale = rand.nextInt(26);
            //Converte il numero casuale in una lettera dell'alfabeto e la aggiunge alla stringa
            char lettera = (char) (numeroCasuale + 'a');
            lettere += lettera;
            //Aggiunge la lettera al testo del bottone corrispondente
            bottoniGriglia[i].setText(Character.toString(lettera));
        }
        panelGriglia.setVisible(true);

        panelDestra = new JPanel();
        panelDestra.setBackground(new Color(216, 112, 124));
        //panelDestra.setBackground(new Color(255, 255, 255));
        panelDestra.setSize(700, 500);
        panelDestra.setLocation(800, 240);
        panelDestra.setLayout(null);

        labelParola = new JLabel();
        labelParola.setSize(310, 50);
        posizionaJLabel(panelDestra, labelParola, 40);
        labelParola.setBackground(new Color(255, 255, 255));
        labelParola.setText("Inserisci la parola trovata: ");
        labelParola.setForeground(new Color(0, 0, 0));
        labelParola.setFont(new Font("Comic Sans", Font.BOLD, 25));
        labelParola.setVerticalAlignment(JLabel.CENTER);

        inputUtente = new JTextField();
        inputUtente.setSize(200 , 30);
        posizionaJTextField(panelDestra, inputUtente, 90);
        inputUtente.setPreferredSize(new Dimension(250, 40));
        inputUtente.setFont(new Font("Comic Sans", Font.BOLD, 25));
        inputUtente.setForeground(new Color(0, 0, 0));
        inputUtente.setBackground(new Color(255, 255, 255));

        btnRefresh = new JButton();
        btnRefresh.setSize(150, 50);
        posizioneJButton(panelDestra, btnRefresh, 225);
        btnRefresh.addActionListener(this);
        btnRefresh.setText("Refresh");
        btnRefresh.setFocusable(false);
        btnRefresh.setVerticalTextPosition(JButton.CENTER);
        btnRefresh.setHorizontalTextPosition(JButton.CENTER);
        btnRefresh.setFont(new Font("Comic Sans", Font.BOLD, 25));
        btnRefresh.setForeground(Color.black);
        btnRefresh.setBackground(Color.lightGray);
        btnRefresh.setVisible(true);

        btnTerminaPartita = new JButton();
        btnTerminaPartita.setSize(215, 50);
        posizioneJButton(panelDestra, btnTerminaPartita, 400);
        btnTerminaPartita.addActionListener(this);
        btnTerminaPartita.setText("Termina partita");
        btnTerminaPartita.setFocusable(false);
        btnTerminaPartita.setVerticalTextPosition(JButton.CENTER);
        btnTerminaPartita.setHorizontalTextPosition(JButton.CENTER);
        btnTerminaPartita.setFont(new Font("Comic Sans", Font.BOLD, 25));
        btnTerminaPartita.setForeground(Color.black);
        btnTerminaPartita.setBackground(Color.lightGray);
        btnTerminaPartita.setVisible(true);

        panelDestra.add(labelParola);
        panelDestra.add(inputUtente);
        panelDestra.add(btnRefresh);
        panelDestra.add(btnTerminaPartita);
        panelDestra.setVisible(true);

        this.add(labelTitolo);
        this.add(countdownLabel);
        this.add(panelGriglia);
        this.add(panelDestra);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTerminaPartita) {
            //if() {   //controllo per vedere se il tempo è maggiore di 0
            int scelta = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler terminare la partita?",
                    "Termina Partita", JOptionPane.YES_NO_OPTION);

            if (scelta == JOptionPane.YES_OPTION) {
                this.dispose();
                PrimaPagina primaPagina = new PrimaPagina();
            }
            //}
        } else if (e.getSource() == btnRefresh) {
                     refreshbaby(); //metodo che fa ripartire il timer e cambia le lettere nella griglia
                                    // nel caso in cui non siano disponibili parole

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

    private void refreshbaby(){
        if (timer != null) {
            timer.cancel();
        }

        // Crea un nuovo timer e schedula un TimerTask
        timer= new Timer();

        timer.schedule(new TimerTask() {
            int countdownSeconds = 300;
            int remainingSeconds = countdownSeconds;
            @Override
            public void run() {
                int minutes = remainingSeconds / 60;
                int seconds = remainingSeconds % 60;
                String timeString = String.format("Tempo rimanente: %02d:%02d", minutes, seconds);
                SwingUtilities.invokeLater(() -> {
                    countdownLabel.setText(timeString);
                });
                remainingSeconds--;
                if (remainingSeconds < 0) {
                    SwingUtilities.invokeLater(() -> {
                        countdownLabel.setText("Tempo scaduto!");
                    });
                    timer.cancel();
                }
            }

        }, 0, 1000); // Avvia il nuovo timer con un ritardo di 0

        String lettere = "";
        Random rand = new Random();
        for (int i = 0; i < bottoniGriglia.length; i++) {
            //Genera un numero casuale compreso tra 0 e 25, corrispondenti alle lettere minuscole dell'alfabeto
            int numeroCasuale = rand.nextInt(26);
            //Converte il numero casuale in una lettera dell'alfabeto e la aggiunge alla stringa
            char lettera = (char) (numeroCasuale + 'a');
            lettere += lettera;
            //Aggiunge la lettera al testo del bottone corrispondente
            bottoniGriglia[i].setText(Character.toString(lettera));
        }


        }

        public void nometext(){

        }
    }



/*

 */
