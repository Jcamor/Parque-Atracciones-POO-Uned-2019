
/**
 * Empleados
 *
 * @author Juan Carlos Amor Gutiérrez
 * @version (1.0 05/05/2019)
 */
public class Empleado {

    // Campos de los empleados
    private String dni;
    private String nombre;
    private String puesto;
    private int telefono;
    private String direccion;
    private double sueldoMes;

    public Empleado(String dni, String nombre, String direccion, int telefono,
            String puesto, double sueldoMes) {
        this.dni = dni;
        this.nombre = nombre;
        this.puesto = puesto;
        this.telefono = telefono;
        this.direccion = direccion;
        this.sueldoMes = sueldoMes;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSueldoMes() {
        return sueldoMes;
    }

    public void setSueldoMes(double sueldoMes) {
        this.sueldoMes = sueldoMes;
    }
}
