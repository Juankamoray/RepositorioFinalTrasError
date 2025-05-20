package dao;

import dto.Profesor;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO {

    public boolean insertarProfesor(Profesor profesor) {
        String sql = "INSERT INTO profesores (nombre, email, pais, especialidad) VALUES (?, ?, ?, ?)";

        try (
            Connection con = ConexionBD.obtenerConexion(); // Conectamos BD
            PreparedStatement ps = con.prepareStatement(sql) // Preparamos la consulta SQL
        ) {
           
            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getEmail());
            ps.setString(3, profesor.getPais());
            ps.setString(4, profesor.getEspecialidad());

            // Ejecutamos la consulta de inserción a BD
            int filas = ps.executeUpdate(); // nos devuelve todas las filas 

            return filas > 0; // Si al menos una fila fue insertada, devolvemos true

        } catch (SQLException e) {
            System.out.println("Error al insertar profesor: " + e.getMessage());
            return false;
        }
    }

    public List<Profesor> obtenerTodos() {
        List<Profesor> lista = new ArrayList<>(); // Lista para almacenar todos los profesores
        String sql = "SELECT * FROM profesores"; // Consulta para obtener todo sobre la tabla profesores

        try (
            Connection con = ConexionBD.obtenerConexion(); // Conectamos a la base de datos
            Statement stmt = con.createStatement(); // Creamos un Statement para ejecutar la consulta
            ResultSet rs = stmt.executeQuery(sql) // Ejecutamos la consulta y obtenemos el resultado
        ) {
            while (rs.next()) { // Mientras haya resultados disponibles
                Profesor profesor = new Profesor(); // Creamos un objeto Profesor vacío

                // Asignamos los valores de cada columna al objeto Profesor
               
                profesor.setNombre(rs.getString("nombre"));
                profesor.setEmail(rs.getString("email"));
                profesor.setPais(rs.getString("pais"));
                profesor.setEspecialidad(rs.getString("especialidad"));

                // Añadimos el profesor a la lista
                lista.add(profesor);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener profesores: " + e.getMessage());
        }

        return lista; 
    }
    public boolean existeProfesor(int idProfesor) {
        String sql = "SELECT COUNT(*) FROM profesores WHERE id = ?";
        try (
            Connection con = ConexionBD.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, idProfesor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al comprobar si existe el profesor: " + e.getMessage());
        }
        return false;
    }

}
