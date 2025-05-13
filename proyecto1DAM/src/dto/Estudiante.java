package dto;

import java.time.LocalDate;

public class Estudiante extends Persona implements Registrable {
    private LocalDate fechaNacimiento;

    public Estudiante() {}

    public Estudiante(int id, String nombre, String email, String pais, LocalDate fechaNacimiento) {
        super(id, nombre, email, pais); // herencia persona
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaNacimiento() {
    	return fechaNacimiento; 
    	}
    public void setFechaNacimiento(LocalDate fechaNacimiento) { 
    	this.fechaNacimiento = fechaNacimiento; 
    	}

    @Override
    public String toString() {
        return getNombre() + " (" + getEmail() + ")";
    }
   
    public void registrar() {
        System.out.println("Registrando estudiante: " + getNombre());
    }
}
