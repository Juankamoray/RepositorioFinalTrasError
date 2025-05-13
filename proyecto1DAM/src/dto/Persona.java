package dto;

public abstract class Persona {
	private int id;
	private String nombre;
	private String email;
	private String pais;
	//constructor
	public Persona() {}

	public Persona(int id, String nombre, String email, String pais) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.pais = pais;
	}

	// Getters y Setters (Ahorramos tantos getters y setters para las demas clases)
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
}
