package ar.unrn.testing;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.time.LocalDate;
import java.util.Properties;

public class RegistradorEnEmail implements Registrador {
    @Override
    public void registrar(LocalDate fecha, int idConcurso, int idParticipante) {
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
            message.setSubject("Nueva inscripción a un concurso");
            String mensaje = "Información de la inscripción:\n" +
                    "ID Concurso: " + idConcurso +
                    "\nID Participante: " + idParticipante +
                    "\nFecha de inscripción: " + fecha.toString();
            message.setText(mensaje);

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}