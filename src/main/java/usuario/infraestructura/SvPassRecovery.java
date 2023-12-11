package usuario.infraestructura;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usuario.dominio.EmailService;
import usuario.dominio.EncryptionService;
import usuario.dominio.UserRepository;
import usuario.dominio.Usuario;


@WebServlet(name = "SvPassRecovery", urlPatterns= {"/SvPassRecovery"})
public class SvPassRecovery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EncryptionService encryptionService;
	private EmailService emailService;
	private UserRepository userRepository;

    public SvPassRecovery() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        this.userRepository = new UserRepositoryImpl(emf);
        this.encryptionService = new EncryptionServiceImpl();
        this.emailService = new EmailServiceImpl();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		Usuario usuario = userRepository.encontrarPorEmail(email);
		
		if (usuario != null) {
			String decryptedPassword = encryptionService.decrypt(usuario.getPassword());
			emailService.sendEmail(email, "Recuperación de contraseña", "Tu contraseña es: " + decryptedPassword);
			
			response.setContentType("text/plain");
			response.getWriter().write("successful");
		}
		
		if (usuario == null) {
			response.setContentType("text/plain");
			response.getWriter().write("error-email");
		}
	}

}
