import java.awt.Color;
import java.awt.image.BufferedImage;

public class FloodFill {
    private BufferedImage imagem;
    private int corAlvo, corSubstituta;

    public FloodFill(BufferedImage imagem, Color corAlvo, Color corSubstituta) {
        this.imagem = imagem;
        this.corAlvo = corAlvo.getRGB();
        this.corSubstituta = corSubstituta.getRGB();
    }

    public void preencherComPilha(int x, int y) {
        if (imagem.getRGB(x, y) != corAlvo) return;

        Pilha<Pixel> pilha = new Pilha<>();
        pilha.empilhar(new Pixel(x, y));

        while (!pilha.estaVazia()) {
            Pixel pixel = pilha.desempilhar();
            int px = pixel.x;
            int py = pixel.y;

            if (ehValido(px, py) && imagem.getRGB(px, py) == corAlvo) {
                imagem.setRGB(px, py, corSubstituta);

                // Empilha os 4 vizinhos laterais
                pilha.empilhar(new Pixel(px + 1, py));
                pilha.empilhar(new Pixel(px - 1, py));
                pilha.empilhar(new Pixel(px, py + 1));
                pilha.empilhar(new Pixel(px, py - 1));
            }
        }
    }

    public void preencherComFila(int x, int y) {
        if (imagem.getRGB(x, y) != corAlvo) return;

        Fila<Pixel> fila = new Fila<>();
        fila.enfileirar(new Pixel(x, y));

        while (!fila.estaVazia()) {
            Pixel pixel = fila.desenfileirar();
            int px = pixel.x;
            int py = pixel.y;

            if (ehValido(px, py) && imagem.getRGB(px, py) == corAlvo) {
                imagem.setRGB(px, py, corSubstituta);

                // Enfileira os 4 vizinhos laterais
                fila.enfileirar(new Pixel(px + 1, py));
                fila.enfileirar(new Pixel(px - 1, py));
                fila.enfileirar(new Pixel(px, py + 1));
                fila.enfileirar(new Pixel(px, py - 1));
            }
        }
    }

    private boolean ehValido(int x, int y) {
        return x >= 0 && x < imagem.getWidth() && y >= 0 && y < imagem.getHeight();
    }
}
