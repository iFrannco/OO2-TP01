package ar.unrn.concurso;

import java.sql.*;
import java.time.LocalDate;

public class RegistradorEnBD implements Registrador {
    String url;
    String user;
    String pass;

    public RegistradorEnBD(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

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
