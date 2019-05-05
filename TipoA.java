
/**
 * Write a description of class TipoA here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TipoA extends Atracciones {

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
