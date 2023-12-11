package usuario.dominio;

public interface EmailService {
	void sendEmail(String destinatario, String asunto, String mensaje);
}
