package ar.unrn.restaurante;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.time.LocalDate;
import java.util.Properties;

public class ExportadorEnEmail implements Exportador {
    @Override
    public void exportar(LocalDate fecha, float montoTotal) {
        final String username = "fcabeza91@gmail.com";
        final String password = "tmwz ibua emni afsr";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); // Para TLS

        Session session = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse("fcabeza91@gmail.com"));
            message.setSubject("Nuevo cobro registrado");
            String mensaje = "Información del cobro:\n" +
                    "Monto Total: " + montoTotal +
                    "\nFecha: " + fecha.toString();
            message.setText(mensaje);

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
