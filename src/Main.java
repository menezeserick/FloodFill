import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Carregar uma imagem a partir de um arquivo
            BufferedImage imagem = ImageIO.read(Main.class.getResourceAsStream("/imagem_entrada.png"));
            
            // Definir a cor alvo (por exemplo, branco) e a cor substituta (por exemplo, vermelho)
            Color corAlvo = Color.WHITE;
            Color corSubstituta = Color.GREEN;

            // Criar o objeto FloodFill
            FloodFill floodFill = new FloodFill(imagem, corAlvo, corSubstituta);

            // Executar o preenchimento com Pilha
            //floodFill.preencherComPilha(10, 10);

            // OU executar o preenchimento com Fila
            floodFill.preencherComFila(500, 400);

            // Salvar o resultado
            ImageIO.write(imagem, "png", new File("imagem_saida.png"));

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

