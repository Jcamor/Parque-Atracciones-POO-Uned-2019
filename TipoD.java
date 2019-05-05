
/**
 * Write a description of class TipoD here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TipoD extends Atracciones {

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
