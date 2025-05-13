package dto;

public class Profesor extends Persona implements Registrable {
    private String especialidad;

    public Profesor() {}

    public Profesor(int id, String nombre, String email, String pais, String especialidad) {
        super(id, nombre, email, pais); // herencia persona
        this.especialidad = especialidad;
    }

    public String getEspecialidad() 
    { return especialidad; 
    }
    public void setEspecialidad(String especialidad) {
    	this.especialidad = especialidad; 
    	}

    @Override
    public String toString() {
        return getNombre() + " - " + especialidad;
    }
    public void registrar() {
    	
        System.out.println("Registrando profesor: " + getNombre());
        
    }
}
