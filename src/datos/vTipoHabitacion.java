package datos;

public class vTipoHabitacion {
	private int id_tipohabitacion;
	private String nombre;
	private String descripcion;
	
	public vTipoHabitacion() {
		
	}

	public vTipoHabitacion(int id_tipohabitacion, String nombre, String descripcion) {
		super();
		this.id_tipohabitacion = id_tipohabitacion;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getId_tipohabitacion() {
		return id_tipohabitacion;
	}

	public void setId_tipohabitacion(int id_tipohabitacion) {
		this.id_tipohabitacion = id_tipohabitacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	// se sobreescribe el metodo toString para que retorne el nombre de la clase
	@Override
	public String toString() {
	    return nombre;
	}
	
	
}
