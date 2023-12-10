package equipo.infraestructura;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import equipo.aplicacion.TeamServiceImpl;
import equipo.dominio.TeamRepository;

@WebServlet(name = "SvTeamsList", urlPatterns= {"/equipos"})
public class SvTeamsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamServiceImpl teamService;
       
    public SvTeamsList() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        TeamRepository teamRepository = new TeamRepositoryImpl(emf);
        this.teamService = new TeamServiceImpl(teamRepository);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("equipos", teamService.getAllTeams());
        request.getRequestDispatcher("pages/equipos.jsp").forward(request, response);
	}
}
