
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;

import static java.awt.Frame.HAND_CURSOR;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import model.entities.Enquete;
import model.entities.Usuario;
import view.components.CustomScrollBarUI;
import view.components.RoundedButton;
import view.components.RoundedPanel;

public class Menu extends JFrame {
	private JLabel logo;
	private JLabel titulo;
	private JLabel subTitulo;
	private JMenuBar mnuBar;
	private JButton botaoFechar;
	private JScrollPane scrollPane;
	private JButton btnCriarEnquete;
	
	// painel enquete criada
	private JButton itemEnqueteCriada;
	private JPanel panelEnquetesCriadas;
	private JLabel tituloEnquetesCriadas;
	
	// painel enquetes participadas
	private JButton itemEnqueteParticipadas;
	private JPanel panelEnquetesParticipadas;
	private JLabel tituloEnquetesParticipadas;
	private int quantidadeEnquetesCriadas;
	
	public Menu(Usuario user) {
		components();
		adicionarEnquete(user.getEnquetesCriadas());
		
	}
	
	public Menu() {
		components();
	}
	
	public void components() {
		setTitle("Criar Enquete");
		setSize(1000, 625);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setUndecorated(true);
		int alt = 40;
		Component[] componentsPanelEnquetesCriadas = new Component[6];

		getContentPane().setBackground(new Color(0xDBCDC2));

		logo = criarJLabel("", 60, 30, 90, alt + 30);
		logo.setIcon(new ImageIcon(getClass().getResource("/img/logo.png")));

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

		titulo = criarJLabel("PollForms", 150, 30, 200, alt);
		titulo.setFont(new Font("Kantumruy Pro", Font.BOLD, 24));

		subTitulo = criarJLabel("Crie enquetes ou explore outras lá criadas!", 160, 60, 400, alt);
		subTitulo.setFont(new Font("Kantumruy Pro", Font.BOLD, 16));
		subTitulo.setForeground(new Color(0x5B5B5B));

		mnuBar = new JMenuBar();
		mnuBar.setSize(getWidth() - 150, alt);
		mnuBar.setLocation(centralizarComponente(mnuBar), 120);
		mnuBar.setBackground(getContentPane().getBackground());
		mnuBar.setBorder(BorderFactory.createEmptyBorder());
		mnuBar.setLayout(new GridLayout(0, 2));

		itemEnqueteCriada = new JButton("Enquetes criadas");
		itemEnqueteCriada.setBackground(getContentPane().getBackground());
		itemEnqueteCriada.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(0x877D75)));
		itemEnqueteCriada.setCursor(new Cursor(HAND_CURSOR));
		itemEnqueteCriada.setFocusPainted(false);
		itemEnqueteCriada.setFont(new Font("Kantumruy Pro", Font.BOLD, 14));
		itemEnqueteCriada.setContentAreaFilled(false);
		itemEnqueteCriada.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				itemEnqueteCriada.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(0x877D75)));
				itemEnqueteParticipadas.setBorder(BorderFactory.createEmptyBorder());
			}
		});

		itemEnqueteParticipadas = new JButton("Enquetes participadas");
		itemEnqueteParticipadas.setBackground(getContentPane().getBackground());
		itemEnqueteParticipadas.setBorder(BorderFactory.createEmptyBorder());
		itemEnqueteParticipadas.setCursor(new Cursor(HAND_CURSOR));
		itemEnqueteParticipadas.setFont(new Font("Kantumruy Pro", Font.BOLD, 14));
		itemEnqueteParticipadas.setFocusPainted(false);
		itemEnqueteParticipadas.setContentAreaFilled(false);
		itemEnqueteParticipadas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				itemEnqueteParticipadas.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(0x877D75)));
				itemEnqueteCriada.setBorder(BorderFactory.createEmptyBorder());
			}
		});
		
		panelEnquetesCriadas = new RoundedPanel(25);
		panelEnquetesCriadas.setBackground(new Color(0xB6AAA1));
		panelEnquetesCriadas.setSize(getWidth() - 180, 460);
		panelEnquetesCriadas.setLayout(new BoxLayout(panelEnquetesCriadas, BoxLayout.Y_AXIS));
		
		panelEnquetesCriadas.setLocation(20,020);
		
		panelEnquetesCriadas.add(Box.createRigidArea(new Dimension(0, 20)));
		
		scrollPane = new JScrollPane(panelEnquetesCriadas);
		scrollPane.setSize(getWidth() - 150, 360);
		scrollPane.setLocation(centralizarComponente(scrollPane), 180);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getViewport().setBackground(getContentPane().getBackground());
		scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI(new Color(0x877D75),getContentPane().getBackground()));
		
		panelEnquetesCriadas.setPreferredSize(new Dimension(panelEnquetesCriadas.getWidth() - 10, panelEnquetesCriadas.getHeight() - 10));
		
		JPanel panelOptionPersonalizado = new JPanel();
		panelOptionPersonalizado.setBackground(getContentPane().getBackground());
		panelOptionPersonalizado.add(new JLabel("Certeza que deseja excluir a enquete?"));
		
		//criando a mensagem de erro para quando a pessoa tentar excluir a enquete
		
		
		btnCriarEnquete = criarBotao("Criar enquete", 'c', 560, 300, alt);
		
		btnCriarEnquete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CriarEnquete();
				
			}
		});
		
		// adicionar componentes
		add(botaoFechar);
		add(logo);
		add(titulo);
		add(subTitulo);
		add(mnuBar);
		mnuBar.add(itemEnqueteCriada);
		mnuBar.add(itemEnqueteParticipadas);
		add(scrollPane);
		add(btnCriarEnquete);
		
		setVisible(true);
	}

	private void adicionarEnquete(List<Enquete> enquetes ) {
		if(quantidadeEnquetesCriadas < 5) {
			for(Enquete enquete : enquetes) {
				panelEnquetesCriadas.add(criarEnquete(enquete));
				panelEnquetesCriadas.add(Box.createRigidArea(new Dimension(0, 5)));
				quantidadeEnquetesCriadas++;
			}
		}
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
	
	private JPanel criarEnquete(Enquete enquete) {
    	JPanel p = new RoundedPanel(20);
    	p.setBackground(new Color(0x877D75));
    	p.setLayout(null);
    	p.setMaximumSize(new Dimension(800, 80));
    	p.setMinimumSize(new Dimension(800, 80));
    	
    	JButton botaoExcluir = new JButton();
    	botaoExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					p.getParent().remove(p);
					quantidadeEnquetesCriadas--;
					revalidate();
					repaint();
			}
		});
    	
    	JLabel titulo = criarJLabel(enquete.getTitulo(), 25, 5, 300, 40);
    	JLabel descricao = criarJLabel(enquete.getDescricao()
    			, 35, 30, 700,  40);
    	descricao.setFont(new Font("Kantumruy Pro", Font.BOLD, 16));    	
    	
    	p.add(titulo);
    	p.add(descricao);
    	p.add(botaoExcluir);
    	
    	return p;
    }

	public static void main(String[] args) {
		new Menu();
	}
}
