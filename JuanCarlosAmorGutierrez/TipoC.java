
/**
 * Atracción Tipo C.
 *
 * @author Juan Carlos Amor Gutiérrez
 * @version (1.0 05/05/2019)
 */
public class TipoC extends Atracciones {

     /**
     * Constructor de objetos para la clase Tipo C
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
    
    public TipoC(int numeroAtracciones) {
        super();
        this.setSenior(false);
        this.setAdulto(false);
        this.setNino(true);
        this.setVip(false);
        this.setAlturaMax(120);
        this.setAlturaMin(0);
        this.setAyudantesAtraccion(3);
        this.setResponsableAtraccion(1);
        this.setNumeroDeAtracciones(numeroAtracciones);
    }

    @Override
    public String toString() {
        return "TipoC{" + '}';
    }

}
