package ar.unrn.testing;

import java.sql.*;
import java.time.LocalDate;

public class RegistradorEnBD implements Registrador {
    String url = "jdbc:mysql://localhost:3306/inscripciones_concurso";
    String user = "root";
    String pass = "1818";

    @Override
    public void registrar(LocalDate fecha, int idConcurso, int idParticipante) {
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);

            Date fechaSQL = Date.valueOf(fecha);
            String sql = "INSERT INTO registro (fecha, id_concurso, id_participante) VALUES (?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setDate(1, fechaSQL);
            pstmt.setInt(2, idConcurso);
            pstmt.setInt(3, idParticipante);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
