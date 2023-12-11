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

@WebServlet(name = "SvUpdatePlayer", urlPatterns= {"/SvUpdatePlayer"})
public class SvUpdatePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlayerService playerService;
       
    public SvUpdatePlayer() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        PlayerRepository playerRepository = new PlayerRepositoryImpl(emf);
        this.playerService = new PlayerServiceImpl(playerRepository);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id-jugador-edit"));
		String nombre = request.getParameter("nombre-edit");
		String apellido = request.getParameter("apellido-edit");
		char sexo = request.getParameter("sexo-edit").charAt(0);
		int edad = Integer.parseInt(request.getParameter("edad-edit"));
		
		try {
			playerService.update(id, nombre, apellido, sexo, edad);
			response.sendRedirect("./jugadores");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
