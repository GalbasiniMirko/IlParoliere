package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;


public class FrameGioco extends JFrame implements ActionListener {
    ImageIcon iconFrame = new ImageIcon("LogoProgettoGPO.png");
    JPanel panelalto;
    JPanel panelcentro;
    JPanel panelbasso;
    JButton bottone1;
    JButton bottone2;
    JButton bottone3;
    JButton bottone4;
    JButton bottone5;
    JButton bottone6;
    JButton btnrefresh;
    Timer timer;
    JLabel countdownLabel;
    int countdownSeconds;
    public FrameGioco(){
        this.setTitle("Il Paroliere");
        this.setIconImage(iconFrame.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //il frame si chiuderà con il tasto in alto a destra
        this.setLayout(new BorderLayout(0,0));
        this.setBounds(250, 50, 1000, 700);

        //ELEMENTI CONTENUTI NEL PANEL DI GIOCO
       JPanel panelalto = new JPanel();
       panelalto.setBackground(new Color(125, 125, 125));
       panelalto.setPreferredSize(new Dimension(100, 120));


       countdownLabel = new JLabel();
       countdownLabel.setHorizontalAlignment(SwingConstants.CENTER);
       countdownLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
       add(countdownLabel, BorderLayout.CENTER);

        int countdownSeconds = 65;
        Timer timer = new Timer();
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


       panelalto.add(countdownLabel);
       JPanel panelcentro = new JPanel();
       panelcentro.setBackground(new Color(216, 112, 124));
       panelcentro.setPreferredSize(new Dimension(100, 100));
       panelcentro.setLayout(new GridLayout(3,3,10,10));

       bottone1 = new JButton();
       bottone1.setText("lettera 1");
       bottone1.setFont(new Font("Comic Sans", Font.BOLD, 15));
       bottone1.setSize(150,50);

       bottone2 = new JButton();
       bottone2.setText("lettera 2");
       bottone2.setFont(new Font("Comic Sans", Font.BOLD, 15));
       bottone2.setSize(150,50);

       bottone3 = new JButton();
       bottone3.setText("lettera 3");
       bottone3.setFont(new Font("Comic Sans", Font.BOLD, 15));
       bottone3.setSize(150,50);

       bottone4 = new JButton();
       bottone4.setText("lettera 4");
       bottone4.setFont(new Font("Comic Sans", Font.BOLD, 15));
       bottone4.setSize(150,50);

       bottone5 = new JButton();
       bottone5.setText("lettera 5");
       bottone5.setFont(new Font("Comic Sans", Font.BOLD, 15));
       bottone5.setSize(150,50);

       bottone6 = new JButton();
       bottone6.setText("lettera 6");
       bottone6.setFont(new Font("Comic Sans", Font.BOLD, 15));
       bottone6.setSize(150,50);

       panelcentro.add(bottone1);
       panelcentro.add(bottone2);
       panelcentro.add(bottone3);
       panelcentro.add(bottone4);
       panelcentro.add(bottone5);
       panelcentro.add(bottone6);


       JPanel panelbasso = new JPanel();
       panelbasso.setBackground(new Color(253, 168, 90));
       panelbasso.setPreferredSize(new Dimension(100, 150));

       btnrefresh= new JButton();
       btnrefresh.setText("REFRESH");
       btnrefresh.setFont(new Font("Comic Sans", Font.BOLD, 15));
       btnrefresh.setBounds(640, 550, 150, 50);


       panelbasso.add(btnrefresh);

        this.add(panelalto, BorderLayout.NORTH);
        this.add(panelcentro, BorderLayout.CENTER);
        this.add(panelbasso, BorderLayout.SOUTH);
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== btnrefresh){
            timer.cancel();
            countdownSeconds = 60;
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
        }
    }
}
