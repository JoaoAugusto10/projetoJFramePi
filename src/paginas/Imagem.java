
package paginas;
import javax.swing.*; // Importa as classes do pacote Swing
import java.awt.*; // Importa as classes do pacote AWT para layouts

public class Imagem extends JFrame {
    ImageIcon imagem; // Declaração da variável para a imagem
    JLabel label; // Declaração da variável para o JLabel

    public Imagem() {
        // Tente carregar a imagem. Certifique-se de que o caminho está correto.
        imagem = new ImageIcon(getClass().getResource("/Imagens/cropped_circle_image.png")); // Caminho para a imagem
        label = new JLabel(imagem); // Cria um JLabel com a imagem

        // Configurações do JFrame
        setSize(500, 400); // Define o tamanho da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Fecha o aplicativo ao fechar a janela
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Adiciona o JLabel ao JFrame
        add(label); // Adiciona o JLabel que contém a imagem ao JFrame

        setVisible(true); // Torna o JFrame visível
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Imagem()); // Executa a GUI na thread do evento
    }
}