package pkEscenarioRio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pkEscenarioRio.pkSujeto.Caperucita;
import pkEscenarioRio.pkSujeto.Lobo;
import pkEscenarioRio.pkSujeto.Pasajero;
import pkEscenarioRio.pkSujeto.Uva;
import pkEscenarioRio.pkSujeto.Vikingo;

public class Controller {

    private static boolean barcoEnIzquierda = true; // true = izquierda, false = derecha
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Crear personajes
        Lobo lobo = new Lobo();
        Caperucita caperucita = new Caperucita();
        Uva uva = new Uva();
        Vikingo vikingo = new Vikingo();

        // Todos empiezan en la orilla izquierda (cruzoAlOtroLado = false por defecto)

        System.out.println("=== JUEGO DEL RIO: Lobo - Vikingo - Uva - Caperucita ===");
        System.out.println("Reglas:");
        System.out.println("- El barco puede llevar hasta 2 personajes (incluyendo al Vikingo).");
        System.out.println("- El Vikingo SIEMPRE debe estar en el barco para que el viaje sea válido.");
        System.out.println("- Lobo y Caperucita NO pueden quedarse solos juntos sin el Vikingo.");
        System.out.println("- Uva y Caperucita NO pueden quedarse solas juntas sin el Vikingo.");
        System.out.println("- Ganas si TODOS llegan a la orilla derecha.");
        System.out.println();

        boolean jugando = true;

