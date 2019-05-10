
/**
 * Atracción Tipo B.
 *
 * @author Juan Carlos Amor Gutiérrez
 * @version (1.0 05/05/2019)
 */
public class TipoB extends Atracciones {

     /**
     * Constructor de objetos para la clase Tipo B
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
    
    public TipoB(int numeroAtracciones) {
        super();
        this.setSenior(true);
        this.setAdulto(true);
        this.setNino(false);
        this.setVip(false);
        this.setAlturaMax(190);
        this.setAlturaMin(120);
        this.setAyudantesAtraccion(5);
        this.setResponsableAtraccion(1);
        this.setNumeroDeAtracciones(numeroAtracciones);
    }

    @Override
    public String toString() {
        return "TipoB{" + '}';
    }

}
