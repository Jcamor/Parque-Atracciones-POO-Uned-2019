
/**
 * Write a description of class TipoB here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TipoB extends Atracciones {

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
