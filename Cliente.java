/**
 * Abstract class Clientes - write a description of the class here
 * 
 * @author: Date:
 */
public class Cliente

{

	private String dni;
	private String nombre;
	private int edad;
	private int alturaCm;
	private String fechaEntrada;
	private boolean diversidadFuncional;
        boolean entradaVip;
        boolean entradaTarde;
        double precioEntrada;

	public Cliente(String dni, String nombre, int edad, int alturaCm, String fechaEntrada,
			boolean diversidadFuncional, boolean entradaVip, boolean entradaTarde, double precioEntrada) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.alturaCm = alturaCm;
		this.fechaEntrada = fechaEntrada;
		this.diversidadFuncional = diversidadFuncional;
                this.entradaVip = entradaVip;
                this.entradaTarde = entradaTarde;
                this.precioEntrada = precioEntrada;
	}

	// instance variables - replace the example below with your own
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getAlturaCm() {
		return alturaCm;
	}

	public void setAlturaCm(int alturaCm) {
		this.alturaCm = alturaCm;
	}

	public String getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public boolean esDiversidadFuncional() {
		return diversidadFuncional;
	}

	public void setDiversidadFuncional(boolean diversidadFuncional) {
		this.diversidadFuncional = diversidadFuncional;
	}
        
        public boolean esEntradaVip() {
		return entradaVip;
	}

	public void setEntradaVip(boolean entradaVip) {
		this.entradaVip = entradaVip;
	}
        
        public boolean esEntradaTarde() {
		return entradaTarde;
	}

	public void setEntradaTarde(boolean entradaTarde) {
		this.entradaTarde = entradaTarde;
	}
        
        public double esPrecioEntrada() {
		return precioEntrada;
	}

	public void setPrecioEntrada(double precioEntrada) {
		this.precioEntrada = precioEntrada;
	}
}
