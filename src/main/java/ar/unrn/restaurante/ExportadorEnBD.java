package ar.unrn.restaurante;

import java.sql.*;
import java.time.LocalDate;

public class ExportadorEnBD implements Exportador {
    String url;
    String user;
    String pass;

    public ExportadorEnBD(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    @Override
    public void exportar(LocalDate fecha, float montoTotal) {
        String sql = "INSERT INTO registro (fecha, monto) VALUES (?, ?)";
        try (
                Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {

            Date fechaSQL = Date.valueOf(fecha);
            pstmt.setDate(1, fechaSQL);
            pstmt.setFloat(2, montoTotal);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
