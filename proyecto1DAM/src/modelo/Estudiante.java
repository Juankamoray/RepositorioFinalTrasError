package modelo;

import java.time.LocalDate;

public class Estudiante {
	private int id;
	private String nombre;
	private String email;
	private String pais;
	private LocalDate fechaNacimiento;

	public Estudiante() {}

	public Estudiante(int id, String nombre, String email, String pais, LocalDate fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.pais = pais;
		this.fechaNacimiento = fechaNacimiento;
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

	public LocalDate getFechaNacimiento() { 
		return fechaNacimiento; 
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return nombre + " (" + email + ")";
	}
}
