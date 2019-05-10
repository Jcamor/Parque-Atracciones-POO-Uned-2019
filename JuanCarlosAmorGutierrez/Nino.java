
/**
 * Niños del parque de Atracciones
 * 
 * @author Juan Carlos Amor Gutiérrez
 * @version (1.0 05/05/2019)
 */
public class Nino extends Cliente {

	private String dniAdultoacompania;

        /**
     * Constructor de objetos para la clase Nino
     *
     * @param dni
     * @param nombre
     * @param edad
     * @param alturaCm
     * @param fechaEntrada
     * @param diversidadFuncional
     * @param entradaVip
     * @param entradaTarde
     * @param precioEntrada
     * @param dniAdultoacompania 
     */
        
	public Nino(String dni, String nombre, int edad, int alturaCm, String fechaEntrada,
                boolean diversidadFuncional, boolean entradaVip, boolean entradaTarde,
		double precioEntrada, String dniAdultoacompania) {
		super(dni, nombre, edad, alturaCm, fechaEntrada, diversidadFuncional, entradaVip, entradaTarde, precioEntrada);
		this.dniAdultoacompania = dniAdultoacompania;
	}

	public String getDniAdultoacompania() {
		return dniAdultoacompania;
	}

	public void setDniAdultoacompania(String dniAdultoacompania) {
		this.dniAdultoacompania = dniAdultoacompania;
	}

    @Override
    public String toString() {
        return "Nino{" + "dniAdultoacompania=" + dniAdultoacompania + '}';
    }

}
