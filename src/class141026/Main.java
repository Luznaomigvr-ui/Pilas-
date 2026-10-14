
package class141026;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimuladorNavegador navegador = new SimuladorNavegador();
        int opcion;

        do {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║   MENÚ - PILAS DINÁMICAS EN JAVA       ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║ 1. Verificar delimitadores             ║");
            System.out.println("║ 2. Visitar URL                         ║");
            System.out.println("║ 3. Retroceder                          ║");
            System.out.println("║ 4. Avanzar                             ║");
            System.out.println("║ 5. Mostrar estado del navegador        ║");
            System.out.println("║ 6. Probar Pila manualmente (push/pop)  ║");
            System.out.println("║ 7. Salir                               ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("⚠ Opción inválida.");
                opcion = -1;
                continue;
            }

            switch (opcion) {

                case 1:
                    System.out.print("Introduce la expresión a verificar: ");
                    String expr = sc.nextLine();
                    VerificadorSintaxis.Resultado r =
                        VerificadorSintaxis.verificar(expr);
                    if (r.balanceada) {
                        System.out.println("✔ " + r.mensaje);
                    } else {
                        System.out.println("✘ " + r.mensaje);
                    }
                    break;

                case 2:
                    System.out.print("Introduce la URL a visitar: ");
                    String url = sc.nextLine().trim();
                    if (url.isEmpty()) {
                        System.out.println("⚠ URL vacía, no se visita nada.");
                    } else {
                        navegador.visitar(url);
                    }
                    break;

                case 3:
                    navegador.retroceder();
                    break;

                case 4:
                    navegador.avanzar();
                    break;

                case 5:
                    navegador.mostrarEstado();
                    break;

                case 6:
                    probarPilaManual(sc);
                    break;

                case 7:
                    System.out.println("Saliendo del programa... ¡Hasta luego!");
                    break;

                default:
                    System.out.println("⚠ Opción no válida.");
            }

        } while (opcion != 7);

        sc.close();
    }

    // Submenú para probar la pila manualmente (útil para demostrar push/pop/peek)
    private static void probarPilaManual(Scanner sc) {
        Pila<String> pila = new Pila<>();
        int op = 0;
        System.out.println("\n--- Prueba manual de Pila<String> ---");
        do {
            System.out.println("\n1) push  2) pop  3) peek  4) size  5) mostrar  6) volver");
            System.out.print("Opción: ");
            try {
                op = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                op = -1;
            }

            try {
                switch (op) {
                    case 1:
                        System.out.print("Valor a apilar: ");
                        pila.push(sc.nextLine());
                        System.out.println("✔ push OK. Tamaño = " + pila.size());
                        break;
                    case 2:
                        System.out.println("pop → " + pila.pop());
                        break;
                    case 3:
                        System.out.println("peek → " + pila.peek());
                        break;
                    case 4:
                        System.out.println("size = " + pila.size());
                        break;
                    case 5:
                        System.out.println("Pila (cima → base): " + pila);
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("⚠ Opción inválida.");
                }
            } catch (IllegalStateException e) {
                // Captura del underflow
                System.out.println("✘ " + e.getMessage());
            }
        } while (op != 6);
    }
}