package encuentros.infraestructura;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encuentros.aplicacion.MatchService;
import encuentros.aplicacion.MatchServiceImpl;
import encuentros.dominio.MatchRepository;
import equipo.aplicacion.TeamService;
import equipo.aplicacion.TeamServiceImpl;
import equipo.dominio.TeamRepository;
import equipo.infraestructura.TeamRepositoryImpl;

@WebServlet(name = "SvListaEncuentros", urlPatterns= {"/encuentros"})
public class SvListaEncuentros extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MatchService matchService;
	private TeamService teamService;

    public SvListaEncuentros() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        MatchRepository matchRepository = new MatchRepositoryImpl(emf);
        this.matchService = new MatchServiceImpl(matchRepository);
        
        TeamRepository teamRepository = new TeamRepositoryImpl(emf);
        this.teamService = new TeamServiceImpl(teamRepository);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("encuentros", matchService.getAllMatch());
		request.setAttribute("equipos", teamService.getAllTeams());
        request.getRequestDispatcher("pages/encuentros.jsp").forward(request, response);
	}
}
