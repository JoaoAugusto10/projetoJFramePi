
package view;

import javax.swing.*;

import view.modelos.RoundedPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Resultado extends JFrame implements ActionListener {
    JTextField txtTitulo;
    JLabel imgLogo; // Declaração do JLabel para a imagem
    JButton btn1, btn2;
    
    public Resultado() {
        setTitle("Menu"); // Título da janela
        setSize(1000, 700); // Tamanho da janela
        setLayout(null); // Anula o layout padrão
        getContentPane().setBackground(new Color(0xDBCDC2)); // Cor de fundo

        // Painel
        RoundedPanel panel = new RoundedPanel(50); // 50 é o raio das bordas arredondadas
        panel.setLayout(null);
        panel.setBackground(new Color(0xB6AAA1)); // Cor de fundo mais escura para o painel
        panel.setBounds(50, 120, 900, 500); // Posição e tamanho do painel
        add(panel); // Adiciona o painel ao JFrame

        // Carrega a fonte "Kantumruy Pro BOLD"
        Font kantumruyProBold = new Font("Kantumruy Pro", Font.BOLD, 16);

        JLabel frase1 = new JLabel("PollForms");
        frase1.setBounds(150, 40, 5000, 30); // Ajuste a posição e o tamanho conforme necessário
        frase1.setForeground(Color.BLACK); // Cor da fonte personalizada
        if (kantumruyProBold != null) {
            frase1.setFont(kantumruyProBold); // Usa a fonte Kantumruy Pro BOLD
        } else {
            frase1.setFont(new Font("Arial", Font.BOLD, 30)); // Fonte padrão se Kantumruy não carregar
        }
        add(frase1); // Adicionando o JLabel ao JFrame
        
        JLabel frase2 = new JLabel("Resultado!");
        frase2.setBounds(450, 80, 5000, 30); // Ajuste a posição e o tamanho conforme necessário
        frase2.setForeground(Color.BLACK); // Cor da fonte personalizada
        if (kantumruyProBold != null) {
            frase2.setFont(kantumruyProBold); // Usa a fonte Kantumruy Pro BOLD
        } else {
            frase2.setFont(new Font("Arial", Font.BOLD, 20)); // Fonte padrão se Kantumruy não carregar
        }
        add(frase2); // Adicionando o JLabel ao JFrame


        // Carrega a imagem logo
        ImageIcon imagemLogo = new ImageIcon(getClass().getResource("/img/logo.png")); // Caminho para a imagem
        imgLogo = new JLabel(imagemLogo); // Cria um JLabel com a imagem
        imgLogo.setBounds(50, 10, 100, 100); // Ajuste a posição e o tamanho da imagem
        add(imgLogo); // Adiciona o JLabel da imagem ao JFrame
         
        // Cadastro
        txtTitulo = criarTexto(30, 50, 400, 30);
        txtTitulo.setForeground(Color.BLACK);
        panel.add(txtTitulo);

        
         // Criação de botões
        btn1 = criarBotao("Criar nova enquete", '1', 200,390, 230, 50);
        btn2 = criarBotao("Explora enquetes", '2',500,390, 200, 50);
        panel.add(btn1);
        panel.add(btn2);
    }

    // Função para carregar a fonte customizada
    private Font loadFont(String path, float size) {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(path));
            return font.deriveFont(size);
        } catch (FontFormatException | IOException e) {
            System.out.println("Erro ao carregar a fonte: " + e.getMessage());
            return null; // Se houver erro, retorna null
        }
    }
     private JTextField criarTexto(int desq, int dtopo, int larg, int alt) {
        JTextField jt = new JTextField();
        jt.setBounds(desq, dtopo, larg, alt);
        jt.setForeground(Color.blue);
        return jt;
    }

    private JButton criarBotao(String string, char c, int distEsq, int rodape, int larg, int altura) {
        JButton b1 = new JButton(string);
        b1.setBounds(distEsq, rodape, larg, altura); // Dist Esq, Dist Topo, larg, alt
        b1.setBackground(new Color(0x40BDF2)); 
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Helvetica", Font.BOLD, 18));
        b1.setToolTipText("Botão " + string);
        b1.setHorizontalAlignment(JLabel.CENTER);
        b1.setVerticalAlignment(JLabel.CENTER);
        b1.setMnemonic(c); // Tecla de atalho
        b1.addActionListener(this);
        return b1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Personalizar ação
    }

    public static void main(String[] args) {
        Resultado resultado = new Resultado();
        resultado.setVisible(true); // Tornar o JFrame visível
        resultado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Encerrar o programa ao fechar a janela
    }
}

