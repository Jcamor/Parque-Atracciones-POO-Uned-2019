
/**
 * Atracción Tipo E.
 *
 * @author Juan Carlos Amor Gutiérrez
 * @version (1.0 05/05/2019)
 */
public class TipoE extends Atracciones {
    
     /**
     * Constructor de objetos para la clase Tipo E
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

    public TipoE(int numeroAtracciones) {
        super();
        this.setSenior(true);
        this.setAdulto(true);
        this.setNino(false);
        this.setVip(true);
        this.setAlturaMax(250);
        this.setAlturaMin(0);
        this.setAyudantesAtraccion(7);
        this.setResponsableAtraccion(1);
        this.setNumeroDeAtracciones(numeroAtracciones);
    }

    @Override
    public String toString() {
        return "TipoE{" + '}';
    }

}
