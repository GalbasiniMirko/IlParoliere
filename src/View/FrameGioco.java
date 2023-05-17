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
    int dGriglia;

    JLabel labelTitolo;
    JLabel countdownLabel;
    Timer timer;
    int countdownSeconds;
    JPanel panelGriglia;
    RoundedButton[][] bottoniGriglia;
    JLabel labelParola;
    JTextField inputUtente;
    JButton btnCercaParola;
    JButton btnRefresh;
    JButton btnTerminaPartita;
    JPanel panelCentro;

    public FrameGioco(int dimGriglia){
        this.setTitle("IL PAROLIERE");
        this.setIconImage(iconFrame.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //il frame si chiuderà con il tasto in alto a destra
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(216, 112, 124));
        d = getToolkit().getScreenSize();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);

        dGriglia = dimGriglia;

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
        //panelGriglia.setBackground(new Color(216, 112, 124));
        panelGriglia.setBackground(new Color(255, 255, 255));
        panelGriglia.setSize(600, 400);
        panelGriglia.setLocation(50, 240);
        panelGriglia.setLayout(new GridLayout(dimGriglia,dimGriglia,5,5));

        char[][] matriceLettere = new char[dimGriglia][dimGriglia];
        Random random = new Random();
        for (int i=0; i<dimGriglia; i++) {
            for (int j=0; j<dimGriglia; j++) {
                matriceLettere[i][j] = (char) (random.nextInt(26) + 'a');
            }
        }

        bottoniGriglia = new RoundedButton[dimGriglia][dimGriglia];
        for(int i=0; i<dimGriglia; i++){
            for (int j=0; j<dimGriglia; j++){
                bottoniGriglia[i][j] = new RoundedButton(String.valueOf(matriceLettere[i][j]));
                bottoniGriglia[i][j].setFont(new Font("Comic Sans", Font.BOLD, 30));
                if(dimGriglia == 7){
                    bottoniGriglia[i][j].setSize(77,48);
                }else if(dimGriglia == 6){
                    bottoniGriglia[i][j].setSize(90,56);
                }else if(dimGriglia == 5){
                    bottoniGriglia[i][j].setSize(108,68);
                }
                bottoniGriglia[i][j].addActionListener(this);
                bottoniGriglia[i][j].setForeground(Color.black);
                bottoniGriglia[i][j].setBackground(Color.lightGray);
                bottoniGriglia[i][j].setBorder(null);
                panelGriglia.add(bottoniGriglia[i][j]);
            }
        }
        panelGriglia.setVisible(true);

        btnRefresh = new JButton();
        btnRefresh.setSize(150, 50);
        btnRefresh.setLocation(275, 700);
        btnRefresh.addActionListener(this);
        btnRefresh.setText("Refresh");
        btnRefresh.setFocusable(false);
        btnRefresh.setVerticalTextPosition(JButton.CENTER);
        btnRefresh.setHorizontalTextPosition(JButton.CENTER);
        btnRefresh.setFont(new Font("Comic Sans", Font.BOLD, 25));
        btnRefresh.setForeground(Color.black);
        btnRefresh.setBackground(Color.lightGray);
        btnRefresh.setVisible(true);

        panelCentro = new JPanel();
        //panelCentro.setBackground(new Color(216, 112, 124));
        panelCentro.setBackground(new Color(255, 255, 255));
        panelCentro.setSize(350, 510);
        panelCentro.setLocation(750, 240);
        panelCentro.setLayout(null);

        labelParola = new JLabel();
        labelParola.setSize(310, 50);
        posizionaJLabel(panelCentro, labelParola, 140);
        labelParola.setBackground(new Color(255, 255, 255));
        labelParola.setText("Inserisci la parola trovata: ");
        labelParola.setForeground(new Color(0, 0, 0));
        labelParola.setFont(new Font("Comic Sans", Font.BOLD, 25));
        labelParola.setVerticalAlignment(JLabel.CENTER);

        inputUtente = new JTextField();
        inputUtente.setSize(200 , 30);
        posizionaJTextField(panelCentro, inputUtente, 190);
        inputUtente.setPreferredSize(new Dimension(250, 40));
        inputUtente.setFont(new Font("Comic Sans", Font.BOLD, 25));
        inputUtente.setForeground(new Color(0, 0, 0));
        inputUtente.setBackground(new Color(255, 255, 255));

        btnCercaParola = new JButton();
        btnCercaParola.setSize(105, 50);
        posizioneJButton(panelCentro, btnCercaParola, 230);
        btnCercaParola.addActionListener(this);
        btnCercaParola.setText("Cerca");
        btnCercaParola.setFocusable(false);
        btnCercaParola.setVerticalTextPosition(JButton.CENTER);
        btnCercaParola.setHorizontalTextPosition(JButton.CENTER);
        btnCercaParola.setFont(new Font("Comic Sans", Font.BOLD, 25));
        btnCercaParola.setForeground(Color.black);
        btnCercaParola.setBackground(Color.lightGray);
        btnCercaParola.setVisible(true);

        btnTerminaPartita = new JButton();
        btnTerminaPartita.setSize(215, 50);
        posizioneJButton(panelCentro, btnTerminaPartita, 460);
        btnTerminaPartita.addActionListener(this);
        btnTerminaPartita.setText("Termina partita");
        btnTerminaPartita.setFocusable(false);
        btnTerminaPartita.setVerticalTextPosition(JButton.CENTER);
        btnTerminaPartita.setHorizontalTextPosition(JButton.CENTER);
        btnTerminaPartita.setFont(new Font("Comic Sans", Font.BOLD, 25));
        btnTerminaPartita.setForeground(Color.black);
        btnTerminaPartita.setBackground(Color.lightGray);
        btnTerminaPartita.setVisible(true);

        panelCentro.add(labelParola);
        panelCentro.add(inputUtente);
        panelCentro.add(btnCercaParola);
        panelCentro.add(btnTerminaPartita);
        panelCentro.setVisible(true);

        this.add(labelTitolo);
        this.add(countdownLabel);
        this.add(panelGriglia);
        this.add(btnRefresh);
        this.add(panelCentro);
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
            FrameGioco frameGioco = new FrameGioco(dGriglia);
            this.dispose();
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
}
