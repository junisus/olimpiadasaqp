package ranking;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encuentros.aplicacion.MatchService;
import encuentros.aplicacion.MatchServiceImpl;
import equipo.aplicacion.TeamService;
import equipo.aplicacion.TeamServiceImpl;
import equipo.dominio.Equipo;
import equipo.dominio.TeamRepository;
import equipo.infraestructura.TeamRepositoryImpl;
import encuentros.dominio.Encuentro;
import encuentros.dominio.MatchRepository;
import encuentros.infraestructura.MatchRepositoryImpl;

@WebServlet(name = "SvRankingEquipos", urlPatterns= {"/ranking"})
public class SvRankingEquipos extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private MatchService matchService;
	private TeamService teamService;
	
    public SvRankingEquipos() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        MatchRepository matchRepository = new MatchRepositoryImpl(emf);
        TeamRepository teamRepository = new TeamRepositoryImpl(emf);
        this.matchService = new MatchServiceImpl(matchRepository);
        this.teamService = new TeamServiceImpl(teamRepository);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Encuentro> encuentros = matchService.getAllMatch();
		List<Equipo> equipos = teamService.getAllTeams();

		// Calcula los puntos totales de cada equipo
		Map<Equipo, Integer> puntosTotales = new HashMap<>();
		for (Equipo equipo : equipos) {
			int puntos = calcularPuntosTotales(equipo, encuentros);
			puntosTotales.put(equipo, puntos);
		}

		// Ordena los equipos por puntos totales en orden descendente
		equipos.sort((Equipo e1, Equipo e2) -> Integer.compare(puntosTotales.get(e2), puntosTotales.get(e1)));

		request.setAttribute("equipos", equipos);
		request.setAttribute("puntosTotales", puntosTotales);
		request.getRequestDispatcher("pages/ranking-equipos.jsp").forward(request, response);
	}
	
	private int calcularPuntosTotales(Equipo equipo, List<Encuentro> encuentros) {
		int puntosTotales = 0;

		for (Encuentro encuentro : encuentros) {
			if (encuentro.getIdEquipoA() == equipo.getId()) {
				// El equipo es el equipo A en este encuentro
				if (encuentro.getResultadoA() > encuentro.getResultadoB()) {
					// El equipo A ganó el encuentro
					puntosTotales += 3;
				} else if (encuentro.getResultadoA() == encuentro.getResultadoB()) {
					// El encuentro terminó en empate
					puntosTotales += 1;
				}
			} else if (encuentro.getIdEquipoB() == equipo.getId()) {
				// El equipo es el equipo B en este encuentro
				if (encuentro.getResultadoB() > encuentro.getResultadoA()) {
					// El equipo B ganó el encuentro
					puntosTotales += 3;
				} else if (encuentro.getResultadoB() == encuentro.getResultadoA()) {
					// El encuentro terminó en empate
					puntosTotales += 1;
				}
			}
		}

		return puntosTotales;
	}
}
