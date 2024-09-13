import java.util.LinkedList;

public class Fila<T> {
    private LinkedList<T> fila;

    public Fila() {
        fila = new LinkedList<>();
    }

    public void enfileirar(T elemento) {
        fila.addLast(elemento);
    }

    public T desenfileirar() {
        if (!estaVazia()) {
            return fila.removeFirst();
        }
        return null;
    }

    public boolean estaVazia() {
        return fila.isEmpty();
    }
}
