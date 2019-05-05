
/**
 * Write a description of class TipoC here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TipoC extends Atracciones {

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
