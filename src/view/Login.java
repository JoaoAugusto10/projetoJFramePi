package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import view.components.*;
import view.lookandfeel.DefaultLookAndFeel;

public class Login extends JFrame {

    private JLabel titulo;
    private JLabel subTitulo;
    private JTextField txtEmail;
    private JPasswordField txtSenha;
    private JButton botaoLogin;
    private JLabel direcionadorCadastro;
    private JButton botaoFechar;
    
    public Login() {
        int alt = 40;
        setSize(460, 625);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0xDBCDC2));
        setLayout(null);
        setResizable(false);
        setUndecorated(true);
        
        titulo = criarJLabel("Bem-vindo", 50, 220, alt);
        titulo.setForeground(new Color(0x4E4741));
        titulo.setFont(new Font("Kantumruy Pro", Font.BOLD, 42));

        subTitulo = criarJLabel("FAÇA LOGIN", 90, 100, alt);
        subTitulo.setForeground(new Color(0x877D75));

        txtEmail = criarTextField(170, 250, alt + 10);
        JPanel panelEmail = criarInput(txtEmail);
        txtEmail.setText("Email ou Usuário");

        txtEmail.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                if (txtEmail.getText().trim().equals("")) {
                    Font f = new Font("Kantumruy Pro", Font.ITALIC, 16);
                    txtEmail.setText("Email ou Usuário");
                    txtEmail.setForeground(new Color(0x877D75));
                    txtEmail.setFont(f);
                }

            }

            @Override
            public void focusGained(FocusEvent e) {
                if (txtEmail.getText().equals("Email ou Usuário")) {
                    Font f = new Font("Kantumruy Pro", Font.PLAIN, 16);
                    txtEmail.setText("");
                    txtEmail.setForeground(new Color(0x4E4741));
                    txtEmail.setFont(f);
                }

            }
        });

        txtSenha = criarPasswordField(250, 250, alt + 10);
        JPanel panelSenha = criarInput(txtSenha);
        txtSenha.setText("Senha");
        txtSenha.setEchoChar((char) 0);

        txtSenha.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                if (txtSenha.getText().trim().equals("")) {
                    txtSenha.setEchoChar((char) 0);
                    Font f = new Font("Kantumruy Pro", Font.ITALIC, 16);
                    txtSenha.setText("Senha");
                    txtSenha.setForeground(new Color(0x877D75));
                    txtSenha.setFont(f);

                }

            }

            @Override
            public void focusGained(FocusEvent e) {
                if (txtSenha.getText().equals("Senha")) {
                    Font f = new Font("Kantumruy Pro", Font.PLAIN, 16);
                    txtSenha.setText("");
                    txtSenha.setForeground(new Color(0x4E4741));
                    txtSenha.setFont(f);
                    txtSenha.setEchoChar('•');
                }

            }
        });

        botaoLogin = criarBotao("Login", 'L', 360, 270, alt + 5);
        botaoLogin.addActionListener(new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu();
                dispose();
            }
        });

        direcionadorCadastro = criarJLabel("Não possui login? Faça cadastro.", 530, 200, alt);
        direcionadorCadastro.setForeground(new Color(0x877D75));
        direcionadorCadastro.setFont(new Font("Kantumruy Pro", Font.PLAIN, 13));
        direcionadorCadastro.setCursor(new Cursor(HAND_CURSOR));

        direcionadorCadastro.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                direcionadorCadastro.setForeground(new Color(0x877D75));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                direcionadorCadastro.setForeground(new Color(0x4E4741));

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                new Cadastro();
                dispose();

            }
        });
        
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
        

        // adicionando componentes
        getContentPane().add(titulo);
        getContentPane().add(subTitulo);
        getContentPane().add(panelEmail);
        getContentPane().add(panelSenha);
        getContentPane().add(botaoLogin);
        getContentPane().add(direcionadorCadastro);
        getContentPane().add(botaoFechar);

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

    private JButton criarBotao(String string, char c, int dTopo, int larg, int alt) {
        JButton b1 = new RoundedButton(string, 25, larg, alt);
        b1.setSize(larg, alt);
        b1.setLocation(centralizarComponente(b1), dTopo);
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

    private JPanel criarInput(JTextField txt) {
        JPanel panelOpca = new RoundedPanel(25);
        panelOpca.setSize(txt.getWidth() + 30, txt.getHeight());
        panelOpca.setBackground(txt.getBackground());
        panelOpca.setBorder(BorderFactory.createEmptyBorder());
        panelOpca.setLocation(centralizarComponente(panelOpca), txt.getLocation().y);
        panelOpca.setLayout(null);
        panelOpca.setOpaque(false);
        txt.setLocation(10, 0);
        panelOpca.add(txt);

        return panelOpca;
    }

    private JTextField criarTextField(int dtopo, int larg, int alt) {
        JTextField jt = new RoundedJTextField(25);
        jt.setSize(larg, alt);
        jt.setLocation(new Point(centralizarComponente(jt), dtopo));
        jt.setForeground(new Color(0x877D75));
        jt.setBackground(new Color(0xE9E9E9));
        jt.setBorder(BorderFactory.createEmptyBorder());
        jt.setFont(new Font("Kantumruy Pro", Font.ITALIC, 16));
        jt.setCursor(new Cursor(TEXT_CURSOR));
        jt.setAlignmentY(LEFT_ALIGNMENT);
        return jt;
    }

    private JTextField criarTextField(int dEsq, int dTopo, int larg, int alt) {
        JTextField jt = new RoundedJTextField(25);
        jt.setBounds(dEsq, dTopo, larg, alt);
        jt.setForeground(new Color(0x877D75));
        jt.setBackground(new Color(0xE9E9E9));
        jt.setBorder(BorderFactory.createEmptyBorder());
        jt.setFont(new Font("Kantumruy Pro", Font.ITALIC, 16));
        jt.setCursor(new Cursor(TEXT_CURSOR));
        jt.setAlignmentY(LEFT_ALIGNMENT);
        return jt;
    }

    private JPasswordField criarPasswordField(int dtopo, int larg, int alt) {
        JPasswordField jt = new JPasswordField();
        jt.setSize(larg, alt);
        jt.setLocation(new Point(centralizarComponente(jt), dtopo));
        jt.setForeground(new Color(0x877D75));
        jt.setBackground(new Color(0xE9E9E9));
        jt.setBorder(BorderFactory.createEmptyBorder());
        jt.setFont(new Font("Kantumruy Pro", Font.ITALIC, 16));
        jt.setCursor(new Cursor(TEXT_CURSOR));
        jt.setAlignmentY(LEFT_ALIGNMENT);
        return jt;
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
        new Login();
    }
}
