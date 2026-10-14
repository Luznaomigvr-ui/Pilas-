
package class141026;
public class VerificadorSintaxis {

    // Clase interna para devolver resultado
    public static class Resultado {
        public boolean balanceada;
        public String mensaje;

        public Resultado(boolean balanceada, String mensaje) {
            this.balanceada = balanceada;
            this.mensaje = mensaje;
        }
    }

    public static Resultado verificar(String expresion) {
        Pila<Character> pila = new Pila<>();
        Pila<Integer> posiciones = new Pila<>();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            // Aperturas
            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
                posiciones.push(i);
            }
            // Cierres
            else if (c == ')' || c == ']' || c == '}') {

                // Cierre sobrante (pila vacía)
                if (pila.isEmpty()) {
                    return new Resultado(false,
                        "Error en posición " + i + ": cierre '" + c +
                        "' sobrante (no hay apertura previa).");
                }

                char apertura = pila.pop();
                posiciones.pop();

                if (!esPareja(apertura, c)) {
                    return new Resultado(false,
                        "Error en posición " + i + ": se esperaba cerrar '" +
                        apertura + "' pero se encontró '" + c + "'.");
                }
            }
        }

        // Aperturas sin cerrar
        if (!pila.isEmpty()) {
            char apertura = pila.pop();
            int pos = posiciones.pop();
            return new Resultado(false,
                "Error: falta cerrar '" + apertura + "' abierto en posición " +
                pos + ". Se esperaba '" + cierreDe(apertura) + "'.");
        }

        return new Resultado(true, "Expresión balanceada correctamente.");
    }

    private static boolean esPareja(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
               (apertura == '[' && cierre == ']') ||
               (apertura == '{' && cierre == '}');
    }

    private static char cierreDe(char apertura) {
        switch (apertura) {
            case '(': return ')';
            case '[': return ']';
            case '{': return '}';
            default:  return '?';
        }
    }
}
