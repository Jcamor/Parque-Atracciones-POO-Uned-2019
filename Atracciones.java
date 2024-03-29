/*
 * Para generar las Atracciones del parque
 *
 * @author Juan Carlos Amor Gutiérrez
 * @version (1.0 05/05/2019)
 */
public class Atracciones {

    // Declaramos los campos de las atracciones
    private boolean senior;
    private boolean adulto;
    private boolean nino;
    private boolean vip;
    private int alturaMax;
    private int alturaMin;
    private int ayudantesAtraccion;
    private int responsableAtraccion;
    private int numeroDeAtracciones;

    /**
     * Constructor de objetos para la clase Atracciones
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
    public Atracciones() {
        this.senior = false;
        this.adulto = false;
        this.nino = false;
        this.vip = false;
        this.alturaMax = 0;
        this.alturaMin = 0;
        this.ayudantesAtraccion = 0;
        this.responsableAtraccion = 0;
        this.numeroDeAtracciones = 0;
    }
 
        // Métodos Geters y Seters
    public boolean esSenior() {
        return senior;
    }

    public void setSenior(boolean senior) {
        this.senior = senior;
    }

    public boolean esAdulto() {
        return adulto;
    }

    public void setAdulto(boolean adulto) {
        this.adulto = adulto;
    }

    public boolean esNino() {
        return nino;
    }

    public void setNino(boolean nino) {
        this.nino = nino;
    }

    public boolean esVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public int getAlturaMax() {
        return alturaMax;
    }

    public void setAlturaMax(int alturaMax) {
        this.alturaMax = alturaMax;
    }

    public int getAlturaMin() {
        return alturaMin;
    }

    public void setAlturaMin(int alturaMin) {
        this.alturaMin = alturaMin;
    }

    public int getAyudantesAtraccion() {
        return ayudantesAtraccion;
    }

    public void setAyudantesAtraccion(int ayudantesAtraccion) {
        this.ayudantesAtraccion = ayudantesAtraccion;
    }

    public int getResponsableAtraccion() {
        return responsableAtraccion;
    }

    public void setResponsableAtraccion(int responsableAtraccion) {
        this.responsableAtraccion = responsableAtraccion;
    }

    public int getNumeroDeAtracciones() {
        return numeroDeAtracciones;
    }

    public void setNumeroDeAtracciones(int numeroDeAtracciones) {
        this.numeroDeAtracciones = numeroDeAtracciones;
    }

    @Override
    public String toString() {
        return "Atracciones{" + "senior=" + senior + ", adulto=" + adulto + ", nino="
                + nino + ", vip=" + vip + ", alturaMax=" + alturaMax + ", alturaMin="
                + alturaMin + ", ayudantesAtraccion=" + ayudantesAtraccion + 
                ", responsableAtraccion=" + responsableAtraccion + ", numeroDeAtracciones="
                + numeroDeAtracciones + '}';
    }

}
