
/**
 * Write a description of class Adulto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Adulto extends Cliente {
	private boolean estudiante;
	private boolean carnetJoven;
	private boolean desempleado;

	public Adulto(String dni, String nombre, int edad, int alturaCm, String fechaEntrada,
                boolean diversidadFuncional, boolean entradaVip, boolean entradaTarde,
		double precioEntrada, boolean estudiante, boolean carnetJoven, boolean desempleado) {
		super(dni, nombre, edad, alturaCm, fechaEntrada, diversidadFuncional, entradaVip, entradaTarde, precioEntrada);
		this.estudiante = estudiante;
		this.carnetJoven = carnetJoven;
		this.desempleado = desempleado;
	}

	public boolean esEstudiante() {
		return estudiante;
	}

	public void setEstudiante(boolean estudiante) {
		this.estudiante = estudiante;
	}

	public boolean esCarnetJoven() {
		return carnetJoven;
	}

	public void setCarnetJoven(boolean carnetJoven) {
		this.carnetJoven = carnetJoven;
	}

	public boolean esDesempleado() {
		return desempleado;
	}

	public void setDesempleado(boolean desempleado) {
		this.desempleado = desempleado;
	}

}
