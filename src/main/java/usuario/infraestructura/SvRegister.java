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
import usuario.dominio.UserRepository;

@WebServlet(name = "SvRegister", urlPatterns= {"/SvRegister"})
public class SvRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;

    public SvRegister() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        UserRepository userRepository = new UserRepositoryImpl(emf);
        this.userService = new UserServiceImpl(userRepository);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password1 = request.getParameter("password-1");
		String password2 = request.getParameter("password-2");
		
		if (!password1.equals(password2)) {
			response.setContentType("text/plain");
            response.getWriter().write("register-error-password");
            
		} else if (userService.register(email, password1)) {
			response.setContentType("text/plain");
            response.getWriter().write("register-successful");
            
		} else {
			response.setContentType("text/plain");
            response.getWriter().write("register-error-email");
		}
	}

}
