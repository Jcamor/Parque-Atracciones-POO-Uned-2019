
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Write a description of class Estadisticas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Estadisticas {

    // instance variables - replace the example below with your own
    public ArrayList<Cliente> clientes;
    public ArrayList<Empleado> empleados;
    public ArrayList<Atracciones> atracciones;

    /**
     * Constructor for objects of class Estadisticas
     *
     * @param clientes
     * @param empleados
     * @param atracciones
     */
    public Estadisticas(ArrayList clientes, ArrayList empleados, ArrayList atracciones) {
        this.clientes = clientes;
        this.empleados = empleados;
        this.atracciones = atracciones;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param y a sample parameter for a method
     * @return the sum of x and y
     */
    public void menuEstadisticas() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        limpiarPantalla();
        while (!salir) {
            System.out.println("    MENU ESTADISTICAS PARQUE DE ATRACCIONES");
            System.out.println("    =======================================");
            System.out.println("      [1]. Numero de Visitantes");
            System.out.println("      [2]. Precio Medio de la Entrada");
            System.out.println("      [3]. Visitas medias registradas");
            System.out.println("      [4]. Resumen anual del gasto de personal");
            System.out.println("      [5]. Salir");

            try {

                System.out.println("\n\n\n");
                System.out.println("    Escribe una de las opciones del menu");
                System.out.print("    > ");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        numeroDeVisitantes();
                        break;
                    case 2:
                        //   precioMedioEntrada();
                        break;
                    case 3:
                    //   visitasMedias()
                    case 4:
                        //   resumenGastoPersonal();
                        break;
                    case 5:
                        salir = true;
                        break;
                        
                    default:
                        limpiarPantalla();
                        System.out.println("\n\n");
                        System.out.println("Solo numeros entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                limpiarPantalla();
                System.out.println("\n\n");
                System.out.println("Solo numeros entre 1 y 5");
                sn.next();
            }
        }

    }

    public void numeroDeVisitantes() {

        String fechaFormato = "dd/MM/yyyy";
        SimpleDateFormat formatoFecha = new SimpleDateFormat(fechaFormato);
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < 12; i++) {
            for (Cliente cliente : clientes) {
                try {
                    cal.setTime(formatoFecha.parse(cliente.getFechaEntrada()));
                } catch (ParseException ex) {
                  //  Logger.getLogger(Estadisticas.class.getName()).log(Level.SEVERE, null, ex);
                }
                if ((cal.get(Calendar.MONTH)) == i) {
                    System.out.println("Mes: " +(i+1));
                    System.out.println("Dia: "+ cal.get(Calendar.DAY_OF_MONTH));
                }
                //int numeroDia = cal.get(Calendar.DAY_OF_MONTH);
                //System.out.println("Dia " + numeroDia);
                //int numeroMes = (cal.get(Calendar.MONTH) + 1);
                //System.out.println("Mes " + numeroMes);
            }
        }
    }

    public void limpiarPantalla() {
        System.out.println("\n\n\n\n\n\n");

    }
}