        while (jugando) {

            mostrarEstado(lobo, caperucita, uva, vikingo);

            if (todosHanCruzado(lobo, caperucita, uva, vikingo)) {
                System.out.println("\n¡Felicidades! Todos han cruzado el río sin romper las reglas. ¡Has ganado!");
                break;
            }

            System.out.println("\nEl barco está en la orilla " + (barcoEnIzquierda ? "IZQUIERDA" : "DERECHA"));
            System.out.println("Debes elegir de 1 a 2 personajes para subir al barco (incluyendo al Vikingo).");
            System.out.println("Escribe los números separados por espacio. (0 para salir del juego)");
            System.out.println("Personajes en esta orilla:");

            List<Pasajero> pasajerosOrilla = obtenerPasajerosEnOrillaActual(lobo, caperucita, uva, vikingo);
            mostrarMenuPasajeros(pasajerosOrilla);

            System.out.print("Tu elección: ");
            String linea = scanner.nextLine().trim();

            if (linea.equals("0")) {
                System.out.println("Has salido del juego.");
                break;
            }

            String[] partes = linea.split("\\s+");
            if (partes.length == 0 || partes.length > 2) {
                System.out.println("Debes elegir 1 o 2 personajes válidos.");
                continue;
            }

            List<Pasajero> seleccion = new ArrayList<>();

            try {
                for (String p : partes) {
                    int opcion = Integer.parseInt(p);
                    if (opcion < 1 || opcion > pasajerosOrilla.size()) {
                        throw new NumberFormatException();
                    }
                    Pasajero elegido = pasajerosOrilla.get(opcion - 1);
                    if (!seleccion.contains(elegido)) {
                        seleccion.add(elegido);
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intenta de nuevo.");
                continue;
            }

            // Validaciones de reglas antes de mover
            if (seleccion.isEmpty() || seleccion.size() > 2) {
                System.out.println("Debes seleccionar mínimo 1 y máximo 2 personajes.");
                continue;
            }

            // Debe estar el Vikingo en la selección
            if (!seleccion.contains(vikingo)) {
                System.out.println("El Vikingo debe ir en el barco para que el viaje sea válido.");
                continue;
            }

            // Mover pasajeros seleccionados al otro lado con el barco
            moverPasajeros(seleccion);

            // Mostrar lo que pasó
            System.out.print("\nEl Vikingo rema hacia la orilla "
                    + (barcoEnIzquierda ? "IZQUIERDA" : "DERECHA") + " con: ");
            for (Pasajero p : seleccion) {
                if (p != vikingo) {
                    System.out.print(p + " ");
                }
            }
            if (seleccion.size() == 1) {
                System.out.print("(solo)");
            }
            System.out.println();

            // Comprobar si se rompieron las reglas
            if (!estadoEsValido(lobo, caperucita, uva, vikingo)) {
                System.out.println("\n*** ¡Se ha roto una regla! ***");
                if (loboMatoCaperucita(lobo, caperucita, vikingo)) {
                    caperucita.serComida(lobo);
                } else if (caperucitaSeComioUva(caperucita, uva, vikingo)) {
                    caperucita.comerUva(uva);
                } else if (uvaFueComida(caperucita, uva, vikingo)) {
                    uva.serComida(caperucita);
                } else if (loboComioCaperucita(lobo, caperucita, vikingo)) {
                    lobo.comerCaperucita(caperucita);
                } else {
                    System.out.println("Ocurrió una situación peligrosa no permitida.");
                }
                System.out.println("Has perdido el juego.");
                jugando = false;
            }
        }

        System.out.println("\nFin del juego.");
    }

    // ---- LÓGICA DE ESTADO Y VALIDACIÓN ----

    private static void moverPasajeros(List<Pasajero> seleccion) {
        // Cambiar lado de todos los seleccionados
        for (Pasajero p : seleccion) {
            p.setCruzoAlOtroLado(!p.getCruzoAlOtroLado());
        }
        // El barco cambia de orilla
        barcoEnIzquierda = !barcoEnIzquierda;
    }

    private static boolean todosHanCruzado(Pasajero... pasajeros) {
        for (Pasajero p : pasajeros) {
            if (!p.getCruzoAlOtroLado()) {
                return false;
            }
        }
        return true;
    }

    private static boolean estadoEsValido(Lobo lobo, Caperucita caperucita, Uva uva, Vikingo vikingo) {
        // Revisar orilla izquierda
        if (!orillaEsSegura(false, lobo, caperucita, uva, vikingo)) {
            return false;
        }
        // Revisar orilla derecha
        if (!orillaEsSegura(true, lobo, caperucita, uva, vikingo)) {
            return false;
        }
        return true;
    }

    private static boolean orillaEsSegura(boolean derecha, Lobo lobo, Caperucita caperucita, Uva uva, Vikingo vikingo) {
        boolean vAqui = vikingo.getCruzoAlOtroLado() == derecha;
        boolean lAqui = lobo.getCruzoAlOtroLado() == derecha;
        boolean cAqui = caperucita.getCruzoAlOtroLado() == derecha;
        boolean uAqui = uva.getCruzoAlOtroLado() == derecha;

        // Lobo y Caperucita sin Vikingo -> peligro
        if (lAqui && cAqui && !vAqui) {
            return false;
        }

        // Uva y Caperucita sin Vikingo -> peligro
        if (uAqui && cAqui && !vAqui) {
            return false;
        }

        return true;
    }

    // Detectores concretos de eventos para mensajes (opcionales, más narrativos)

    private static boolean loboMatoCaperucita(Lobo lobo, Caperucita caperucita, Vikingo vikingo) {
        boolean lIzq = !lobo.getCruzoAlOtroLado();
        boolean cIzq = !caperucita.getCruzoAlOtroLado();
        boolean vIzq = !vikingo.getCruzoAlOtroLado();

        boolean lDer = lobo.getCruzoAlOtroLado();
        boolean cDer = caperucita.getCruzoAlOtroLado();
        boolean vDer = vikingo.getCruzoAlOtroLado();

        return (lIzq && cIzq && !vIzq) || (lDer && cDer && !vDer);
    }

    private static boolean caperucitaSeComioUva(Caperucita caperucita, Uva uva, Vikingo vikingo) {
        boolean cIzq = !caperucita.getCruzoAlOtroLado();
        boolean uIzq = !uva.getCruzoAlOtroLado();
        boolean vIzq = !vikingo.getCruzoAlOtroLado();

        boolean cDer = caperucita.getCruzoAlOtroLado();
        boolean uDer = uva.getCruzoAlOtroLado();
        boolean vDer = vikingo.getCruzoAlOtroLado();

        return (cIzq && uIzq && !vIzq) || (cDer && uDer && !vDer);
    }

    private static boolean uvaFueComida(Caperucita caperucita, Uva uva, Vikingo vikingo) {
        // Igual que caperucitaSeComioUva, pero dejamos este método por claridad si quieres cambiar la narrativa
        return caperucitaSeComioUva(caperucita, uva, vikingo);
    }

    private static boolean loboComioCaperucita(Lobo lobo, Caperucita caperucita, Vikingo vikingo) {
        // Igual que loboMatoCaperucita, mantenido separado por claridad
        return loboMatoCaperucita(lobo, caperucita, vikingo);
    }

    // ---- IMPRESIÓN Y MENÚ ----

    private static void mostrarEstado(Lobo lobo, Caperucita caperucita, Uva uva, Vikingo vikingo) {
        System.out.println("\n---------------- ESTADO ACTUAL ----------------");

        List<String> izquierda = new ArrayList<>();
        List<String> derecha = new ArrayList<>();

        Pasajero[] todos = { vikingo, lobo, caperucita, uva };

        for (Pasajero p : todos) {
            if (!p.getCruzoAlOtroLado()) {
                izquierda.add(p.toString());
            } else {
                derecha.add(p.toString());
            }
        }

        System.out.println("Orilla IZQUIERDA: " + izquierda);
        System.out.println("Orilla DERECHA  : " + derecha);
        System.out.println("Barco en        : " + (barcoEnIzquierda ? "IZQUIERDA" : "DERECHA"));
    }

    private static List<Pasajero> obtenerPasajerosEnOrillaActual(Lobo lobo, Caperucita caperucita, Uva uva, Vikingo vikingo) {
        List<Pasajero> lista = new ArrayList<>();
        Pasajero[] todos = { vikingo, lobo, caperucita, uva };

        for (Pasajero p : todos) {
            boolean enIzquierda = !p.getCruzoAlOtroLado();
            if (barcoEnIzquierda && enIzquierda) {
                lista.add(p);
            } else if (!barcoEnIzquierda && !enIzquierda == false) {
                // p está en derecha y el barco también
                if (p.getCruzoAlOtroLado()) {
                    lista.add(p);
                }
            }
        }

        return lista;
    }

    private static void mostrarMenuPasajeros(List<Pasajero> pasajerosOrilla) {
        for (int i = 0; i < pasajerosOrilla.size(); i++) {
            System.out.println((i + 1) + ". " + pasajerosOrilla.get(i));
        }
    }
}
