
package class141026;
public class Pila<T> {

    // Nodo interno (clase enlazada dinámica)
    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo<T> cima;
    private int tamanio;

    public Pila() {
        this.cima = null;
        this.tamanio = 0;
    }

    // push: inserta en la cima
    public void push(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);
        nuevo.siguiente = cima;
        cima = nuevo;
        tamanio++;
    }

    // pop: extrae y devuelve la cima (controla underflow)
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException(
                "Underflow: la pila está vacía, no se puede hacer pop()");
        }
        T dato = cima.dato;
        cima = cima.siguiente;
        tamanio--;
        return dato;
    }

    // peek: consulta la cima sin extraer
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException(
                "Underflow: la pila está vacía, no se puede hacer peek()");
        }
        return cima.dato;
    }

    // isEmpty
    public boolean isEmpty() {
        return cima == null;
    }

    // size
    public int size() {
        return tamanio;
    }

    // toString: muestra de cima a base
    @Override
    public String toString() {
        if (isEmpty()) return "(vacía)";
        StringBuilder sb = new StringBuilder("[");
        Nodo<T> actual = cima;
        while (actual != null) {
            sb.append(actual.dato);
            if (actual.siguiente != null) sb.append(", ");
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}

