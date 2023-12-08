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

@WebServlet(name = "SvPlayersList", urlPatterns= {"/jugadores"})
public class SvPlayersList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlayerService playerService;
       
    public SvPlayersList() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        PlayerRepository playerRepository = new PlayerRepositoryImpl(emf);
        this.playerService = new PlayerServiceImpl(playerRepository);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("jugadores", playerService.getAllPlayers());
        request.getRequestDispatcher("pages/jugadores.jsp").forward(request, response);
	}
}
