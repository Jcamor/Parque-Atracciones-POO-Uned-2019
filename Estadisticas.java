
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Para las estadísticas del parque Clientes, Empleados y Atracciones
 *
 * @author Juan Carlos Amor Gutiérrez
 * @version (1.0 05/05/2019)
 */
public class Estadisticas {

    // Declaramos los ArrayList
    public ArrayList<Cliente> clientes;
    public ArrayList<Empleado> empleados;
    public ArrayList<Atracciones> atracciones;

    /**
     * Constructor de objetos para la clase Estadísticas
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

    public void menuEstadisticas() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opción del menú
        System.out.println("\n\n\n\n\n\n");
        while (!salir) {
            System.out.println("    MENU ESTADISTICAS ");
            System.out.println("    ==================");
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
                        precioMedioEntrada();
                        break;
                    case 3:
                        visitasMedias();
                    case 4:
                        gastoPersonal();
                        break;
                    case 5:
                        salir = true;
                        break;

                    default:
                         System.out.println("\n\n\n\n\n\n");                        
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {                
                 System.out.println("\n\n\n\n\n\n");
                System.out.println("Solo números entre 1 y 5");
                sn.next();
            }
        }

    }
    // El número de visitantes por meses
    public void numeroDeVisitantes() {

        String fechaFormato = "dd/MM/yyyy";
        SimpleDateFormat formatoFecha = new SimpleDateFormat(fechaFormato);
        Calendar cal = Calendar.getInstance(); // Instanciamos el objeto Calendar
        for (int i = 0; i < 12; i++) {
            for (Cliente cliente : clientes) {
                try {
                    // Lo convertimos a formato calendar con parse
                    cal.setTime(formatoFecha.parse(cliente.getFechaEntrada()));
                } catch (ParseException ex) {
                }
                // Nos da el mes empezando de 0 para enero,...
                if ((cal.get(Calendar.MONTH)) == i) {
                    switch (i + 1) {
                        case 1:
                            System.out.println("Mes de Enero: ");
                            System.out.println("Fecha: " + cliente.getFechaEntrada()
                                    + " Nombre: " + cliente.getNombre());
                            System.out.println();
                            break;
                        case 2:
                            System.out.println("Mes de Febrero: ");
                            System.out.println("Fecha: " + cliente.getFechaEntrada()
                                    + " Nombre: " + cliente.getNombre());
                            System.out.println();
                            break;
                        case 3:
                            System.out.println("Mes de Marzo: ");
                            System.out.println("Fecha: " + cliente.getFechaEntrada()
                                    + " Nombre: " + cliente.getNombre());
                            System.out.println();
                            break;
                        case 4:
                            System.out.println("Mes de Abril: ");
                            System.out.println("Fecha: " + cliente.getFechaEntrada()
                                    + " Nombre: " + cliente.getNombre());
                            System.out.println();
                            break;
                        case 5:
                            System.out.println("Mes de Mayo: ");
                            System.out.println("Fecha: " + cliente.getFechaEntrada()
                                    + " Nombre: " + cliente.getNombre());
                            System.out.println();
                            break;
                        case 6:
                            System.out.println("Mes de Junio: ");
                            System.out.println("Fecha: " + cliente.getFechaEntrada()
                                    + " Nombre: " + cliente.getNombre());
                            System.out.println();
                            break;
                        case 7:
                            System.out.println("Mes de Julio: ");
                            System.out.println("Fecha: " + cliente.getFechaEntrada()
                                    + " Nombre: " + cliente.getNombre());
                            System.out.println();
                            break;
                        case 8:
                            System.out.println("Mes de Agosto: ");
                            System.out.println("Fecha: " + cliente.getFechaEntrada()
                                    + " Nombre: " + cliente.getNombre());
                            System.out.println();
                            break;
                        case 9:
                            System.out.println("Mes de Septiembre: ");
                            System.out.println("Fecha: " + cliente.getFechaEntrada()
                                    + " Nombre: " + cliente.getNombre());
                            System.out.println();
                            break;
                        case 10:
                            System.out.println("Mes de Octubre: ");
                            System.out.println("Fecha: " + cliente.getFechaEntrada()
                                    + " Nombre: " + cliente.getNombre());
                            System.out.println();
                            break;
                        case 11:
                            System.out.println("Mes de Noviembre: ");
                            System.out.println("Fecha: " + cliente.getFechaEntrada()
                                    + " Nombre: " + cliente.getNombre());
                            System.out.println();
                            break;
                        case 12:
                            System.out.println("Mes de Diciembre: ");
                            System.out.println("Fecha: " + cliente.getFechaEntrada()
                                    + " Nombre: " + cliente.getNombre());
                            System.out.println();
                            break;
                        default:

                    }

                }

            }
        }
    }

        // Calcular el precio medio de todos los clientes del parque
    public void precioMedioEntrada() {
        int i = 0;
        double totalPrecioEntrada = 0;
        for (Cliente cliente : clientes) {
            totalPrecioEntrada = totalPrecioEntrada + cliente.esPrecioEntrada();
            i++;
        }
        if (i != 0) {
            System.out.println("\n\n\n");
            // Para tener solo 2 decimales con un String.format
            System.out.println("El precio medio de la entrada es: "
                    + String.format("%.2f", (totalPrecioEntrada / i)));
            System.out.println("\n\n\n");
        }
    }

        // Calcular las visitas medias por dias, meses, etc..
    public void visitasMedias() {

    }

        // Calcular el gasto personal por meses y por años
    public void gastoPersonal() {
        int sumaAyudantes = 0;
        int sumaResponsables = 0;
        int atencionCliente = 0;
        int relacionesPublicas = 0;
        double gastoPersonal = 0;

        for (Atracciones atraccion : atracciones) {
            sumaAyudantes = sumaAyudantes
                    + (atraccion.getAyudantesAtraccion() * atraccion.getNumeroDeAtracciones());
            sumaResponsables = sumaResponsables + atraccion.getNumeroDeAtracciones();
        }
        atencionCliente = (int) ((sumaAyudantes + sumaResponsables) * 0.3);
        relacionesPublicas = (int) ((sumaAyudantes + sumaResponsables) * 0.1);
        gastoPersonal = ((sumaAyudantes * 950) + (sumaResponsables * 1092.5)
                + (atencionCliente * 1045) + (relacionesPublicas * 1140));
        System.out.println("\n\n");
        System.out.println("Gasto Mensual");
        System.out.println("Ayudantes de Atracciones: " + sumaAyudantes
                + "  Total Ayudantes: " + (sumaAyudantes * 950) + " euros");
        System.out.println("Responsables de Atracciones: " + sumaResponsables
                + "  Total Responsables: " + (sumaResponsables * 1092.5 + " euros"));
        System.out.println("Atencion al Cliente: " + atencionCliente
                + "  Total Atencion al Cliente: " + (atencionCliente * 1045 + " euros"));
        System.out.println("Relaciones Publicas: " + relacionesPublicas
                + "  Total Relaciones Publicas: " + (relacionesPublicas * 1140 + " euros"));
        System.out.println("El Gasto Mensual de Personal: " + gastoPersonal + " euros");
        System.out.println("\n\n");
        System.out.println("Gasto Anual");
        System.out.println("Ayudantes de Atracciones: " + ((sumaAyudantes * 950) * 12) + " euros");
        System.out.println("Responsables de Atracciones: " + ((sumaResponsables * 1092.5) * 12) + " euros");
        System.out.println("Atencion al Cliente: " + ((atencionCliente * 1045) * 12) + " euros");
        System.out.println("Relaciones Publicas: " + ((relacionesPublicas * 1140) * 12) + " euros");
        System.out.println("El Gasto Anual de Personal: " + (gastoPersonal * 12) + " euros");
        System.out.println("\n\n");
    }

    @Override
    public String toString() {
        return "Estadisticas{" + "clientes=" + clientes + ", empleados=" + empleados
                + ", atracciones=" + atracciones + '}';
    }
}
