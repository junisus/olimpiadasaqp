package encuentros.infraestructura;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
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

@WebServlet(name = "SvAddMatch", urlPatterns= {"/SvAddMatch"})
public class SvAddMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MatchService matchService;

    public SvAddMatch() {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oli");
        MatchRepository matchRepository = new MatchRepositoryImpl(emf);
        this.matchService = new MatchServiceImpl(matchRepository);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idEquipoA = Integer.parseInt(request.getParameter("id-equipo-a"));
		int idEquipoB = Integer.parseInt(request.getParameter("id-equipo-b"));
		String fecha = request.getParameter("fecha");
		String h = request.getParameter("hora");
		String lugar = request.getParameter("lugar");
		String ra = request.getParameter("resultado-a");
		String rb = request.getParameter("resultado-b");
		int resA;
		int resB;
		
	    SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
	    SimpleDateFormat formatoFecha = new SimpleDateFormat("HH:mm");
	    
	    if (ra.isEmpty()) {
	    	resA = 0;
	    } else {
	    	resA = Integer.parseInt(ra);
	    }
	    
	    if (rb.isEmpty()) {
	    	resB = 0;
	    } else {
	    	resB = Integer.parseInt(rb);
	    }

	    try {
	    	
	        Date fechaConvertida = new Date(formatoEntrada.parse(fecha).getTime());
	        Time hora = new Time(formatoFecha.parse(h).getTime());
	        matchService.save(idEquipoA, idEquipoB, fechaConvertida, hora, lugar, resA, resB);
	        response.sendRedirect("./encuentros");
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	}
}
