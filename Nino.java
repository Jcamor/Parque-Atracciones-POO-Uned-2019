
/**
 * Write a description of class Nino here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nino extends Cliente {

	private String dniAdultoacompania;

	public Nino(String dni, String nombre, int edad, int alturaCm, String fechaEntrada, boolean diversidadFuncional,
			String dniAdultoacompania) {
		super(dni, nombre, edad, alturaCm, fechaEntrada, diversidadFuncional);
		this.dniAdultoacompania = dniAdultoacompania;
	}

	public String getDniAdultoacompania() {
		return dniAdultoacompania;
	}

	public void setDniAdultoacompania(String dniAdultoacompania) {
		this.dniAdultoacompania = dniAdultoacompania;
	}

}
