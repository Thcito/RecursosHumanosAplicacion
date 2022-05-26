package entidades;

public class Trabajador {

	private String dni;
	private String nombre;
	private String apellido;
	private String direccion;
	private String email;
	private float telefono;
	private int edad;
	private String cargo;
	private boolean sexo;
	private boolean extranjero;

	public Trabajador() {

	}

	public Trabajador(String dni, String nombre, String apellido, String direccion, String email, float telefono,
			int edad, String cargo, boolean sexo, boolean extranjero) {

		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDireccion(direccion);
		this.setEmail(email);
		this.setTelefono(telefono);
		this.setEdad(edad);
		this.setCargo(cargo);
		this.setSexo(sexo);
		this.setExtranjero(extranjero);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {

		if (dni.length() > 9) {
			throw new IllegalArgumentException("El largo campo del dni no puede ser superior a 9");
		} else if (dni.length() < 9) {

			// String.format("%09d" , dni);
		}

		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {

		if (nombre.length() < 3 || nombre.length() > 30) {
			throw new IllegalArgumentException("El largo debe estar entre 3 y 30 caracteres");
		}
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {

		if (apellido.length() < 3 || apellido.length() > 30) {
			throw new IllegalArgumentException("El largo debe estar entre 3 y 30 caracteres");
		}

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getTelefono() {
		return telefono;
	}

	public void setTelefono(float telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Trabajador [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", email=" + email + ", telefono=" + telefono + ", edad=" + edad + ", cargo=" + cargo + ", sexo="
				+ sexo + ", extranjero=" + extranjero + "]";
	}

	

}
