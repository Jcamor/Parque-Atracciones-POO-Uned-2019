
/**
 * Write a description of class Entrada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.InputMismatchException;
import java.util.Scanner;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Entrada {

	private String dni = "";
	private String nombre = "";
	private int edad = 0;
	private int alturaCm = 0;
	private boolean diversidadFuncional = false;
	private boolean carnetJoven = false;
	private boolean desempleado = false;
	private boolean entradaTarde = false;
	private boolean entradaVip = false;
	private boolean ventaAnticipada = false;
	private String fechaEntrada = "";
	private Scanner sn;
	
	public void menuGenerarEntrada() {
		sn = new Scanner(System.in);
		boolean salir = false;
		limpiarPantalla();
		System.out.println("\n\n\n\n");
		System.out.println("Entrada Parque de Atraccciones");
		System.out.println("==============================");
		System.out.println();
		while (!salir) {
			try {
				System.out.print("DNI del Cliente: ");
				dni = sn.nextLine();
				System.out.println();
				System.out.print("Nombre del Cliente: ");
				nombre = sn.nextLine();
				System.out.println();
				System.out.print("Edad: ");
				edad = sn.nextInt();
				System.out.println();
				System.out.print("Altura en centimetros: ");
				alturaCm = sn.nextInt();
				System.out.println();
				diversidadFuncional = preguntasVarias("Diversidad Funcional");
				entradaVip = preguntasVarias("Entrada VIP");
				entradaTarde = preguntasVarias("Entrada por la Tarde");
				ventaAnticipada = preguntasVarias("Venta Anticipada");
				if (edad > 12 && edad < 64) {
					carnetJoven = preguntasVarias("Carnet Joven");
					desempleado = preguntasVarias("Desempleado");
				}

				if (ventaAnticipada) {
					do {
						Scanner leerFecha = new Scanner(System.in);
						System.out.println("Fecha Entrada (dd/mm/aaaa)");
						fechaEntrada = leerFecha.next();
					} while (!validarFecha(fechaEntrada));
				}else {
					Date fecha = new Date();			 
			        String fechaFormato = "dd/MM/yyyy";
			        SimpleDateFormat formatoFecha = new SimpleDateFormat(fechaFormato);
			        fechaEntrada = (formatoFecha.format(fecha));
			    }
				salir = true;
			} catch (InputMismatchException e) {
				System.out.println("Solo números");
				sn.next();
			}

		}

		System.out.println(fechaEntrada);
		System.out.println("Dni: " + dni + nombre + edad + alturaCm + diversidadFuncional);

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
	
    public void limpiarPantalla(){
        try {

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            } catch (Exception e) {}
    }

}