import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Write a description of class Entradas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu
{
    /**
     * Constructor for objects of class Entradas
     */
	private boolean ventaAnticipada = false;
	
    public Menu()
    {
        // initialise instance variables
    }
    
    public void menuPrincipal(){
        
       
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        limpiarPantalla();
        while (!salir) {
            System.out.println("\n\n\n\n");
            System.out.println("    MENU PARQUE DE ATRACCIONES");
            System.out.println("    ==========================");
            System.out.println("      [1]. Menu Entradas");
            System.out.println("      [2]. Menu Empleados");
            System.out.println("      [3]. Menu Datos EstadÃ­sticos");
            System.out.println("      [4]. Salir");
 
            try {
 
                System.out.println("\n\n\n");
                System.out.println("    Escribe una de las opciones del menu");
                System.out.print("    > ");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        menuEntradasPrincipal();
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        limpiarPantalla();
                        System.out.println("\n\n");
                        System.out.println("Solo nÃºmeros entre 1 y 4");
                        //System.out.println("\n\n");
                }
            } catch (InputMismatchException e) {
                limpiarPantalla();
                System.out.println("\n\n");
                System.out.println("Solo nÃºmeros entre 1 y 4");
                //System.out.println("\n\n");
                sn.next();
            }
        }        
    }
    
    public void menuEntradasPrincipal(){
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        limpiarPantalla();
        while (!salir) {
            System.out.println("\n\n\n\n");
            System.out.println("    MENU ENTRADAS PARQUE DE ATRACCIONES");
            System.out.println("    ===================================");
            System.out.println("      [1]. Entradas para el Día");
            System.out.println("      [2]. Entradas por Internet");
            System.out.println("      [3]. Validar entradas por Internet");
            System.out.println("      [4]. Regresar al Menu Principal");
        
            try {
 
                System.out.println("\n\n\n");
                System.out.println("    Escribe una de las opciones del menu");
                System.out.print("    > ");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                    
                        menuEmitirEntradas();
                        break;
                    case 2:
                        ventaAnticipada = true;
                        menuEmitirEntradas();
                        break;
                    case 3:
                        
                        System.out.println("Has seleccionado la opcion 3");
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        limpiarPantalla();
                        System.out.println("\n\n");
                        System.out.println("Solo números entre 1 y 4");
                       // System.out.println("\n\n");
                }
            } catch (InputMismatchException e) {
                limpiarPantalla();
                System.out.println("\n\n");
                System.out.println("Solo números del 1 al 4");
                //System.out.println("\n\n");
                sn.next();
            }
        }
    
    }
    
    public void menuEmitirEntradas(){
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        limpiarPantalla();
        while (!salir) {
            System.out.println("\n\n\n\n");
            System.out.println("    MENU EMITIR ENTRADAS PARQUE DE ATRACCIONES");
            System.out.println("    ==========================================");
            System.out.println("      [1]. Entrada Individual");
            System.out.println("      [2]. Entradas familia");
            System.out.println("      [3]. Regresar al Menu anterior");
        
            try {
 
                System.out.println("\n\n\n");
                System.out.println("    Escribe una de las opciones del menu");
                System.out.print("    > ");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        limpiarPantalla();
                        Entrada entrada = new Entrada();
                        entrada.menuGenerarEntrada(ventaAnticipada);
                        break;
                    case 2:
                        
                        System.out.println("Has seleccionado la opcion 2");
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        limpiarPantalla();
                        System.out.println("\n\n");
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                limpiarPantalla();
                System.out.println("\n\n");
                System.out.println("Solo números del 1 al 3");
                sn.next();
            }
        }
    
    }
  
    
    public void limpiarPantalla(){
        try {

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            } catch (Exception e) {}
    }
}
