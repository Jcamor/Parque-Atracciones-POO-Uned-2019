
/**
 * Atracción Tipo A.
 *
 * @author Juan Carlos Amor Gutiérrez
 * @version (1.0 05/05/2019)
 */
public class TipoA extends Atracciones {

    /**
     * Constructor de objetos para la clase Tipo A
     *
     * @param senior
     * @param adulto
     * @param nino
     * @param vip
     * @param alturaMax
     * @param alturaMin
     * @param ayudantesAtraccion
     * @param responsableAtraccion
     * @param numeroDeAtracciones
     * 
     */
    
    public TipoA(int numeroAtracciones) {
        super();
        this.setSenior(true);
        this.setAdulto(true);
        this.setNino(true);
        this.setVip(true);
        this.setAlturaMax(250);
        this.setAlturaMin(120);
        this.setAyudantesAtraccion(6);
        this.setResponsableAtraccion(1);
        this.setNumeroDeAtracciones(numeroAtracciones);
    }

    @Override
    public String toString() {
        return "TipoA{" + '}';
    }
     
}
