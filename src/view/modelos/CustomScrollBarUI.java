/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.modelos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author 1
 */
public class CustomScrollBarUI extends BasicScrollBarUI{
    private Color corPolegar; 
    private Color corTrilha;

    public CustomScrollBarUI(Color CorPolegar, Color CorTrilha) {
        this.corPolegar = CorPolegar;
        this.corTrilha = CorTrilha;
    }
    
    @Override
    protected void configureScrollBarColors() {
        thumbColor = corPolegar;
        trackColor = corTrilha;
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(corPolegar);
        g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 10, 10); // Arredondamento
        g2.dispose();
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        // Desenha a trilha da barra de rolagem
        g.setColor(corTrilha);
        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        // Cria um botão de rolagem sem visualização
        return criarBotaoVazio();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        // Cria um botão de rolagem sem visualização
        return criarBotaoVazio();
    }

    private JButton criarBotaoVazio() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0, 0));
        button.setMinimumSize(new Dimension(0, 0));
        button.setMaximumSize(new Dimension(0, 0));
        return button;
    }
}

