package pkEscenarioRio;

import pkEscenarioRio.pkSujeto.*;

public class Controller {
    private Barco barco;
    private Vikingo vikingo;
    private Lobo lobo;
    private Caperucita caperucita;
    private Uva uva;

    public Controller() {
        barco = new Barco();
        vikingo = new Vikingo();
        lobo = new Lobo();
        caperucita = new Caperucita();
        uva = new Uva();
    }

    public void ejecutarEscenario() {
        System.out.println("Iniciando el escenario del cruce del río...");

        barco.llevarObjeto(vikingo, caperucita);
        barco.dejarpasajero(caperucita);

        barco.llevarObjeto(vikingo, null);

        barco.llevarObjeto(vikingo, lobo);
        barco.dejarpasajero(lobo);

        barco.llevarObjeto(vikingo, caperucita);
        barco.dejarpasajero(caperucita);

        barco.llevarObjeto(vikingo, uva);
        barco.dejarpasajero(uva);

        barco.llevarObjeto(vikingo, null);

        barco.llevarObjeto(vikingo, caperucita);
        barco.dejarpasajero(caperucita);

        System.out.println("\nTodos cruzaron el río sin incidentes. ¡Problema resuelto!");
        System.out.println("Fin del escenario.");
    }
}
