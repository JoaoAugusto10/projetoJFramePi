package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

public class CriarEnquete extends JFrame implements ActionListener {
	private JLabel titulo;
	private JLabel descricao;
	private JLabel opcResposta;
	private JLabel frase;
	private JTextField txtTitulo;
	private JTextField txtDescricao;
	private JTextField txtOpcResposta;
	private JTextField txtOpcResposta2;
	private JButton btnOpcao;
	private JButton btnCria;
	private JLabel imagemLabel; // Declaração do JLabel para a imagem
	
	public CriarEnquete() {
		setTitle("Cadastro"); // Titulo da janela
		setSize(1000, 625); // tamanho da janela
		setLayout(null); // anula o layout padrão
		setResizable(false);
		int alt = 40;
		getContentPane().setBackground(new Color(0xDBCDC2));

		// Painel
		JPanel panel = new RoundedPanel(50);// 50 é o raio das bordas arredondadas
		panel.setLayout(null);
		panel.setBackground(new Color(0xB6AAA1)); // Cor de fundo mais escura para o painel
		panel.setBounds(50, 100, 900, 600); // Posição e tamanho do painel

		JLabel frase1 = new JLabel("Crie enquetes ou explore outras ja criadas!");
		frase1.setBounds(160, 60, 5000, 30); // Ajuste a posição e o tamanho conforme necessário
		frase1.setForeground(new Color(0x5B5B5B)); // Cor da fonte
		frase1.setFont(new Font("Kantumruy Pro", Font.BOLD, 16)); // Estilo da fonte
		
		JLabel frase2 = new JLabel("PollForms");
		frase2.setBounds(150, 30, 5000, 30); // Ajuste a posição e o tamanho conforme necessário
		frase2.setForeground(Color.BLACK); // Cor da fonte
		frase2.setFont(new Font("Kantumruy Pro", Font.BOLD, 24)); // Estilo da fonte
		

		// Carrega a imagem
		ImageIcon imagem = new ImageIcon(getClass().getResource("/img/cropped_circle_image.png")); // Caminho para a
																									// imagem
		imagemLabel = new JLabel(imagem); // Cria um JLabel com a imagem
		imagemLabel.setBounds(50, 10, 100, 100); // Ajuste a posição e o tamanho da imagem

		// Adiciona o JLabel da imagem ao JFrame
		

		// Cadastro
		titulo = criarJLabel("Titulo", 30, 50, 270, alt);
		titulo.setForeground(Color.BLACK);
		txtTitulo = criarTextField(30, 90, 840, alt);

		descricao = criarJLabel("Descrição", 30, 130, 270, alt);
		descricao.setForeground(Color.BLACK);
		txtDescricao = criarTextField(30, 170, 840, alt);

		opcResposta = criarJLabel("Opções de Resposta", 30, 210, 270, alt);
		opcResposta.setForeground(Color.BLACK);
			
		int rodape = getHeight() - 80;
		int distEsq = getWidth() / 2;
		int larg = 150;

		btnOpcao = criarBotao("+  Opções", 'O',30 , 350, 120, alt, 15);
		btnOpcao.setBackground(new Color(0xDBCDC2));
		btnCria = criarBotao("Criar Enquete", 'C', 30, 410, 830, alt, 15);
		
		txtOpcResposta = criarTextField(30, 250, 780, alt);
		JPanel panelOpcao = criarOpcaoResposta(txtOpcResposta);
		txtOpcResposta2 = criarTextField(30, 300, 780, alt);
		JPanel panelOpcao2 = criarOpcaoResposta(txtOpcResposta2);
		

		
		// Adiciona os componentes diretamente ao painel
		add(panel); // Adiciona o painel ao JFrame
		add(frase1); // Adicionando o JLabel ao JFrame
		add(frase2); // Adicionando o JLabel ao JFrame
		add(imagemLabel);
		
		panel.add(titulo);
		panel.add(txtTitulo);
		panel.add(descricao);
		panel.add(txtDescricao);
		panel.add(opcResposta);
		panel.add(panelOpcao);
		panel.add(panelOpcao2);
		panel.add(btnOpcao);
		panel.add(btnCria);
		setLocationRelativeTo(null);
		setVisible(true); // Exibindo a janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JButton criarBotao(String string, char c,int desq, int dtopo, int larg, int alt, int radius) {
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

	private JTextField criarTextField(int desq, int dtopo, int larg, int alt) {
		JTextField jt = new RoundedJTextField(10);
		jt.setBounds(desq, dtopo, larg, alt);;
		jt.setForeground(Color.black);
		jt.setBackground(new Color(0x877D75));
		jt.setBorder(BorderFactory.createEmptyBorder());
		jt.setFont(new Font("Kantumruy Pro", Font.PLAIN, 16));
		jt.setCursor(new Cursor(TEXT_CURSOR));
		jt.setAlignmentY(LEFT_ALIGNMENT);
		jt.setMargin(new Insets(0, 30, 0, 30));
		return jt;
	}

	private JPanel criarOpcaoResposta(JTextField txt) {
		JPanel panelOpca = new RoundedPanel(10);
		panelOpca.setSize(txt.getWidth() + 60, txt.getHeight());
		panelOpca.setBackground(txt.getBackground());
		panelOpca.setBorder(BorderFactory.createEmptyBorder());
		panelOpca.setLocation(txt.getLocation().x, txt.getLocation().y);
		panelOpca.setLayout(null);
		panelOpca.setOpaque(false);
		txt.setLocation(10, 0);

		JLabel label = new JLabel(new ImageIcon(getClass().getResource("/img/lixeira.png")));
		label.setBounds(txt.getWidth() + 15, 0, 40, 40);
		label.setCursor(new Cursor(HAND_CURSOR));
		
		panelOpca.add(txt);
		panelOpca.add(label);
		
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
		if (e.getSource() == btnCria)
			System.exit(0);
	}

	public static void main(String[] args) {
		new CriarEnquete();
	}

}
