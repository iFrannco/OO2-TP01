package ar.unrn.restaurante;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.time.LocalDate;
import java.util.Properties;

public class ExportadorEnEmail implements Exportador {
    private String username;
    private String password;
    private String port;
    private String proveedorDeCorreo;
    private String smpt;
    private String tls;
    private String correoReceptor;

    public ExportadorEnEmail(String username, String password, String port, String proveedorDeCorreo, String smpt, String tls, String correoReceptor) {
        this.username = username;
        this.password = password;
        this.port = port;
        this.proveedorDeCorreo = proveedorDeCorreo;
        this.smpt = smpt;
        this.tls = tls;
        this.correoReceptor = correoReceptor;
    }

    @Override
    public void exportar(LocalDate fecha, float montoTotal) {

        Properties prop = new Properties();
        prop.put("mail.smtp.host", this.proveedorDeCorreo);
        prop.put("mail.smtp.port", this.port);
        prop.put("mail.smtp.auth", this.smpt);
        prop.put("mail.smtp.starttls.enable", this.tls);

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
