package View;

import java.awt.*;
import javax.swing.*;

public class ShadowedLabel extends JLabel {
    private Color shadowColor;
    private Point shadowOffset;

    public ShadowedLabel(String text) {
        super(text);
        shadowColor = Color.GRAY;
        shadowOffset = new Point(2, 2);
    }

    public void setShadowColor(Color color) {
        shadowColor = color;
        repaint();
    }

    public void setShadowOffset(Point offset) {
        shadowOffset = offset;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        //Disegna l'ombra
        g2d.setColor(shadowColor);
        FontMetrics metrics = g2d.getFontMetrics(getFont());
        int textWidth = metrics.stringWidth(getText());
        int textHeight = metrics.getHeight();
        int x = (getWidth() - textWidth) / 2 + shadowOffset.x;
        int y = (getHeight() + textHeight) / 2 + shadowOffset.y;
        g2d.drawString(getText(), x, y);

        //Disegna il testo principale
        g2d.setColor(getForeground());
        x = (getWidth() - textWidth) / 2;
        y = (getHeight() + textHeight) / 2;
        g2d.drawString(getText(), x, y);

        g2d.dispose();
    }
}