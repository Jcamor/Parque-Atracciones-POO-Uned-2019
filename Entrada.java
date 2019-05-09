
/**
 * Write a description of class Entrada here.
 *
 * @author (Juan Carlos Amor Gutierrez)
 * @version (1.0 05/05/2019)
 */
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Entrada {

    private String dni;
    private String nombre;
    private String dniacompaniante;
    private int edad;
    private int alturaCm;
    private double precioEntrada;
    private boolean diversidadFuncional;
    private boolean carnetJoven;
    private boolean carnetEstudiante;
    private boolean desempleado;
    private boolean entradaTarde;
    private boolean entradaVip;
    private String fechaEntrada;
    private ArrayList<Cliente> clientes;
    private boolean ventaAnticipada;
    private boolean entradaFamilia;

    public Entrada(boolean ventaAnticipada, boolean entradaFamilia, ArrayList<Cliente> clientes) {
        this.dni = "";
        this.nombre = "";
        this.dniacompaniante = "";
        this.edad = 0;
        this.alturaCm = 0;
        this.precioEntrada = 0;
        this.diversidadFuncional = false;
        this.carnetJoven = false;
        this.carnetEstudiante = false;
        this.desempleado = false;
        this.entradaTarde = false;
        this.entradaVip = false;
        this.fechaEntrada = "";
        this.clientes = clientes;
        this.ventaAnticipada = ventaAnticipada;
        this.entradaFamilia = entradaFamilia;
    }

    public void menuGenerarEntrada() {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        boolean todasEntradasVip = false;
        boolean entradaAceptada = false;

        int numeroEntradaFamilia = 0;
        int contadorEntradaFamilia = 0;
        //cargarFechasTempora();
        limpiarPantalla();
        System.out.println("\n\n\n\n");
        System.out.println("Entrada Parque de Atraccciones");
        System.out.println("==============================");
        System.out.println();
        if (entradaFamilia) {
            while (numeroEntradaFamilia < 4) {
                System.out.print("Número de entradas familiares (min 4 personas): ");
                numeroEntradaFamilia = sn.nextInt();
            }
        }
        while (!salir) {
            try {
                if (entradaFamilia) {
                    contadorEntradaFamilia++;
                    System.out.println("Entrada Familiar numero: " + contadorEntradaFamilia);
                    System.out.println("===========================");
                }
                System.out.println();
                System.out.println();
                System.out.print("Edad: ");
                edad = sn.nextInt();
                System.out.println();
                if (edad > 2) {
                    dni = sn.nextLine();
                    System.out.print("DNI del Cliente: ");
                    dni = sn.nextLine();
                    System.out.println();
                    System.out.print("Nombre del Cliente: ");
                    nombre = sn.nextLine();
                    System.out.println();
                    if (edad < 13) {
                        System.out.print("DNI del Acompañante: ");
                        dniacompaniante = sn.nextLine();
                        System.out.println();
                    }
                    System.out.print("Altura en centimetros: ");
                    alturaCm = sn.nextInt();
                    System.out.println();
                    diversidadFuncional = false;
                    diversidadFuncional = preguntasVarias("Diversidad Funcional");
                    entradaTarde = false;
                    entradaTarde = preguntasVarias("Entrada por la Tarde");
                    entradaVip = false;
                    if (!entradaFamilia) {
                        entradaVip = preguntasVarias("Entrada VIP");
                    }
                    if (todasEntradasVip && entradaFamilia) {
                        entradaVip = true;
                    }

                    if (contadorEntradaFamilia == 1 && entradaFamilia) {
                        entradaVip = preguntasVarias("Entrada VIP");
                        todasEntradasVip = entradaVip;
                    }

                    if (entradaVip && entradaFamilia) {
                        System.out.println("Todas las Entradas Familiares son VIP");
                        System.out.println();
                    } else if (entradaFamilia) {
                        System.out.println("todas las entradas familiares deben ser iguales en el suplemento VIP");
                        System.out.println();
                    }

                    if (edad > 12 && edad < 64) {
                        carnetJoven = false;
                        carnetJoven = preguntasVarias("Carnet Joven");
                        carnetEstudiante = false;
                        carnetEstudiante = preguntasVarias("Carnet Estudiante");
                        desempleado = false;
                        desempleado = preguntasVarias("Desempleado");
                    }

                    if (ventaAnticipada) {
                        fechaVentaAnticipada();
                    } else {
                        Date fecha = new Date();
                        String fechaFormato = "dd/MM/yyyy";
                        SimpleDateFormat formatoFecha = new SimpleDateFormat(fechaFormato);
                        fechaEntrada = (formatoFecha.format(fecha));

                    }

                } else {
                    System.out.println("Niños menores de 3 años no necesitan entrada");
                    System.out.println();
                    System.out.println();
                }

                imprimirEntrada();

                entradaAceptada = preguntasVarias("Es correcta la entrada");
                if (entradaAceptada) {
                    if (edad > 2 && edad < 13) {
                        Nino entradaNino = new Nino(dni, nombre, edad, alturaCm, fechaEntrada,
                                diversidadFuncional, entradaVip, entradaTarde, precioEntrada, dniacompaniante);
                        clientes.add(entradaNino);
                    }
                    if (edad > 12 && edad < 64) {
                        Adulto entradaAdulto = new Adulto(dni, nombre, edad, alturaCm, fechaEntrada,
                                diversidadFuncional, entradaVip, entradaTarde, precioEntrada,
                                carnetEstudiante, carnetJoven, desempleado);
                        clientes.add(entradaAdulto);
                    }
                    if (edad > 64) {
                        Senior entradaSenior = new Senior(dni, nombre, edad, alturaCm, fechaEntrada,
                                diversidadFuncional, entradaVip, entradaTarde, precioEntrada);
                        clientes.add(entradaSenior);
                    }
                }
                if (!entradaFamilia) {
                    salir = true;
                }
                if (edad < 3 && entradaFamilia) {
                    contadorEntradaFamilia--;
                }
                if (numeroEntradaFamilia == contadorEntradaFamilia) {
                    salir = true;
                }
                /* System.out.println(clientes);
                for (Cliente cliente : clientes) {
                    System.out.println("Nombre: " + cliente.getNombre() + " edad: " + cliente.getEdad());
                }
                boolean parar = preguntasVarias("parada");*/

            } catch (InputMismatchException e) {
                System.out.println("Solo numeros");
                sn.next();
            }
        }

    }

    public void fechaVentaAnticipada() {
        do {
            Scanner leerFecha = new Scanner(System.in);
            System.out.println("Fecha Entrada (dd/mm/aaaa)");
            fechaEntrada = leerFecha.next();
        } while (!validarFecha(fechaEntrada));
        System.out.println();
        System.out.println();
        int temporada = 0;
        try {
            temporada = comprobarTemporada();
        } catch (ParseException ex) {
        }

        switch (temporada) {
            case 1:
                System.out.println("Puedes usarla solo en temporada media");
                break;
            case 2:
                System.out.println("Puedes usarla solo en temporada alta");
                break;
            case 3:
                System.out.println("Puedes usarla solo en temportada baja");
                break;
        }

        System.out.println("\n\n");
    }

    public void imprimirEntrada() {
        limpiarPantalla();
        if (edad > 2) {
            System.out.println("Entrada Parque Atracciones");
            System.out.println("==========================");
            System.out.println("Dni: " + dni + "  Nombre: " + nombre);
            this.precioEntrada = calcularPrecioEntrada();
            System.out.println("El precio de la entrada: " + precioEntrada);
            System.out.println("\n\n");
        }

    }

    public boolean finDeSemana() {
        int numeroDia = 0;
        String fechaFormato = "dd/MM/yyyy";
        SimpleDateFormat formatoFecha = new SimpleDateFormat(fechaFormato);
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(formatoFecha.parse(fechaEntrada));
        } catch (ParseException ex) {
            Logger.getLogger(Entrada.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        numeroDia = cal.get(Calendar.DAY_OF_WEEK);
        if (numeroDia == 1 || numeroDia == 6 || numeroDia == 7) {
            return true;
        }
        return false;
    }

    public double calcularPrecioEntrada() {
        double precioAcumulado = 0;
        double precioMinimo = 0;
        double precioDeLaEntrada = 0;
        int temporada = 0;

        if (edad > 2 && edad < 13) {
            System.out.println("Entrada Niño");
            System.out.println("============");
            precioDeLaEntrada = 30;
            precioAcumulado = 30;
            precioMinimo = (precioDeLaEntrada * 0.10);
        }
        if (edad > 64) {
            System.out.println("Entrada Senior");
            System.out.println("==============");
            precioDeLaEntrada = 39;
            precioAcumulado = 39;
            precioMinimo = (precioDeLaEntrada * 0.10);
        }

        if (edad > 12 && edad < 64) {
            System.out.println("Entrada Adulto");
            System.out.println("==============");
            precioDeLaEntrada = 60;
            precioAcumulado = 60;
            precioMinimo = (precioDeLaEntrada * 0.10);
        }
        if (carnetJoven) {
            System.out.println("Descuento del 10% por Carnet Joven");
            precioAcumulado = precioAcumulado - (precioDeLaEntrada * 0.10);
        }
        if (carnetEstudiante) {
            System.out.println("Descuento del 10% por Carnet Estudiante");
            precioAcumulado = precioAcumulado - (precioDeLaEntrada * 0.10);
        }
        if (desempleado) {
            System.out.println("Descuento del 10% por Desempleado");
            precioAcumulado = precioAcumulado - (precioDeLaEntrada * 0.10);
        }
        if (diversidadFuncional) {
            System.out.println("Descuento del 20% por Discapacidad Funcional");
            precioAcumulado = precioAcumulado - (precioDeLaEntrada * 0.20);
        }
        try {
            temporada = comprobarTemporada();
        } catch (ParseException ex) {
            Logger.getLogger(Entrada.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        if (temporada == 2) {
            System.out.println("Aumento del 25% por Temporada Alta");
            precioAcumulado = precioAcumulado + (precioDeLaEntrada * 0.25);
        }

        if (temporada == 3) {
            System.out.println("Descuento del 25% por Temporada Baja");
            precioAcumulado = precioAcumulado - (precioDeLaEntrada * 0.25);
        }
        if (entradaFamilia) {
            System.out.println("Descuento del 15% por Entrada Familiar");
            precioAcumulado = precioAcumulado - (precioDeLaEntrada * 0.15);
        }
        if (entradaTarde) {
            System.out.println("Descuento del 50% por Entrada de Tarde");
            precioAcumulado = precioAcumulado - (precioDeLaEntrada * 0.50);
        }

        if (!finDeSemana()) {
            System.out.println("Descuento del 15% por Entrada entre semana");
            precioAcumulado = precioAcumulado - (precioDeLaEntrada * 0.15);
        }

        if (precioAcumulado < precioMinimo) {
            precioDeLaEntrada = precioMinimo;
        } else {
            precioDeLaEntrada = precioAcumulado;
        }

        if (edad > 2 && edad < 13) {
            if (entradaVip) {
                System.out.println("Entrada VIP + 25 euros");
                precioDeLaEntrada = precioDeLaEntrada + 25;
            }
        }
        if (edad > 64) {
            if (entradaVip) {
                System.out.println("Entrada VIP + 32.5 euros");
                precioDeLaEntrada = precioDeLaEntrada + 32.5;
            }
        }

        if (edad > 12 && edad < 65) {
            if (entradaVip) {
                System.out.println("Entrada VIP + 50 euros");
                precioDeLaEntrada = precioDeLaEntrada + 50;
            }
        }
        return precioDeLaEntrada;
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

    public boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public void limpiarPantalla() {
        System.out.println("\n\n\n\n\n\n");
    }

    public int comprobarTemporada() throws ParseException {
        int temporada = 1; // 1=temporada media, 2=temporada alta, 3=temporada baja
        int numeroMes = 0;
        int numeroDia = 0;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(formatoFecha.parse(fechaEntrada));
        try {
            cal.setTime(formatoFecha.parse(fechaEntrada));
        } catch (ParseException ex) {
        }
        numeroDia = cal.get(Calendar.DAY_OF_MONTH);
        numeroMes = cal.get(Calendar.MONTH);
        if (numeroMes == 7 || numeroMes == 8 || numeroMes == 11) {
            temporada = 2; // Temporada alta
        }
        if (numeroMes == 0) {
            if (numeroDia > 0 && numeroDia < 9) { // Navidad
                temporada = 2; // temporada alta
            }
        }
        if (numeroMes == 3) {
            if (numeroDia > 14 && numeroDia < 22) { // Semana Santa
                temporada = 2; // temporada alta
            }
        }
        if (numeroMes == 1 || numeroMes == 10) {
            temporada = 3; // temporada baja
        }
        return temporada;
    }

}
