package main;
import java.util.*;
import dao.*;
import dto.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EstudianteDAO estudianteDAO = new EstudianteDAO();
        ProfesorDAO profesorDAO = new ProfesorDAO();
        CursoDAO cursoDAO = new CursoDAO();
        MatriculaDAO matriculaDAO = new MatriculaDAO();

        int opcion;

        do {
        	//menu
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Añadir Estudiante");
            System.out.println("2. Añadir Profesor");
            System.out.println("3. Añadir Curso");
            System.out.println("4. Matricular Estudiante en Curso");
            System.out.println("5. Listar Estudiantes");
            System.out.println("6. Listar Profesores");
            System.out.println("7. Listar Cursos");
            System.out.println("8. Listar Matrículas");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: (Ya sea 1,2,3,4,5,6,7,8,9 o 0) ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
            case 1: {
                System.out.print("Nombre : ");
                
                String nombre = scanner.nextLine();
                System.out.print("Email: ");
                
                String email = scanner.nextLine();
                System.out.print("Pais: ");
                
                String pais = scanner.nextLine();
                System.out.print("Fecha de nacimiento ej: (2006-01-21): ");   
                String fechaStr = scanner.nextLine();
                LocalDate fechaNacimiento = LocalDate.parse(fechaStr);

                Estudiante est = new Estudiante();
                est.setNombre(nombre);
                est.setEmail(email);
                est.setPais(pais);
                est.setFechaNacimiento(fechaNacimiento);

                if (estudianteDAO.añadirEstudiante(est)) {
                    System.out.println("El estudiante se ha añadido perfectamente");
                } else {
                    System.out.println("Hubo un error al añadir al estudiante, comprueba si los datos que pusiste son correctos");
                }
                scanner.nextLine();
            }


                case 2 : {
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("País: ");
                    String pais = scanner.nextLine();
                    System.out.print("Especialidad: ");
                    String especialidad = scanner.nextLine();

                    Profesor prof = new Profesor();
                    prof.setNombre(nombre);
                    prof.setEmail(email);
                    prof.setPais(pais);
                    prof.setEspecialidad(especialidad);

                    if (profesorDAO.insertarProfesor(prof)) {
                        System.out.println("El profesor se ha añadido correctamente");
                    } else {
                        System.out.println("Parece que hubo un error al añadir profesor, comprueba si los datos que pusiste son correctos");
                    }
                    scanner.nextLine();
                    break;
                }

                case 3 :{
                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descripcion: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Duracion en semanas: ");
                    int duracion = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nivel: ");
                    String nivel = scanner.nextLine();
                    System.out.print("ID del profesor: ");
                    int idProfesor = scanner.nextInt();
                    scanner.nextLine();
                    if (!profesorDAO.existeProfesor(idProfesor)) {
                        System.out.println("Error: El profesor con la  ID " + idProfesor + " no existe.");
                    } 
                    Curso curso = new Curso();
                    curso.setTitulo(titulo);
                    curso.setDescripcion(descripcion);
                    curso.setDuracionSemanas(duracion);
                    curso.setNivel(nivel);
                    curso.setId(idProfesor);
                    
                    if (cursoDAO.insertarCurso(curso)) {
                        System.out.println("Tu curso se ha añadido correctamente");
                    } else {
                        System.out.println("Hubo un error al añadir curso trata de poner bien los campos");
                    }
                    scanner.nextLine();
                    break;
                }

                case 4: {
                    System.out.print("ID del Estudiante: ");
                    int idEstudiante = scanner.nextInt();
                    System.out.print("ID del Curso: ");
                    int idCurso = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Estado (en curso/completado): ");
                    String estado = scanner.nextLine();

                    Matricula matricula = new Matricula();
                    matricula.setIdEstudiante(idEstudiante);
                    matricula.setIdCurso(idCurso);
                    matricula.setEstado(estado);
                    matricula.setFechaInscripcion(LocalDate.now());

                    if (matriculaDAO.insertarMatricula(matricula)) {
                        System.out.println("Matricula realizada a la perfeccion");
                    } else {
                        System.out.println("Error al matricular.");
                    }
                    scanner.nextLine();
                    break;
                }

                case 5 : {
                    List<Estudiante> estudiantes = estudianteDAO.obtenerTodos();
                    System.out.println("--- Lista de Estudiantes ---");
                    for (Estudiante e : estudiantes) {
                        System.out.println(e);
                    }
                    scanner.nextLine();
                    break;
                }

                case 6 : {
                    List<Profesor> profesores = profesorDAO.obtenerTodos();
                    System.out.println("--- Lista de Profesores ---");
                    for (Profesor p : profesores) {
                        System.out.println(p);
                    }
                    scanner.nextLine();
                    break;
                }

                case 7 : {
                    List<Curso> cursos = cursoDAO.obtenerTodos();
                    System.out.println("--- Lista de Cursos ---");
                    for (Curso c : cursos) {
                        System.out.println(c);
                    }
                    scanner.nextLine();
                    break;
                }

                case 8 : {
                    List<Matricula> matriculas = matriculaDAO.obtenerTodas();
                    System.out.println("--- Lista de Matriculas ---");
                    for (Matricula m : matriculas) {
                        System.out.println(m);
                    }
                    scanner.nextLine();
                    break;
                }

                case 0 : System.out.println("Saliendo...");

                default : System.out.println("Opción no válida."); //el default sirve si se puso una opcion fuera de las que hay en el switch
            }

        } while (opcion != 0);

        scanner.close();
    }
}
