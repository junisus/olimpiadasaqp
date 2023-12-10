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

@WebServlet(name = "SvDeleteMatch", urlPatterns= {"/SvDeleteMatch"})
public class SvDeleteMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MatchService matchService;

    public SvDeleteMatch() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        MatchRepository matchRepository = new MatchRepositoryImpl(emf);
        this.matchService = new MatchServiceImpl(matchRepository);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id-encuentro-delete"));
		
		matchService.delete(id);
		response.sendRedirect("./encuentros");
	}

}
