package dao;
import dto.Matricula;
import util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MatriculaDAO {

    public boolean insertarMatricula(Matricula matricula) {
        String sql = "INSERT INTO matriculas (id_estudiante, id_curso, fecha_inscripcion, estado) VALUES (?, ?, ?, ?)";

        try (
            Connection con = ConexionBD.obtenerConexion(); //Conectamos con la base de datos
            PreparedStatement ps = con.prepareStatement(sql) //Preparamos la sentencia SQL con parámetros
        ) {
            //Asignamos los valores de la matrícula a la consulta
            ps.setInt(1, matricula.getIdEstudiante());
            ps.setInt(2, matricula.getIdCurso());
            ps.setDate(3, Date.valueOf(matricula.getFechaInscripcion()));
            ps.setString(4, matricula.getEstado());

            //Ejecutamos la inserción en la base de datos
            int filas = ps.executeUpdate();

            //Devolvemos true si al menos hay una fila
            return filas > 0;

        } catch (SQLException e) {
            //En caso de error, lo mostramos por consola
            System.out.println("Error al insertar matrícula: " + e.getMessage());
            return false;
        }
    }

    public List<Matricula> obtenerTodas() {
        List<Matricula> lista = new ArrayList<>();
        String sql = "SELECT * FROM matriculas"; //Consulta para obtener todas las matrículas

        try (
            Connection con = ConexionBD.obtenerConexion(); //Nos conectamos a la base de datos
            Statement stmt = con.createStatement(); //Creamos el statement para ejecutar la consulta
            ResultSet rs = stmt.executeQuery(sql) //El ResultSet guarda los resultados de la consulta
        ) {
            while (rs.next()) { //Mientras haya más filas, seguimos recorriendo
                Matricula matricula = new Matricula(); //Creamos un objeto Matricula vacío

                //Vamos rellenando la matricula 1 por 1
                matricula.setId(rs.getInt("id"));
                matricula.setIdEstudiante(rs.getInt("id_estudiante"));
                matricula.setIdCurso(rs.getInt("id_curso"));
                matricula.setFechaInscripcion(rs.getDate("fecha_inscripcion").toLocalDate());
                matricula.setEstado(rs.getString("estado"));

                lista.add(matricula); 
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener matrículas: " + e.getMessage());
        }

        return lista;
    }
}
