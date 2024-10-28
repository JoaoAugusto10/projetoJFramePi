
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.components.RoundedButton;

public class Menu extends JFrame {
    private JLabel logo;
    private JLabel titulo;
    private JLabel subTitulo;
    private JButton botaoTroca;
    private JPanel barraBotaoTroca;
    private JButton botaoFechar;
    
    //painel enquete criada
    private JPanel panelEnquetesCriadas;
    private JLabel tituloEnquetesCriadas;
    
    //painel enquetes participadas
    private JPanel panelEnquetesParticipadas;
    private JLabel tituloEnquetesParticipadas;
    
    public Menu(){
        setTitle("Criar Enquete");
        setSize(1000, 625);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setUndecorated(true);
        int alt = 40;
        
        getContentPane().setBackground(new Color(0xDBCDC2));
        
        logo = criarJLabel("", 50, 50, 90, alt);
        logo.setIcon(new ImageIcon().getClass().getResource("/img/logo.png"));
        
        botaoFechar = criarBotao("X", 'x', getWidth() - 50, 0, 50, alt);
        botaoFechar.setBackground(getContentPane().getBackground());
        botaoFechar.setFont(new Font("Kantumruy Pro", Font.PLAIN, 20));
        botaoFechar.setMnemonic(0);
        
        botaoFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        //adicionar componentes
        add(botaoFechar);
        add(logo);
        setVisible(true);
    }
    
    private JButton criarBotao(String string, char c, int dEsq, int dTopo, int larg, int alt) {
        JButton b1 = new RoundedButton(string, 25, larg, alt);
        b1.setSize(larg, alt);
        b1.setLocation(dEsq, dTopo);
        b1.setBackground(new Color(0x40BDF2));
        b1.setFont(new Font("Kantumruy Pro", Font.BOLD, 16));
        b1.setToolTipText("Botão " + string);
        b1.setForeground(new Color(0x4E4741));
        b1.setHorizontalAlignment(0);
        b1.setVerticalAlignment(0);
        b1.setMnemonic(c); // Tecla de atalho
        b1.setCursor(new Cursor(HAND_CURSOR));
        return b1;
    }
    private JLabel criarJLabel(String string, int dTopo, int larg, int alt) {
        JLabel jl = new JLabel(string);
        jl.setSize(larg, alt);
        jl.setLocation(new Point(centralizarComponente(jl), dTopo));
        jl.setFont(new Font("Kantumruy Pro", Font.BOLD, 16));
        return jl;
    }
    
    private JLabel criarJLabel(String string, int dEsq, int dTopo, int larg, int alt) {
        JLabel jl = criarJLabel(string, dTopo, larg, alt);
        jl.setLocation(dEsq, dTopo);
        return jl;
    }
    
    private int centralizarComponente(Component c) {
        int width = c.getWidth();
        int widthTela = getWidth();

        return ((widthTela - width) / 2);
    }
    
    public static void main(String[] args) {
        new Menu();
    }
}
