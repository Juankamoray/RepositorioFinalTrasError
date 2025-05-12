package main;

import dao.EstudianteDAO;
import modelo.Estudiante;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Me creo como estudiante para comprobar si funciona la conexion a la BD
        Estudiante est = new Estudiante();
        est.setNombre("Juan Carlos Moreno Moray");
        est.setEmail("juan.carlos.moreno.moray@salesianas.com");
        est.setPais("España");
        est.setFechaNacimiento(LocalDate.of(2006, 1, 21));

        // Con DAO vamos a insertarme en la tabla
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        boolean insertado = estudianteDAO.añadirEstudiante(est);

        if (insertado) {
            System.out.println("Se ha añadadido estudiante a la BD");
        } else {
            System.out.println("No se ha añadido el estudiante a la BD");
        }
    }
}
