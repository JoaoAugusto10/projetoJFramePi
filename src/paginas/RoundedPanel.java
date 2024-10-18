package paginas;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.RoundRectangle2D;

class RoundedPanel extends JPanel {
    private int radius;

    public RoundedPanel(int radius) {
        this.radius = radius;
        setOpaque(false); // Permite que o fundo arredondado apareça corretamente
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground()); // Usa a cor de fundo definida para o painel
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), radius, radius)); // Desenha o retângulo com bordas arredondadas
    }
}
