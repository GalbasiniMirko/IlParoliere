package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameGioco extends JFrame implements ActionListener {
    ImageIcon iconFrame = new ImageIcon("LogoProgettoGPO.png");
    JPanel panelalto;
    JPanel panelcentro;
    JPanel panelbasso;
    JLabel titolo;
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
       JLabel titolo = new JLabel();
       titolo.setText("hai ancora :");
       titolo.setFont(new Font("Comic Sans", Font.BOLD, 25));
       panelalto.add(titolo);

       JPanel panelcentro = new JPanel();
       panelcentro.setBackground(new Color(216, 112, 124));
       panelcentro.setPreferredSize(new Dimension(100, 100));

       JPanel panelbasso = new JPanel();
       panelbasso.setBackground(new Color(253, 168, 90));
       panelbasso.setPreferredSize(new Dimension(100, 150));


        this.add(panelalto, BorderLayout.NORTH);
        this.add(panelcentro, BorderLayout.CENTER);
        this.add(panelbasso, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
