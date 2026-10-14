
package class141026;
public class SimuladorNavegador {

    private Pila<String> pilaAtras;
    private Pila<String> pilaAdelante;
    private String paginaActual;

    public SimuladorNavegador() {
        pilaAtras    = new Pila<>();
        pilaAdelante = new Pila<>();
        paginaActual = "(vacío)";
    }

    // Visitar URL nueva
    public void visitar(String url) {
        if (!paginaActual.equals("(vacío)")) {
            pilaAtras.push(paginaActual);
        }
        paginaActual = url;

        // Vaciar pilaAdelante (comportamiento real de navegador)
        while (!pilaAdelante.isEmpty()) {
            pilaAdelante.pop();
        }
        System.out.println("→ Visitando: " + url);
    }

    // Retroceder
    public void retroceder() {
        if (pilaAtras.isEmpty()) {
            System.out.println("⚠ No hay páginas hacia atrás.");
            return;
        }
        pilaAdelante.push(paginaActual);
        paginaActual = pilaAtras.pop();
        System.out.println("← Retrocediendo a: " + paginaActual);
    }

    // Avanzar
    public void avanzar() {
        if (pilaAdelante.isEmpty()) {
            System.out.println("⚠ No hay páginas hacia adelante.");
            return;
        }
        pilaAtras.push(paginaActual);
        paginaActual = pilaAdelante.pop();
        System.out.println("→ Avanzando a: " + paginaActual);
    }

    // Mostrar estado completo
    public void mostrarEstado() {
        System.out.println("\n===== ESTADO DEL NAVEGADOR =====");
        System.out.println("Página actual : " + paginaActual);
        System.out.println("Pila ATRÁS    : " + pilaAtras);
        System.out.println("Pila ADELANTE : " + pilaAdelante);
        System.out.println("================================\n");
    }

    // Getters (por si se necesitan)
    public Pila<String> getPilaAtras()    { return pilaAtras; }
    public Pila<String> getPilaAdelante() { return pilaAdelante; }
    public String getPaginaActual()       { return paginaActual; }
}