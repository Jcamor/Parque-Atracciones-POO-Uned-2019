
/**
 * Write a description of class Entrada here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Entrada {

    private String dni = "";
    private String nombre = "";
    private String dniacompaniante;
    private int edad = 0;
    private int alturaCm = 0;
    private double precioDeLaEntrada = 0;
    private boolean diversidadFuncional = false;
    private boolean carnetJoven = false;
    private boolean carnetEstudiante = false;
    private boolean desempleado = false;
    private boolean entradaTarde = false;
    private boolean entradaVip = false;

    private boolean ventaAnticipada = false;
    private boolean entradaFamilia = false;

    private String fechaEntrada = "";
    private Date temporadaAlta[];
    private Date temporadaBaja[];

    public void menuGenerarEntrada(boolean ventaAnticipada, boolean entradaFamilia) {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        cargarFechasTempora();
        limpiarPantalla();
        System.out.println("\n\n\n\n");
        System.out.println("Entrada Parque de Atraccciones");
        System.out.println("==============================");
        System.out.println();
        if (entradaFamilia) {
            System.out.print("Número de entradas familiares (min 4 personas): ");
            int numeroEntradaFamilia = sn.nextInt();
        }
        while (!salir) {
            try {
                System.out.print("Edad: ");
                edad = sn.nextInt();
                System.out.println();
                if (edad > 3) {
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
                    diversidadFuncional = preguntasVarias("Diversidad Funcional");
                    entradaVip = preguntasVarias("Entrada VIP");
                    entradaTarde = preguntasVarias("Entrada por la Tarde");
                    if (edad > 12 && edad < 64) {
                        carnetJoven = preguntasVarias("Carnet Joven");
                        carnetEstudiante = preguntasVarias("Carnet Estudiante");
                        desempleado = preguntasVarias("Desempleado");
                    }

                    if (ventaAnticipada) {
                        do {
                            Scanner leerFecha = new Scanner(System.in);
                            System.out.println("Fecha Entrada (dd/mm/aaaa)");
                            fechaEntrada = leerFecha.next();
                        } while (!validarFecha(fechaEntrada));
                        System.out.println();
                        System.out.println();
                        if (compararFechaAlta()) {
                            System.out.println("Puedes usarla cualquier día del año");
                        } else {
                            if (compararFechaBaja()) {
                                System.out.println("Puedes usarla solo en temporada baja");
                            } else {
                                System.out.println("Puedes usarla solo en temportada media");
                            }
                        }
                        System.out.println();
                        System.out.println();
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
                salir = true;
            } catch (InputMismatchException e) {
                System.out.println("Solo numeros");
                sn.next();
            }

        }
        limpiarPantalla();
        if (edad > 3) {
            System.out.println("Entrada Parque Atracciones");
            System.out.println("==========================");
            System.out.println("Dni: " + dni + "  Nombre: " + nombre);
            precioDeLaEntrada = calcularPrecioEntrada();
            System.out.println("El precio de la entrada: " + precioDeLaEntrada);
            System.out.println();
            System.out.println();
            boolean entradaAceptada = preguntasVarias("Es correcta la entrada");
            if (entradaAceptada) {
                //ArrayList Cliente
            }
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
            Logger.getLogger(Entrada.class.getName()).log(Level.SEVERE, null, ex);
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
        double precioEntrada = 0;

        if (edad > 2 && edad < 13) {
            System.out.println("Entrada Niño");
            System.out.println("============");
            precioEntrada = 30;
            precioAcumulado = 30;
            precioMinimo = (precioEntrada * 0.10);
        }
        if (edad > 64) {
            System.out.println("Entrada Senior");
            System.out.println("==============");
            precioEntrada = 39;
            precioAcumulado = 39;
            precioMinimo = (precioEntrada * 0.10);
        }

        if (edad > 12 && edad < 64) {
            System.out.println("Entrada Adulto");
            System.out.println("==============");
            precioEntrada = 60;
            precioAcumulado = 60;
            precioMinimo = (precioEntrada * 0.10);
        }
        if (carnetJoven) {
            System.out.println("Descuento del 10% por Carnet Joven");
            precioAcumulado = precioAcumulado - (precioEntrada * 0.10);
        }
        if (carnetEstudiante) {
            System.out.println("Descuento del 10% por Carnet Estudiante");
            precioAcumulado = precioAcumulado - (precioEntrada * 0.10);
        }
        if (desempleado) {
            System.out.println("Descuento del 10% por Desempleado");
            precioAcumulado = precioAcumulado - (precioEntrada * 0.10);
        }
        if (diversidadFuncional) {
            System.out.println("Descuento del 20% por Discapacidad Funcional");
            precioAcumulado = precioAcumulado - (precioEntrada * 0.20);
        }

        if (compararFechaAlta()) {
            System.out.println("Aumento del 25% por Temporada Alta");
            precioAcumulado = precioAcumulado + (precioEntrada * 0.25);
        }

        if (compararFechaBaja()) {
            System.out.println("Descuento del 25% por Temporada Baja");
            precioAcumulado = precioAcumulado - (precioEntrada * 0.25);
        }
        if (entradaFamilia) {
            System.out.println("Descuento del 15% por Entrada Familiar");
            precioAcumulado = precioAcumulado - (precioEntrada * 0.15);
        }
        if (entradaTarde) {
            System.out.println("Descuento del 50% por Entrada de Tarde");
            precioAcumulado = precioAcumulado - (precioEntrada * 0.50);
        }

        if (!finDeSemana()) {
            System.out.println("Descuento del 15% por Entrada entre semana");
            precioAcumulado = precioAcumulado - (precioEntrada * 0.15);
        }

        if (precioAcumulado < precioMinimo) {
            precioEntrada = precioMinimo;
        } else {
            precioEntrada = precioAcumulado;
        }

        if (edad > 2 && edad < 13) {
            if (entradaVip) {
                System.out.println("Entrada VIP + 25 euros");
                precioEntrada = precioEntrada + 25;
            }
        }
        if (edad > 64) {
            if (entradaVip) {
                System.out.println("Entrada VIP + 32.5 euros");
                precioEntrada = precioEntrada + 32.5;
            }
        }

        if (edad > 12 && edad < 64) {
            System.out.println("Entrada VIP + 50 euros");
            precioEntrada = precioEntrada + 50;
        }
        return precioEntrada;
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
        try {

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        } catch (Exception e) {
        }
    }

    public boolean compararFechaAlta() {
        boolean temAlta = false;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < temporadaAlta.length; i++) {
            String fechaParaComparar = sdf.format(temporadaAlta[i]);
            if (fechaEntrada.equals(fechaParaComparar)) {
                temAlta = true;
            }
        }
        return temAlta;

    }

    public boolean compararFechaBaja() {
        boolean temBaja = false;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < temporadaBaja.length; i++) {
            String fechaParaComparar = sdf.format(temporadaBaja[i]);
            if (fechaEntrada.equals(fechaParaComparar)) {
                temBaja = true;
            }
        }
        return temBaja;
    }

    public void cargarFechasTempora() {
        temporadaAlta = new Date[77];
        temporadaBaja = new Date[58];
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            temporadaAlta[0] = sdf.parse("01/01/2019");
            temporadaAlta[1] = sdf.parse("02/01/2019");
            temporadaAlta[2] = sdf.parse("03/01/2019");
            temporadaAlta[3] = sdf.parse("04/01/2019");
            temporadaAlta[4] = sdf.parse("05/01/2019");
            temporadaAlta[5] = sdf.parse("06/01/2019");
            temporadaAlta[6] = sdf.parse("07/01/2019");
            temporadaAlta[7] = sdf.parse("08/01/2019");

            temporadaAlta[8] = sdf.parse("15/04/2019");
            temporadaAlta[9] = sdf.parse("16/04/2019");
            temporadaAlta[10] = sdf.parse("17/04/2019");
            temporadaAlta[11] = sdf.parse("18/04/2019");
            temporadaAlta[12] = sdf.parse("19/04/2019");
            temporadaAlta[13] = sdf.parse("20/04/2019");
            temporadaAlta[14] = sdf.parse("21/04/2019");

            temporadaAlta[15] = sdf.parse("01/08/2019");
            temporadaAlta[16] = sdf.parse("02/08/2019");
            temporadaAlta[17] = sdf.parse("03/08/2019");
            temporadaAlta[18] = sdf.parse("04/08/2019");
            temporadaAlta[19] = sdf.parse("05/08/2019");
            temporadaAlta[20] = sdf.parse("06/08/2019");
            temporadaAlta[21] = sdf.parse("07/08/2019");
            temporadaAlta[22] = sdf.parse("08/08/2019");
            temporadaAlta[23] = sdf.parse("09/09/2019");
            temporadaAlta[24] = sdf.parse("10/09/2019");
            temporadaAlta[25] = sdf.parse("11/09/2019");
            temporadaAlta[26] = sdf.parse("12/09/2019");
            temporadaAlta[27] = sdf.parse("13/09/2019");
            temporadaAlta[28] = sdf.parse("14/09/2019");
            temporadaAlta[29] = sdf.parse("15/09/2019");
            temporadaAlta[30] = sdf.parse("16/09/2019");
            temporadaAlta[31] = sdf.parse("17/09/2019");
            temporadaAlta[32] = sdf.parse("18/09/2019");
            temporadaAlta[33] = sdf.parse("19/09/2019");
            temporadaAlta[34] = sdf.parse("20/09/2019");
            temporadaAlta[35] = sdf.parse("21/09/2019");
            temporadaAlta[36] = sdf.parse("22/09/2019");
            temporadaAlta[37] = sdf.parse("23/09/2019");
            temporadaAlta[38] = sdf.parse("24/09/2019");
            temporadaAlta[39] = sdf.parse("25/09/2019");
            temporadaAlta[40] = sdf.parse("26/09/2019");
            temporadaAlta[41] = sdf.parse("27/09/2019");
            temporadaAlta[42] = sdf.parse("28/09/2019");
            temporadaAlta[43] = sdf.parse("29/09/2019");
            temporadaAlta[44] = sdf.parse("30/09/2019");
            temporadaAlta[45] = sdf.parse("31/09/2019");

            temporadaAlta[46] = sdf.parse("01/12/2019");
            temporadaAlta[47] = sdf.parse("02/12/2019");
            temporadaAlta[48] = sdf.parse("04/12/2019");
            temporadaAlta[49] = sdf.parse("05/12/2019");
            temporadaAlta[50] = sdf.parse("06/12/2019");
            temporadaAlta[51] = sdf.parse("07/12/2019");
            temporadaAlta[52] = sdf.parse("08/12/2019");
            temporadaAlta[53] = sdf.parse("09/12/2019");
            temporadaAlta[54] = sdf.parse("10/12/2019");
            temporadaAlta[55] = sdf.parse("11/12/2019");
            temporadaAlta[56] = sdf.parse("12/12/2019");
            temporadaAlta[57] = sdf.parse("13/12/2019");
            temporadaAlta[58] = sdf.parse("14/12/2019");
            temporadaAlta[59] = sdf.parse("15/12/2019");
            temporadaAlta[60] = sdf.parse("16/12/2019");
            temporadaAlta[61] = sdf.parse("17/12/2019");
            temporadaAlta[62] = sdf.parse("18/12/2019");
            temporadaAlta[63] = sdf.parse("19/12/2019");
            temporadaAlta[64] = sdf.parse("20/12/2019");
            temporadaAlta[65] = sdf.parse("21/12/2019");
            temporadaAlta[66] = sdf.parse("22/12/2019");
            temporadaAlta[67] = sdf.parse("23/12/2019");
            temporadaAlta[68] = sdf.parse("24/12/2019");
            temporadaAlta[69] = sdf.parse("25/12/2019");
            temporadaAlta[70] = sdf.parse("26/12/2019");
            temporadaAlta[71] = sdf.parse("27/12/2019");
            temporadaAlta[72] = sdf.parse("28/12/2019");
            temporadaAlta[73] = sdf.parse("29/12/2019");
            temporadaAlta[74] = sdf.parse("30/12/2019");
            temporadaAlta[75] = sdf.parse("31/12/2019");
            temporadaAlta[76] = sdf.parse("03/12/2019");

            temporadaBaja[0] = sdf.parse("01/02/2019");
            temporadaBaja[1] = sdf.parse("02/02/2019");
            temporadaBaja[2] = sdf.parse("03/02/2019");
            temporadaBaja[3] = sdf.parse("04/02/2019");
            temporadaBaja[4] = sdf.parse("05/02/2019");
            temporadaBaja[5] = sdf.parse("06/02/2019");
            temporadaBaja[6] = sdf.parse("07/02/2019");
            temporadaBaja[7] = sdf.parse("08/02/2019");
            temporadaBaja[8] = sdf.parse("09/02/2019");
            temporadaBaja[9] = sdf.parse("10/02/2019");
            temporadaBaja[10] = sdf.parse("11/02/2019");
            temporadaBaja[11] = sdf.parse("12/02/2019");
            temporadaBaja[12] = sdf.parse("13/02/2019");
            temporadaBaja[13] = sdf.parse("14/02/2019");
            temporadaBaja[14] = sdf.parse("15/02/2019");
            temporadaBaja[15] = sdf.parse("16/02/2019");
            temporadaBaja[16] = sdf.parse("17/02/2019");
            temporadaBaja[17] = sdf.parse("18/02/2019");
            temporadaBaja[18] = sdf.parse("19/02/2019");
            temporadaBaja[19] = sdf.parse("20/02/2019");
            temporadaBaja[20] = sdf.parse("21/02/2019");
            temporadaBaja[21] = sdf.parse("22/02/2019");
            temporadaBaja[22] = sdf.parse("23/02/2019");
            temporadaBaja[23] = sdf.parse("24/02/2019");
            temporadaBaja[24] = sdf.parse("25/02/2019");
            temporadaBaja[25] = sdf.parse("26/02/2019");
            temporadaBaja[26] = sdf.parse("27/02/2019");
            temporadaBaja[27] = sdf.parse("28/02/2019");

            temporadaBaja[28] = sdf.parse("01/11/2019");
            temporadaBaja[29] = sdf.parse("02/11/2019");
            temporadaBaja[30] = sdf.parse("03/11/2019");
            temporadaBaja[31] = sdf.parse("04/11/2019");
            temporadaBaja[32] = sdf.parse("05/11/2019");
            temporadaBaja[33] = sdf.parse("06/11/2019");
            temporadaBaja[34] = sdf.parse("07/11/2019");
            temporadaBaja[35] = sdf.parse("08/11/2019");
            temporadaBaja[36] = sdf.parse("09/11/2019");
            temporadaBaja[37] = sdf.parse("10/11/2019");
            temporadaBaja[38] = sdf.parse("11/11/2019");
            temporadaBaja[39] = sdf.parse("12/11/2019");
            temporadaBaja[40] = sdf.parse("13/11/2019");
            temporadaBaja[41] = sdf.parse("14/11/2019");
            temporadaBaja[42] = sdf.parse("15/11/2019");
            temporadaBaja[43] = sdf.parse("16/11/2019");
            temporadaBaja[44] = sdf.parse("17/11/2019");
            temporadaBaja[45] = sdf.parse("18/11/2019");
            temporadaBaja[46] = sdf.parse("19/11/2019");
            temporadaBaja[47] = sdf.parse("20/11/2019");
            temporadaBaja[48] = sdf.parse("21/11/2019");
            temporadaBaja[49] = sdf.parse("22/11/2019");
            temporadaBaja[50] = sdf.parse("23/11/2019");
            temporadaBaja[51] = sdf.parse("24/11/2019");
            temporadaBaja[52] = sdf.parse("25/11/2019");
            temporadaBaja[53] = sdf.parse("26/11/2019");
            temporadaBaja[54] = sdf.parse("27/11/2019");
            temporadaBaja[55] = sdf.parse("28/11/2019");
            temporadaBaja[56] = sdf.parse("29/11/2019");
            temporadaBaja[57] = sdf.parse("30/11/2019");

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
