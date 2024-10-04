import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedImage imagem = ImageIO.read(Main.class.getResourceAsStream("/imagem_entrada.png"));

            Color corAlvo = Color.WHITE;
            Color corSubstituta = Color.RED;

            FloodFill floodFill = new FloodFill(imagem, corAlvo, corSubstituta);

                Scanner scanner = new Scanner(System.in);
                System.out.println("Escolha:");
                System.out.println("1 - Pilha");
                System.out.println("2 - Fila");
                int escolha = scanner.nextInt();

                if (escolha == 1) {
                    System.out.println("Usando Pilha");
                    floodFill.preencherComPilha(500, 400);
                } else if (escolha == 2) {
                    System.out.println("Usando Fila");
                    floodFill.preencherComFila(500, 400);
                } else {
                    System.out.println("Escolha inválida, execute o programa denovo.");
                    return;
                }

            ImageIO.write(imagem, "png", new File("imagem_saida.png"));

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

