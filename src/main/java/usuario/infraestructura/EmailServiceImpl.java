package usuario.infraestructura;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import usuario.dominio.EmailService;

public class EmailServiceImpl implements EmailService{
	private final String HOST = "smtp.gmail.com";
    private String FROM = "junisuspg94@gmail.com";
    private String PASS = "tlya sexe ntrx qhvy ";
    
	@Override
	public void sendEmail(String destinatario, String asunto, String mensaje) {
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.user", FROM);
        props.put("mail.smtp.password", PASS);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(FROM));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));

            message.setSubject(asunto);
            message.setText(mensaje);

            Transport transport = session.getTransport("smtp");
            transport.connect(HOST, FROM, PASS);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}
	
}
