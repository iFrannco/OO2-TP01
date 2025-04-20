package ar.unrn.concurso;

import java.sql.*;
import java.time.LocalDate;

public class RegistradorEnBD implements Registrador {
    String url = "jdbc:mysql://localhost:3306/inscripciones_concurso";
    String user = "root";
    String pass = "1818";

    @Override
    public void registrar(LocalDate fecha, int idConcurso, int idParticipante) {
        String sql = "INSERT INTO registro (fecha, id_concurso, id_participante) VALUES (?, ?, ?)";

        try (
                Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement pstmt = conn.prepareStatement(sql);

        ) {

            Date fechaSQL = Date.valueOf(fecha);


            pstmt.setDate(1, fechaSQL);
            pstmt.setInt(2, idConcurso);
            pstmt.setInt(3, idParticipante);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
