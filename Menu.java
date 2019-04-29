
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Write a description of class Entradas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Menu {

    /**
     * Constructor for objects of class Entradas
     */
    private boolean ventaAnticipada = false;
    private boolean entradaFamilia = false;

    public ArrayList<Cliente> clientes;
    public ArrayList<Empleado> empleados;

    public Menu(ArrayList<Cliente> clientes, ArrayList<Empleado> empleados) {
        this.clientes = clientes;
        this.empleados = empleados;
    }

    public void menuPrincipal() {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        limpiarPantalla();
        while (!salir) {
            //System.out.println("\n\n\n\n");
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
                        menuEmpleados();
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
                        System.out.println("Solo numeros entre 1 y 4");
                    //System.out.println("\n\n");
                }
            } catch (InputMismatchException e) {
                limpiarPantalla();
                System.out.println("\n\n");
                System.out.println("Solo numeros entre 1 y 4");
                //System.out.println("\n\n");
                sn.next();
            }
        }
    }

    public void menuEntradasPrincipal() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        ventaAnticipada = false;
        int opcion; //Guardaremos la opcion del usuario
        limpiarPantalla();
        while (!salir) {
            //System.out.println("\n\n\n\n");
            System.out.println("    MENU ENTRADAS PARQUE DE ATRACCIONES");
            System.out.println("    ===================================");
            System.out.println("      [1]. Entradas para el Dia");
            System.out.println("      [2]. Entradas por Internet");
            System.out.println("      [3]. Regresar al Menu Principal");

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
                        salir = true;
                        break;
                    default:
                        limpiarPantalla();
                        System.out.println("\n\n");
                        System.out.println("Solo numeros entre 1 y 3");

                }
            } catch (InputMismatchException e) {
                limpiarPantalla();
                System.out.println("\n\n");
                System.out.println("Solo numeros del 1 al 3");
                sn.next();
            }
        }

    }

    public void menuEmitirEntradas() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        entradaFamilia = false;
        int opcion; //Guardaremos la opcion del usuario
        limpiarPantalla();
        while (!salir) {
            //System.out.println("\n\n\n\n");
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
                        entradaFamilia = false;
                        entrada.menuGenerarEntrada(ventaAnticipada, entradaFamilia, clientes);
                        break;
                    case 2:
                        limpiarPantalla();
                        Entrada entradafamiliar = new Entrada();
                        entradaFamilia = true;
                        entradafamiliar.menuGenerarEntrada(ventaAnticipada, entradaFamilia, clientes);
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        limpiarPantalla();
                        System.out.println("\n\n");
                        System.out.println("Solo numeros entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                limpiarPantalla();
                System.out.println("\n\n");
                System.out.println("Solo numeros del 1 al 3");
                sn.next();
            }
        }

    }

    public void limpiarPantalla() {
        System.out.println("\n\n\n\n\n\n");

    }

    public void menuEmpleados() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        while (!salir) {
            System.out.println("\n\n\n\n\n\n");
            System.out.println("    MENU EMPLEADOS PARQUE ATRACCIONES");
            System.out.println("    =================================");
            System.out.println("      [1]. Añadir Empleado");
            System.out.println("      [2]. Borrar Empleado");
            System.out.println("      [3]. Listar Empleado");
            System.out.println("      [4]. Salir");

            try {

                System.out.println("\n\n\n");
                System.out.println("    Escribe una de las opciones del menu");
                System.out.print("    > ");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        agregarEmpleado();
                        break;
                    case 2:
                        borrarEmpleado();
                        break;
                    case 3:
                        listarEmpleados();
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("\n\n");
                        System.out.println("Solo números entre 1 y 4");
                        System.out.println("\n\n");
                }
            } catch (InputMismatchException e) {

                System.out.println("\n\n");
                System.out.println("Solo números entre 1 y 4");
                System.out.println("\n\n");
                sn.next();
            }
        }
    }

    public void agregarEmpleado() {

        Scanner sn = new Scanner(System.in);
        int opcion; //Guardaremos la opcion del usuario
        String dni = "";
        String nombre = "";
        String puesto = "";
        int telefono = 0;
        String direccion = "";
        double sueldoMes = 0;
        double sueldoBase = 950;

        System.out.println();
        System.out.println();
        System.out.println("Introducir datos Empleado");
        System.out.println("=========================");
        System.out.println();

        System.out.print("Dni: ");
        dni = sn.nextLine();
        System.out.println();

        System.out.print("Nombre: ");
        nombre = sn.nextLine();
        System.out.println();

        System.out.print("Direccion: ");
        direccion = sn.nextLine();
        System.out.println();
        boolean salir = false;
        while (!salir) {
            try {
                System.out.print("Telefono: ");
                telefono = sn.nextInt();
                System.out.println();
                salir = true;
            } catch (InputMismatchException e) {

                System.out.println("\n\n");
                System.out.println("Solo números para el telefono");
                System.out.println("\n\n");
                sn.next();
            }
        }
        opcion = 0;
        salir=false;
        while (!salir) {
            try {
                System.out.println("       Puesto de trabajo");
                System.out.println("       =================");
                System.out.println("      [1]. Atencion al Cliente");
                System.out.println("      [2]. Relaciones Publicas");
                System.out.println("      [3]. Responsables de Atraccion");
                System.out.println("      [4]. Ayudante de Atraccion");
                System.out.println();
                System.out.println("    Escribe una de las opciones del puesto");
                System.out.print("    > ");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        puesto = "Atencion al cliente";
                        sueldoMes = sueldoBase * 1.10;
                        salir = true;
                        break;
                    case 2:
                        puesto = "Relaciones Publicas";
                        sueldoMes = sueldoBase * 1.20;
                        salir = true;
                        break;
                    case 3:
                        puesto = "Responsables de Atraccion";
                        sueldoMes = sueldoBase * 1.15;
                        salir = true;
                        break;
                    case 4:
                        puesto = "Ayudante de Atraccion";
                        sueldoMes = sueldoBase;
                        salir = true;
                        break;
                    default:
                        System.out.println("\n\n");
                        System.out.println("Solo números entre 1 y 4");
                        System.out.println("\n\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Solo numeros");
                sn.next();

            }
        }
        Empleado emple = new Empleado(dni, nombre, direccion, telefono, puesto, sueldoMes);
        System.out.println(emple.getDni() + " " + emple.getNombre() + " " + emple.getDireccion()
                + " " + emple.getTelefono() + " " + emple.getPuesto() + " " + emple.getSueldoMes());
        if (empleados.add(emple)) {
            System.out.println();
            System.out.println("El empleado " + emple.getNombre() + " ha sido grabado correctamente");
        } else {
            System.out.println();
            System.out.println("El empleado " + emple.getNombre() + " NO ha sido grabado");
        }
    }

    public void borrarEmpleado() {
        Scanner sn = new Scanner(System.in);
        String dniBorrar = "";
        boolean confirmarBorrar = false;
        System.out.println();
        System.out.print("Introduce DNI del empleado a eliminar: ");
        dniBorrar = sn.nextLine();
        Iterator<Empleado> it = empleados.iterator();
        while (it.hasNext()) {
            Empleado emplea = it.next();
            if (dniBorrar.equalsIgnoreCase(emplea.getDni())) {
                System.out.println();
                System.out.println("Dni: " + emplea.getDni() + " Nombre: " + emplea.getNombre());
                confirmarBorrar = preguntasVarias("Deseas borrar este empleado");
                if (confirmarBorrar) {
                    System.out.println();
                    System.out.println("El empleado " + emplea.getNombre() + " ha sido borrado");
                    empleados.remove(emplea);
                } else {
                    System.out.println();
                    System.out.println("El empleado " + emplea.getNombre() + " NO ha sido borrado");
                }
            } else {
                System.out.println("DNI no encontrado");
            }
        }
    }

    public void listarEmpleados() {
        boolean salir = false;
        for (Empleado emplea : empleados) {
            System.out.println();
            System.out.println("Dni: " + emplea.getDni());
            System.out.println("Nombre: " + emplea.getNombre());
            System.out.println("Direccion: " + emplea.getDireccion());
            System.out.println("Telefono: " + emplea.getTelefono());
            System.out.println("Puesto: " + emplea.getPuesto());
            System.out.println("Sueldo Mes: " + emplea.getSueldoMes());
            System.out.println();

        }
    }

    public boolean preguntasVarias(String pregunta) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        String respuesta = "";
        boolean respuestaDevuelta = false;

        try {
            do {
                System.out.print(pregunta + " (S/N) :");
                respuesta = sn.nextLine();
                if (respuesta.equalsIgnoreCase("s")) {
                    respuestaDevuelta = true;
                    salir = true;
                }
                if (respuesta.equalsIgnoreCase("n")) {
                    respuestaDevuelta = false;
                    salir = true;
                }
                System.out.println();
            } while (!salir);
        } catch (InputMismatchException e) {

        }
        return respuestaDevuelta;
    }
}
