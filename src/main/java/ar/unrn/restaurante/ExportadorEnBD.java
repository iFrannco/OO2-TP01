package ar.unrn.restaurante;

import java.sql.*;
import java.time.LocalDate;

public class ExportadorEnBD implements Exportador {
    String url = "jdbc:mysql://localhost:3306/restaurante";
    String user = "root";
    String pass = "1818";

    @Override
    public void exportar(LocalDate fecha, float montoTotal) {
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);

            Date fechaSQL = Date.valueOf(fecha);
            String sql = "INSERT INTO registro (fecha, monto) VALUES (?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setDate(1, fechaSQL);
            pstmt.setFloat(2, montoTotal);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
