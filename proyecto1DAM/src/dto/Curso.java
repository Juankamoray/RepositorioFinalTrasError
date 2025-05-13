package dto;
public class Curso {
	private int id;
	private String titulo;
	private String descripcion;
	private int duracionSemanas;
	private String nivel; // hay 3 tipos, (básico, intermedio, avanzado)
	private int idProfesor; 

	public Curso() {}

	public Curso(int id, String titulo, String descripcion, int duracionSemanas, String nivel, int idProfesor) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.duracionSemanas = duracionSemanas;
		this.nivel = nivel;
		this.idProfesor = idProfesor;
	}

	// Getters y Setters

	public int getId() {
		return id;
	}
	public void setId(int id) { 
		this.id = id; 
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo; 
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) { 
		this.descripcion = descripcion; 
	}

	public int getDuracionSemanas() {
		return duracionSemanas; 
	}
	public void setDuracionSemanas(int duracionSemanas) { 
		this.duracionSemanas = duracionSemanas; 
	}

	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) { 
		this.nivel = nivel; 
	}

	public int getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	@Override
	public String toString() {
		return titulo + " (" + nivel + ")";
	}
}
