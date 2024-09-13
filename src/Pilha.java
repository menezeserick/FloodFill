import java.util.ArrayList;

public class Pilha<T> {
    private ArrayList<T> pilha;

    public Pilha() {
        pilha = new ArrayList<>();
    }

    public void empilhar(T elemento) {
        pilha.add(elemento);
    }

    public T desempilhar() {
        if (!estaVazia()) {
            return pilha.remove(pilha.size() - 1);
        }
        return null;
    }

    public boolean estaVazia() {
        return pilha.isEmpty();
    }
}
