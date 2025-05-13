package dao;
import util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dto.Estudiante;

public class EstudianteDAO {

    public boolean añadirEstudiante(Estudiante estudiante) {
        String sql = "INSERT INTO estudiantes (nombre, email, pais, fecha_nacimiento) VALUES (?, ?, ?, ?)";
        try (Connection connect = ConexionBD.obtenerConexion();
             PreparedStatement ps = connect.prepareStatement(sql)) {

            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getEmail());
            ps.setString(3, estudiante.getPais());
            ps.setDate(4, Date.valueOf(estudiante.getFechaNacimiento()));

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar estudiante: " + e.getMessage());
            return false;
        }
    }

    public List<Estudiante> obtenerTodos() {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes";

        try (Connection con = ConexionBD.obtenerConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Estudiante est = new Estudiante();
                est.setId(rs.getInt("id"));
                est.setNombre(rs.getString("nombre"));
                est.setEmail(rs.getString("Email"));
                est.setPais(rs.getString("pais"));
                est.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());

                lista.add(est);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener estudiantes: " + e.getMessage());
        }

        return lista;
    }
}
