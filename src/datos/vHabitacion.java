package datos;

public class vHabitacion {
	private int id_habitacion;
	private int numero;
	private double costo;
	private String descripcion;
	private int id_tipoHabitacion;
	private String estado;
	
	public vHabitacion() {
		
	}

	public vHabitacion(int id_habitacion, int numero, double costo, String descripcion, int id_tipoHabitacion,
			String estado) {
		super();
		this.id_habitacion = id_habitacion;
		this.numero = numero;
		this.costo = costo;
		this.descripcion = descripcion;
		this.id_tipoHabitacion = id_tipoHabitacion;
		this.estado = estado;
	}

	public int getId_habitacion() {
		return id_habitacion;
	}

	public void setId_habitacion(int id_habitacion) {
		this.id_habitacion = id_habitacion;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId_tipoHabitacion() {
		return id_tipoHabitacion;
	}

	public void setId_tipoHabitacion(int id_tipoHabitacion) {
		this.id_tipoHabitacion = id_tipoHabitacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
