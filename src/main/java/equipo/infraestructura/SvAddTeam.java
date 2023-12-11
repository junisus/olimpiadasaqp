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

@WebServlet(name = "SvAddTeam", urlPatterns= {"/SvAddTeam"})
public class SvAddTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamService teamService;
    
    public SvAddTeam() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        TeamRepository teamRepository = new TeamRepositoryImpl(emf);
        this.teamService = new TeamServiceImpl(teamRepository);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCategoria = Integer.parseInt(request.getParameter("id-categoria"));
		String nombre = request.getParameter("nombre");
		
		try {
			teamService.save(idCategoria, nombre);
			response.sendRedirect("./equipos");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
