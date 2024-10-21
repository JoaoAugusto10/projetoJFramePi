package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

import javax.swing.JButton;

import org.w3c.dom.events.MouseEvent;

public class RoundedButton extends JButton  {
	private int radius;
	private int baseWidth;
	private int baseHeight;
	private int targetWidth;
	private int targetHeight;
	private Timer animationTimer;

	
	public RoundedButton(String text, int radius, int baseWidth, int baseHeight ) {
		super(text);
		this.radius = radius;
		this.baseWidth = getWidth();
		this.baseHeight = getHeight();
		setSize(baseWidth, baseHeight);

		setContentAreaFilled(false);
		setCursor(getCursor());
		setFocusPainted(false);
		
		
		targetWidth = baseWidth;
        targetHeight = baseHeight;

     
        animationTimer = new Timer(20, e -> animateButton());

        this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				targetWidth = baseWidth;
                targetHeight = baseHeight;
         
                animationTimer.start();
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				targetWidth = baseWidth + 10;
                targetHeight = baseHeight + 8;
       
                animationTimer.start();
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(getBackground());
		g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radius, radius));
		super.paintComponent(g2);
		g2.dispose();
	}

	@Override
	protected void paintBorder(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(0,0,0,0));
		g2.draw(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, radius, radius)); // Borda arredondada
		g2.dispose();
	}
	
	private void animateButton() {
        Dimension tamanho = getSize();
        int width = tamanho.width;
        int height = tamanho.height;
        Point location = getLocation();
       
        if (width != targetWidth || height != targetHeight) {
            int newWidth = (int) (width + (targetWidth - width) * 0.2);
            int newHeight = (int) (height + (targetHeight - height) * 0.2);
            
            int newX = (int) (location.x - ((newWidth - width) / 2));
            int newY = (int) (location.y - ((newHeight - height) / 2));
            
            setBounds(newX, newY, newWidth, newHeight);

            revalidate();
            repaint();
        } else {
            animationTimer.stop();
        }
    }

}
