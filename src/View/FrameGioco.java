package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    JButton bottone1;
    JButton bottone2;
    JButton bottone3;
    JButton bottone4;
    JButton bottone5;
    JButton bottone6;
    JButton bottone7;
    JButton bottone8;
    JButton bottone9;
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

        countdownSeconds = 65;   //TEMPO DA DECIDERE
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
        bottone1 = new JButton();
        bottone1.setText("lettera 1");
        bottone1.setFont(new Font("Comic Sans", Font.BOLD, 15));
        bottone1.setSize(150,50);
        bottone1.addActionListener(this);
        bottone1.setForeground(Color.black);
        bottone1.setBackground(Color.lightGray);

        bottone2 = new JButton();
        bottone2.setText("lettera 2");
        bottone2.setFont(new Font("Comic Sans", Font.BOLD, 15));
        bottone2.setSize(150,50);
        bottone2.addActionListener(this);
        bottone2.setForeground(Color.black);
        bottone2.setBackground(Color.lightGray);

        bottone3 = new JButton();
        bottone3.setText("lettera 3");
        bottone3.setFont(new Font("Comic Sans", Font.BOLD, 15));
        bottone3.setSize(150,50);
        bottone3.addActionListener(this);
        bottone3.setForeground(Color.black);
        bottone3.setBackground(Color.lightGray);

        bottone4 = new JButton();
        bottone4.setText("lettera 4");
        bottone4.setFont(new Font("Comic Sans", Font.BOLD, 15));
        bottone4.setSize(150,50);
        bottone4.addActionListener(this);
        bottone4.setForeground(Color.black);
        bottone4.setBackground(Color.lightGray);

        bottone5 = new JButton();
        bottone5.setText("lettera 5");
        bottone5.setFont(new Font("Comic Sans", Font.BOLD, 15));
        bottone5.setSize(150,50);
        bottone5.addActionListener(this);
        bottone5.setForeground(Color.black);
        bottone5.setBackground(Color.lightGray);

        bottone6 = new JButton();
        bottone6.setText("lettera 6");
        bottone6.setFont(new Font("Comic Sans", Font.BOLD, 15));
        bottone6.setSize(150,50);
        bottone6.addActionListener(this);
        bottone6.setForeground(Color.black);
        bottone6.setBackground(Color.lightGray);

        bottone7 = new JButton();
        bottone7.setText("lettera 7");
        bottone7.setFont(new Font("Comic Sans", Font.BOLD, 15));
        bottone7.setSize(150,50);
        bottone7.addActionListener(this);
        bottone7.setForeground(Color.black);
        bottone7.setBackground(Color.lightGray);

        bottone8 = new JButton();
        bottone8.setText("lettera 8");
        bottone8.setFont(new Font("Comic Sans", Font.BOLD, 15));
        bottone8.setSize(150,50);
        bottone8.addActionListener(this);
        bottone8.setForeground(Color.black);
        bottone8.setBackground(Color.lightGray);

        bottone9 = new JButton();
        bottone9.setText("lettera 9");
        bottone9.setFont(new Font("Comic Sans", Font.BOLD, 15));
        bottone9.setSize(150,50);
        bottone9.addActionListener(this);
        bottone9.setForeground(Color.black);
        bottone9.setBackground(Color.lightGray);

        panelGriglia = new JPanel();
        panelGriglia.setBackground(new Color(216, 112, 124));
        //panelGriglia.setBackground(new Color(255, 255, 255));
        panelGriglia.setSize(700, 500);
        panelGriglia.setLocation(50, 240);
        panelGriglia.setLayout(new GridLayout(3,3,10,10));
        panelGriglia.add(bottone1);
        panelGriglia.add(bottone2);
        panelGriglia.add(bottone3);
        panelGriglia.add(bottone4);
        panelGriglia.add(bottone5);
        panelGriglia.add(bottone6);
        panelGriglia.add(bottone7);
        panelGriglia.add(bottone8);
        panelGriglia.add(bottone9);
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
        if(e.getSource() == btnTerminaPartita) {
            //if() {   //controllo per vedere se il tempo è maggiore di 0
                int scelta = JOptionPane.showConfirmDialog (null, "Sei sicuro di voler terminare la partita?",
                        "Termina Partita", JOptionPane.YES_NO_OPTION);

                if(scelta == JOptionPane.YES_OPTION){
                    this.dispose();
                    PrimaPagina primaPagina = new PrimaPagina();
                }
            //}
        }else if(e.getSource() == btnRefresh) {

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
    private void refreshbaby(JPanel griglia, Timer timer){

    }
}

/*

 */
