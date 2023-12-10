package encuentros.infraestructura;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

@WebServlet(name = "SvUpdateMatch", urlPatterns= {"/SvUpdateMatch"})
public class SvUpdateMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MatchService matchService;
       
    public SvUpdateMatch() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        MatchRepository matchRepository = new MatchRepositoryImpl(emf);
        this.matchService = new MatchServiceImpl(matchRepository);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id-encuentro"));
		int idEquipoA = Integer.parseInt(request.getParameter("id-equipo-A"));
		int idEquipoB = Integer.parseInt(request.getParameter("id-equipo-B"));
		String fecha = request.getParameter("fecha");
		Time hora = Time.valueOf(request.getParameter("hora"));
		String lugar = request.getParameter("lugar");
		
	    SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
	    
	    try {
	        Date fechaConvertida = new Date(formatoEntrada.parse(fecha).getTime());

	        matchService.update(id, idEquipoA, idEquipoB, fechaConvertida, hora, lugar);
	        response.sendRedirect("./encuentros");
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	}

}
