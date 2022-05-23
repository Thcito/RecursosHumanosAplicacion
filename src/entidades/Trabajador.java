package entidades;

public class Trabajador {

	private String dni;
	private String nombre;
	private String apellido;
	private int edad;
	private String cargo;
	private boolean sexo;
	private boolean extranjero;

	public Trabajador() {

	}

	public Trabajador(String dni, String nombre, String apellido, int edad, String cargo, boolean sexo, boolean extranjero) {
		
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setEdad(edad);
		this.setCargo(cargo);
		this.setSexo(sexo);
		this.setExtranjero(extranjero);
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
		
		if (nombre.length() < 3 || nombre.length() > 100 ) {
			throw new IllegalArgumentException("El largo debe estar entre 3 y 100 caracteres");
		}
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if (edad < 18) {
			throw new IllegalArgumentException("La persona debe ser mayor de edad");
		}
		this.edad = edad;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public boolean isExtranjero() {
		return extranjero;
	}

	public void setExtranjero(boolean extranjero) {
		this.extranjero = extranjero;
	}

	@Override
	public String toString() {
		return "Trabajador [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", cargo=" + cargo + ", sexo=" + sexo + ", extranjero=" + extranjero + "]";
	}

}
