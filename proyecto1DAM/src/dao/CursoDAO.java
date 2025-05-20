package dao;

import dto.Curso;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public boolean insertarCurso(Curso curso) {
        String sql = "INSERT INTO cursos (titulo, descripcion, duracionSemanas, nivel, id_Profesor) VALUES (?, ?, ?, ?, ?)";

        try (
 Connection con = ConexionBD.obtenerConexion(); // esto sirve para obtener la conexion a la base de datos
             PreparedStatement ps = con.prepareStatement(sql) //Se usa el ps para preparar la consulta SQL para que sea ejecutada
            		 ) {

            ps.setString(1, curso.getTitulo());
            ps.setString(2, curso.getDescripcion());
            ps.setInt(3, curso.getDuracionSemanas());
            ps.setString(4, curso.getNivel());
            ps.setInt(5, curso.getId());

            
            //aqui ya se ha ejecutado nuestra consulta y se ha insertado a la BD
            int filas = ps.executeUpdate();
            //Si se insertó al menos una fila nos va a devolver true
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar curso: " + e.getMessage());
            return false;
        }
    }

    public List<Curso> obtenerTodos() {
        List<Curso> lista = new ArrayList<>();
        String sql = "SELECT * FROM cursos"; // para obtener todos los cursos

        try (
        	Connection con = ConexionBD.obtenerConexion(); //Conectar a la BD
            Statement stmt = con.createStatement(); //Statement se usa para ejecutar la consulta
            ResultSet rs = stmt.executeQuery(sql) // el ResultSet almacena el resultado de la consulta
            		 ) {

            while (rs.next()) { // el while (rs.next) quiere decir que mientras haya mas resultados se continue
                Curso curso = new Curso();
                // el rs (ResultSet) nos permite acceder a cada columna de los resultados
                //posteriormente se lee cada columna y se almacena en un objeto curso
                curso.setId(rs.getInt("id"));
                curso.setTitulo(rs.getString("titulo"));
                curso.setDescripcion(rs.getString("descripcion"));
                curso.setDuracionSemanas(rs.getInt("duracionSemanas"));
                curso.setNivel(rs.getString("nivel"));
                curso.setIdProfesor(rs.getInt("id_profesor"));

                lista.add(curso);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener cursos: " + e.getMessage());
        }

        return lista;
    }
}
