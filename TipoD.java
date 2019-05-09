
/**
 * Atracción Tipo D.
 *
 * @author Juan Carlos Amor Gutiérrez
 * @version (1.0 05/05/2019)
 */
public class TipoD extends Atracciones {

     /**
     * Constructor de objetos para la clase Tipo D
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
    
    public TipoD(int numeroAtracciones) {
        super();
        this.setSenior(true);
        this.setAdulto(true);
        this.setNino(true);
        this.setVip(true);
        this.setAlturaMax(250);
        this.setAlturaMin(0);
        this.setAyudantesAtraccion(5);
        this.setResponsableAtraccion(1);
        this.setNumeroDeAtracciones(numeroAtracciones);
    }

    @Override
    public String toString() {
        return "TipoD{" + '}';
    }

}
