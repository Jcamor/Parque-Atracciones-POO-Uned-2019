
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
    public ArrayList<Atracciones> atracciones;

    public Menu(ArrayList<Cliente> clientes, ArrayList<Empleado> empleados,
            ArrayList<Atracciones> atracciones) {
        this.clientes = clientes;
        this.empleados = empleados;
        this.atracciones = atracciones;
    }

    public void menuPrincipal() {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        limpiarPantalla();
        while (!salir) {
            System.out.println("    MENU PARQUE DE ATRACCIONES");
            System.out.println("    ==========================");
            System.out.println("      [1]. Menu Entradas");
            System.out.println("      [2]. Menu Empleados");
            System.out.println("      [3]. Menu Datos Estadisticos");
            System.out.println("      [4]. Menu Atracciones");
            System.out.println("      [5]. Salir");

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
                        Estadisticas estadistica = new Estadisticas(clientes, empleados, atracciones);
                        estadistica.menuEstadisticas();
                        break;
                    case 4:
                        menuAtracciones();
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

    public void menuEntradasPrincipal() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        ventaAnticipada = false;
        int opcion; //Guardaremos la opcion del usuario
        limpiarPantalla();
        while (!salir) {
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
                        ventaAnticipada = false;
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
        salir = false;
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

    public void menuAtracciones() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        while (!salir) {
            System.out.println("\n\n\n\n\n\n");
            System.out.println("    MENU ATRACCIONES PARQUE ATRACCIONES");
            System.out.println("    ===================================");
            System.out.println("      [1]. Añadir Atracciones");
            System.out.println("      [2]. Borrar Atracciones");
            System.out.println("      [3]. Listar Atracciones");
            System.out.println("      [4]. Salir");

            try {

                System.out.println("\n\n\n");
                System.out.println("    Escribe una de las opciones del menu");
                System.out.print("    > ");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        agregarAtracciones();
                        break;
                    case 2:
                        borrarAtracciones();
                        break;
                    case 3:
                        listarAtracciones();
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

    public void agregarAtracciones() {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int numeroTipoA = 0;
        int numeroTipoB = 0;
        int numeroTipoC = 0;
        int numeroTipoD = 0;
        int numeroTipoE = 0;
        boolean correcto = false;
        int sumaAyudantes = 0;
        int atencionCliente = 0;
        int relacionesPublicas = 0;
        try {
            System.out.println("\n\n\n\n\n\n");
            System.out.println("    MENU AGREGAR ATRACCIONES");
            System.out.println("    ========================");
            System.out.println("\n\n\n\n");
            System.out.print("Atracciones Tipo A ¿Cuantas? >");
            numeroTipoA = sn.nextInt();
            System.out.println();
            System.out.print("Atracciones Tipo B ¿Cuantas? >");
            numeroTipoB = sn.nextInt();
            System.out.println();
            System.out.print("Atracciones Tipo C ¿Cuantas? >");
            numeroTipoC = sn.nextInt();
            System.out.println();
            System.out.print("Atracciones Tipo D ¿Cuantas? >");
            numeroTipoD = sn.nextInt();
            System.out.println();
            System.out.print("Atracciones Tipo E ¿Cuantas? >");
            numeroTipoE = sn.nextInt();
        } catch (InputMismatchException e) {
            limpiarPantalla();
            System.out.println("\n\n");
            System.out.println("Solo numeros");
            sn.next();
        }
        System.out.println();
        System.out.println("    RESUMEN");
        System.out.println("    =======\n");
        System.out.println("Atracciones Tipo A: " + numeroTipoA);
        System.out.println("Atracciones Tipo B: " + numeroTipoB);
        System.out.println("Atracciones Tipo C: " + numeroTipoC);
        System.out.println("Atracciones Tipo D: " + numeroTipoD);
        System.out.println("Atracciones Tipo E: " + numeroTipoE);
        correcto = preguntasVarias("Son correctas las atracciones");
        if (correcto = true) {
            TipoA atraccionA = new TipoA(numeroTipoA);
            atracciones.add(atraccionA);
            TipoB atraccionB = new TipoB(numeroTipoB);
            atracciones.add(atraccionB);
            TipoC atraccionC = new TipoC(numeroTipoC);
            atracciones.add(atraccionC);
            TipoD atraccionD = new TipoD(numeroTipoD);
            atracciones.add(atraccionD);
            TipoE atraccionE = new TipoE(numeroTipoE);
            atracciones.add(atraccionE);
            for (Atracciones atraccion : atracciones) {
                sumaAyudantes = sumaAyudantes + 1 + atraccion.getAyudantesAtraccion();
            }
            atencionCliente = (int) (sumaAyudantes * 0.3);
            relacionesPublicas = (int) (sumaAyudantes * 0.1);
            System.out.println("Se necesitan " + atencionCliente
                    + " empleados de Atencion al Cliente");
            System.out.println("Se necesitan " + relacionesPublicas
                    + " empleados de Relaciones Publicas");
        }
    }

    public void listarAtracciones() {
        int sumaAyudantes = 0;
        int atencionCliente = 0;
        int relacionesPublicas = 0;
        for (Atracciones atraccion : atracciones) {
            System.out.println("\n\n");
            System.out.println("Atracciones " + atraccion.toString()
                    + "  Numero de atracciones funcionando "
                    + atraccion.getNumeroDeAtracciones());
            if (atraccion.esAdulto() || atraccion.esSenior()) {
                System.out.println("Permitido Adultos");
            }
            if (atraccion.esNino()) {
                System.out.println("Permitido Niños");
            }
            if (atraccion.esVip()) {
                System.out.println("Se permite el pase VIP");
            }
            System.out.println("Numero de Ayudantes de Atraccion: "
                    + atraccion.getAyudantesAtraccion());
            sumaAyudantes = sumaAyudantes + 1 + atraccion.getAyudantesAtraccion();
        }
        if (sumaAyudantes != 0) {
            atencionCliente = (int) (sumaAyudantes * 0.3);
            relacionesPublicas = (int) (sumaAyudantes * 0.1);
            System.out.println("\n\nSe necesitan " + atencionCliente
                    + " empleados de Atencion al Cliente");
            System.out.println("Se necesitan " + relacionesPublicas
                    + " empleados de Relaciones Publicas");
        }

    }

    public void borrarAtracciones() {
        System.out.println("\n\n\n\n\n");
        if (preguntasVarias("Deseas borrar todas las Atracciones")) {
            atracciones.clear();
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
