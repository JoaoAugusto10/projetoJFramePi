package view;

import javax.swing.*;

import view.modelos.RoundedPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    JButton btn1, btn2, btn3, btn4, btn5, btn6;
    JLabel imagemLabel; // Declaração do JLabel para a imagem

    public Menu() {
        setTitle("Menu"); // Titulo da janela
        setSize(1000, 700); // Tamanho da janela
        setLayout(null); // Anula o layout padrão
        getContentPane().setBackground(new Color(0xDBCDC2)); // Cor de fundo

        // Painel
        RoundedPanel panel = new RoundedPanel(50); // 50 é o raio das bordas arredondadas
        panel.setLayout(null);
        panel.setBackground(new Color(150, 150, 150)); // Cor de fundo mais escura para o painel
        panel.setBounds(50, 100, 900, 600); // Posição e tamanho do painel
        add(panel); // Adiciona o painel ao JFrame
        JLabel frase1 = new JLabel("Crie enquetes ou explore outras ja criadas!");
        frase1.setBounds(150, 50, 5000, 30); // Ajuste a posição e o tamanho conforme necessário
        frase1.setForeground(Color.BLACK); // Cor da fonte
        frase1.setFont(new Font("Arial", Font.BOLD, 16)); // Estilo da fonte
        add(frase1); // Adicionando o JLabel ao JFrame
        JLabel frase2 = new JLabel("PollForms");
        frase2.setBounds(150, 30, 5000, 30); // Ajuste a posição e o tamanho conforme necessário
        frase2.setForeground(Color.BLACK); // Cor da fonte
        frase2.setFont(new Font("Arial", Font.BOLD, 24)); // Estilo da fonte
        add(frase2); // Adicionando o JLabel ao JFrame

        // Carrega a imagem
        ImageIcon imagem = new ImageIcon(getClass().getResource("/Imagens/cropped_circle_image.png")); // Caminho para a imagem
        imagemLabel = new JLabel(imagem); // Cria um JLabel com a imagem
        imagemLabel.setBounds(50, 10, 100, 100); // Ajuste a posição e o tamanho da imagem

        // Adiciona o JLabel da imagem ao JFrame
        add(imagemLabel); 

        // Criação de botões
        btn1 = criarBotao("", '1', 30, 50, 250, 200);
        btn2 = criarBotao("", '2', 325, 50, 250, 200);
        btn3 = criarBotao("", '3', 620, 50, 250, 200);
        btn4 = criarBotao("", '4', 30, 270, 250, 200);
        btn5 = criarBotao("", '5', 325, 270, 250, 200);
        btn6 = criarBotao("", '6', 620, 270, 250, 200);

        // Adiciona os botões ao painel
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);

        centralizar();
        setVisible(true); // Exibindo a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JButton criarBotao(String string, char c, int distEsq, int rodape, int larg, int altura) {
        JButton b1 = new JButton(string);
        b1.setBounds(distEsq, rodape, larg, altura); // Dist Esq, Dist Topo, larg, alt
        b1.setBackground(new Color(0x40BDF2)); 
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Helvetica", Font.BOLD, 18));
        b1.setToolTipText("Botão " + string);
        b1.setHorizontalAlignment(0);
        b1.setVerticalAlignment(0);
        b1.setMnemonic(c); // Tecla de atalho
        b1.addActionListener(this);
        return b1;
    }

    public static void main(String[] args) {
        new Menu();
    }

    public void centralizar() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension janela = getSize();
        if (janela.height > screen.height)
            setSize(janela.width, screen.height);
        if (janela.width > screen.width)
            setSize(screen.width, janela.height);
        setLocation((screen.width - janela.width) / 2, (screen.height - janela.height) / 2);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1)
            System.exit(0);
    }
}
