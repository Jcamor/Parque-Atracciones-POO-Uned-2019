
/**
 * Write a description of class TipoE here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TipoE extends Atracciones {

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
