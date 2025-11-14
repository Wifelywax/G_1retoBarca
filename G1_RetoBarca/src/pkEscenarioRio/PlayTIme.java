// package pkEscenarioRio;

// import pkEscenarioRio.pkSujeto.Caperucita;
// import pkEscenarioRio.pkSujeto.Lobo;
// import pkEscenarioRio.pkSujeto.Vikingo;
// import pkEscenarioRio.pkSujeto.Uva;
// import java.util.Scanner;

// public class PlayTIme {
    
//     static Scanner sc = new Scanner(System.in);
//     static char option;
//     static char eleccionPersonaje;
//     private static Barco barco;
//     private static Vikingo vikingo;
//     private static Lobo lobo;
//     private static Caperucita caperucita;
//     private static Uva uva;

//     public static void seleccionPersonaje(){
//         do{
//                 System.out.println("BIENVENIDO AVENTURERO! QUIERES JUGAR? (s/n)");
//                 option = sc.nextLine().charAt(0);
//                 switch (option) {
//                     case 'n':
//                         System.out.println("FIN DEL JUEGO... ¿Quieres volver a jugar? (s/n)");
//                         option = sc.nextLine().charAt(0);
//                         break;
//                     case 's':
//                         System.out.println("Usted es un crack.");

//                         System.out.println("PERSONAJES DISPONIBLES ");

//                         do{
//                             System.out.println("Eija el primer personaje (digite la inicial del personaje): ");
//                             int i = 1;
//                             if (!vikingo.getCruzoAlOtroLado()){
//                                 System.out.println(i + ". " + " Vikingo");
//                                 i++;
//                             }
//                             if (!caperucita.getCruzoAlOtroLado()){
//                                 System.out.println(i + ". " + " Caperucita");
//                                 i++;
//                             }
//                             if (!lobo.getCruzoAlOtroLado()){
//                                 System.out.println(i + ". " + " Lobo");
//                                 i++;
//                             }
//                             if (!uva.getCruzoAlOtroLado()){
//                                 System.out.println(i + ". " + " Uva");
//                                 i++;
//                             }
//                             eleccionPersonaje = sc.nextLine().charAt(0);
//                             switch (eleccionPersonaje) {
//                                 case 'v':
//                                     vikingo.setSubioAlBarco(true);
//                                     break;
//                                 case 'c':
//                                     caperucita.setSubioAlBarco(true);
//                                     break;
//                                 case 'l':
//                                     lobo.setSubioAlBarco(true);
//                                     break;
//                                 case 'u':
//                                     uva.setSubioAlBarco(true);
//                                 default:
//                                     System.out.println("ERROR: Eliga nuevamente");
//                                     eleccionPersonaje = 'e';
//                                     break;
//                             }
//                         } while (eleccionPersonaje == 'e');

//                         //Eleccion 2do personaje:
//                         do{
//                             System.out.println("Eija el segundo personaje (digite la inicial del personaje): ");
//                             int i = 1;
//                             if (!vikingo.getSubioAlBarco()){
//                                 System.out.println(i + ". " + " Vikingo");
//                                 i++;
//                             }
//                             if (!caperucita.getSubioAlBarco()){
//                                 System.out.println(i + ". " + " Caperucita");
//                                 i++;
//                             }
//                             if (!lobo.getSubioAlBarco()){
//                                 System.out.println(i + ". " + " Lobo");
//                                 i++;
//                             }
//                             if (!uva.getSubioAlBarco()){
//                                 System.out.println(i + ". " + " Uva");
//                                 i++;
//                             }
//                             eleccionPersonaje = sc.nextLine().charAt(0);
//                             switch (eleccionPersonaje) {
//                                 case 'v':
//                                     vikingo.setSubioAlBarco(true);
//                                     break;
//                                 case 'c':
//                                     caperucita.setSubioAlBarco(true);
//                                     break;
//                                 case 'l':
//                                     lobo.setSubioAlBarco(true);
//                                     break;
//                                 case 'u':
//                                     uva.setSubioAlBarco(true);
//                                 default:
//                                     System.out.println("ERROR: Eliga nuevamente");
//                                     eleccionPersonaje = 'e';
//                                     break;
//                             }
//                         } while (eleccionPersonaje == 'e');

//                         break;
//                     default:
//                         System.out.println("ERROR: Digite nuevamente");    
//                         break;
//                 }

//             }while (option != 'n');
//     }



// }
