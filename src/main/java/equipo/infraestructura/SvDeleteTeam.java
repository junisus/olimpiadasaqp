package equipo.infraestructura;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import equipo.aplicacion.TeamService;
import equipo.aplicacion.TeamServiceImpl;
import equipo.dominio.TeamRepository;

@WebServlet("/SvDeleteTeam")
public class SvDeleteTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamService teamService;

    public SvDeleteTeam() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        TeamRepository teamRepository = new TeamRepositoryImpl(emf);
        this.teamService = new TeamServiceImpl(teamRepository);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id-equipo-delete"));
		
		teamService.delete(id);
		response.sendRedirect("./equipos");
	}
}
