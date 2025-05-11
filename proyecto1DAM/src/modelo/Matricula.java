package modelo;

import java.time.LocalDate;

public class Matricula {
	private int id;
	private int idEstudiante;
	private int idCurso;
	private LocalDate fechaInscripcion;
	private String estado; // 2 opciones, completado o en curso

	public Matricula() {}

	public Matricula(int id, int idEstudiante, int idCurso, LocalDate fechaInscripcion, String estado) {
		this.id = id;
		this.idEstudiante = idEstudiante;
		this.idCurso = idCurso;
		this.fechaInscripcion = fechaInscripcion;
		this.estado = estado;
	}

	// Getters y Setters

	public int getId() { 
		return id;
	}
	public void setId(int id) {
		this.id = id; 
	}

	public int getIdEstudiante() { 
		return idEstudiante; 
	}
	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante; 
	}

	public int getIdCurso() { 
		return idCurso; 
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public LocalDate getFechaInscripcion() {
		return fechaInscripcion;
	}
	public void setFechaInscripcion(LocalDate fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public String getEstado() { 
		return estado; 
	}
	public void setEstado(String estado) {
		this.estado = estado; 
	}

	@Override
	public String toString() {
		return "Curso ID: " + idCurso + ", Estado: " + estado;
	}
}
