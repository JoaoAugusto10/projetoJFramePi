package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollPaneUI;

import view.components.*;

public class CriarEnquete extends JFrame implements ActionListener {

    private JScrollPane scrollPanel;
    private JPanel panel;
    private JLabel titulo;
    private JLabel descricao;
    private JLabel opcResposta;
    private JLabel frase;
    private JTextField txtTitulo;
    private JTextField txtDescricao;
    private JTextField txtOpcResposta;
    private JTextField txtOpcResposta2;
    private JTextField txtOpcResposta3;
    private JTextField txtOpcResposta4;
    private JTextField txtOpcResposta5;
    private JButton btnCria;
    private JLabel imagemLabel; // Declaração do JLabel para a imagem
    private JButton botaoFechar;

    public CriarEnquete() {
        setTitle("Criar Enquete"); // Titulo da janela
        setSize(1000, 625); // tamanho da janela
        setLayout(null); // anula o layout padrão
        setResizable(false);
        setUndecorated(true);
        int alt = 40;
        getContentPane().setBackground(new Color(0xDBCDC2));

        panel = new RoundedPanel(50);
        panel.setLayout(null);
        panel.setBackground(new Color(0xB6AAA1)); // Cor de fundo mais escura para o painel
        panel.setBounds(50, 100, 900, 700); // Posição e tamanho do painel
        panel.setBorder(BorderFactory.createEmptyBorder());
        // Painel
        scrollPanel = new JScrollPane(panel);
        scrollPanel.setBounds(panel.getLocation().x, panel.getLocation().y, panel.getWidth(), panel.getHeight() - 240);
        scrollPanel.setBorder(BorderFactory.createEmptyBorder());
        scrollPanel.getViewport().setBackground(getContentPane().getBackground());
        scrollPanel.getVerticalScrollBar()
                .setUI(new CustomScrollBarUI(new Color(0x877D75), getContentPane().getBackground()));

        // JPanel panel = new RoundedPanel(50);// 50 é o raio das bordas arredondadas
        panel.setPreferredSize(new Dimension(panel.getWidth() - 20, panel.getHeight() - 80));

        JLabel frase1 = new JLabel("Crie enquetes ou explore outras ja criadas!");
        frase1.setBounds(160, 60, 5000, 30); // Ajuste a posição e o tamanho conforme necessário
        frase1.setForeground(new Color(0x5B5B5B)); // Cor da fonte
        frase1.setFont(new Font("Kantumruy Pro", Font.BOLD, 16)); // Estilo da fonte

        JLabel frase2 = new JLabel("PollForms");
        frase2.setBounds(150, 30, 5000, 30); // Ajuste a posição e o tamanho conforme necessário
        frase2.setForeground(Color.BLACK); // Cor da fonte
        frase2.setFont(new Font("Kantumruy Pro", Font.BOLD, 24)); // Estilo da fonte

        // Carrega a imagem
        ImageIcon imagem = new ImageIcon(getClass().getResource("/img/logo.png")); // Caminho para a
        // imagem
        imagemLabel = new JLabel(imagem); // Cria um JLabel com a imagem
        imagemLabel.setBounds(50, 10, 100, 100); // Ajuste a posição e o tamanho da imagem

        // Adiciona o JLabel da imagem ao JFrame
        // Cadastro
        titulo = criarJLabel("Titulo", 30, 50, 270, alt);
        titulo.setForeground(Color.BLACK);
        txtTitulo = criarTextField(30, 90, 810, alt);
        JPanel panelTItulo = criarInput(txtTitulo);

        descricao = criarJLabel("Descrição", 30, 130, 270, alt);
        descricao.setForeground(Color.BLACK);
        txtDescricao = criarTextField(30, 170, 810, alt);
        JPanel panelDescricao = criarInput(txtDescricao);

        opcResposta = criarJLabel("Opções de Resposta", 30, 210, 270, alt);
        opcResposta.setForeground(Color.BLACK);

        int rodape = getHeight() - 80;
        int distEsq = getWidth() / 2;
        int larg = 150;

        txtOpcResposta = criarTextField(30, 250, 810, alt);
        JPanel panelOpcao = criarInput(txtOpcResposta);

        txtOpcResposta2 = criarTextField(30, 300, 810, alt);
        JPanel panelOpcao2 = criarInput(txtOpcResposta2);

        txtOpcResposta3 = criarTextField(30, 350, 810, alt);
        JPanel panelOpcao3 = criarInput(txtOpcResposta3);

        txtOpcResposta4 = criarTextField(30, 400, 810, alt);
        JPanel panelOpcao4 = criarInput(txtOpcResposta4);

        txtOpcResposta5 = criarTextField(30, 450, 810, alt);
        JPanel panelOpcao5 = criarInput(txtOpcResposta5);

        btnCria = criarBotao("Criar Enquete", 'C', 30, 510, 830, alt, 15);
        btnCria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
        
        
        botaoFechar = criarBotao("X", 'x', getWidth() - 50, 0, 50, alt, 25);
        botaoFechar.setBackground(getContentPane().getBackground());
        botaoFechar.setFont(new Font("Kantumruy Pro", Font.PLAIN, 20));
        botaoFechar.setMnemonic(0);

        botaoFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        // Adiciona os componentes diretamente ao painel
        add(scrollPanel); // Adiciona o painel ao JFrame
        add(frase1); // Adicionando o JLabel ao JFrame
        add(frase2); // Adicionando o JLabel ao JFrame
        add(imagemLabel);
        add(botaoFechar);
        
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(titulo);
        panel.add(panelTItulo);
        panel.add(descricao);
        panel.add(panelDescricao);
        panel.add(opcResposta);
        panel.add(panelOpcao);
        panel.add(panelOpcao2);
        panel.add(panelOpcao3);
        panel.add(panelOpcao4);
        panel.add(panelOpcao5);
        panel.add(btnCria);
        setLocationRelativeTo(null);
        setVisible(true); // Exibindo a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JButton criarBotao(String string, char c, int desq, int dtopo, int larg, int alt, int radius) {
        JButton b1 = new RoundedButton(string, radius, larg, alt);
        b1.setBounds(desq, dtopo, larg, alt);
        b1.setBackground(new Color(0x40BDF2));
        b1.setForeground(Color.YELLOW);
        b1.setFont(new Font("Kantumruy Pro", Font.BOLD, 16));
        b1.setToolTipText("Botão " + string);
        b1.setForeground(Color.BLACK);
        b1.setHorizontalAlignment(0);
        b1.setVerticalAlignment(0);
        b1.setMnemonic(c); // Tecla de atalho
        b1.addActionListener(this);
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
    private JTextField criarTextField(int desq, int dtopo, int larg, int alt) {
        JTextField jt = new RoundedJTextField(10);
        jt.setBounds(desq, dtopo, larg, alt);
        jt.setForeground(Color.black);
        jt.setBackground(new Color(0x877D75));
        jt.setBorder(BorderFactory.createEmptyBorder());
        jt.setFont(new Font("Kantumruy Pro", Font.PLAIN, 16));
        jt.setCursor(new Cursor(TEXT_CURSOR));
        jt.setAlignmentY(LEFT_ALIGNMENT);
        return jt;
    }

    private JPanel criarInput(JTextField txt) {
        JPanel panelOpca = new RoundedPanel(10);
        panelOpca.setSize(txt.getWidth() + 30, txt.getHeight());
        panelOpca.setBackground(txt.getBackground());
        panelOpca.setBorder(BorderFactory.createEmptyBorder());
        panelOpca.setLocation(txt.getLocation().x, txt.getLocation().y);
        panelOpca.setLayout(null);
        panelOpca.setOpaque(false);
        txt.setLocation(10, 0);
        panelOpca.add(txt);

        return panelOpca;
    }

    private JLabel criarJLabel(String string, int desq, int dtopo, int larg, int alt) {
        JLabel jl = new JLabel(string);
        jl.setBounds(desq, dtopo, larg, alt);
        jl.setForeground(new Color(110, 182, 145)); // Cor da fonte
        jl.setFont(new Font("Kantumruy Pro", Font.BOLD, 16));
        return jl;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCria) {
            System.exit(0);
        }
    }
    
    private int centralizarComponente(Component c) {
        int width = c.getWidth();
        int widthTela = getWidth();

        return ((widthTela - width) / 2);
    }

    	
    public static void main(String[] args) {
		new CriarEnquete();
	}
}
