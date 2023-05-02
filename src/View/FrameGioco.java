package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameGioco extends JFrame implements ActionListener {
    ImageIcon iconFrame = new ImageIcon("LogoProgettoGPO.png");
    JPanel panelGioco;

    public FrameGioco(){
        this.setTitle("Il Paroliere");
        this.setIconImage(iconFrame.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //il frame si chiuderà con il tasto in alto a destra
        this.setLayout(new BorderLayout(0, 0));
        this.setBounds(250, 50, 1000, 700);

        //ELEMENTI CONTENUTI NEL PANEL DI GIOCO
        panelGioco = new JPanel();
        panelGioco.setBackground(new Color(216, 112, 124));
        panelGioco.setPreferredSize(new Dimension(1000, 700));
        panelGioco.setLayout(null);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
