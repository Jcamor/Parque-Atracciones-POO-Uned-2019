
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Clase Menu para los menús
 *
 * @author Juan Carlos Amor Gutiérrez
 * @version (1.0 05/05/2019)
 */
public class Menu {

    private boolean ventaAnticipada; // Controla la venta por internet
    private boolean entradaFamilia; //Controla las entradas familiares

    public ArrayList<Cliente> clientes;
    public ArrayList<Empleado> empleados;
    public ArrayList<Atracciones> atracciones;
    
     /**
     * Constructor de objetos para la clase Menu
     *
     * @param clientes
     * @param empleados
     * @param atracciones
     * @param ventaAnticipada
     * @param entradaFamilia
     * 
     */

    public Menu(ArrayList<Cliente> clientes, ArrayList<Empleado> empleados,
            ArrayList<Atracciones> atracciones) {
        this.clientes = clientes;
        this.empleados = empleados;
        this.atracciones = atracciones;
        this.ventaAnticipada = false;
        this.entradaFamilia = false;
    }
    
    // Menu Principal del Programa
    public void menuPrincipal() {
        cargarDatos(); // Cargamos los datos en los arraysList
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opción del usuario
        limpiarPantalla();
        while (!salir) {
            System.out.println("    MENU PARQUE DE ATRACCIONES");
            System.out.println("    ==========================");
            System.out.println("      [1]. Menu Entradas");
            System.out.println("      [2]. Menu Empleados");
            System.out.println("      [3]. Menu Datos Estadísticos");
            System.out.println("      [4]. Menu Atracciones");
            System.out.println("      [5]. Salir");

            try {

                System.out.println("\n\n\n");
                System.out.println("    Escribe una de las opciones del menú");
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
                        // Le pasamos los ArrayList para mostrar las estadísticas
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
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                limpiarPantalla();
                System.out.println("Solo números entre 1 y 5");
                sn.next();
            }
        }
    }

