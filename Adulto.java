
/**
 * Adultos del parque de Atracciones
 *
 * @author Juan Carlos Amor Gutiérrez
 * @version (1.0 05/05/2019)
 */
public class Adulto extends Cliente {

    private boolean estudiante;
    private boolean carnetJoven;
    private boolean desempleado;

    /**
     * Constructor de objetos para la clase Adulto
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
     * @param estudiante 
     * @param carnetJoven 
     * @param desempleado 
     * 
     */
    
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

    @Override
    public String toString() {
        return "Adulto{" + "estudiante=" + estudiante + ", carnetJoven=" + carnetJoven + ", desempleado=" + desempleado + '}';
    }

}
