package jugadores.infraestructura;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jugadores.aplicacion.PlayerService;
import jugadores.aplicacion.PlayerServiceImpl;
import jugadores.dominio.PlayerRepository;

@WebServlet(name = "SvAddPlayer", urlPatterns= {"/SvAddPlayer"})
public class SvAddPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlayerService playerService;
       
    public SvAddPlayer() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        PlayerRepository playerRepository = new PlayerRepositoryImpl(emf);
        this.playerService = new PlayerServiceImpl(playerRepository);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		char sexo = request.getParameter("sexo").charAt(0);
		int edad = Integer.parseInt(request.getParameter("edad"));
		
		System.out.println("SEXO -> " + request.getParameter("sexo") + " <-");
		
		try {
			playerService.save(nombre, apellido, sexo, edad);
	        response.sendRedirect("./jugadores");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