    public void menuEntradasPrincipal() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        ventaAnticipada = false;
        int opcion; //Guardaremos la opción del menú
        limpiarPantalla();
        while (!salir) {
            System.out.println("    MENU ENTRADAS ");
            System.out.println("    ==============");
            System.out.println("      [1]. Entradas para el Día");
            System.out.println("      [2]. Entradas por Internet");
            System.out.println("      [3]. Regresar al Menú Principal");

            try {

                System.out.println("\n\n\n");
                System.out.println("    Escribe una de las opciones del menú");
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
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                limpiarPantalla();
                System.out.println("Solo números del 1 al 3");
                sn.next();
            }
        }

    }

    //Menú para las entradas tanto del día como de anticipadas
    public void menuEmitirEntradas() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        entradaFamilia = false;
        int opcion; //Guardaremos la opcion del menú
        limpiarPantalla();
        while (!salir) {
            System.out.println("    MENU EMITIR ENTRADAS ");
            System.out.println("    =====================");
            System.out.println("      [1]. Entrada Individual");
            System.out.println("      [2]. Entradas família");
            System.out.println("      [3]. Regresar al Menú anterior");

            try {

                System.out.println("\n\n\n");
                System.out.println("    Escribe una de las opciones del menú");
                System.out.print("    > ");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        limpiarPantalla();
                        // le pasamos si es venta anticipada, si está dentro de una familiar y el arrayList de clientes
                        Entrada entrada = new Entrada(ventaAnticipada, entradaFamilia, clientes);
                        entradaFamilia = false;
                        entrada.menuGenerarEntrada();
                        break;
                    case 2:
                        limpiarPantalla();
                        entradaFamilia = true;  // ponemos verdadera la entrada família,
                                                //creamos el objetos y generamos la entrada
                        Entrada entradafamiliar = new Entrada(ventaAnticipada, entradaFamilia, clientes);
                        entradafamiliar.menuGenerarEntrada();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        limpiarPantalla();
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

    public void limpiarPantalla() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }

    public void menuEmpleados() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        while (!salir) {
            System.out.println("\n\n\n\n\n\n");
            System.out.println("    MENU EMPLEADOS ");
            System.out.println("    ===============");
            System.out.println("      [1]. Añadir Empleado");
            System.out.println("      [2]. Borrar Empleado");
            System.out.println("      [3]. Listar Empleado");
            System.out.println("      [4]. Salir");

            try {

                System.out.println("\n\n\n");
                System.out.println("    Escribe una de las opciones del menú");
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
        int opcion; 
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

        System.out.print("Dirección: ");
        direccion = sn.nextLine();
        System.out.println();
        boolean salir = false;
        while (!salir) {
            try {
                System.out.print("Teléfono: ");
                telefono = sn.nextInt();
                System.out.println();
                salir = true;
            } catch (InputMismatchException e) {

                System.out.println("\n\n");
                System.out.println("Solo números para el teléfono");
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
                System.out.println("      [1]. Atención al Cliente");
                System.out.println("      [2]. Relaciones Públicas");
                System.out.println("      [3]. Responsables de Atracción");
                System.out.println("      [4]. Ayudante de Atracción");
                System.out.println();
                System.out.println("    Escribe uno de los puestos");
                System.out.print("    > ");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        puesto = "Atención al cliente";
                        sueldoMes = sueldoBase * 1.10;
                        salir = true;
                        break;
                    case 2:
                        puesto = "Relaciones Públicas";
                        sueldoMes = sueldoBase * 1.20;
                        salir = true;
                        break;
                    case 3:
                        puesto = "Responsables de Atracción";
                        sueldoMes = sueldoBase * 1.15;
                        salir = true;
                        break;
                    case 4:
                        puesto = "Ayudante de Atracción";
                        sueldoMes = sueldoBase;
                        salir = true;
                        break;
                    default:
                        System.out.println("\n\n");
                        System.out.println("Solo números entre 1 y 4");
                        System.out.println("\n\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Solo números");
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
            System.out.println("Dirección: " + emplea.getDireccion());
            System.out.println("Teléfono: " + emplea.getTelefono());
            System.out.println("Puesto: " + emplea.getPuesto());
            System.out.println("Sueldo Mes: " + emplea.getSueldoMes());
            System.out.println();

        }
    }
    
    // Menú para gestionar atracciones
    public void menuAtracciones() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        while (!salir) {
            System.out.println("\n\n\n\n\n\n");
            System.out.println("    MENU ATRACCIONES");
            System.out.println("    ================");
            System.out.println("      [1]. Añadir Atracciones");
            System.out.println("      [2]. Borrar Atracciones");
            System.out.println("      [3]. Listar Atracciones");
            System.out.println("      [4]. Salir");

            try {

                System.out.println("\n\n\n");
                System.out.println("    Escribe una de las opciones del menú");
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

        try {
            System.out.println("\n\n\n\n\n\n");
            System.out.println("    MENU AGREGAR ATRACCIONES");
            System.out.println("    ========================");
            System.out.println("\n\n\n\n");
            System.out.print("Atracciones Tipo A ¿Cuantas?(4) >");
            numeroTipoA = sn.nextInt();
            System.out.println();
            System.out.print("Atracciones Tipo B ¿Cuantas?(6) >");
            numeroTipoB = sn.nextInt();
            System.out.println();
            System.out.print("Atracciones Tipo C ¿Cuantas?(4) >");
            numeroTipoC = sn.nextInt();
            System.out.println();
            System.out.print("Atracciones Tipo D ¿Cuantas?(3) >");
            numeroTipoD = sn.nextInt();
            System.out.println();
            System.out.print("Atracciones Tipo E ¿Cuantas?(7) >");
            numeroTipoE = sn.nextInt();
        } catch (InputMismatchException e) {
            limpiarPantalla();
            System.out.println("\n\n");
            System.out.println("Solo números");
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

        }
    }

    public void listarAtracciones() {
        int sumaAyudantes = 0;
        int atencionCliente = 0;
        int relacionesPublicas = 0;
        int sumaResponsables = 0;
        double gastoPersonal = 0;

        for (Atracciones atraccion : atracciones) {
            System.out.println("\n\n");
            System.out.println("Atracciones " + atraccion.toString()
                    + "  Número de atracciones funcionando "
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
            System.out.println("Número de Ayudantes de Atraccion: "
                    + atraccion.getAyudantesAtraccion());
            sumaAyudantes = sumaAyudantes + 1 + atraccion.getAyudantesAtraccion();
        }
        // Para decir cuantos empleados se necesitan y el coste de de ellos, tanto mensual como anual
        if (sumaAyudantes != 0) {
            for (Atracciones atraccion : atracciones) {
                sumaAyudantes = sumaAyudantes + atraccion.getAyudantesAtraccion();
                sumaResponsables++;
            }
            atencionCliente = (int) ((sumaAyudantes + sumaResponsables) * 0.3);
            relacionesPublicas = (int) ((sumaAyudantes + sumaResponsables) * 0.1);
            System.out.println("Se necesitan " + atencionCliente
                    + " empleados de Atención al Cliente");
            System.out.println("Se necesitan " + relacionesPublicas
                    + " empleados de Relaciones Públicas");
            gastoPersonal = ((sumaAyudantes * 950) + (sumaResponsables * 1092.5)
                    + (atencionCliente * 1045) + (relacionesPublicas * 1140));
            System.out.println("El Gasto Mensual de Personal: " + gastoPersonal + " euros");
            System.out.println("El Gasto Anual de Personal: " + (gastoPersonal * 12) + " euros");
        }

    }

    public void borrarAtracciones() {
        System.out.println("\n\n\n\n\n");
        if (preguntasVarias("Deseas borrar todas las Atracciones")) {
            atracciones.clear();
        }
    }
    // Este método lo he creado para verificar si responde "s/n" y no diferencie entre mayúsculas y minísculas
    // me devuelve verdadero o falso a la pregunta
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

        // Objetos para cargar los datos a los ArrayList, para pruebas de estadísticas
    public void cargarDatos() {
        Nino entradaNino1 = new Nino("25369784S", "José Martinez", 8, 95, "25/02/2019",
                false, true, false, 50, "36999999Z");
        clientes.add(entradaNino1);
        Adulto entradaAdulto1 = new Adulto("58988785F", "Pedro Prieto", 35, 185, "11/03/2019",
                true, true, false, 100,
                false, false, false);
        clientes.add(entradaAdulto1);
        Senior entradaSenior1 = new Senior("5846987A", "Rogélio Gonzalez", 76, 175, "06/08/2019",
                true, false, false, 26.3);
        clientes.add(entradaSenior1);
        Nino entradaNino2 = new Nino("2587456H", "Francisco Trigo", 3, 75, "25/02/2019",
                false, true, false, 50, "3555559Z");
        clientes.add(entradaNino2);
        Adulto entradaAdulto2 = new Adulto("5256475F", "María Gracia", 55, 175, "11/09/2019",
                true, false, true, 85.5,
                false, true, false);
        clientes.add(entradaAdulto2);
        Senior entradaSenior2 = new Senior("5846987A", "Amáncio Silva", 66, 165, "06/01/2019",
                true, true, false, 56.3);
        clientes.add(entradaSenior2);
        Nino entradaNino3 = new Nino("2566997K", "Eva López", 10, 115, "25/12/2019",
                true, true, false, 45, "369745879Z");
        clientes.add(entradaNino3);
        Adulto entradaAdulto3 = new Adulto("58988785F", "María Prieto", 15, 135, "11/06/2019",
                true, true, false, 80,
                false, false, false);
        clientes.add(entradaAdulto3);
        Senior entradaSenior3 = new Senior("5846987A", "Gerardo Rivas", 76, 175, "06/11/2019",
                true, false, true, 56.3);
        clientes.add(entradaSenior3);

        Empleado emple1 = new Empleado("66958448T", "María Lopez", "c/ Nueva, 14", 68792554, "Relaciones Publicas", 1092.5);
        empleados.add(emple1);
        Empleado emple2 = new Empleado("66898544G", "José Martinez", "c/ Vieja, 89", 68799634, "Ayudante de Atraccion", 950);
        empleados.add(emple2);
        Empleado emple3 = new Empleado("98745684R", "Nuria Blazquez", "c/ Granvia, 1", 68743554, "Atencion al cliente", 1045);
        empleados.add(emple3);

        TipoA atraccionA = new TipoA(4);
        atracciones.add(atraccionA);
        TipoB atraccionB = new TipoB(6);
        atracciones.add(atraccionB);
        TipoC atraccionC = new TipoC(4);
        atracciones.add(atraccionC);
        TipoD atraccionD = new TipoD(3);
        atracciones.add(atraccionD);
        TipoE atraccionE = new TipoE(7);
        atracciones.add(atraccionE);
    }
}
