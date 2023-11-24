package usuario.infraestructura;

import java.io.IOException;

import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usuario.aplicacion.UserService;
import usuario.aplicacion.UserServiceImpl;
import usuario.dominio.EncryptionService;
import usuario.dominio.UserRepository;

@WebServlet(name = "SvLogin", urlPatterns= {"/SvLogin"})
public class SvLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private EncryptionService encryptionService;
    public SvLogin() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        UserRepository userRepository = new UserRepositoryImpl(emf);
        this.userService = new UserServiceImpl(userRepository);
        this.encryptionService = new EncryptionServiceImpl();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
        String password = request.getParameter("password");
       
        if (userService.login(email, encryptionService.encrypt(password))) {
            response.setContentType("text/plain");
            response.getWriter().write("login-successful");
            
        } else {
        	response.setContentType("text/plain");
            response.getWriter().write("login-error");
        }
	}
}
