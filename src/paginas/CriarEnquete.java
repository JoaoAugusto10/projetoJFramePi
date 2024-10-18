package paginas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CriarEnquete extends JFrame implements ActionListener {
    JLabel titulo, descricao, opcResposta,frase;
    JTextField txtTitulo, txtDescricao, txtOpcResposta,txtOpcResposta2;
    JButton btnOpcao, btnCria;

    public CriarEnquete() {
        setTitle("Cadastro"); // Titulo da janela
        setSize(1000, 700); // tamanho da janela
        setLayout(null); // anula o layout padrão
        int alt = 40;
        getContentPane().setBackground(new Color(0xDBCDC2));

        // Painel
        RoundedPanel panel = new RoundedPanel(50); // 50 é o raio das bordas arredondadas
        panel.setLayout(null);
        panel.setBackground(new Color(150, 150, 150)); // Cor de fundo mais escura para o painel
        panel.setBounds(50, 100, 900, 600); // Posição e tamanho do painel
        add(panel); // Adiciona o painel ao JFrame
        JLabel frase = new JLabel("Crie enquetes ou explore outras ja criadas!");
        frase.setBounds(150, 50, 5000, 30); // Ajuste a posição e o tamanho conforme necessário
        frase.setForeground(Color.BLACK); // Cor da fonte
        frase.setFont(new Font("Arial", Font.BOLD, 16)); // Estilo da fonte
        add(frase); // Adicionando o JLabel ao JFrame

        // Cadastro
        titulo = criarJLabel("Titulo", 30, 50, 270, alt);
        titulo.setForeground(Color.BLACK);
        txtTitulo  = criarTexto(30, 90, 840, alt);
        descricao =  criarJLabel("Descrição", 30,130, 270, alt);
        descricao.setForeground(Color.BLACK);
        txtDescricao = criarTexto(30, 170, 840, 100);
        opcResposta =  criarJLabel("Opções de Resposta", 30,280, 270, alt);
        opcResposta.setForeground(Color.BLACK);
        txtOpcResposta = criarTexto(30, 320, 840, alt);
        txtOpcResposta2 = criarTexto(30, 380, 840, alt);
        
        
        
        int rodape = getHeight() - 80;
        int distEsq = getWidth() / 2;
        int larg = 150;

        btnOpcao = criarBotao("Opções", 'O', 30, 440, 120, alt);
        btnCria = criarBotao("Criar Enquete", 'C', 30, 490, 840, alt);

        // Adiciona os componentes diretamente ao painel
        panel.add(titulo);
        panel.add(txtTitulo);
        panel.add(descricao);
        panel.add(txtDescricao);
        panel.add(opcResposta);
        panel.add(txtOpcResposta);
        panel.add(txtOpcResposta2);
        panel.add(btnOpcao);
        panel.add(btnCria);
        

        centralizar();
        setVisible(true); // Exibindo a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JButton criarBotao(String string, char c, int distEsq, int rodape, int larg, int altura) {
        JButton b1 = new JButton(string);
        b1.setBounds(distEsq, rodape, larg, altura); // Dist Esq, Dist Topo, larg, alt
        b1.setBackground(new Color(0x40BDF2)); 
        b1.setForeground(Color.YELLOW);
        b1.setFont(new Font("Helvetica", Font.BOLD, 18));
        b1.setToolTipText("Botão " + string);
        b1.setForeground(Color.BLACK);
        b1.setHorizontalAlignment(0);
        b1.setVerticalAlignment(0);
        b1.setMnemonic(c); // Tecla de atalho
        b1.addActionListener(this);
        return b1;
    }

    private JTextField criarTexto(int desq, int dtopo, int larg, int alt) {
        JTextField jt = new JTextField();
        jt.setBounds(desq, dtopo, larg, alt);
        jt.setForeground(Color.blue);
        return jt;
    }

    private JLabel criarJLabel(String string, int desq, int dtopo, int larg, int alt) {
        JLabel jl = new JLabel(string);
        jl.setLocation(desq, dtopo); // Dist Esq e Topo
        jl.setSize(larg, alt); // Largura e altura do rótulo
        jl.setForeground(new Color(110, 182, 145)); // Cor da fonte
        jl.setFont(new Font("Courier new", Font.BOLD, 18)); // Nome, estilo e tamanho da fonte
        return jl;
    }

    public static void main(String[] args) {
        new CriarEnquete();
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
        if (e.getSource() == btnCria)
            System.exit(0);
    }
}
