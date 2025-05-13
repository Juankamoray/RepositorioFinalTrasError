package dto;

public class Profesor {
	private int id;
	private String nombre;
	private String email;
	private String pais;
	private String especialidad;

	public Profesor() {}

	public Profesor(int id, String nombre, String email, String pais, String especialidad) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.pais = pais;
		this.especialidad = especialidad;
	}

	// Getters y Setters

	public int getId() {
		return id;
	}
	public void setId(int id) { 
		this.id = id;
	}

	public String getNombre() { 
		return nombre;
	}
	public void setNombre(String nombre) { 
		this.nombre = nombre;
	}

	public String getEmail() { 
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPais() { 
		return pais; 
	}
	public void setPais(String pais) { 
		this.pais = pais;
	}

	public String getEspecialidad() { 
		return especialidad; 
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return nombre + " - " + especialidad;
	}
}
