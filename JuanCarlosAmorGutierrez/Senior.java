
/**
 * Senior del parque Atracciones
 *
 * @author Juan Carlos Amor Gutiérrez
 * @version (1.0 05/05/2019)
 */
public class Senior extends Cliente {
    
    /**
     * Constructor de objetos para la clase Senior
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
     * 
     */

    public Senior(String dni, String nombre, int edad, int alturaCm, String fechaEntrada,
            boolean diversidadFuncional, boolean entradaVip, boolean entradaTarde,
            double precioEntrada) {
        super(dni, nombre, edad, alturaCm, fechaEntrada, diversidadFuncional,
                entradaVip, entradaTarde, precioEntrada);
    }

}
